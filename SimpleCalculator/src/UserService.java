//package


//imports
import java.io.Console;
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
			case '+':	return Calculations.add(firstNumber, secondNumber);
				break;
			case '-':	return Calculations.subtract(firstNumber, secondNumber);
				break;
			case '/':	return Calculations.divide(firstNumber, secondNumber);
				if (secondNumber == 0) {
					System.out.println("A number cannot be divided by a zero.");
					return 0;
					break;
				}
			case '*': return calculations.multiply(firstNumber, secondNumber);
				break;
			default: System.out.println("Invalid input!"); break;
		}
	}
	
}
