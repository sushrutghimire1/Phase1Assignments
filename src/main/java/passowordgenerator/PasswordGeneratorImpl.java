package passowordgenerator;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class PasswordGeneratorImpl implements PasswordGenerator {
    HashMap<Integer, Character> map;
    int numberOfKeywords = 6;

    public PasswordGeneratorImpl() {
        this.map = new HashMap<>();
    }

    @Override
    public String generatePassword() {
        char[] password = new char[numberOfKeywords];
        addRandomCharactersToMap(numberOfKeywords);
        for (Map.Entry<Integer, Character> mapEntry : map.entrySet())
            password[mapEntry.getKey()] = mapEntry.getValue();
        return String.valueOf(password);
    }

    private void addRandomCharactersToMap(int numberOfKeywords) {
        Random random = new Random();
        int firstPosition, secondPosition;
        for (PasswordCharacters passwordCharacters : PasswordCharacters.values()) {
            do {
                firstPosition = random.nextInt(numberOfKeywords);
                secondPosition = firstPosition + 3;
                secondPosition = secondPosition >= numberOfKeywords ? (secondPosition) % numberOfKeywords : secondPosition;
            }
            while (map.containsKey(firstPosition) || map.containsKey(secondPosition));

            if (passwordCharacters.equals(PasswordCharacters.SYMBOLS))
                putRandomCharacters(firstPosition, secondPosition, PasswordCharacters.SYMBOLS.getCharacters());
            if (passwordCharacters.equals(PasswordCharacters.NUMBERS))
                putRandomCharacters(firstPosition, secondPosition, PasswordCharacters.NUMBERS.getCharacters());
            if (passwordCharacters.equals(PasswordCharacters.ALPHABETS))
                putRandomCharacters(firstPosition, secondPosition, PasswordCharacters.ALPHABETS.getCharacters());
        }
    }

    private void putRandomCharacters(int firstPosition, int secondPosition, String givenChars) {
        Random random = new Random();
        map.put(firstPosition, givenChars.charAt(random.nextInt(givenChars.length())));
        map.put(secondPosition, givenChars.charAt(random.nextInt(givenChars.length())));
    }

    @Override
    public Boolean isValidPassword(String password) {
        if (password.length() != numberOfKeywords)
            return false;
        return containsValidElements(password);
    }

    private Boolean containsValidElements(String password) {
        int numberOfDigits = 0, numberOfUppercase = 0, numberOfSymbols = 0;
        for (char c : password.toCharArray()) {
            if (Character.isDigit(c))
                numberOfDigits++;
            else if (Character.isUpperCase(c))
                numberOfUppercase++;
            for (Symbols symbol : Symbols.values()) {
                if (c == symbol.getSymbol().charAt(0))
                    numberOfSymbols++;
            }
        }
        return numberOfDigits == 2 && numberOfUppercase == 2 && numberOfSymbols == 2;
    }
}
