//packages


//imports
import java.util.Scanner;

//main class - App
public class App {


    //main method
    public static void main(String[] args) throws Exception {
        
        //scanner initialized
        Scanner scanner = new Scanner(System.in);

        //promts the user how the numbers and arithmetic expression is used within a formula
        System.out.println("Enter the first number + arithmetic symbol + second number = result");

        //prompt for the first number
        System.out.println("Enter the first number: ");
        double firstNumber = scanner.nextDouble();

        System.out.println("Enter the arithmetic operator: ");
        char arithmeticSymbol = scanner.next().charAt(0);

        //prompts the user to enter a value for the second number
        System.out.println("Enter the second number: ");
        double secondNumber = scanner.nextDouble();


        if (firstNumber.isEmpty && secondNumber.isEmpty) {
            System.out.println("Empty input! Try typing a number(s)");
        } else {

            

        }




    }
}
