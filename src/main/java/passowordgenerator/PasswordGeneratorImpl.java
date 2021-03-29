package passowordgenerator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class PasswordGeneratorImpl implements PasswordGenerator {
    final private ArrayList<Character> symbols = new ArrayList<>();

    public PasswordGeneratorImpl() {
        symbols.add('_');
        symbols.add('$');
        symbols.add('#');
        symbols.add('%');
    }

    @Override
    public String generatePassword() {
        int numberOfKeywords = 6;
        return randomizePassword(numberOfKeywords);
    }

    private String randomizePassword(int numberOfKeywords) {
        Random random = new Random();
        char[] password = new char[numberOfKeywords];
        HashMap<Integer, Character> map = new HashMap<>();
        for (PasswordSpecification passwordSpecification : PasswordSpecification.values()) {
            int randomNumber, nextPosition;
            do {
                randomNumber = random.nextInt(numberOfKeywords);
                nextPosition = randomNumber + 3 >= numberOfKeywords ? (randomNumber + 3) % numberOfKeywords : randomNumber + 3;
            }
            while (map.containsKey(randomNumber) || map.containsKey(nextPosition));

            if (passwordSpecification.equals(PasswordSpecification.SYMBOLS)) {
                String specialCharacters = "_$#%";
                map.put(randomNumber, specialCharacters.charAt(random.nextInt(specialCharacters.length())));
                map.put(nextPosition, specialCharacters.charAt(random.nextInt(specialCharacters.length())));
            }

            if (passwordSpecification.equals(PasswordSpecification.NUMBERS)) {
                String numbers = "1234567890";
                map.put(randomNumber, numbers.charAt(random.nextInt(numbers.length())));
                map.put(nextPosition, numbers.charAt(random.nextInt(numbers.length())));
            }

            if (passwordSpecification.equals(PasswordSpecification.UPPERCASE)) {
                String capitalCaseLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
                map.put(randomNumber, capitalCaseLetters.charAt(random.nextInt(capitalCaseLetters.length())));
                map.put(nextPosition, capitalCaseLetters.charAt(random.nextInt(capitalCaseLetters.length())));
            }

        }
        for (Map.Entry<Integer, Character> mapEntry : map.entrySet()) {
            password[mapEntry.getKey()] = mapEntry.getValue();
        }
        return String.valueOf(password);
    }


    @Override
    public Boolean isValidPassword(String password) {
        if (password.length() != 6)
            return false;
        Boolean x = containsValidElements(password);
        if (x != null) return x;
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

    private Boolean containsValidElements(String password) {
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
            char[] arr = password.toCharArray();
            for (int i = 0; i < password.length(); i++)
                if (arr[i] == symbol) {
                    numberOfSymbols++;
                }
        }
        if (numberOfSymbols != 2)
            return false;
        return null;
    }
}
