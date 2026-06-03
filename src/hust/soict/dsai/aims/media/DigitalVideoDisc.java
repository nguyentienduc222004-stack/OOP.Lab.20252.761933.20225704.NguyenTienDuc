package hust.soict.dsai.aims.media;
import hust.soict.dsai.aims.exception.PlayerException;

public class DigitalVideoDisc extends Disc implements Playable { // Kế thừa Disc

    // 1. Constructor đầy đủ tham số mới (Gọi lên lớp cha Disc)
    public DigitalVideoDisc(int id, String title, String category, float cost, String director, int length) {
        super(id, title, category, cost, length, director);
    }

    // 2. Các Constructor cũ để tương thích với file Test cũ
    public DigitalVideoDisc(String title) {
        super(0, title, null, 0.0f, 0, null);
    }

    public DigitalVideoDisc(String title, String category, float cost) {
        super(0, title, category, cost, 0, null);
    }

    public DigitalVideoDisc(String title, String category, String director, float cost) {
        super(0, title, category, cost, 0, director);
    }

    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        super(0, title, category, cost, length, director);
    }
   
    @Override
    public void play() throws PlayerException {
        if (this.getLength() <= 0) {
            throw new PlayerException("ERROR: DVD length is non-positive!");
        }

        System.out.println("Playing DVD: " + this.getTitle());
        System.out.println("DVD length: " + this.getLength());
    }
}