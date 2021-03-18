package equationprocessor;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String equation = sc.nextLine();
        EquationCalculator equationCalculator= new EquationCalculator();
        System.out.println("The result is:" + equationCalculator.calculateEquation(equation));
    }
}
