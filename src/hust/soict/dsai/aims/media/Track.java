package hust.soict.dsai.aims.media;

public class Track implements Playable {
    private String title;
    private int length;

    // Constructor đầy đủ tham số
    public Track(String title, int length) {
        this.title = title;
        this.length = length;
    }

    // Các hàm Getter public theo yêu cầu đề bài
    public String getTitle() {
        return title;
    }

    public int getLength() {
        return length;
    }
    @Override
    public void play() {
        if (this.getLength() > 0) {
            System.out.println("Playing track: " + this.getTitle());
            System.out.println("Track length: " + this.getLength());
        } else {
            System.out.println("ERROR: Track \"" + this.getTitle() + "\" cannot be played (Length is 0 or less).");
        }
    }
}