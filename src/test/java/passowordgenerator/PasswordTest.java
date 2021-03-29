package passowordgenerator;


import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class PasswordTest {

    @Rule
    public RepeatRule repeatRule = new RepeatRule();

    private final PasswordGenerator passwordGenerator = new PasswordGeneratorImpl();

    @Test
    @RepeatRule.Repeat(times = 10)
    public void shouldThrowErrorWhenNotValid() {
        String random = passwordGenerator.generatePassword();
        System.out.println(random);
        assertTrue(passwordGenerator.isValidPassword(random));
    }
}
