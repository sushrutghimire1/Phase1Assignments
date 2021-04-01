package passowordgenerator;

public enum Symbols {
    UNDERSCORE("_"),
    DOLLAR("$"),
    HASH("#"),
    PERCENTAGE("%");

    String symbol;

    Symbols(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }
}
