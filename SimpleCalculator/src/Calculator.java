// PACKAGES


// IMPORTS
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;



//main
public class Calculator extends JFrame implements ActionListener{

    // GUI components: Buttons for numbers and operations + text field
    // private final JFrame frame;
    private final JTextArea historyField;
    private final JTextField textField;
    private final JPanel panel;   // Panel to hold buttons in a grid layout

    // Logic Handler
    private final Calculations calc;

    private final JButton[] numberButtons = new JButton[10];    // numbers
    private final JButton[] functionButtons = new JButton[8];   //Arithmetic Symbols

    // declared for the arithmetix symbols
    private final JButton addButton, subButton, multButton, divButton;
    private final JButton decButton, equButton, delButton, clrButton;
    private final JButton posNegButton, percentageButton; 

    // Button labels for the calculator grid
    private static final String[] BUTTON_LABELS = {

        "CLR", "POSNEG", "%", "+",
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


    // Constructor for the Class of the same name
    Calculator() {

        // Frame setup
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(new Color(2, 7, 11));
        setSize(360, 575);
        setLayout(null);
        setVisible(true);

        // Text Field to display history and results 
        historyField = new JTextArea();
        historyField.setBounds(0, 4, 344, 100);
        historyField.setFont(historyDisplayPanelFont);
        historyField.setBackground(new Color(2, 7, 11));
        historyField.setBorder(BorderFactory.createEmptyBorder());
        historyField.setForeground(new Color(255, 153, 51));
        historyField.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        historyField.setEditable(false);
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

        // Logic Handler
        calc = new Calculations(textField, historyField);


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
        add(panel);
        add(historyField);
        add(textField);
        
        setVisible(true);

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
        // TODO Auto-generated method stub
        calc.handleAction(e);
    }


}