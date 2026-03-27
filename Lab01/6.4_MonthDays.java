import java.util.Scanner;

public class MonthDays {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String monthInput;
        int year;

        while (true) {
            System.out.print("Enter month (Name, Abbreviation, 3 letters, or Number): ");
            monthInput = sc.next().trim();
            System.out.print("Enter year: ");
            
            if (sc.hasNextInt()) {
                year = sc.nextInt();
                if (year < 0) {
                    System.out.println("Invalid year. Please try again.");
                    continue;
                }
            } else {
                System.out.println("Invalid year format. Please try again.");
                sc.next(); // Clear input
                continue;
            }

            int days = getDaysInMonth(monthInput, year);
            if (days != -1) {
                System.out.println("Number of days: " + days);
                break; // Thoát vòng lặp khi nhập đúng
            } else {
                System.out.println("Invalid month. Please try again (e.g., January, Jan., Jan, or 1).");
            }
        }
        sc.close();
    }

    // Hàm kiểm tra số ngày và xử lý năm nhuận
    public static int getDaysInMonth(String month, int year) {
        month = month.toLowerCase();
        boolean isLeap = (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);

        if (month.equals("1") || month.equals("january") || month.equals("jan.") || month.equals("jan")) return 31;
        if (month.equals("2") || month.equals("february") || month.equals("feb.") || month.equals("feb")) return isLeap ? 29 : 28;
        if (month.equals("3") || month.equals("march") || month.equals("mar.") || month.equals("mar")) return 31;
        if (month.equals("4") || month.equals("april") || month.equals("apr.") || month.equals("apr")) return 30;
        if (month.equals("5") || month.equals("may")) return 31;
        if (month.equals("6") || month.equals("june") || month.equals("jun")) return 30;
        if (month.equals("7") || month.equals("july") || month.equals("jul")) return 31;
        if (month.equals("8") || month.equals("august") || month.equals("aug.") || month.equals("aug")) return 31;
        if (month.equals("9") || month.equals("september") || month.equals("sept.") || month.equals("sep")) return 30;
        if (month.equals("10") || month.equals("october") || month.equals("oct.") || month.equals("oct")) return 31;
        if (month.equals("11") || month.equals("november") || month.equals("nov.") || month.equals("nov")) return 30;
        if (month.equals("12") || month.equals("december") || month.equals("dec.") || month.equals("dec")) return 31;

        return -1; // Trả về -1 nếu nhập sai
    }
}
