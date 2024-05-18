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
		System.out.println("Hello! This is a simple calculator, type in your numbers and desired "
				+ "operation, or END as the operation to terminate the program.");
		System.out.print("Enter your first number: ");
		double first = sc.nextInt();
		System.out.print("Enter your second number: ");
		double second = sc.nextInt();
		System.out.print("Finally, enter the operation [+, -, *, /, ^, %]: ");
		String operation = sc.next();
		calculate(first, second, operation, sc);
	}
	
	private static void calculate(double first, double second, String operation, Scanner sc) {
		while(!operation.equals(END_COMMAND)) {
			double result = first;
			if (operation.equals("^")) {
				result = Math.pow(first, second);
			} else {
				if (operation.equals("+")) {
					result += second;
				}
				if (operation.equals("-")) {
					result -= second;
				}
				if (operation.equals("*")) {
					result *= second;
				}
				if (operation.equals("/")) {
					result /= second;
				}
				if (operation.equals("%")) {
					result %= second;
				}
				
				System.out.println("Result: " + result);
				System.out.print("Enter the second number: ");
				double newSec = sc.nextInt();
				System.out.print("Enter the new operation [+, -, *, /, ^, %]: ");
				String newOp = sc.next();
				calculate(result, newSec, newOp, sc);
			}
		}
		
		System.out.println("Terminated calculator.");
		
		
	}	
	
}


