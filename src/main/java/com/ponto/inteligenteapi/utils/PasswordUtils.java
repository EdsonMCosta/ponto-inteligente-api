package com.ponto.inteligenteapi.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordUtils {

    private static final Logger log = LoggerFactory.getLogger(PasswordUtils.class);

    public PasswordUtils() {
    }

    /**
     * Generate a hash using the BCrypt
     *
     * @param password
     * @return String
     */
    public static String generateBCrypt(String password){
        if (password == null){
            return password;
        }

        log.info("Generating a hash using the BCrypt");
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        return bCryptPasswordEncoder.encode(password);
    }
}
