//package


//imports
import java.util.Scanner;

//class
public class UserService {

	private Scanner scanner;
	private Calculations calculations;

	public UserService() {
		this.scanner = new Scanner(System.in);
		this.calculations = new Calculations();
	}

	private double performCalculations(double firstNumber, char operator, double secondNumber) {
		switch (operator) {
			case '+':
				return calculations.add(firstNumber, secondNumber);
			case '-':
				return calculations.subtract(firstNumber, secondNumber);
			case '/':	
				if (secondNumber == 0) {
					System.out.println("A number cannot be divided by a zero.");
					return 0;
				}
			case '*':
				return calculations.multiply(firstNumber, secondNumber);
			default: 
				System.out.println("Invalid input!"); 
				return 0;
		}
	}


	public void startCalculator() {
		//prompt to tell user that they are using the calculator app
		System.out.println("Welcome to the calculator!");

		//while statement which prompts the user to input a first number, second number, and arithmetic symbol
		while (true) { 
			System.out.println("Enter the first number: ");
			double firstNumber = scanner.nextDouble();

			System.out.println("Enter an arithmetic expression: ");
			char arithmeticSymbol = scanner.next().charAt(0);

			System.out.println("Enter the second number's value: ");
			double secondNumber = scanner.nextDouble();

			double result = performCalculations(firstNumber, arithmeticSymbol, secondNumber);
			System.out.println("Results: " + result);

			System.out.println("Perform another operation? (Y/N)");
			String choice = scanner.next();
			if (!choice.equalsIgnoreCase("yes")) {
				System.out.println("Goodbye!");
				break;
			}
		}
	}
	
	
}
