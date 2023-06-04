import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorGUI {
    private JFrame frame;
    private JTextField textField;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    CalculatorGUI window = new CalculatorGUI();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public CalculatorGUI() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 250, 350);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        textField = new JTextField();
        textField.setBounds(20, 10, 200, 30);
        frame.getContentPane().add(textField);
        textField.setColumns(10);

        // Creating number buttons and operations
        int bookX = 20;
        int bookY = 50;
        int bookW = 50;
        int bookH = 50;

        for (int i = 9; i >= 0; i--) {
            String buttonText = String.valueOf(i);

            JButton button = new JButton(buttonText);
            button.setBounds(bookX, bookY, bookW, bookH);
            frame.getContentPane().add(button);

            button.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    String existingText = textField.getText();
                    textField.setText(existingText + buttonText);
                }
            });

            bookX += 60;

            if (bookX >= 200) {
                bookX = 20;
                bookY += 60;
            }
        }

        // Adding operation buttons
        JButton addButton = new JButton("+");
        addButton.setBounds(20, 230, 50, 50);
        frame.getContentPane().add(addButton);

        // When operation button clicked, add it to the textField
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                textField.setText(textField.getText() + "+");
            }
        });

        JButton eqButton = new JButton("=");
        eqButton.setBounds(140, 230, 50, 50);
        frame.getContentPane().add(eqButton);

        // When equals button clicked, compute the result
        eqButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                computeResult();
            }
        });
    }

    private void computeResult() {
        String[] operation = textField.getText().split("\\+");
        if (operation.length == 2) {
            int num1 = Integer.parseInt(operation[0]);
            int num2 = Integer.parseInt(operation[1]);
            int result = num1 + num2;

            textField.setText(String.valueOf(result));
        } else {
            textField.setText("Error");
        }
    }
}
