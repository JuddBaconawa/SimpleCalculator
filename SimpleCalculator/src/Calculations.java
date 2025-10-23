//packages



//imports
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

//Calculation class
public class Calculations {

    JTextArea historyField;
    JTextField textField;

    

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
