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

	
	
}
