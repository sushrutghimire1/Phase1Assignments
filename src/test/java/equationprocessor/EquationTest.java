package equationprocessor;


import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import static org.junit.Assert.assertEquals;

public class EquationTest {

    private final EquationCalculator equationCalculator;

    public EquationTest() {
        equationCalculator = new EquationCalculator();
    }

    @Test
    public void testValidationOfEquation() {
        String equation1 = "31+5*6-7";
        String equation2 = "(32+5)*(6-7)";
        String equation3 = "(32+8)/(5+5)";
        String equation4 = "(32+8)^2";
        Assertions.assertAll("validation Of Equation",
                () -> Assertions.assertTrue(EquationHelperUtils.isValidEquation(equation1)),
                () -> Assertions.assertTrue(EquationHelperUtils.isValidEquation(equation2)),
                () -> Assertions.assertTrue(EquationHelperUtils.isValidEquation(equation3)),
                () -> Assertions.assertTrue(EquationHelperUtils.isValidEquation(equation4)));
    }

    @Test
    public void testPrecedenceOfOperator() {
        Assertions.assertAll("validation Of Precedence",
                () -> Assertions.assertEquals(EquationHelperUtils.getPrecedence('('), 0),
                () -> Assertions.assertEquals(EquationHelperUtils.getPrecedence(')'), 0),
                () -> Assertions.assertEquals(EquationHelperUtils.getPrecedence('+'), 1),
                () -> Assertions.assertEquals(EquationHelperUtils.getPrecedence('-'), 1),
                () -> Assertions.assertEquals(EquationHelperUtils.getPrecedence('*'), 2),
                () -> Assertions.assertEquals(EquationHelperUtils.getPrecedence('/'), 2),
                () -> Assertions.assertEquals(EquationHelperUtils.getPrecedence('^'), 3)
                );
    }

    @Test
    public void testOverallCalculationOfEquation() {
        String equation1 = "31+5*6-7";
        String equation2 = "(32+5)*(6-7)";
        String equation3 = "(32+8)/(5+5)";
        String equation4 = "(32+8)^2";
        Assertions.assertAll("Overall Calculation Of Equation",
                () -> assertEquals(Double.valueOf(54), equationCalculator.calculateEquation(equation1)),
                () -> assertEquals(Double.valueOf(-37), equationCalculator.calculateEquation(equation2)),
                () -> assertEquals(Double.valueOf(4), equationCalculator.calculateEquation(equation3)),
                () -> assertEquals(Double.valueOf(1600), equationCalculator.calculateEquation(equation4)));
    }
}
