package equationprocessor;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class EquationHelperUtils {

    public static String refineEquationWithInput(String equation) {
        Scanner scanner = new Scanner(System.in);
        String[] operands = equation.replaceAll("\\(|\\)", "").split("\\+|-|\\*|/|\\(|\\)|\\^");
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

    public static boolean isValidEquation(String equation) {
        boolean previousIsOperator = false;
        if (equation == null)
            return false;
        char[] arr = equation.toCharArray();
        if (!Character.isDigit(arr[0]) && arr[0] != '(' && !Character.isLetter(arr[0]))
            return false;
        for (char a : arr) {
            if (Character.isDigit(a) || Character.isLetter(a) || a == '(' || a == ')')
                previousIsOperator = false;
            if (!AllowedOperation.isAllowedOperation(a) && !Character.isDigit(a) && !Character.isLetter(a) && a != '(' && a != ')')
                return false;
            else if (AllowedOperation.isAllowedOperation(a)) {
                if (previousIsOperator)
                    return false;
                previousIsOperator = true;
            }
        }
        return true;
    }

    public static int getPrecedence(Character c) {
        if (c == '(' || c == ')' || c == null) return 0;
        return AllowedOperation.toOperator(c.toString()).getPrecedence();
    }
}
