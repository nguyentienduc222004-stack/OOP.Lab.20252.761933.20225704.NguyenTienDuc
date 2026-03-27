import java.util.Arrays;
import java.util.Scanner;

public class ArraySorting {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // 1. Nhập kích thước mảng
        System.out.print("Enter the number of elements in the array: ");
        int n = sc.nextInt();
        double[] myNumbers = new double[n];
        
        // 2. Nhập các phần tử của mảng
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            myNumbers[i] = sc.nextDouble();
        }
        
        // 3. Sắp xếp mảng (Sử dụng thư viện Arrays.sort)
        Arrays.sort(myNumbers);
        
        // 4. Tính tổng và giá trị trung bình
        double sum = 0;
        for (double num : myNumbers) {
            sum += num;
        }
        double average = sum / n;
        
        // 5. In kết quả ra màn hình
        System.out.println("--- Results ---");
        System.out.println("Sorted Array: " + Arrays.toString(myNumbers));
        System.out.println("Sum of elements: " + sum);
        System.out.println("Average value: " + average);
        
        sc.close();
    }
}