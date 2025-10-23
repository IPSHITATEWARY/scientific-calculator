import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Stack;
import javax.swing.*;

public class ScientificCalculator extends JFrame implements ActionListener {
    private JTextField display;
    private StringBuilder input;

    public ScientificCalculator() {
        input = new StringBuilder();

        // Create the frame
        setTitle("Scientific Calculator");
        setSize(400, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Create display
        display = new JTextField();
        display.setEditable(false);
        display.setFont(new Font("Arial", Font.BOLD, 24));
        add(display, BorderLayout.NORTH);

        // Create buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(6, 4, 10, 10));

        String[] buttons = {
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "0", ".", "=", "+",
            "sin", "cos", "tan", "log",
            "sqrt", "(", ")", "C"
        };

        for (String text : buttons) {
            JButton button = new JButton(text);
            button.addActionListener(this);
            buttonPanel.add(button);
        }

        add(buttonPanel, BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        if (command.charAt(0) == 'C') {
            input.setLength(0);
            display.setText("");
        } else if (command.charAt(0) == '=') {
            try {
                double result = evaluate(input.toString());
                display.setText(String.valueOf(result));
                input.setLength(0);
            } catch (Exception ex) {
                display.setText("Error");
                input.setLength(0);
            }
        } else {
            input.append(command);
            display.setText(input.toString());
        }
    }

    private double evaluate(String expression) {
        // This is a very basic implementation of expression evaluation
        // You can replace this with a more robust expression parser if needed
        // Here we use a stack-based approach for simplicity

        // Handle basic operations and functions
        String[] tokens = expression.split(" ");
        Stack<Double> values = new Stack<>();
        Stack<String> ops = new Stack<>();

        for (String token : tokens) {
            if (isNumeric(token)) {
                values.push(Double.parseDouble(token));
            } else if (isOperator(token)) {
                while (!ops.isEmpty() && precedence(ops.peek()) >= precedence(token)) {
                    values.push(applyOp(ops.pop(), values.pop(), values.pop()));
                }
                ops.push(token);
            } else if (isFunction(token)) {
                double value = values.pop();
                values.push(applyFunction(token, value));
            }
        }

        while (!ops.isEmpty()) {
            values.push(applyOp(ops.pop(), values.pop(), values.pop()));
        }

        return values.pop();
    }

    private boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private boolean isOperator(String token) {
        return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/");
    }

    private boolean isFunction(String token) {
        return token.equals("sin") || token.equals("cos") || token.equals("tan") || token.equals("log") || token.equals("sqrt");
    }

    private int precedence(String op) {
        switch (op) {
            case "+":
            case "-":
                return 1;
            case "*":
            case "/":
                return 2;
            default:
                return 0;
        }
    }

    private double applyOp(String op, double b, double a) {
        switch (op) {
            case "+":
                return a + b;
            case "-":
                return a - b;
            case "*":
                return a * b;
            case "/":
                if (b == 0) throw new UnsupportedOperationException("Cannot divide by zero");
                return a / b;
        }
        return 0;
    }

private double applyFunction(String func, double value) {
        switch (func) {
            case "sin":
                return Math.sin(Math.toRadians(value));
            case "cos":
                return Math.cos(Math.toRadians(value));
                case "tan":
                return Math.tan(Math.toRadians(value));
            case "log":
                return Math.log(value);
            case "sqrt":
                return Math.sqrt(value);
        }
        return 0;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ScientificCalculator calculator = new ScientificCalculator();
            calculator.setVisible(true);
        });
    }
}
