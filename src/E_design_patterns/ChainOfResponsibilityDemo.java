package E_design_patterns;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class ChainOfResponsibilityDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        method0(scanner);
    }

    private static void method0(Scanner scanner) {
        try {
            method1(scanner);
        } catch (ArithmeticException e) {
            System.out.println("handling ArithmeticException in method0");
        }
    }

    private static void method1(Scanner scanner) {
        try {
            method2(scanner);
        } catch (NoSuchElementException e) {
            System.out.println("handling NoSucElementException in method 1");
        }
    }

    private static void method2(Scanner scanner) {
        try {
            method3(scanner);
        } catch (InputMismatchException e) {
            System.out.println("handling InputMismatchException in method2");
        }
    }

    // can throw InputMismatchException (if the data is not an int)
    // or NoSuchElementException (if the user entered Control-D, which indicates end of input)
    // ArithmeticException (if denominator is 0)
    private static void method3(Scanner scanner) {
        System.out.print("integer numerator: ");
        int numerator = scanner.nextInt();

        System.out.print("integer denominator: ");
        int denominator = scanner.nextInt();

        int quotient = numerator / denominator;
        System.out.println(quotient);
    }
}
