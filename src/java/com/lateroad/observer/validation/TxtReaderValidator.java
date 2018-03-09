package com.lateroad.observer.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TxtReaderValidator {
    private static final String LINE_FORMAT_PATTERN = "(-?\\d*\\s){7}\\d\\s*?";

    public boolean validateLine(String line) {
        Pattern pattern = Pattern.compile(LINE_FORMAT_PATTERN);
        Matcher m = pattern.matcher(line);
        return m.matches();
    }
}
