package passowordgenerator;


import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class PasswordTest {
    private final PasswordGenerator passwordGenerator = new PasswordGeneratorImpl();

    @Test
    public void shouldThrowErrorWhenNotValid() {
        String random = passwordGenerator.generatePassword();
        assertTrue(passwordGenerator.isValidPassword(random));
    }
}
