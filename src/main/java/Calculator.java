//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//
//public class Calculator implements ActionListener {
//    JFrame frame;
//    JPanel panel;
//    JTextField textField;
//    Font font = new Font("Monospaced", Font.BOLD, 25);
//
//    JButton[] numberBtns = new JButton[10];
//    JButton[] functionBtns = new JButton[12];
//    JButton addBtn, subBtn, mulBtn, divBtn, sqrBtn, sqrtBtn, powertBtn, eqBtn, clrBtn, dotBtn, delBtn, negBtn;
//
//    double num1 = 0, num2 = 0, result = 0;
//    char operator;
//
//    public Calculator() {
//        frame = new JFrame("Calculator");
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setSize(450, 600);
//        frame.setLayout(null);
//
//        textField = new JTextField();
//        textField.setBounds(10, 10, 415, 80);
//        textField.setFont(font);
//        textField.setEditable(true);
//
//        addBtn = new JButton("+");
//        subBtn = new JButton("-");
//        mulBtn = new JButton("*");
//        divBtn = new JButton("/");
//        sqrBtn = new JButton("x^2");
//        sqrtBtn = new JButton("sqrt");
//        powertBtn = new JButton("x^y");
//        eqBtn = new JButton("=");
//        clrBtn = new JButton("C");
//        dotBtn = new JButton(".");
//        delBtn = new JButton("<-");
//        negBtn = new JButton("+/-");
//
//        functionBtns[0] = addBtn;
//        functionBtns[1] = subBtn;
//        functionBtns[2] = mulBtn;
//        functionBtns[3] = divBtn;
//        functionBtns[4] = sqrBtn;
//        functionBtns[5] = sqrtBtn;
//        functionBtns[6] = eqBtn;
//        functionBtns[7] = delBtn;
//        functionBtns[8] = clrBtn;
//        functionBtns[9] = powertBtn;
//        functionBtns[10] = negBtn;
//        functionBtns[11] = dotBtn;
//
//
//
//        for (JButton functionBtn : functionBtns) {
//            functionBtn.addActionListener(this);
//            functionBtn.setFont(font);
//            functionBtn.setFocusable(false);
//        }
//
//        for (int i=0; i<10;i++) {
//            numberBtns[i] = new JButton(String.valueOf(i));
//            numberBtns[i].addActionListener(this);
//            numberBtns[i].setFont(font);
//            numberBtns[i].setFocusable(false);
//        }
//
//        panel = new JPanel();
//        panel.setBounds(10, 215, 415, 330);
//        panel.setLayout(new GridLayout(5, 4, 5, 5));
//
//        panel.add(powertBtn);
//        panel.add(sqrBtn);
//        panel.add(sqrtBtn);
//        panel.add(divBtn);
//        panel.add(numberBtns[7]);
//        panel.add(numberBtns[8]);
//        panel.add(numberBtns[9]);
//        panel.add(mulBtn);
//        panel.add(numberBtns[4]);
//        panel.add(numberBtns[5]);
//        panel.add(numberBtns[6]);
//        panel.add(subBtn);
//        panel.add(numberBtns[1]);
//        panel.add(numberBtns[2]);
//        panel.add(numberBtns[3]);
//        panel.add(addBtn);
//        panel.add(negBtn);
//        panel.add(numberBtns[0]);
//        panel.add(dotBtn);
//        panel.add(eqBtn);
//
//        clrBtn.setBounds(220,150, 100, 60);
//        delBtn.setBounds(325,150, 100, 60);
//
//        frame.add(panel);
//        frame.add(textField);
//        frame.add(clrBtn);
//        frame.add(delBtn);
//
//        frame.setVisible(true);
//    }
//
//    @Override
//    public void actionPerformed(ActionEvent e) {
//        for (int i=0; i<10;i++) {
//            if (e.getSource() == numberBtns[i]) {
//                textField.setText(textField.getText().concat(String.valueOf(i)));
//            }
//        }
//
//        if (e.getSource() == dotBtn) {
//            if (!textField.getText().contains(".")) textField.setText(textField.getText().concat(".")); // check if the textfield already contains a decimal point
//        }
//
//        if (e.getSource() == addBtn) {
//            num1 = Double.parseDouble(textField.getText());
//            operator = '+';
//            textField.setText("");
//        }
//
//        if (e.getSource() == subBtn) {
//            num1 = Double.parseDouble(textField.getText());
//            operator = '-';
//            textField.setText("");
//        }
//
//        if (e.getSource() == mulBtn) {
//            num1 = Double.parseDouble(textField.getText());
//            operator = '*';
//            textField.setText("");
//        }
//
//        if (e.getSource() == divBtn) {
//            num1 = Double.parseDouble(textField.getText());
//            operator = '/';
//            textField.setText("");
//        }
//
//        if (e.getSource() == sqrBtn) {
//            num1 = Double.parseDouble(textField.getText());
//
//            operator = '~';
//            textField.setText("");
//
//            System.out.println(num1 + " " + operator + " " + num2);
//        }
//
//        if (e.getSource() == sqrtBtn) {
//            num1 = Double.parseDouble(textField.getText());
//            operator = 'v';
//            textField.setText("");
//        }
//
//        if (e.getSource() == powertBtn) {
//            num1 = Double.parseDouble(textField.getText());
//            operator = '^';
//            textField.setText("");
//        }
//
//        if (e.getSource() == eqBtn) {
//            if (operator != 'v' && operator != '~') {
//                num2 = Double.parseDouble(textField.getText());
//            }
//            result = calculation(num1, num2, operator);
//            textField.setText(String.valueOf(result));
//            num1 = result;
//            System.out.println(result + " " + num1 + " " + num2);
//        }
//
//        if (e.getSource() == clrBtn) {
//            textField.setText("");
//            num1 = 0;
//            num2 = 0;
//        }
//
//        if (e.getSource() == delBtn) {
//            int newLength = textField.getText().length() - 1;
//            if (newLength >= 0) textField.setText(textField.getText().substring(0, newLength)); // check if the textfield is not empty before deleting
//        }
//
//        if (e.getSource() == negBtn) {
//            double temp = Double.parseDouble(textField.getText());
//            temp *= -1;
//            textField.setText(String.valueOf(temp));
//        }
//    }
//
//    public double calculation(double num1, double num2, char operator) {
//        return switch (operator) {
//            case '+' -> num1 + num2;
//            case '-' -> num1 - num2;
//            case '*' -> num1 * num2;
//            case '/' -> num1 / num2;
//            case '~' -> Math.pow(num1, 2);
//            case 'v' -> Math.sqrt(num1);
//            case '%' -> num1 % num2;
//            case '^' -> Math.pow(num1, num2);
//            default -> 0;
//        };
//    }
//}