package equationprocessor;


import equationprocessor.exceptions.InvalidEquationException;

import java.util.Stack;

public class EquationCalculator {

    private final Stack<Integer> operands;
    private final Stack<Character> operations;

    public EquationCalculator() {
        operands = new Stack<>();
        operations = new Stack<>();
    }

    public double calculateEquation(String equation) {
        if (!EquationHelperUtils.isValidEquation(equation))
            throw new InvalidEquationException();
        return evaluateEquation(EquationHelperUtils.refineEquationWithInput(equation));
    }


    private double evaluateEquation(String equation) {
        char[] eqn = equation.toCharArray();
        for (int i = 0; i < eqn.length; i++) {
            if (Character.isDigit(eqn[i])) {
                int num = 0;
                while (Character.isDigit(eqn[i])) {
                    num = num * 10 + (Integer.parseInt(Character.toString(eqn[i])));
                    i++;
                    if (i >= eqn.length)
                        break;
                }
                i--;
                operands.push(num);
            } else if (eqn[i] == '(')
                operations.push(eqn[i]);
            else if (eqn[i] == ')') {
                while (operations.peek() != '(')
                    performOperation();
                operations.pop();
            } else if (AllowedOperation.isAllowedOperation(eqn[i])) {
                while (!operations.isEmpty() && EquationHelperUtils.getPrecedence(eqn[i])
                        <= EquationHelperUtils.getPrecedence(operations.peek()))
                    performOperation();
                operations.push(eqn[i]);
            }
        }
        performFinalEvaluation();
        return operands.pop();
    }

    private void performFinalEvaluation() {
        while (!operations.isEmpty())
            performOperation();
    }

    private void performOperation() {
        int a = operands.pop();
        int b = operands.pop();
        operands.push(AllowedOperation.toOperator(operations.pop().toString()).apply(a, b));
    }

}
