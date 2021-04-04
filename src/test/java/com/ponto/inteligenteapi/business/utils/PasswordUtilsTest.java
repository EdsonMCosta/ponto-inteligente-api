package com.ponto.inteligenteapi.business.utils;


import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

/**
 * PasswordUtilsTest
 *
 * @author : Edson Costa
 * @since : 03/04/2021
 **/
public class PasswordUtilsTest {

    private static final String PASSWORD = "987654321";
    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Test
    public void testNullPassword() throws Exception {
        assertNull(PasswordUtils.generateBCrypt(null));
    }

    @Test
    public void testGeneratePasswordHash() throws Exception {
        final String crypt = PasswordUtils.generateBCrypt(PASSWORD);

        assertTrue(passwordEncoder.matches(PASSWORD, crypt));
    }
}