package simpleCalculator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Calculator {
    
    public static final ArrayList<String> OPERATORS = 
            new ArrayList<>(Arrays.asList("+", "-", "*", "/", "%", "^"));
    public static final String END_COMMAND = "END";
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Hello! This is a simple calculator. Type in your numbers and desired "
                + "operation, or END as the operation to terminate the program.");
        System.out.print("Enter your first number: ");
        double first = sc.nextDouble();
        System.out.print("Enter your second number: ");
        double second = sc.nextDouble();
        System.out.print("Finally, enter the operation [+, -, *, /, ^, %]: ");
        String operation = sc.next();
        while (!OPERATORS.contains(operation) && !operation.equals(END_COMMAND)) {
            System.out.println("Invalid operation. Please enter a valid operation [+, -, *, /, ^, %]: ");
            operation = sc.next();
        }
        calculate(first, second, operation, sc);
    }
    
    private static void calculate(double first, double second, String operation, Scanner sc) {
        while (!operation.equals(END_COMMAND)) {
            double result = first;
            if (operation.equals("^")) {
                result = Math.pow(first, second);
            } else if (operation.equals("+")) {
                result += second;
            } else if (operation.equals("-")) {
                result -= second;
            } else if (operation.equals("*")) {
                result *= second;
            } else if (operation.equals("/")) {
                result /= second;
            } else if (operation.equals("%")) {
                result %= second;
            } else {
                System.out.println("Invalid operation.");
                continue;
            }
            
            System.out.println("Result: " + result);
            System.out.print("Enter the next number: ");
            double newSec = sc.nextDouble();
            System.out.print("Enter the new operation [+, -, *, /, ^, %] or END to terminate: ");
            String newOp = sc.next();
            //check for the valid operator
            while (!OPERATORS.contains(newOp) && !newOp.equals(END_COMMAND)) {
                System.out.println("Invalid operation. Please enter a valid operation [+, -, *, /, ^, %]: ");
                newOp = sc.next();
            }
            first = result;
            second = newSec;
            operation = newOp;
        }
        
        System.out.println("Terminated calculator.");
    }   
}
