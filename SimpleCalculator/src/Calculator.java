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
        addButton.setForeground(new Color (6, 28, 41));
        subButton.setBackground(new Color(255, 153, 51));
        subButton.setForeground(new Color(6, 28, 41));
        multButton.setBackground(new Color(255, 153, 51));
        multButton.setForeground(new Color(6, 28, 41));
        divButton.setBackground(new Color(255, 153, 51));
        divButton.setForeground(new Color(6, 28, 41));
        equButton.setBackground(new Color(255, 153, 51));
        equButton.setForeground(new Color(6, 28, 41));
        

        // ================== Size Customization =================

        // Font

        
        // equButton.setPreferredSize(new Dimension(160, 50));
        

        // functionButtons.setBackground(new Color(255, 153, 51));
        // panel.setBackground(new Color(151, 151, 151));


        // For loop to add action listeners
        for(int i=0; i<10; i++) {
            functionButtons[i].addActionListener(this);
            functionButtons[i].setFont(myFont); // use the custom font 
            functionButtons[i].setFocusable(false);
            functionButtons[i].setBackground(new Color(6, 28, 41));
            functionButtons[i].setForeground(new Color(151, 151, 151));
        }


        // =================Color Customization================
        // Arithmetic Symbol Buttons color
        addButton.setBackground(new Color(255, 153, 41));
        addButton.setForeground(new Color (6, 28, 41));
        subButton.setBackground(new Color(255, 153, 41));
        subButton.setForeground(new Color(6, 28, 41));
        multButton.setBackground(new Color(255, 153, 41));
        multButton.setForeground(new Color(6, 28, 41));
        divButton.setBackground(new Color(255, 153, 51));
        divButton.setForeground(new Color(6, 28, 41));
        equButton.setBackground(new Color(255, 153, 51));
        equButton.setForeground(new Color(6, 28, 41));

        // For loop to create number buttons 0-9
        for(int i = 0; i<10; i++) {
            numberButtons[i] = new RoundedButton(String.valueOf(i), 15);  // convert int to string
            numberButtons[i].addActionListener(this);
            numberButtons[i].setFont(myFont);
            numberButtons[i].setFocusable(false);
            numberButtons[i].setBackground(new Color(3, 14, 21));
            numberButtons[i].setForeground(new Color(151, 151, 151));
        }

        // Clear Button font size change
        clrButton.setFont(new Font("Sans Serif", Font.BOLD, 18));
        posNegButton.setFont(new Font("Sans Serif", Font.BOLD, 18));
        percentageButton.setFont(new Font("Sans Serif", Font.BOLD, 18));

        // Set bounds for "delete" and "clear" buttons
        // delButton.setBounds(80, 480, 145, 50);
        // clrButton.setBounds(235, 480, 145, 50);

        // Create a panel to hold the buttons in a grid layout
        panel = new JPanel();
        panel.setBounds(10, 190, 325, 300);
        panel.setLayout(new GridLayout(5, 4, 20, 8));
        panel.setBackground(new Color(2, 7, 11));       // color of the panel
        // panel.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2)); // Add a border to the panel

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