package equationprocessor;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class AllowedOperationTest {

    @Test
    void canInitValidOperators() {
        Assertions.assertAll("Validate Operators",
                () -> Assertions.assertEquals(AllowedOperation.MINUS, AllowedOperation.toOperator("-")),
                () -> Assertions.assertEquals(AllowedOperation.PLUS, AllowedOperation.toOperator("+")),
                () -> Assertions.assertEquals(AllowedOperation.POWER, AllowedOperation.toOperator("^")),
                () -> Assertions.assertEquals(AllowedOperation.DIVIDE, AllowedOperation.toOperator("/")),
                () -> Assertions.assertEquals(AllowedOperation.MULTIPLY, AllowedOperation.toOperator("*"))
        );
    }
}