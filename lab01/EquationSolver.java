import javax.swing.JOptionPane;

public class EquationSolver {
    public static void main(String[] args) {
        String menu = "Chọn loại phương trình cần giải:\n"
                    + "1. Phương trình bậc nhất 1 ẩn (ax + b = 0)\n"
                    + "2. Hệ phương trình bậc nhất 2 ẩn\n"
                    + "3. Phương trình bậc hai 1 ẩn (ax^2 + bx + c = 0)";
        
        String choice = JOptionPane.showInputDialog(null, menu, "Equation Solver", JOptionPane.QUESTION_MESSAGE);

        if (choice.equals("1")) {
            solveLinearEquation();
        } else if (choice.equals("2")) {
            solveLinearSystem();
        } else if (choice.equals("3")) {
            solveQuadraticEquation();
        }
        System.exit(0);
    }

    // 1. Giải phương trình ax + b = 0
    public static void solveLinearEquation() {
        double a = Double.parseDouble(JOptionPane.showInputDialog("Nhập a:"));
        double b = Double.parseDouble(JOptionPane.showInputDialog("Nhập b:"));
        if (a == 0) {
            JOptionPane.showMessageDialog(null, b == 0 ? "Vô số nghiệm" : "Vô nghiệm");
        } else {
            JOptionPane.showMessageDialog(null, "Nghiệm x = " + (-b / a));
        }
    }

    // 2. Giải hệ phương trình (Sử dụng định thức Cramer)
    public static void solveLinearSystem() {
        // Nhập a11, a12, b1, a21, a22, b2 theo công thức trong tài liệu
        double a11 = Double.parseDouble(JOptionPane.showInputDialog("Nhập a11:"));
        double a12 = Double.parseDouble(JOptionPane.showInputDialog("Nhập a12:"));
        double b1  = Double.parseDouble(JOptionPane.showInputDialog("Nhập b1:"));
        double a21 = Double.parseDouble(JOptionPane.showInputDialog("Nhập a21:"));
        double a22 = Double.parseDouble(JOptionPane.showInputDialog("Nhập a22:"));
        double b2  = Double.parseDouble(JOptionPane.showInputDialog("Nhập b2:"));

        double D  = a11 * a22 - a21 * a12; // [cite: 270]
        double D1 = b1 * a22 - b2 * a12;  // [cite: 270]
        double D2 = a11 * b2 - a21 * b1;  // [cite: 271]

        if (D != 0) {
            JOptionPane.showMessageDialog(null, "x1 = " + (D1/D) + ", x2 = " + (D2/D));
        } else {
            JOptionPane.showMessageDialog(null, (D1 == 0 && D2 == 0) ? "Vô số nghiệm" : "Vô nghiệm");
        }
    }

    // 3. Giải phương trình ax^2 + bx + c = 0
    public static void solveQuadraticEquation() {
        double a = Double.parseDouble(JOptionPane.showInputDialog("Nhập a:"));
        double b = Double.parseDouble(JOptionPane.showInputDialog("Nhập b:"));
        double c = Double.parseDouble(JOptionPane.showInputDialog("Nhập c:"));

        if (a == 0) {
            // Trở về phương trình bậc nhất
            if (b == 0) {
                JOptionPane.showMessageDialog(null, c == 0 ? "Vô số nghiệm" : "Vô nghiệm");
            } else {
                JOptionPane.showMessageDialog(null, "x = " + (-c / b));
            }
        } else {
            double delta = b * b - 4 * a * c; // [cite: 277]
            if (delta < 0) {
                JOptionPane.showMessageDialog(null, "Vô nghiệm"); // [cite: 274]
            } else if (delta == 0) {
                JOptionPane.showMessageDialog(null, "Nghiệm kép x = " + (-b / (2 * a))); // [cite: 274]
            } else {
                double x1 = (-b + Math.sqrt(delta)) / (2 * a);
                double x2 = (-b - Math.sqrt(delta)) / (2 * a);
                JOptionPane.showMessageDialog(null, "x1 = " + x1 + ", x2 = " + x2);
            }
        }
    }
}