package de.neuefische.cologne.rikardo.passwordcheck;

import java.lang.reflect.Array;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordCheck {

    public static void main(String[] args) {

        Scanner input_value = new Scanner(System.in);

        System.out.println("________________Passwort Validierungs Programm_______________________");
        System.out.println("|  Vorgefertige Passwörter verwenden oder neue Passwörter anlegen?  |");
        System.out.println("|  - [1] vorgefertige Passwörter validieren                         |");
        System.out.println("|  - [2] neues Passwort anlegen und anschließend validieren        |");
        System.out.println("_____________________________________________________________________");
        System.out.println("Bitte Zahl eingeben und bestätigen: ");

        int task = input_value.nextInt();

        switch (task) {
            case 1:
                String[] passwords = {"afsjgks","aksjdscswd","adsacsa214sad2s","Asfe23sasdSW","asd23adASD?!a..!2s"};
                System.out.println("Folgende Passwörte werde nun validiert" + " " + java.util.Arrays.toString(passwords));
                for (String s : passwords) {
                    System.out.println(s + " " + ":" + " " + checkPassword(s));
                }
                break;
            case 2:
                System.out.println("Passwort Regeln: mind. 10 Zeichen, a-z, A-Z, 0-9");
                System.out.println("Bitte Password eingeben: ");
                Scanner input_value2 = new Scanner(System.in);
                String password = input_value2.nextLine();
                System.out.println(checkPassword(password));
                String[] failureMessages = new String[4];
                failureMessages = showPasswordProperties(password);
                for (int i = 0; i < failureMessages.length; i++) {
                    System.out.println(failureMessages[i]);
                }
                break;

        }
    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
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
