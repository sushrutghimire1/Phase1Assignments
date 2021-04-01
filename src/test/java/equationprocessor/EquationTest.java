package equationprocessor;


import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class EquationTest {

    @Test
    public void testSeparationOfInteger() {
        String equation1 = "31+5*6-7";
        String equation2 = "(32+5)*(6-7)";
        String equation3 = "(32+8)/(5+5)";
        String equation4 = "(32+8)^2";
        EquationCalculator equationCalculator = new EquationCalculator();
        assertEquals(Double.valueOf(54), equationCalculator.calculateEquation(equation1));
        assertEquals(Double.valueOf(-37), equationCalculator.calculateEquation(equation2));
        assertEquals(Double.valueOf(4), equationCalculator.calculateEquation(equation3));
        assertEquals(Double.valueOf(1600), equationCalculator.calculateEquation(equation4));
    }
}
