package ch09;
import java.awt.*;
import java.awt.event.ActionListener;  // ActionListener 임포트
import javax.swing.*;

public class Calculator extends JFrame {

    JTextField display;
    JLabel history;
    JPanel panel;
    JButton button;
    double operand1 = 0.0, operand2 = 0.0;
    String operator = "";

    Calculator() {
        // 계산기 프레임 설정
        this.setBounds(100, 100, 300, 500);
        this.setTitle("계산기");
        this.setLayout(new BorderLayout());
        display = new JTextField(30);
        display.setText("0");
        display.setFont(new Font("궁서체", Font.BOLD, 35));
        display.setHorizontalAlignment( SwingConstants.RIGHT );
        this.add(display, BorderLayout.NORTH);

        // 버튼 패널 설정
        panel = new JPanel();
        panel.setLayout(new GridLayout(6,4));

        addButton("%", e -> display.setText(Double.parseDouble(display.getText()) / 100 + ""));
        addButton("CE", e -> display.setText("0"));
        addButton("C", e -> display.setText("0"));
        addButton("<-", e -> display.setText(display.getText().substring(0, display.getText().length() - 1)));
        addButton("1/x", e -> display.setText(1.0 / Double.parseDouble(display.getText()) + ""));
        addButton("x^2", e -> display.setText(Math.pow(Double.parseDouble(display.getText()), 2) + ""));
        addButton("sqrt", e -> display.setText(Math.sqrt(Double.parseDouble(display.getText())) + ""));
        addButton("/", e -> performOperation("/"));
        addNumberButton("7");
        addNumberButton("8");
        addNumberButton("9");
        addButton("*", e -> performOperation("*"));
        addNumberButton("4");
        addNumberButton("5");
        addNumberButton("6");
        addButton("-", e -> performOperation("-"));
        addNumberButton("1");
        addNumberButton("2");
        addNumberButton("3");
        addButton("+", e -> performOperation("+"));
        addButton("+/-", e -> display.setText(Double.parseDouble(display.getText()) * -1 + ""));
        addNumberButton("0");
        addButton(".", e -> {
            if (!display.getText().contains(".")) {
                display.setText(display.getText() + ".");
            }
        });
        addButton("=", e -> calculateResult());

        this.add(panel, BorderLayout.CENTER);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    private void addButton(String title, ActionListener listener) {
        button = new JButton(title);
        button.addActionListener(listener);
        panel.add(button);
    }

    private void addNumberButton(String number) {
        addButton(number, e -> {
            if (display.getText().equals("0")) {
                display.setText(number);
            } else {
                display.setText(display.getText() + number);
            }
        });
    }

    private void performOperation(String operation) {
        operand1 = Double.parseDouble(display.getText());
        display.setText("0");
        operator = operation;
    }

    private void calculateResult() {
        operand2 = Double.parseDouble(display.getText());
        double result = 0;
        switch (operator) {
            case "+":
                result = operand1 + operand2;
                break;
            case "-":
                result = operand1 - operand2;
                break;
            case "*":
                result = operand1 * operand2;
                break;
            case "/":
                result = operand1 / operand2;
                break;
        }
        display.setText(Double.toString(result));
    }

    public static void main(String[] args) {
        new Calculator();
    }
}
