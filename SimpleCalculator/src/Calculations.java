//packages



//imports
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

//Calculation class
public class Calculations {

    // display components for the calculator
    private final JTextArea historyField;
    private final JTextField textField;

    // numbers and operator storage
    private double num1 = 0, num2 = 0, result = 0;
    private char operator;


    private boolean justCalculated = false;
    private final StringBuilder history = new StringBuilder();

    public Calculations(JTextField textField, JTextArea historyField) {
        this.textField = textField;
        this.historyField = historyField;
    }

    public void handleAction(ActionEvent e) {
            String cmd = e.getActionCommand();

            if (cmd.matches("[0-9]")) {
                handleNumber(cmd);
                return;
            }

            switch (cmd) {
                case "." -> handleDecimal();
                case "+", "-", "*", "/" -> handleOperator(cmd.charAt(0));
                case "=" -> handleEquals();
                case "%" -> handlePercent();
                case "CLR" -> handleClear();
                case "DEL" -> handleDelete();
                case "POSNEG" -> handlePosNeg();
            }
        
    }

    // ---------------------------------
    //     HANDLER METHODS
    // ---------------------------------
    private void handleNumber(String num) {
        if (justCalculated) {
            textField.setText(num);
            history.setLength(0);
            history.append(num);
            justCalculated = false;
            updateHistory();
            return;
        }

        //appens the number to textfield and historyfield
        textField.setText(textField.getText() + num);
        history.append(num);
        updateHistory();
    }

    // adds decimal
    private void handleDecimal() {
        String current = textField.getText();
        if (!current.contains(".")) {
            textField.setText(current + ".");
            history.append(".");
            updateHistory();
        }
    }

    private void handleOperator(char op) {
        if (textField.getText().isEmpty()) return;

        num1 = Double.parseDouble(textField.getText());
        operator = op;
        history.append(" ").append(op).append(" ");
        updateHistory();
        textField.setText("");
        justCalculated = false; // reset flag
    }

    private void handleEquals() {
        if (textField.getText().isEmpty()) return;

        num2 = Double.parseDouble(textField.getText());
        result = calculate(num1, num2, operator);

        textField.setText(String.valueOf(result));
        history.append(" = ").append(result);
        updateHistory();

        num1 = result;
        justCalculated = true;
    }

    private void handlePercent() {
        if (textField.getText().isEmpty()) return;

        double value = Double.parseDouble(textField.getText()) / 100;
        textField.setText(String.valueOf(result));


        history.append("%");
        updateHistory();
       
    }

    private void handleDelete() {
        String current = textField.getText();
        if (!current.isEmpty()) {
            textField.setText(current.substring(0, current.length() - 1));
        }

        if (history.length() > 0) {
            history.deleteCharAt(history.length() - 1);
            updateHistory();
        }

        // prevents falling into the next case?
    }

    private void handlePosNeg() {
        if (textField.getText().isEmpty()) return;

        // flips the number
        double value = Double.parseDouble(textField.getText()) * -1;

        //updates the text field
        textField.setText(String.valueOf(value));

        //update history in place

        int lastIndex = history.length() - 1;

        //removes digits of the curren number at the end
        while (lastIndex >= 0 && (Character.isDigit(history.charAt(lastIndex)) || history.charAt(lastIndex) == '.')) {
            lastIndex--;
        }

        // keep everything before the number, then append the new signed number
        String before = history.substring(0, lastIndex + 1);
        history.setLength(0); // clear
        history.append(before).append(value); // append flipped number
        historyField.setText(history.toString()); // show in history
    }

    private void handleClear() {
        textField.setText("");
        history.setLength(0);
        updateHistory();
        num1 = num2 = result = 0;
        operator = '\0';
        justCalculated = false;
    }


    // ---------------------------------
    //     UTILITY METHODS
    // ---------------------------------

    private double calculate(double a, double b, char op) {
        return switch (op) {
            case '+' -> a + b;
            case '-' -> a - b;
            case '*' -> a * b;
            case '/' -> (b != 0) ? a / b : Double.NaN;
            default -> 0;
        };
    }

    private void updateHistory() {
        historyField.setText(history.toString());
    }

    private void updateHistoryFieldWithValue(double value) {
      String historyString = history.toString();
      int lastOperatorIndex = Math.max(
        Math.max(historyString.lastIndexOf('+'), historyString.lastIndexOf('-')),
        Math.max(historyString.lastIndexOf('*'), historyString.lastIndexOf('/'))
      );

      if (lastOperatorIndex == -1) {
          history.setLength(0);
          history.append(value);
      } else {
          String before = historyString.substring(0, lastOperatorIndex + 1);
          history.setLength(0);
          history.append(before).append(" ").append(value);
      }
      historyField.setText(history.toString());      
    }

}
