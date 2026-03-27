import javax.swing.JOptionPane;

public class CalculateTwoNumbers {
    public static void main(String[] args) {
        String strNum1, strNum2;
        
        strNum1 = JOptionPane.showInputDialog(null, "Please input the first number: ", "Input", JOptionPane.INFORMATION_MESSAGE);
        double num1 = Double.parseDouble(strNum1); // Xóa sạch phần [cite] ở đây

        strNum2 = JOptionPane.showInputDialog(null, "Please input the second number: ", "Input", JOptionPane.INFORMATION_MESSAGE);
        double num2 = Double.parseDouble(strNum2);

        double sum = num1 + num2;
        double difference = num1 - num2;
        double product = num1 * num2;
        
        String result = "Sum: " + sum + "\n"
                      + "Difference: " + difference + "\n"
                      + "Product: " + product + "\n";

        if (num2 != 0) {
            double quotient = num1 / num2;
            result += "Quotient: " + quotient;
        } else {
            result += "Quotient: Cannot divide by zero!";
        }

        JOptionPane.showMessageDialog(null, result, "Result", JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);
    }
}
