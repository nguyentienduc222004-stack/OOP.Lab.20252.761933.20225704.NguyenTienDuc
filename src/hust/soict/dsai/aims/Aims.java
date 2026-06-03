package hust.soict.dsai.aims;

import java.util.Scanner;
import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.*;
import hust.soict.dsai.aims.store.Store;

public class Aims {
    private static Store store = new Store();
    private static Cart cart = new Cart();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Khởi tạo sẵn dữ liệu mẫu cho Store để test
        initSampleData();

        int choice;
        do {
            showMenu();
            choice = scanner.nextInt();
            scanner.nextLine(); // Đọc bỏ dòng trống sau khi nhập số

            switch (choice) {
                case 1:
                    storeMenuWorkflow();
                    break;
                case 2:
                    updateStoreWorkflow();
                    break;
                case 3:
                    cartMenuWorkflow();
                    break;
                case 0:
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 0);
    }

    // Nạp dữ liệu mẫu ban đầu để khi chạy chương trình có sẵn đồ test
    private static void initSampleData() {
        DigitalVideoDisc dvd = new DigitalVideoDisc(1, "The Lion King", "Animation", 19.95f, "Roger Allers", 88);
        Book book = new Book(2, "Java Programming", "Education", 29.99f);
        book.addAuthor("James Gosling");
        
        CompactDisc cd = new CompactDisc(3, "Space Jam", "Soundtrack", 15.5f, 0, "Various", "Michael Jordan");
        Track track1 = new Track("Fly Like an Eagle", 4);
        Track track2 = new Track("I Believe I Can Fly", 5);
        cd.addTrack(track1);
        cd.addTrack(track2);

        store.addMedia(dvd);
        store.addMedia(book);
        store.addMedia(cd);
    }

    // ================= MAIN MENU =================
    public static void showMenu() {
        System.out.println("\n--- AIMS APPLICATION ---");
        System.out.println("1. View store");
        System.out.println("2. Update store");
        System.out.println("3. See current cart");
        System.out.println("0. Exit");
        System.out.println("--------------------------------");
        System.out.print("Please choose a number (0-3): ");
    }

    private static void storeMenuWorkflow() {
        int choice;
        do {
            store.printStore();
            storeMenu();
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1: // Xem chi tiết Media
                    System.out.print("Enter the title of the media: ");
                    String title = scanner.nextLine();
                    System.out.println("Details feature for \"" + title + "\" is under development.");
                    break;
                case 2: // Thêm vào giỏ hàng
                    System.out.print("Enter the title of the media to add: ");
                    String addTitle = scanner.nextLine();
                    System.out.println("Searching and adding \"" + addTitle + "\" to cart...");
                    break;
                case 3: // Phát thử (Play)
                    System.out.print("Enter the title of the media to play: ");
                    String playTitle = scanner.nextLine();
                    System.out.println("Playing feature for \"" + playTitle + "\"...");
                    break;
                case 4: // Xem giỏ hàng luôn
                    cart.printCart();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 0);
    }

    public static void storeMenu() {
        System.out.println("\n--- STORE OPTIONS ---");
        System.out.println("1. See a media's details");
        System.out.println("2. Add a media to cart");
        System.out.println("3. Play a media");
        System.out.println("4. See current cart");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.print("Please choose a number (0-4): ");
    }

    // ================= UPDATE STORE =================
    private static void updateStoreWorkflow() {
        System.out.println("\n--- UPDATE STORE ---");
        System.out.println("1. Add a media to store");
        System.out.println("2. Remove a media from store");
        System.out.print("Choose option (1-2): ");
        int opt = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Feature updating store is selected (Under development).");
    }

    // ================= CART MENU =================
    private static void cartMenuWorkflow() {
        int choice;
        do {
            cart.printCart();
            cartMenu();
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Filter options (Under development)...");
                    break;
                case 2:
                    System.out.println("Sort options (Under development)...");
                    break;
                case 3:
                    System.out.print("Enter title to remove from cart: ");
                    String remTitle = scanner.nextLine();
                    System.out.println("Removing \"" + remTitle + "\"...");
                    break;
                case 4:
                    System.out.print("Enter title to play: ");
                    String pTitle = scanner.nextLine();
                    System.out.println("Playing \"" + pTitle + "\"...");
                    break;
                case 5:
                    System.out.println("An order has been created successfully! Thank you!");
                    cart = new Cart(); // Làm trống giỏ hàng sau khi đặt
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 0);
    }

    public static void cartMenu() {
        System.out.println("\n--- CART OPTIONS ---");
        System.out.println("1. Filter medias in cart");
        System.out.println("2. Sort medias in cart");
        System.out.println("3. Remove media from cart");
        System.out.println("4. Play a media");
        System.out.println("5. Place order");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.print("Please choose a number (0-5): ");
    }
}