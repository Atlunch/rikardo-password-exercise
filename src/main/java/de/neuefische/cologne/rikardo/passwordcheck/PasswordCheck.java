package de.neuefische.cologne.rikardo.passwordcheck;

import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordCheck {

    public static void main(String[] args) {

        startScreen();

        Scanner input_value = new Scanner(System.in);
        int task = input_value.nextInt();

        switch (task) {
            case 1 -> inputPasswordArrayAndValidate();
            case 2 -> inputPasswordAndValidate();
            default -> throw new IllegalStateException("Unexpected value: " + task);
        }
    }

    public static void startScreen(){
        System.out.println("________________Passwort Validierungs Programm_______________________");
        System.out.println("|  Vorgefertige Passwörter verwenden oder neue Passwörter anlegen?  |");
        System.out.println("|  - [1] vorgefertige Passwörter validieren                         |");
        System.out.println("|  - [2] neues Passwort anlegen und anschließend validieren        |");
        System.out.println("_____________________________________________________________________");
        System.out.println("Bitte Zahl eingeben und bestätigen: ");
    }

    public static void inputPasswordArrayAndValidate(){
        String[] passwords = {"afsjgks","aksjdscswd","adsacsa214sad2s","Asfe23sasdSW","asd23adASD?!a..!2s"};
        System.out.println("Folgende Passwörte werde nun validiert" + " " + Arrays.toString(passwords));
        for (String s : passwords) {
            System.out.println(s + " " + ":" + " " + checkPassword(s));
        }
    }

    public static void inputPasswordAndValidate(){
        System.out.println("Passwort Richtlinien: mind. 10 Zeichen, a-z, A-Z, 0-9");
        System.out.println("Bitte Password eingeben: ");
        Scanner inputPassword = new Scanner(System.in);
        String password = inputPassword.nextLine();
        String[] failureMessages;
        failureMessages = showPasswordProperties(password);
        System.out.println("_____________________________________________________________________");
        for (String failureMessage : failureMessages) {
            System.out.println(failureMessage);
        }
        System.out.println("_____________________________________________________________________");
        if(!checkPassword(password)) {
            System.out.println("Das eingegeben Passwort entsprach nicht den Richtlinien.");
            System.out.println("Wollen Sie es nochmal probieren oder soll das Programm beendet werden?");
            System.out.println("- [1] nochmal probieren");
            System.out.println("- [2] Programm beenden");
            Scanner inputTask = new Scanner(System.in);
            int task = inputTask.nextInt();
            switch (task) {
                case 1 -> inputPasswordAndValidate();
                case 2 -> System.out.println("Das Programm wurde beendet.");
                default -> throw new IllegalStateException("Unexpected value: " + task);
            }
        } else {
            System.out.println("Das eingegebene Passwort wurde akzeptiert.");
        }
    }



    public static boolean checkPassword(String password) {
        return checkPasswordLength(password) && checkIfPasswordIncludeNumber(password) && checkIfPasswordIncludeLowerUppercase(password) && checkPasswordSpecialChars(password);
    }

    public static String[] showPasswordProperties(String password) {
        String[] failureMessages = new String[4];
        if (checkPasswordLength(password)) {
            failureMessages[0] = "Richtig: Passwort enthält 10 oder mehr Zeichen.";
        } else {
            failureMessages[0] = "Falsch: Passwort enthält weniger als 10 Zeichen.";
        }
        if (checkIfPasswordIncludeNumber(password)) {
            failureMessages[1] = "Richtig: Passwort enthält mind. eine Zahl.";
        } else {
            failureMessages[1] = "Falsch: Passwort enthält keine Zahl.";
        }
        if (checkIfPasswordIncludeLowerUppercase(password)) {
            failureMessages[2] = "Richtig: Passwort enthält sowohl kleine als auch große Buchstaben.";
        } else {
            failureMessages[2] = "Falsch: Passwort enthält entweder nur kleine oder nur große Buchstaben.";
        }
        if (checkPasswordSpecialChars(password)) {
            failureMessages[3] = "Richtig: Passwort enthält keine Sonderzeichen.";
        } else {
            failureMessages[3] = "Falsch: Passwort enthält Sonderzeichen.";
        }

        return failureMessages;
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
