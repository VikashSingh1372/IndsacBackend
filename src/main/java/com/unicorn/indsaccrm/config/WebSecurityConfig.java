package com.unicorn.indsaccrm.config;

import javax.sql.DataSource;

import com.unicorn.indsaccrm.oauth.jwt.JwtAuthenticationEntryPoint;
import com.unicorn.indsaccrm.oauth.jwt.JwtRequestFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;

	@Autowired
	private UserDetailsService customUserDetailsService;
	
	@Autowired
	private DataSource dataSource;

	@Autowired
	private JwtRequestFilter jwtRequestFilter;
	
	@Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
	
	@Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		// configure AuthenticationManager so that it knows from where to load
		// user for matching credentials
		// Use BCryptPasswordEncoder
        auth
        	.userDetailsService(customUserDetailsService)
        	.passwordEncoder(passwordEncoder());
    }

	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}
	
    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
		httpSecurity
				.csrf().disable()
				// dont authenticate this particular request
				.authorizeRequests()
				.antMatchers("/authenticate", "/register","/enquiry","/subscribe").permitAll().
				/*  .authorizeRequests()
            	.antMatchers("/resources/**", "/webjars/**","/assets/**").permitAll()
                .antMatchers("/").permitAll()
                .antMatchers("/admin/**").hasRole("ADMIN") */
                anyRequest().authenticated()
                .and()
           /* .formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/home")
                .failureUrl("/login?error")
                .permitAll()
                .and()*/
            .logout()
            	.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
            	.logoutSuccessUrl("/login?logout")
            	.deleteCookies("my-remember-me-cookie")
                .permitAll()
                .and()
             .rememberMe()
             	//.key("my-secure-key")
             	.rememberMeCookieName("my-remember-me-cookie")
             	.tokenRepository(persistentTokenRepository())
             	.tokenValiditySeconds(24 * 60 * 60)
             	.and().
		// make sure we use stateless session; session won't be used to
		// store user's state.
		exceptionHandling().authenticationEntryPoint(jwtAuthenticationEntryPoint).and().sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS);

		// Add a filter to validate the tokens with every request
		httpSecurity.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
    }
    
    PersistentTokenRepository persistentTokenRepository(){
    	JdbcTokenRepositoryImpl tokenRepositoryImpl = new JdbcTokenRepositoryImpl();
    	tokenRepositoryImpl.setDataSource(dataSource);
    	return tokenRepositoryImpl;
    }
}
