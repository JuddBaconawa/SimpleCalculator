// PACKAGES

// IMPORTS
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;



//main
public class Calculator implements ActionListener{

    // GUI components: Buttons for numbers and operations + text field
    JFrame frame;
    JTextField historyField;
    JTextField textField;

    // Arrays to hold number and function buttons
    JButton[] numberButtons = new JButton[10];  // Numbers 0-9
    JButton[] functionButtons = new JButton[10]; // 8 function buttons

    // Function buttons: add, subtract, multiply, divide, decimal, equals, delete, clear
    JButton addButton, subButton, multButton, divButton;
    JButton percentageButton, posNegButton, decButton, equButton, delButton, clrButton, negButton;
    JPanel panel;   // Panel to hold buttons in a grid layout

    // Creates and uses a custom font
    Font myFont = new Font("Open Sans", Font.BOLD, 30);
    Font displayPanelFont = new Font("Sans Serif", Font.BOLD, 60);
    Font historyDisplayPanelFont = new Font("Sans Serif", Font.BOLD, 30);

    // Variables to store the numbers
    double num1=0, num2=0, result=0;
    char operator;

    // Constructor for the Class of the same name
    Calculator() {

        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // frame.setBackground(Color.CYAN);
        frame.getContentPane().setBackground(new Color(6, 28, 41));
        // frame.setBorder(1);
        frame.setSize(360, 575);
        frame.setLayout(null);

        // Text Field to display history and results 
        historyField = new JTextField();
        historyField.setBounds(0, 4, 344, 80);
        historyField.setFont(historyDisplayPanelFont);
        historyField.setBackground(new Color(6, 28, 41));
        historyField.setBorder(BorderFactory.createEmptyBorder());
        historyField.setForeground(new Color(255, 153, 51));
        historyField.setHorizontalAlignment(JTextField.RIGHT); //text aligns to the right
        historyField.setBorder(BorderFactory.createEmptyBorder(50, 0, 0, 0));

        // Text field to display numbers and results
        textField = new JTextField();
        textField.setBounds(0, 85, 344, 80);
        textField.setFont(displayPanelFont);
        textField.setBackground(new Color(6, 28, 41));
        textField.setForeground(new Color(66, 217, 200));
        textField.setBorder(BorderFactory.createEmptyBorder());
        textField.setFont(displayPanelFont);
        textField.setEditable(false);       //so the user cant type in
        textField.setHorizontalAlignment(JTextField.RIGHT); //text aligns to the right

        // text label for the buttons
        addButton = new RoundedButton("+", 15);
        subButton = new RoundedButton("-", 15);
        multButton = new RoundedButton("*", 15);
        divButton = new RoundedButton("/", 15);
        decButton = new RoundedButton(".", 15);
        equButton = new RoundedButton("=", 15);
        delButton = new RoundedButton("C", 15);
        clrButton = new RoundedButton("A/C", 15);
        percentageButton = new RoundedButton("%", 15);
        posNegButton = new RoundedButton("-/+", 15);



        // Add action listeners to the function buttons
        functionButtons[0] = addButton;
        functionButtons[1] = subButton;
        functionButtons[2] = multButton;
        functionButtons[3] = divButton;
        functionButtons[4] = decButton;
        functionButtons[5] = equButton;
        functionButtons[6] = delButton;
        functionButtons[7] = clrButton;
        functionButtons[8] = percentageButton;
        functionButtons[9] = posNegButton;


        // =================Color Customization================
        // Arithmetic Symbol Buttons color
        addButton.setBackground(new Color(255, 153, 51));
        addButton.setForeground(Color.white);
        subButton.setBackground(new Color(255, 153, 51));
        subButton.setForeground(Color.WHITE);
        multButton.setBackground(new Color(255, 153, 51));
        multButton.setForeground(new Color(44, 140, 153));
        divButton.setBackground(new Color(255, 153, 51));
        divButton.setForeground(new Color(66, 217, 200));
        

        // ================== Size Customization =================

        // Font
        clrButton.setFont(new Font("Sans Serif", Font.BOLD, 10));
        
        // equButton.setPreferredSize(new Dimension(160, 50));
        

        // functionButtons.setBackground(new Color(255, 153, 51));
        // panel.setBackground(new Color(151, 151, 151));


        // For loop to add action listeners
        for(int i=0; i<10; i++) {
            functionButtons[i].addActionListener(this);
            functionButtons[i].setFont(myFont); // use the custom font 
            functionButtons[i].setFocusable(false);
        }

        // For loop to create number buttons 0-9
        for(int i = 0; i<10; i++) {
            numberButtons[i] = new RoundedButton(String.valueOf(i), 15);  // convert int to string
            numberButtons[i].addActionListener(this);
            numberButtons[i].setFont(myFont);
            numberButtons[i].setFocusable(false);
            numberButtons[i].setBackground(new Color(40, 70, 75));
            numberButtons[i].setForeground(new Color(151, 151, 151));
        }

        // Set bounds for "delete" and "clear" buttons
        // delButton.setBounds(80, 480, 145, 50);
        // clrButton.setBounds(235, 480, 145, 50);

        // Create a panel to hold the buttons in a grid layout
        panel = new JPanel();
        panel.setBounds(5, 185, 335, 300);
        panel.setLayout(new GridLayout(5, 4, 1, 1));
        panel.setBackground(new Color(6, 28, 41));       // color of the panel
        // panel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2)); // Add a border to the panel

        panel.add(clrButton);
        panel.add(posNegButton);
        panel.add(percentageButton);
        panel.add(addButton);
        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(subButton);
        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(multButton);
        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(divButton);
        panel.add(decButton);
        panel.add(numberButtons[0]);
        panel.add(delButton);
        panel.add(equButton);
        
        



        // Add components to the frame
        frame.add(panel);
        // frame.add(delButton);
        // frame.add(clrButton);
        frame.add(historyField);
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