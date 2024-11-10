
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Calculator extends JFrame implements ActionListener {

    private JTextField display;
    private double num1, num2, result;
    private char operator;

    public Calculator() {
        // Set up the frame
        setTitle("Calculator");
        setSize(400, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create display field
        display = new JTextField();
        display.setEditable(false);
        display.setFont(new Font("Arial", Font.BOLD, 28));
        display.setHorizontalAlignment(SwingConstants.RIGHT);
        add(display, BorderLayout.NORTH);

        // Create button panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(4, 4, 10, 10));

        // Define button labels
        String[] buttons = {
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "0", ".", "=", "+"
        };

        // Create and add buttons
        for (String text : buttons) {
            JButton button = new JButton(text);
            button.setFont(new Font("Arial", Font.BOLD, 24));
            button.addActionListener(this);
            buttonPanel.add(button);
        }

        add(buttonPanel, BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        if (command.charAt(0) >= '0' && command.charAt(0) <= '9' || command.equals(".")) {
            // If it's a number or a decimal point
            display.setText(display.getText() + command);
        } else if (command.equals("=")) {
            // Calculate result when '=' is pressed
            num2 = Double.parseDouble(display.getText());
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
                    if (num2 != 0) {
                        result = num1 / num2; 
                    }else {
                        display.setText("Error");
                        return;
                    }
                    break;
            }
            display.setText(String.valueOf(result));
            num1 = result; // For continued calculations
        } else {
            // Operator is clicked
            num1 = Double.parseDouble(display.getText());
            operator = command.charAt(0);
            display.setText("");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Calculator calc = new Calculator();
            calc.setVisible(true);
        });
    }
}
