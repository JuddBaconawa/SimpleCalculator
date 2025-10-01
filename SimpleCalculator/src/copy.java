import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator implements ActionListener {

    // GUI
    JFrame frame;
    JTextArea historyField;
    JTextField textField;
    JPanel panel;

    // Buttons
    JButton[] numberButtons = new JButton[10];
    JButton[] functionButtons = new JButton[10];
    JButton addButton, subButton, multButton, divButton;
    JButton percentageButton, posNegButton, decButton, equButton, delButton, clrButton;

    // Fonts
    Font myFont = new Font("Open Sans", Font.BOLD, 40);
    Font displayPanelFont = new Font("Sans Serif", Font.BOLD, 25);
    Font historyDisplayPanelFont = new Font("Sans Serif", Font.BOLD, 20);

    // State
    double num1 = 0, num2 = 0, result = 0;
    char operator;
    StringBuilder history = new StringBuilder();

    Calculator() {
        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(new Color(2, 7, 11));
        frame.setSize(360, 575);
        frame.setLayout(null);

        // History field inside scroll pane
        historyField = new JTextArea();
        historyField.setFont(historyDisplayPanelFont);
        historyField.setBackground(new Color(2, 7, 11));
        historyField.setForeground(new Color(255, 153, 51));
        historyField.setEditable(false);
        historyField.setLineWrap(true);
        historyField.setWrapStyleWord(true);

        JScrollPane historyScroll = new JScrollPane(historyField);
        historyScroll.setBounds(0, 4, 344, 100);
        historyScroll.setBorder(BorderFactory.createEmptyBorder());

        // Result field
        textField = new JTextField();
        textField.setBounds(0, 99, 344, 60);
        textField.setFont(displayPanelFont);
        textField.setBackground(new Color(2, 7, 11));
        textField.setForeground(new Color(66, 217, 200));
        textField.setBorder(BorderFactory.createEmptyBorder());
        textField.setEditable(false);
        textField.setHorizontalAlignment(JTextField.RIGHT);

        // Create buttons
        addButton = createFunctionButton("+");
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

        // Put in functionButtons array for convenience
        functionButtons = new JButton[] {
            addButton, subButton, multButton, divButton,
            decButton, equButton, delButton, clrButton,
            percentageButton, posNegButton
        };

        // Number buttons
        for (int i = 0; i < 10; i++) {
            numberButtons[i] = createNumberButton(String.valueOf(i));
        }

        // Layout
        panel = new JPanel();
        panel.setBounds(10, 190, 325, 300);
        panel.setLayout(new GridLayout(5, 4, 20, 8));
        panel.setBackground(new Color(2, 7, 11));

        // Add buttons to panel
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

        // Add to frame
        frame.add(panel);
        frame.add(historyScroll);
        frame.add(textField);
        frame.setVisible(true);
    }

    private JButton createNumberButton(String text) {
        JButton btn = new RoundedButton(text, 15);
        btn.setFont(myFont);
        btn.setFocusable(false);
        btn.setBackground(new Color(3, 14, 21));
        btn.setForeground(new Color(151, 151, 151));
        btn.addActionListener(this);
        btn.setActionCommand(text);
        return btn;
    }

    private JButton createFunctionButton(String text) {
        JButton btn = new RoundedButton(text, 15);
        btn.setFont(new Font("Sans Serif", Font.BOLD, 18));
        btn.setBackground(new Color(255, 153, 51));
        btn.setForeground(new Color(6, 28, 41));
        btn.setFocusable(false);
        btn.addActionListener(this);
        return btn;
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
                    textField.setText("");
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
                    history.deleteCharAt(history.length() - 1);
                    historyField.setText(history.toString());
                }
                break;

            case "POSNEG":
                if (!textField.getText().isEmpty()) {
                    double value = Double.parseDouble(textField.getText()) * -1;
                    textField.setText(String.valueOf(value));
                }
                break;
        }
    }

    public static void main(String[] args) {
        new Calculator();
    }
}
