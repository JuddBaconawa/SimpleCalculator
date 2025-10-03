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
    Font arithmeticFont = new Font("Sans Serif", Font.BOLD, 18);
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
        multButton = createFunctionButton("*");
        divButton = createFunctionButton("/");
        decButton = createFunctionButton(".");
        equButton = createFunctionButton("=");
        delButton = createFunctionButton("C");
        clrButton = createFunctionButton("A/C");
        percentageButton = createFunctionButton("%");
        posNegButton = createFunctionButton("-/+");

        // Assign action commands
        addButton.setActionCommand("+");
        subButton.setActionCommand("-");
        multButton.setActionCommand("*");
        divButton.setActionCommand("/");
        decButton.setActionCommand(".");
        equButton.setActionCommand("=");
        delButton.setActionCommand("DEL");
        clrButton.setActionCommand("CLR");
        percentageButton.setActionCommand("%");
        posNegButton.setActionCommand("POSNEG");


        // Add action listeners to the function buttons
        functionButtons = new JButton[] {
            addButton, subButton, multButton, divButton,
            decButton, equButton, delButton, clrButton,
            percentageButton, posNegButton
        };


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
        button.setFont(arithmeticFont);
        button.setBackground(new Color(255, 153, 51));
        button.setForeground(new Color(6, 28, 41));
        button.setFocusable(false);
        button.addActionListener(this);
        return button;

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();

        switch (cmd) {
            case "0": case "1": case "2": case "3": case "4":
            case "5": case "6": case "7": case "8": case "9":
                textField.setText(textField.getText() + cmd);
                history.append(cmd);
                historyField.setText(history.toString());
                break;

            case ".":
                if (!textField.getText().contains(".")) {
                    textField.setText(textField.getText() + ".");
                    history.append(".");
                    historyField.setText(history.toString());
                }
                break;
            
            case "+": case "-": case "*": case "/":
                if (!textField.getText().isEmpty()) {
                    num1 = Double.parseDouble(textField.getText());
                    operator = cmd.charAt(0);
                    history.append(" " + cmd + " ");
                    historyField.setText(history.toString());
                    textField.setText(" ");
                }
                break;

            case "=":
                if (!textField.getText().isEmpty()) {
                    num2 = Double.parseDouble(textField.getText());
                    switch (operator) {
                        case '+': result = num1 + num2; break;
                        case '-': result = num1 - num2; break;
                        case '*': result = num1 * num2; break;
                        case '/': 
                            if (num2 == 0) {
                                textField.setText("Error");
                                return;
                            }
                            result = num1 / num2; break;
                    }
                    textField.setText(String.valueOf(result));
                    history.append(" = " + result);
                    historyField.setText(history.toString());
                    num1 = result; // Continue chaining
                }
                break;

            case "%":
                if (!textField.getText().isEmpty()) {
                    double current = Double.parseDouble(textField.getText()) / 100;
                    textField.setText(String.valueOf(current));
                    history.append("%");
                    historyField.setText(history.toString());
                }
                break;

            case "CLR":
                textField.setText("");
                history.setLength(0);
                historyField.setText("");
                num1 = num2 = result = 0;
                operator = '\0';
                break;

            case "DEL":
                String current = textField.getText();
                if (!current.isEmpty()) {
                    textField.setText(current.substring(0, current.length() - 1));
                }
                if (history.length() > 0) {
                    history.deleteCharAt(history.length() -1);
                    historyField.setText(history.toString());
                }

            case "POSNEG":
                if (!textField.getText().isEmpty()) {
                    double value = Double.parseDouble(textField.getText());
                    textField.setText(String.valueOf(value));

                    // Update History
                    String historyString = history.toString();
                    int lastOperatorIndex = Math.max(
                        Math.max(historyString.lastIndexOf('+'), historyString.lastIndexOf('-')),
                        Math.max(historyString.lastIndexOf('*'), historyString.lastIndexOf('/'))
                    );

                    if (lastOperatorIndex == -1) {
                        // No operator found, toggle the entire number into this number
                        history.setLength(0);
                        history.append(value);
                    } else {
                        //replace the last number part
                        String before = historyString.substring(0, lastOperatorIndex + 1);
                        history.setLength(0);
                        history.append(before).append(" ").append(value);
                    }

                    historyField.setText(history.toString());
                }
                break;
                
        }

    }

}