package com.unicorn.indsaccrm.util.email;

import com.unicorn.indsaccrm.user.User;

import javax.mail.MessagingException;
import java.io.UnsupportedEncodingException;

public interface EmailService {

    public void generateOneTimePassword(User user) throws MessagingException, UnsupportedEncodingException;
    public void sendOTPEmail(User user, String OTP) throws MessagingException, UnsupportedEncodingException;
    public void clearOTP(User user);
}
