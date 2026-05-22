package hust.soict.dsai.aims.media;

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
    public void play() {
        if (this.getLength() > 0) {
            System.out.println("Playing CD: " + this.getTitle() + " by " + this.getArtist());
            System.out.println("Total CD length: " + this.getLength());
            System.out.println("-------------------------");
            
            // Vòng lặp gọi hàm play() của từng Track nhạc bên trong CD
            for (Track track : tracks) {
                track.play();
            }
        } else {
            System.out.println("ERROR: CD \"" + this.getTitle() + "\" cannot be played (Total length is 0 or less).");
        }
    }
}