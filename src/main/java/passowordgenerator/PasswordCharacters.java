package passowordgenerator;

public enum PasswordCharacters {
    ALPHABETS("ABCDEFGHIJKLMNOPQRSTUVWXYZ"),
    NUMBERS("1234567890"),
    SYMBOLS(PasswordCharacters.getSymbols());

    private final String characters;

    PasswordCharacters(String characters) {
        this.characters = characters;
    }

    public static String getSymbols() {
        StringBuilder symbols = new StringBuilder();
        for (Symbols symbol : Symbols.values()) {
            symbols.append(symbol.getSymbol());
        }
        return symbols.toString();
    }

    public String getCharacters() {
        return characters;
    }
}
