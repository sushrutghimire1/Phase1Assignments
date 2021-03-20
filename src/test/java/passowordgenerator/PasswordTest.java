package passowordgenerator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PasswordTest {
    private final PasswordGenerator passwordGenerator = new PasswordGeneratorImpl();

    @Test
    void shouldThrowErrorWhenNotValid() {
        String random = passwordGenerator.generatePassword();
        System.out.println(random);
        Assertions.assertTrue(passwordGenerator.isValidPassword(random));
    }
}
