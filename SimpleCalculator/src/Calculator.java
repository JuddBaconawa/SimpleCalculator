// PACKAGES

// IMPORTS
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;



//main
public class Calculator implements ActionListener{

    // GUI components: Buttons for numbers and operations + text field
    JFrame frame;
    JTextArea historyField;
    JTextField textField;
    JPanel panel;   // Panel to hold buttons in a grid layout

    // Arrays to hold number and function buttons
    JButton[] numberButtons = new JButton[10];  // Numbers 0-9
    JButton[] functionButtons = new JButton[10]; // 8 function buttons

    // Function buttons: add, subtract, multiply, divide, decimal, equals, delete, clear
    JButton addButton, subButton, multButton, divButton;
    JButton percentageButton, posNegButton, decButton, equButton, delButton, clrButton, negButton;


    // Creates and uses a custom font
    Font myFont = new Font("Open Sans", Font.BOLD, 40);
    Font displayPanelFont = new Font("Sans Serif", Font.BOLD, 23);
    Font historyDisplayPanelFont = new Font("Sans Serif", Font.BOLD, 18);

    // Variables to store the numbers
    double num1=0, num2=0, result=0;
    char operator;
    StringBuilder history = new StringBuilder(); // To keep track of the calculation history

    // Constructor for the Class of the same name
    Calculator() {

        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(new Color(2, 7, 11));
        frame.setSize(360, 575);
        frame.setLayout(null);

        // Text Field to display history and results 
        historyField = new JTextArea();
        historyField.setBounds(0, 4, 344, 100);
        historyField.setFont(historyDisplayPanelFont);
        historyField.setBackground(new Color(2, 7, 11));
        historyField.setBorder(BorderFactory.createEmptyBorder());
        historyField.setForeground(new Color(255, 153, 51));
        historyField.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        historyField.setLineWrap(true);
        historyField.setWrapStyleWord(true);

        JScrollPane historyScroll = new JScrollPane(historyField);
        historyScroll.setBounds(0, 4, 344, 100);
        historyScroll.setBorder(BorderFactory.createEmptyBorder());

        textField = new JTextField();
        textField.setBounds(0, 99, 344, 60);
        textField.setFont(displayPanelFont);
        textField.setBackground(new Color(2, 7, 11));
        textField.setForeground(new Color(66, 217, 200));
        textField.setBorder(BorderFactory.createEmptyBorder());
        textField.setFont(displayPanelFont);
        textField.setEditable(false);       //so the user cant type in
        textField.setHorizontalAlignment(JTextField.RIGHT); //text aligns to the right

        // create and assign text label for the buttons
        addButton = createFunctionButton ("+");
        subButton = createFunctionButton("-");
        multButton = new RoundedButton("*");
        divButton = new RoundedButton("/", 15);
        decButton = new RoundedButton(".", 15);
        equButton = new RoundedButton("=", 15);
        delButton = new RoundedButton("C", 15);
        clrButton = new RoundedButton("A/C", 15);
        percentageButton = new RoundedButton("%", 15);
        posNegButton = new RoundedButton("-/+", 15);

        // Assign action commands
        addButton.setActionCommand("+");



        // Add action listeners to the function buttons
        functionButtons = new JButton[] {
            addButton, subButton, multButton, divButton,
            decButton, equButton, delButton, clrButton,
            percentageButton, posNegButton
        };


        // For loop to add action listeners
        for(int i=0; i<10; i++) {
            numberButtons[i] = createNumberButton(String.valueOf(i));
        }



        // For loop to create number buttons 0-9
        for(int i = 0; i<10; i++) {
            numberButtons[i] = createNumberButton(String.valueOf(i));  // convert int to string
        }

        // Create a panel to hold the buttons in a grid layout
        panel = new JPanel();
        panel.setBounds(10, 190, 325, 300);
        panel.setLayout(new GridLayout(5, 4, 20, 8));
        panel.setBackground(new Color(2, 7, 11));       // color of the panel

        // Add buttons to the panel in the desired order
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
        frame.add(historyField);
        frame.add(textField);
        frame.setVisible(true);

    }

    private JButton createNumberButton(String text) {
        JButton button = new RoundedButton(text, 15);
        button.setFont(myFont);
        button.setFocusable(false);
        button.setBackground(new Color(3, 14, 21));
        button.setForeground(new Color(151, 151, 151));
        button.addActionListener(this);
        button.setActionCommand(text);
        return button;

    }

    private JButton createFunctionButton(String text) {
        JButton button = new RoundedButton(text, 15);
        button.setFont(myFont);
        button.setBackground(new Color(255, 153, 51));
        button.setForeground(new Color(6, 28, 41));
        button.setFocusable(false);
        button.addActionListener(this);
        return button;

    }

    public static void main(String[] args) {
        
        new Calculator();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();


        // TODO Auto-generated method stub
        for(int i=0; i<10; i++) {
            if(e.getSource() == numberButtons[i]) {
                textField.setText(textField.getText().concat(String.valueOf(i)));
                historyField.setText(historyField.getText() + String.valueOf(i));
            }
        }
        if(e.getSource() == decButton) {
            textField.setText(textField.getText().concat("."));
            historyField.setText(historyField.getText().concat("."));
        }
        if(e.getSource() == addButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '+';
            historyField.setText(historyField.getText().concat(" + "));
            textField.setText("");
        }
        if(e.getSource() == subButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '-';
            textField.setText("");
            historyField.setText(historyField.getText().concat(" - "));
        }
        if(e.getSource() == multButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '*';
            historyField.setText(historyField.getText().concat(" * "));
            textField.setText(" ");
        }
        if(e.getSource() == divButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '/';
            textField.setText("");
            historyField.setText(historyField.getText().concat(" / "));
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
                historyField.setText(historyField.getText() + " = " + result);  // to show full expression
                num1 = result; // To continue the calculation with the result
        }
        if(e.getSource() == percentageButton) {
            double current = Double.parseDouble(textField.getText());
            current = current / 100;
            textField.setText(String.valueOf(current));
            historyField.setText(historyField.getText() + "%");
        }
        if(e.getSource() == clrButton) {
            textField.setText("");
            historyField.setText("");
            num1 = 0;
            num2 = 0;
            result = 0;
            operator = '\0'; // Reset operator  
        }
        if(e.getSource() == delButton) {
            String string = textField.getText();
            textField.setText("");
            for(int i=0; i<string.length()-1; i++) {
                textField.setText(textField.getText()+string.charAt(i));
                historyField.setText(historyField.getText()+string.charAt(i));
            }

            // Remove last character from historyField as well
            String hist = historyField.getText();
            if(hist.length() > 0) {
                historyField.setText(hist.substring(0, hist.length() - 1));
            }
        }
    }
}