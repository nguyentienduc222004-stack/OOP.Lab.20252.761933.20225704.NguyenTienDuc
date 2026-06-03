package hust.soict.dsai.aims.media;
import hust.soict.dsai.aims.exception.PlayerException;
import java.util.ArrayList;

public class CompactDisc extends Disc implements Playable { // Kế thừa từ Disc để dùng lại id, title, category, cost, length, director
    private String artist;
    private ArrayList<Track> tracks = new ArrayList<Track>();

    // Constructor mặc định
    public CompactDisc() {
        super();
    }

    // Constructor đầy đủ tham số
    public CompactDisc(int id, String title, String category, float cost, int length, String director, String artist) {
        super(id, title, category, cost, length, director);
        this.artist = artist;
    }

    // Chỉ tạo getter public cho artist theo đúng yêu cầu đề bài
    public String getArtist() {
        return artist;
    }

    // Phương thức thêm Track (Kiểm tra trùng lặp)
    public void addTrack(Track track) {
        if (!tracks.contains(track)) {
            tracks.add(track);
            System.out.println("Track \"" + track.getTitle() + "\" has been added to CD.");
        } else {
            System.out.println("Track \"" + track.getTitle() + "\" already exists in this CD.");
        }
    }

    // Phương thức xóa Track (Kiểm tra tồn tại)
    public void removeTrack(Track track) {
        if (tracks.contains(track)) {
            tracks.remove(track);
            System.out.println("Track \"" + track.getTitle() + "\" has been removed from CD.");
        } else {
            System.out.println("Track \"" + track.getTitle() + "\" does not exist in this CD.");
        }
    }

    // Ghi đè phương thức getLength() để tính tổng chiều dài từ các Track
    @Override
    public int getLength() {
        int totalLength = 0;
        for (Track track : tracks) {
            totalLength += track.getLength();
        }
        return totalLength;
    }
    @Override
    public void play() throws PlayerException {
        if (this.getLength() <= 0) {
            throw new PlayerException("ERROR: CD length is non-positive!");
        }

        System.out.println("Playing CD: " + this.getTitle());
        System.out.println("CD length: " + this.getLength());

        for (Track track : tracks) {
            track.play();
        }
    }
}