package de.neuefische.cologne.rikardo.passwordcheck;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordCheck {

    public static void main(String[] args) {

        Scanner input_value = new Scanner(System.in);
        System.out.println("Bitte Password eingeben: ");
        String password = input_value.nextLine();

        if (checkPassword(password)) {
            System.out.println("Password ist korrekt");
        } else {
            System.out.println("Password ist NICHT korrekt");
        }


    }

    public static boolean checkPassword(String password) {
        return checkPasswordLength(password) && checkIfPasswordIncludeNumber(password) && checkIfPasswordIncludeLowerUppercase(password) && checkPasswordSpecialChars(password);
    }


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
