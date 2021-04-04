package passowordgenerator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

public class PasswordTest {
    private final PasswordGenerator passwordGenerator = new SixDigitPasswordGenerator();

    @RepeatedTest(10)
    @DisplayName("Password validation Test")
    public void shouldThrowErrorWhenNotValid() {
        String random = passwordGenerator.generatePassword();
        System.out.println(random);
        Assertions.assertTrue(passwordGenerator.isValidPassword(random));
    }
}
