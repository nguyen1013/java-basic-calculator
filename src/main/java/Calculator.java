//import javax.swing.*;
//import java.awt.Font;
//import java.awt.GridLayout;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//
//public class Calculator implements ActionListener {
//    // Declare the components
//    JFrame frame;
//    JPanel panel;
//    JTextField textField;
//    Font font = new Font("Monospaced", Font.BOLD, 25);
//
//    // Declare the buttons and buttons arrays
//    JButton[] numberBtns = new JButton[10];
//    JButton[] functionBtns = new JButton[12];
//    JButton addBtn, subBtn, mulBtn, divBtn, sqrBtn, sqrtBtn, powerBtn, eqBtn, clrBtn, dotBtn, delBtn, negBtn;
//
//    double num1 = 0, num2 = 0, result = 0;
//    char operator;
//
//    public Calculator() {
//        // Initialize the frame
//        frame = new JFrame("Calculator");
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setSize(450, 600);
//        frame.setResizable(false);
//        frame.setLayout(null);
//
//        // Initialize the textfield
//        textField = new JTextField();
//        textField.setBounds(10, 10, 415, 80);
//        textField.setFont(font);
//        textField.setEditable(true);
//        textField.setHorizontalAlignment(JTextField.RIGHT);
//
//        // Initialize the panel
//        panel = new JPanel();
//        panel.setBounds(10, 215, 415, 330);
//        panel.setLayout(new GridLayout(5, 4, 5, 5));
//
//        // Initialize the buttons
//        addBtn = new JButton("+");
//        subBtn = new JButton("-");
//        mulBtn = new JButton("*");
//        divBtn = new JButton("/");
//        sqrBtn = new JButton("x^2");
//        sqrtBtn = new JButton("sqrt");
//        powerBtn = new JButton("x^y");
//        eqBtn = new JButton("=");
//        clrBtn = new JButton("C");
//        dotBtn = new JButton(".");
//        delBtn = new JButton("<-");
//        negBtn = new JButton("+/-");
//
//        // Add functional buttons to the array
//        functionBtns[0] = addBtn;
//        functionBtns[1] = subBtn;
//        functionBtns[2] = mulBtn;
//        functionBtns[3] = divBtn;
//        functionBtns[4] = sqrBtn;
//        functionBtns[5] = sqrtBtn;
//        functionBtns[6] = eqBtn;
//        functionBtns[7] = delBtn;
//        functionBtns[8] = clrBtn;
//        functionBtns[9] = powerBtn;
//        functionBtns[10] = negBtn;
//        functionBtns[11] = dotBtn;
//
//        // Add action listeners to the functional buttons
//        for (JButton functionBtn : functionBtns) {
//            functionBtn.addActionListener(this);
//            functionBtn.setFont(font);
//        }
//
//        // Add action listeners to the number buttons
//        for (int i=0; i<10;i++) {
//            numberBtns[i] = new JButton(String.valueOf(i));
//            numberBtns[i].addActionListener(this);
//            numberBtns[i].setFont(font);
//        }
//
//        // Add the buttons to the panel
//        panel.add(powerBtn);
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
//        // Set the bounds of the top buttons
//        clrBtn.setBounds(220,150, 100, 60);
//        delBtn.setBounds(325,150, 100, 60);
//
//        // Add the components to the frame
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
//            setDotBtn();
//        }
//
//        if (e.getSource() == addBtn) {
//            setAddBtn();
//        }
//
//        if (e.getSource() == subBtn) {
//            setSubBtn();
//        }
//
//        if (e.getSource() == mulBtn) {
//            setMulBtn();
//        }
//
//        if (e.getSource() == divBtn) {
//            setDivBtn();
//        }
//
//        if (e.getSource() == sqrBtn) {
//            setSquare();
//        }
//
//        if (e.getSource() == sqrtBtn) {
//            setSquareRoot();
//        }
//
//        if (e.getSource() == powerBtn) {
//            setPower();
//        }
//
//        if (e.getSource() == clrBtn) {
//            setClear();
//        }
//
//        if (e.getSource() == delBtn) {
//            setDelete();
//        }
//
//        if (e.getSource() == negBtn) {
//            setNegate();
//        }
//
//        if (e.getSource() == eqBtn) {
//            performCalculation();
//        }
//    }
//
//    /**
//     * BELOW ARE HELPER METHODS TO PERFORM THE SETTING NUMBERS, OPERATORS AND CALCULATIONS
//     */
//
//    private void performCalculation() {
//        try {
//            if (operator != 'v' && operator != '~') {
//                if (num2 == 0) {
//                    num2 = Double.parseDouble(textField.getText());
//                }
//            }
//            result = getCalculation(num1, num2, operator);
//            textField.setText(String.valueOf(result));
//            num1 = result;
//
//        } catch (Exception ex) {
//            textField.setText("Error");
//            num1 = 0;
//            num2 = 0;
//        }
//    }
//
//    private void setDotBtn() {
//        if (!textField.getText().contains(".")) textField.setText(textField.getText().concat(".")); // check if the textfield already contains a decimal point
//    }
//
//    private void setAddBtn() {
//        num1 = Double.parseDouble(textField.getText());
//        operator = '+';
//        textField.setText("");
//    }
//
//    private void setSubBtn() {
//        num1 = Double.parseDouble(textField.getText());
//        operator = '-';
//        textField.setText("");
//    }
//
//    private void setMulBtn() {
//        num1 = Double.parseDouble(textField.getText());
//        operator = '*';
//        textField.setText("");
//    }
//
//    private void setDivBtn() {
//        num1 = Double.parseDouble(textField.getText());
//        operator = '/';
//        textField.setText("");
//    }
//
//    private void setPower() {
//        num1 = Double.parseDouble(textField.getText());
//        operator = '^';
//        textField.setText("");
//    }
//
//    private void setSquare() {
//        num1 = Double.parseDouble(textField.getText());
//        operator = '~';
//        textField.setText("");
//    }
//
//    private void setSquareRoot() {
//        num1 = Double.parseDouble(textField.getText());
//        operator = 'v';
//        textField.setText("");
//    }
//
//    private void setNegate() {
//        double temp = Double.parseDouble(textField.getText());
//        temp *= -1;
//        textField.setText(String.valueOf(temp));
//    }
//
//    private void setClear() {
//        textField.setText("");
//        num1 = 0;
//        num2 = 0;
//    }
//
//    private void setDelete() {
//        int newLength = textField.getText().length() - 1;
//        if (newLength >= 0) textField.setText(textField.getText().substring(0, newLength)); // check if the textfield is not empty before deleting
//    }
//
//    private double getCalculation(double num1, double num2, char operator) {
//        System.out.println(num1 + " " + operator + " " + num2);
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