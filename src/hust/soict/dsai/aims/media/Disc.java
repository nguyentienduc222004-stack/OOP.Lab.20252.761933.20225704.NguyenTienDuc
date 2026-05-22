package hust.soict.dsai.aims.media;

public class Disc extends Media {
    private int length;
    private String director;

    // Constructor mặc định
    public Disc() {
        super();
    }

    // Constructor đầy đủ tham số để các lớp con gọi qua super()
    public Disc(int id, String title, String category, float cost, int length, String director) {
        super(id, title, category, cost); 
        this.length = length;
        this.director = director;
    }

    // Các hàm Getter cho thuộc tính riêng của Disc
    public int getLength() {
        return length;
    }

    public String getDirector() {
        return director;
    }
}