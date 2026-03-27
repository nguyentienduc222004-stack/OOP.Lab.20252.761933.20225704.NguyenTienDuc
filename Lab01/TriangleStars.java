import java.util.Scanner;

public class TriangleStars {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        
        System.out.print("Nhập chiều cao tam giác (n): ");
        int n = keyboard.nextInt(); 

        for (int i = 1; i <= n; i++) {
            // In khoảng trắng để đẩy dấu sao vào giữa
            for (int j = 1; j <= n - i; j++) {
                System.out.print(" ");
            }
            
            // In dấu sao (*) theo công thức số lẻ: 2*i - 1
            for (int k = 1; k <= (2 * i - 1); k++) {
                System.out.print("*");
            }
            
            // Xuống dòng sau mỗi tầng
            System.out.println();
        }
        keyboard.close();
    }
}
