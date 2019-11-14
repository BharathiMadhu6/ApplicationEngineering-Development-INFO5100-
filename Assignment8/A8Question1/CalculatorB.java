package A8Question1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorB implements ActionListener {
    private JButton button1;
    private JLabel label1, label2, label3, label4;
    private JTextField textField1, textField2;
    private JComboBox operations;

    public static void main(String[] args) {
        CalculatorB calculatorb = new CalculatorB();
        calculatorb.run();
    }

    public void run() {
        JFrame frame = new JFrame();
        frame.setBackground(Color.black);
        label1 = new JLabel("Enter first number");
        label2 = new JLabel("Enter second number");
        label3 = new JLabel("Operation");
        label4 = new JLabel(" Result : ");
        button1 = new JButton("CALCULATE");
        textField1 = new JTextField(10);
        textField2 = new JTextField(10);
        operations = new JComboBox(new String[]{"+", "-", "/", "*"});
        JPanel panel = new JPanel();
        GridLayout grid = new GridLayout(5,1);
        panel.setLayout(grid);
        panel.setBackground(Color.pink);
        frame.getContentPane().add(panel);
        panel.add(label1);
        panel.add(textField1);
        panel.add(label2);
        panel.add(textField2);
        panel.add(label3);
        panel.add(operations);
        panel.add(button1);
        panel.add(label4);
        button1.addActionListener(this);
        frame.setSize(500,500);
        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent event) {
        int n1;
        int n2;
        n1 = Integer.parseInt(textField1.getText());
        n2 = Integer.parseInt(textField2.getText());
        String option = operations.getSelectedItem().toString();
        int result = calculate(n1, n2, option);
        label4.setText(" Result :"+ Integer.toString(result));
    }

    public int calculate(int n1, int n2, String option) {
        if(option.equals("+")) {
            return n1 + n2;
        }
        if(option.equals("-")) {
            return n1 - n2;
        }
        if(option.equals("*")) {
            return n1 * n2;
        }
        return n1 / n2;
    }
}
