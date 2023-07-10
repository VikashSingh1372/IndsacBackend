package com.unicorn.indsaccrm.common.user;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;
@CrossOrigin
@RestController
public class UserProfileController {
    Logger logger = LoggerFactory.getLogger(UserProfileController.class);

    @Autowired
    UserService userService;


    @Autowired
    UserRepository userRepository;

    @RequestMapping(value = "/users")
    @PostMapping
    public ResponseEntity<?> getAllUsers() throws Exception {
            return ResponseEntity.ok(userRepository.findAll());
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<?> getUserById(@PathVariable UUID id) throws Exception {
        logger.info("Get User by id="+id);
        return ResponseEntity.ok(userRepository.findById(id));
    }

    @GetMapping("/user")
    public ResponseEntity<?> getLoggedInUserId() throws Exception {
        Optional<com.unicorn.indsaccrm.common.user.User> user=userRepository.findByEmail(((User) SecurityContextHolder.getContext()
                .getAuthentication().getPrincipal()).getUsername());
        if(user!=null){
            return ResponseEntity.ok(user.get().getId());
        }else{
            return new ResponseEntity<>("Not Found", HttpStatus.NOT_FOUND);
        }
    }
    @PutMapping("/resetpassword")
    ResponseEntity<?>updatednewpassword(@RequestBody ResetPasswordResource resetPasswordResource)throws Exception{
        return userService.resetPassowrd(resetPasswordResource);
    }


}
