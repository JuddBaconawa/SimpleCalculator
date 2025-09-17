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
    JButton[] numberButtons = new JButton[10];  // Numbers 0-9
    JButton[] functionButtons = new JButton[8]; // 8 function buttons

    // Function buttons: add, subtract, multiply, divide, decimal, equals, delete, clear
    JButton addButton, subButton, multButton, divButton;
    JButton decButton, equButton, delButton, clrButton, negButton;
    JPanel panel;   // Panel to hold buttons in a grid layout

    // Creates and uses a custom font
    Font myFont = new Font("Ink Free", Font.BOLD, 30);

    // Variables to store the numbers
    double num1=0, num2=0, result=0;
    char operator;

    // Constructor for the Class of the same name
    Calculator() {

        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // frame.setBackground(Color.CYAN);
        frame.getContentPane().setBackground(Color.CYAN);
        frame.setSize(450, 550);
        frame.setLayout(null);

        textField = new JTextField();
        textField.setBounds(50, 25, 350, 50);
        textField.setBackground(Color.CYAN);
        textField.setFont(myFont);
        // textField.setEditable(false);       //so the user cant type in
        textField.setHorizontalAlignment(JTextField.RIGHT); //text aligns to the right

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

        // =================Color Customization================
        // Arithmetic Symbol Buttons color
        addButton.setBackground(new Color(255, 153, 51));
        subButton.setBackground(new Color(255, 153, 51));
        multButton.setBackground(new Color(255, 153, 51));
        divButton.setBackground(new Color(255, 153, 51));

        // Number Buttons color
        

        // functionButtons.setBackground(new Color(255, 153, 51));


        // For loop to add action listeners
        for(int i=0; i<8; i++) {
            functionButtons[i].addActionListener(this);
            functionButtons[i].setFont(myFont); // use the custom font 
            functionButtons[i].setFocusable(false);
        }

        // For loop to create number buttons 0-9
        for(int i = 0; i<10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));  // convert int to string
            numberButtons[i].addActionListener(this);
            numberButtons[i].setFont(myFont);
            numberButtons[i].setFocusable(false);
        }

        // Set bounds for "delete" and "clear" buttons
        delButton.setBounds(50, 430, 145, 50);
        clrButton.setBounds(205, 430, 145, 50);

        // Create a panel to hold the buttons in a grid layout
        panel = new JPanel();
        panel.setBounds(50, 100, 350, 300);
        panel.setLayout(new GridLayout(4, 4, 10, 10));
        panel.setBackground(Color.WHITE);
        // panel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2)); // Add a border to the panel

        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(addButton);
        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(subButton);
        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(multButton);
        panel.add(decButton);
        panel.add(numberButtons[0]);
        panel.add(equButton);
        panel.add(divButton);



        // Add components to the frame
        frame.add(panel);
        frame.add(delButton);
        frame.add(clrButton);
        frame.add(textField);
        frame.setVisible(true);

    }

    public static void main(String[] args) {
        
        Calculator calc = new Calculator();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        for(int i=0; i<10; i++) {
            if(e.getSource() == numberButtons[i]) {
                textField.setText(textField.getText().concat(String.valueOf(i)));
            }
        }
        if(e.getSource() == decButton) {
            textField.setText(textField.getText().concat("."));
        }
        if(e.getSource() == addButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '+';
            textField.setText("");
        }
        if(e.getSource() == subButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '-';
            textField.setText("");
        }
        if(e.getSource() == multButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '*';
            textField.setText("");
        }
        if(e.getSource() == divButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '/';
            textField.setText("");
        }
        if(e.getSource() == equButton) {
            num2 = Double.parseDouble(textField.getText());
            switch (operator) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    result = num1 / num2;
                    break;
                }
                textField.setText(String.valueOf(result));
                num1 = result; // To continue the calculation with the result
        }
        if(e.getSource() == clrButton) {
            textField.setText("");
        }
        if(e.getSource() == delButton) {
            String string = textField.getText();
            textField.setText("");
            for(int i=0; i<string.length()-1; i++) {
                textField.setText(textField.getText()+string.charAt(i));
            }
        }


    }
}