package equationprocessor;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class EquationTest {

    @Test
    public void testSeparationOfInteger() {
        String equation1 = "31+5*6-7";
        String equation2 = "(32+5)*(6-7)";
        String equation3 = "(32+8)/(5+5)";
        String equation4 = "(32+8)^2";
        EquationCalculator equationCalculator = new EquationCalculator();
        Assertions.assertEquals(Double.valueOf(54), Double.valueOf(equationCalculator.calculateEquation(equation1)));
        Assertions.assertEquals(Double.valueOf(-37), Double.valueOf(equationCalculator.calculateEquation(equation2)));
        Assertions.assertEquals(Double.valueOf(4), Double.valueOf(equationCalculator.calculateEquation(equation3)));
        Assertions.assertEquals(Double.valueOf(1600), Double.valueOf(equationCalculator.calculateEquation(equation4)));
    }
}
