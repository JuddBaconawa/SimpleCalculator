// PACKAGES

// IMPORTS
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;



//main
public class Calculator implements ActionListener{

    // GUI components: Buttons for numbers and operations + text field
    JFrame frame;
    JTextField textField;

    // Arrays to hold number and function buttons
    JButton[] numberButtons = new JButton[10];
    JButton[] functionButtons = new JButton[8];

    // Function buttons: add, subtract, multiply, divide, decimal, equals, delete, clear
    JButton addButton, subButton, multButton, divButton;
    JButton decButton, equButton, delButton, clrButton;
    JPanel panel;

    // Creates and uses a custom font
    Font myFont = new Font("Ink Free", Font.BOLD, 30);

    // Variables to store the numbers
    double num1=0, num2=0, result=0;
    char operator;

    // Constructor for the Class of the same name
    Calculator() {

        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(450, 550);
        frame.setLayout(null);

        textField = new JTextField();
        textField.setBounds(50, 25, 300, 50);
        textField.setFont(myFont);
        textField.setEditable(false);       //so the user cant type in

        // text label for the buttons
        addButton = new JButton("+");
        subButton = new JButton("-");
        multButton = new JButton("*");
        divButton = new JButton("/");
        decButton = new JButton(".");
        equButton = new JButton("=");
        delButton = new JButton("Delete");
        clrButton = new JButton("Clear");

        // Add action listeners to the function buttons
        functionButtons[0] = addButton;
        functionButtons[1] = subButton;
        functionButtons[2] = multButton;
        functionButtons[3] = divButton;
        functionButtons[4] = decButton;
        functionButtons[5] = equButton;
        functionButtons[6] = delButton;
        functionButtons[7] = clrButton;
    

        frame.add(textField);
        frame.setVisible(true);

    }

    public static void main(String[] args) {
        
        Calculator calc = new Calculator();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
    }
}