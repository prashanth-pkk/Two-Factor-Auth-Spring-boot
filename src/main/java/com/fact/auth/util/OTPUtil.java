package com.fact.auth.util;

import java.security.SecureRandom;

public class OTPUtil {
    private static final SecureRandom random = new SecureRandom();

    public static String generateOTP(int length) {
        if (length < 4 || length > 10) {
            throw new IllegalArgumentException("OTP length must be between 4 and 10 digits");
        }

        int lowerBound = (int) Math.pow(10, length - 1);
        int upperBound = (int) Math.pow(10, length) - 1;
        int otp = lowerBound + random.nextInt(upperBound - lowerBound + 1);

        return String.format("%0" + length + "d", otp);
    }
}
