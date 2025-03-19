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
			//addition method case
			case '+':
				return calculations.add(firstNumber, secondNumber);
			//subtraction method case
			case '-':
				return calculations.subtract(firstNumber, secondNumber);
			//division method case
			case '/':	
				if (secondNumber == 0) {
					System.out.println("A number cannot be divided by a zero.");
					return 0;
				}
			//multip0lication method case
			case '*':
				return calculations.multiply(firstNumber, secondNumber);
			//other than before method case error catcher
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
			//first value prompt
			System.out.println("Enter the first number: ");
			double firstNumber = scanner.nextDouble();

			//arithmetic symbol input
			System.out.println("Enter an arithmetic expression: ");
			char arithmeticSymbol = scanner.next().charAt(0);

			//second value prompt
			System.out.println("Enter the second number's value: ");
			double secondNumber = scanner.nextDouble();

			//implements performCalculation method to solve the issue
			double result = performCalculations(firstNumber, arithmeticSymbol, secondNumber);
			System.out.println("Results: " + result);

			//prompts the user to either start another math problems or exit
			System.out.println("Perform another operation? (Yes/No)");
			String choice = scanner.next();
			if (!choice.equalsIgnoreCase("yes")) {
				System.out.println("Goodbye!");
				break;
			}
		}
	}
	
	
}
