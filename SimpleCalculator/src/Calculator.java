// PACKAGES


// IMPORTS
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;



//main
public class Calculator extends JFrame implements ActionListener{

    // GUI components: Buttons for numbers and operations + text field
    private final JFrame frame;
    private final JTextArea historyField;
    private final JTextField textField;
    private final JPanel panel;   // Panel to hold buttons in a grid layout

    // Logic Handler
    private final Calculations calc;

    // Button labels for the calculator grid
    private static final String[] BUTTON_LABELS = {
        "CLR", "%", "POSNEG", "+",
        "1", "2", "3", "-",
        "4", "5", "6", "*",
        "7", "8", "9", "/",
        ".", "0", "=", "DEL"
    };




    // Creates and uses a custom font
    Font myFont = new Font("Open Sans", Font.BOLD, 40);
    Font arithmeticFont = new Font("Sans Serif", Font.BOLD, 18);
    Font displayPanelFont = new Font("Sans Serif", Font.BOLD, 23);
    Font historyDisplayPanelFont = new Font("Sans Serif", Font.BOLD, 18);

    // Variables to store the numbers
    // double num1=0, num2=0, result=0;
    // char operator;
    // boolean justCalculated = false; //flags
    Calculations calculations = new Calculations();
    StringBuilder history = new StringBuilder(); // To keep track of the calculation history

    // Constructor for the Class of the same name
    Calculator() {

        // frame = new JFrame("Calculator");
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.getContentPane().setBackground(new Color(2, 7, 11));
        this.frame.setSize(360, 575);
        this.frame.setLayout(null);
        this.frame.setVisible(true);

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
        textField.setBounds(0, 104, 344, 60);
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


}