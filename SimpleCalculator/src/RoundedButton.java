// PACKAGES

// IMPORTS


// Main  class
public class RoundedButton extends JButton {

    // Instance variable declaration
    private int radius;


    // Constructor for the Round
    public RoundedButton(String text, int radius) {
        super(text);
        this.radius = radius;
        setContentAreaFilled(false);
        setFocusPainted(false);

    }
}
