package passowordgenerator;

public enum PasswordCharacters {
    ALPHABETS("ABCDEFGHIJKLMNOPQRSTUVWXYZ"),
    NUMBERS("1234567890"),
    SYMBOLS("_$#%");

    private final String characters;

    PasswordCharacters(String characters) {
        this.characters = characters;
    }

    public String getCharacters() {
        return characters;
    }
}
