package passowordgenerator;

import java.util.ArrayList;
import java.util.Random;

public class PasswordGeneratorImpl implements PasswordGenerator {
    final private ArrayList<Character> symbols = new ArrayList<>();
    String capitalCaseLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    String specialCharacters = "_$#%";
    String numbers = "1234567890";

    public PasswordGeneratorImpl() {
        symbols.add('_');
        symbols.add('$');
        symbols.add('#');
        symbols.add('%');
    }

    @Override
    public String generatePassword() {
        Random random = new Random();
        String randomPassword = "";
        randomPassword += specialCharacters.charAt(random.nextInt(specialCharacters.length()));
        randomPassword += numbers.charAt(random.nextInt(numbers.length()));
        randomPassword += capitalCaseLetters.charAt(random.nextInt(capitalCaseLetters.length()));
        randomPassword += numbers.charAt(random.nextInt(numbers.length()));
        randomPassword += capitalCaseLetters.charAt(random.nextInt(capitalCaseLetters.length()));
        randomPassword += specialCharacters.charAt(random.nextInt(specialCharacters.length()));
        return randomPassword;
    }

    @Override
    public Boolean isValidPassword(String password) {
        if (password.length() != 6)
            return false;
        int numberOfDigits = 0;
        int numberOfUppercase = 0;
        int numberOfSymbols = 0;
        for (char c : password.toCharArray()) {
            if (Character.isDigit(c)) {
                numberOfDigits++;
            }
            if (Character.isUpperCase(c)) {
                numberOfUppercase++;
            }
        }
        if (numberOfDigits != 2) {
            return false;
        }
        if (numberOfUppercase != 2) {
            return false;
        }
        for (Character symbol : symbols) {
            if (password.contains(symbol.toString())) {
                numberOfSymbols++;
            }
        }
        if (numberOfSymbols != 2)
            return false;
        char[] passwordArray = password.toCharArray();
        for (int i = 0; i < passwordArray.length - 1; i++) {
            if (Character.isDigit(passwordArray[i]) && Character.isDigit(passwordArray[i + 1])) {
                return false;
            }
            if (Character.isUpperCase(passwordArray[i]) && Character.isUpperCase(passwordArray[i + 1])) {
                return false;
            }
            for (Character symbol : symbols) {
                if (passwordArray[i] == symbol && passwordArray[i + 1] == symbol) {
                    return false;
                }
            }
        }
        return true;
    }
}
