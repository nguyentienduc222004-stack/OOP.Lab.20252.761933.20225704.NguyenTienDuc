package lab01;
import java.util.Scanner; // Import lớp Scanner để đọc dữ liệu từ bàn phím [cite: 736]

public class InputFromKeyboard {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in); // Khởi tạo đối tượng Scanner [cite: 741]
        
        System.out.println("What's your name?");
        String strName = keyboard.nextLine(); // Đọc một dòng văn bản (tên) [cite: 742]
        
        System.out.println("How old are you?");
        int iAge = keyboard.nextInt(); // Đọc số nguyên (tuổi) [cite: 745, 746]
        
        System.out.println("How tall are you (m)?");
        double dHeight = keyboard.nextDouble(); // Đọc số thực (chiều cao) [cite: 748, 749]
        
        // In kết quả ra màn hình [cite: 776, 777]
        System.out.println("Mrs/Ms. " + strName + ", " + iAge + " years old. " 
                           + "Your height is " + dHeight + ".");
        
        keyboard.close(); // Đóng scanner sau khi dùng xong
    }
}
