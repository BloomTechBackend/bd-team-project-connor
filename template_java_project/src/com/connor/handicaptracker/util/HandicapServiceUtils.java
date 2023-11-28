package com.connor.handicaptracker.util;

import org.junit.platform.commons.util.StringUtils;

import java.util.regex.Pattern;

public class HandicapServiceUtils {
    private static final Pattern INVALID_CHARACTER_PATTERN = Pattern.compile("[\"\'\\\\]");
    private static final int MAX_USERNAME_LENGTH = 20;
    public static boolean isValidString(final String stringToValidate) {
        if (StringUtils.isBlank(stringToValidate)) {
            return false;
        }
        if (stringToValidate.length() > MAX_USERNAME_LENGTH) {
            return false;
        }
        for (char c : stringToValidate.toCharArray()) {
            if (!Character.isLetterOrDigit(c) && c != '-' && c != '_') {
                return false;
            }
        }

        return !INVALID_CHARACTER_PATTERN.matcher(stringToValidate).find();
    }
}
