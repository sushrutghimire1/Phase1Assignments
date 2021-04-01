package equationprocessor;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class AllowedOperationTest {

    @Test
    void canInitValidPlusOperator() {
        AllowedOperation allowedOperation = AllowedOperation.toOperator("-");
        Assertions.assertEquals(AllowedOperation.MINUS, allowedOperation);
    }
}