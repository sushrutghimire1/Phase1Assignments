package passowordgenerator;

public enum PasswordSpecification {

    NUMBERS(2),
    UPPERCASE(2),
    SYMBOLS(2);

    private final int number;

    PasswordSpecification(int number) {
        this.number = number;
    }

}
