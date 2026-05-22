package hust.soict.dsai.test.disc;

import hust.soict.dsai.aims.media.DigitalVideoDisc;

public class TestPassingParameter {

    public static void main(String[] args) {
        // Khởi tạo 2 đối tượng DVD
        DigitalVideoDisc jungleDVD = new DigitalVideoDisc("Jungle");
        DigitalVideoDisc cinderellaDVD = new DigitalVideoDisc("Cinderella");

        // Thử nghiệm hàm swap (tráo đổi)
        correctSwap(jungleDVD, cinderellaDVD);
        System.out.println("jungle dvd title: " + jungleDVD.getTitle());
        System.out.println("cinderella dvd title: " + cinderellaDVD.getTitle());

        // Thử nghiệm hàm changeTitle (đổi tiêu đề)
        changeTitle(jungleDVD, cinderellaDVD.getTitle());
        System.out.println("jungle dvd title: " + jungleDVD.getTitle());
    }
    public static void correctSwap(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
        // Lưu tạm title của dvd1
        String tmpTitle = dvd1.getTitle();
        
        // Lấy title dvd2 gán cho dvd1
        dvd1.setTitle(dvd2.getTitle());
        
        // Lấy title tạm gán cho dvd2
        dvd2.setTitle(tmpTitle);
    }

    // Hàm swap mẫu (không thực sự đổi được đối tượng gốc)
    public static void swap(Object o1, Object o2) {
        Object tmp = o1;
        o1 = o2;
        o2 = tmp;
    }

    // Hàm đổi tiêu đề (thay đổi được vì tác động vào thuộc tính)
    public static void changeTitle(DigitalVideoDisc dvd, String title) {
        String oldTitle = dvd.getTitle();
        dvd.setTitle(title);
        dvd = new DigitalVideoDisc(oldTitle);
    }
}