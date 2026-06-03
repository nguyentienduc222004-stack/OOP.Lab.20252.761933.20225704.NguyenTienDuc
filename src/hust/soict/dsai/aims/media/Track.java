package hust.soict.dsai.aims.media;
import hust.soict.dsai.aims.exception.PlayerException;
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
    public void play() throws PlayerException {
        if (this.getLength() <= 0) {
            throw new PlayerException("ERROR: Track length is non-positive!");
        }

        System.out.println("Playing track: " + this.getTitle());
        System.out.println("Track length: " + this.getLength());
    }
}