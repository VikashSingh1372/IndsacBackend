package com.unicorn.indsaccrm.common.util.email;

import com.unicorn.indsaccrm.common.user.User;
import com.unicorn.indsaccrm.common.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import net.bytebuddy.utility.RandomString;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.transaction.Transactional;
import java.io.UnsupportedEncodingException;
import java.util.Date;

@Service
@Transactional
public class EmailServiceImpl implements EmailService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder bcryptEncoder;
    @Autowired
    private JavaMailSender mailSender;

    @Value("${spring.mail.username}")
    private  String fromEmail;

    @Override
    public void generateOneTimePassword(User user) throws MessagingException, UnsupportedEncodingException {
        String OTP = RandomString.make(8);
        String encodedOTP = bcryptEncoder.encode(OTP);

        user.setOneTimePassword(encodedOTP);
        user.setOtpRequestedTime(new Date());

        userRepository.save(user);

        sendOTPEmail(user, OTP);
    }

    @Override
    public void sendOTPEmail(User user, String OTP) throws MessagingException, UnsupportedEncodingException {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);

        helper.setFrom(fromEmail, "CloudNode Unicorn Support");
        helper.setTo(user.getEmail());

        String subject = "Here's your One Time Password (OTP) - Expire in 5 minutes!";

        String content = "<p>Hello " + user.getName() + "</p>"
                + "<p>For security reason, you're required to use the following "
                + "One Time Password to login:</p>"
                + "<p><b>" + OTP + "</b></p>"
                + "<br>"
                + "<p>Note: this OTP is set to expire in 5 minutes.</p>";

        helper.setSubject(subject);

        helper.setText(content, true);

        mailSender.send(message);
    }

    @Override
    public void clearOTP(User user) {
        user.setOneTimePassword(null);
        user.setOtpRequestedTime(null);
        userRepository.save(user);
    }
}
