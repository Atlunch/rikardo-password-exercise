package de.neuefische.cologne.rikardo.passwordcheck;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordCheckClass {

    public String password;

    public static boolean checkPasswordLength(String password) {
        return password.length() >=  10;
    }

    public static boolean checkIfPasswordIncludeNumber(String password) {
        return password.matches(".*\\d.*");
    }

    public static boolean checkIfPasswordIncludeLowerUppercase(String password) {
        return !password.equals(password.toLowerCase()) && !password.equals(password.toUpperCase());
    }

    public static boolean checkPasswordSpecialChars(String password) {
        Pattern pattern = Pattern.compile("[a-zA-Z0-9]*");
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }

}
