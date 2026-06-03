package hust.soict.dsai.aims.media;

import java.util.ArrayList;
import java.util.List;

public class Book extends Media { // Sử dụng từ khóa extends để kế thừa Media
    private List<String> authors = new ArrayList<String>();

    public Book() {
        super(); // Gọi constructor mặc định của cha
    }

    public Book(int id, String title, String category, float cost) {
        super(id, title, category, cost); // Gọi constructor có tham số của lớp cha Media
    }

    // --- Các phương thức quản lý mảng tác giả ---
    public void addAuthor(String authorName) {
        if (!authors.contains(authorName)) {
            authors.add(authorName);
            System.out.println("Added author: " + authorName);
        } else {
            System.out.println("Author \"" + authorName + "\" already exists.");
        }
    }

    public void removeAuthor(String authorName) {
        if (authors.contains(authorName)) {
            authors.remove(authorName);
            System.out.println("Removed author: " + authorName);
        } else {
            System.out.println("Author \"" + authorName + "\" not found.");
        }
    }
}