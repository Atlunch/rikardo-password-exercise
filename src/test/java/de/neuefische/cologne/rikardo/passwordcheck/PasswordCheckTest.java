package de.neuefische.cologne.rikardo.passwordcheck;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class PasswordCheckTest {

    //Check Password Length
    @Test
    @DisplayName("Das Passwort enthält 10 Zeichen")
    public void testcheckPasswordLengthTrue(){
        String password = "aaaaaaaaaa";
        boolean result = PasswordCheck.checkPasswordLength(password);
        assertTrue(result);
    }
    @Test
    @DisplayName("Das Passwort hat nicht 10 Zeichen")
    public void testcheckPasswordLengthFalse(){
        String password = "aaaaaaaaa";
        boolean result = PasswordCheck.checkPasswordLength(password);
        assertFalse(result);
    }

    //Check If Password Include Number
    @Test
    @DisplayName("Das Passwort enthält eine Zahl")
    public void testcheckIfPasswordIncludeNumberTrue(){
        String password = "aaaaaaaaa1";
        boolean result = PasswordCheck.checkIfPasswordIncludeNumber(password);
        assertTrue(result);
    }
    @Test
    @DisplayName("Das Passwort enthält keine Zahl")
    public void testcheckIfPasswordIncludeNumberFalse(){
        String password = "aaaaaaaaaa";
        boolean result = PasswordCheck.checkIfPasswordIncludeNumber(password);
        assertFalse(result);
    }

    //Check If Password Include Lowercase and Uppercase
    @Test
    @DisplayName("Das Passwort muss sowohl große als auch kleine Buchstaben enthalten")
    public void testcheckIfPasswordIncludeLowerUppercaseTrue(){
        String password = "aaaaaaaaA";
        boolean result = PasswordCheck.checkIfPasswordIncludeLowerUppercase(password);
        assertTrue(result);
    }
    @Test
    @DisplayName("Das Passwort enthält nur kleine Buchstaben")
    public void testcheckIfPasswordIncludeOnlyLowercaseFalse(){
        String password = "aaaaaaaaa";
        boolean result = PasswordCheck.checkIfPasswordIncludeLowerUppercase(password);
        assertFalse(result);
    }
    @Test
    @DisplayName("Das Passwort enthält nur große Buchstaben")
    public void testcheckIfPasswordIncludeLOnlyUppercaseFalse(){
        String password = "AAAAAAAAAA";
        boolean result = PasswordCheck.checkIfPasswordIncludeLowerUppercase(password);
        assertFalse(result);
    }

    //Check if Password Include Special Chars

    @Test
    @DisplayName("Das Passwort enthält Sonderzeichen")
    public void testcheckPasswordSpecialCharsTrue(){
        String password = "AAAAAAAAAAA";
        boolean result = PasswordCheck.checkPasswordSpecialChars(password);
        assertTrue(result);
    }

    @Test
    @DisplayName("Das Passwort enthält keine Sonderzeichen")
    public void testcheckPasswordSpecialCharsFalse(){
        String password = ".;AAAAAAAAA";
        boolean result = PasswordCheck.checkPasswordSpecialChars(password);
        assertFalse(result);
    }

    //Check password

    @Test
    @DisplayName("Das Passwort ist korrekt")
    public void testcheckPasswordTrue(){
        String password = "a8sSHJeks821Sfsd";
        boolean result = PasswordCheck.checkPassword(password);
        assertTrue(result);
    }

    @Test
    @DisplayName("Das Passwort ist korrekt")
    public void testcheckPasswordFalse(){
        String password = "a8sSsa";
        boolean result = PasswordCheck.checkPassword(password);
        assertFalse(result);
    }


}