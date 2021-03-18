package equationprocessor;



import equationprocessor.exceptions.DivideByZeroException;
import equationprocessor.exceptions.InvalidEquationException;

import java.util.*;

public class EquationCalculator {
    private final ArrayList<Character> operationList;
    private final Stack<Integer> operands;
    private final Stack<Character> operations;

    public EquationCalculator() {
        operands = new Stack<>();
        operations = new Stack<>();
        operationList = new ArrayList<>();
        operationList.add('+');
        operationList.add('-');
        operationList.add('*');
        operationList.add('/');
        operationList.add('^');
    }

    public double calculateEquation(String equation) {
        if (!isValidEquation(equation))
            throw new InvalidEquationException();
        String[] operands = equation.replaceAll("\\(|\\)", "").split("\\+|-|\\*|/|\\(|\\)|\\^");
        String replacedEquation = getEquationByReplacingVariables(operands, equation);
        return evaluateEquation(replacedEquation);
    }

    private String getEquationByReplacingVariables(String[] operands, String equation) {
        Scanner scanner = new Scanner(System.in);
        HashMap<String, Integer> map = new HashMap<>();
        for (String temp : operands) {
            if (!temp.matches("\\d+")) {
                map.put(temp, 0);
            }
        }
        map.forEach((key, value) -> {
            System.out.println("Enter the value of " + key + ":");
            map.put(key, scanner.nextInt());
        });
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            equation = equation.replaceAll(entry.getKey(), entry.getValue().toString());
        }
        return equation;
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
            } else if (eqn[i] == '(') {
                operations.push(eqn[i]);
            } else if (eqn[i] == ')') {
                while (operations.peek() != '(') {
                    performOperation();
                }
                operations.pop();
            } else if (operationList.contains(eqn[i])) {
                while (!operations.isEmpty() && getPrecedence(eqn[i]) <= getPrecedence(operations.peek())) {
                    performOperation();
                }
                operations.push(eqn[i]);
            }
        }
        while (!operations.isEmpty()) {
            performOperation();
        }
        return operands.pop();
    }


    private int getPrecedence(Character c) {
        if (c == '^')
            return 3;
        if (c == '*' || c == '/')
            return 2;
        if (c == '+' || c == '-')
            return 1;
        return 0;
    }

    private void performOperation() {
        int a = operands.pop();
        int b = operands.pop();
        char operation = operations.pop();
        if (operation == '+')
            operands.push(a + b);
        if (operation == '-')
            operands.push(b - a);
        if (operation == '*')
            operands.push(a * b);
        if (operation == '/') {
            if (a == 0)
                throw new DivideByZeroException();
            operands.push(b / a);
        }
        if (operation == '^') {
            operands.push((int) Math.pow(b, a));
        }
    }


    private boolean isValidEquation(String equation) {
        boolean previousIsOperator = false;
        if (equation == null)
            return false;
        char[] arr = equation.toCharArray();
        if (!Character.isDigit(arr[0]) && arr[0] != '(' && !Character.isLetter(arr[0]))
            return false;
        for (char a : arr) {
            if (Character.isDigit(a) || Character.isLetter(a) || a == '(' || a == ')')
                previousIsOperator = false;
            if (!operationList.contains(a) && !Character.isDigit(a) && !Character.isLetter(a) && a != '(' && a != ')')
                return false;
            else if (operationList.contains(a)) {
                if (previousIsOperator)
                    return false;
                previousIsOperator = true;
            }
        }
        return true;
    }

}
