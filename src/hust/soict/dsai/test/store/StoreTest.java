package hust.soict.dsai.test.store;

import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.store.Store;

public class StoreTest {
    public static void main(String[] args) {
        Store store = new Store();

        // Khởi tạo các DVD test
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 88, 19.95f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 124, 24.95f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladdin", "Animation", 18.99f);

        // 1. Thử nghiệm tính năng thêm sản phẩm (Đã đổi sang addMedia)
        store.addMedia(dvd1);
        store.addMedia(dvd2);
        store.addMedia(dvd3);

        // Hiển thị danh sách cửa hàng sau khi thêm
        store.printStore();

        // 2. Thử nghiệm tính năng xóa sản phẩm (Đã đổi sang removeMedia)
        store.removeMedia(dvd2);

        // Hiển thị lại danh sách cửa hàng sau khi xóa
        store.printStore();
    }
}