package passowordgenerator;

import java.util.ArrayList;

public class PasswordGeneratorImpl implements PasswordGenerator {
    private ArrayList<Character> symbols = new ArrayList<>();
    private String generatedPassword;

    public PasswordGeneratorImpl() {
        symbols.add('_');
        symbols.add('$');
        symbols.add('#');
        symbols.add('%');
    }

    @Override
    public String generatePassword() {
        return "1234EE";
    }

    @Override
    public Boolean isValidPassword() {
        if (generatedPassword.length() != 6)
            return false;
        int numberOfDigits = 0;
        int numberOfUppercase = 0;
        int numberOfSymbols = 0;
        for (char c : generatedPassword.toCharArray()) {
            if (Character.isDigit(c)) {
                numberOfDigits++;
            }
            if (Character.isUpperCase(c)) {
                numberOfUppercase++;
            }
        }
        if (numberOfDigits != 4) {
            return false;
        }
        if (numberOfUppercase != 2) {
            return false;
        }
        for (Character symbol : symbols) {
            if (generatedPassword.contains(symbol.toString())) {
                numberOfSymbols++;
            }
        }
        if (numberOfSymbols != 2)
            return false;
        char[] passwordArray = generatedPassword.toCharArray();
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
