package hust.soict.dsai.aims.store;

import java.util.ArrayList;

import hust.soict.dsai.aims.media.Media;

public class Store {

    private ArrayList<Media> itemsInStore = new ArrayList<Media>();

    // Hàm thêm sản phẩm vào cửa hàng
    public void addMedia(Media media) {
        if (!itemsInStore.contains(media)) {
            itemsInStore.add(media);
            System.out.println("The media \"" + media.getTitle() + "\" has been added to the store.");
        } else {
            System.out.println("The media \"" + media.getTitle() + "\" already exists in the store.");
        }
    }

    // Hàm xóa sản phẩm khỏi cửa hàng
    public void removeMedia(Media media) {
        if (itemsInStore.contains(media)) {
            itemsInStore.remove(media);
            System.out.println("The media \"" + media.getTitle() + "\" has been removed from the store.");
        } else {
            System.out.println("The media \"" + media.getTitle() + "\" was not found in the store.");
        }
    }

    // Hàm hiển thị danh sách sản phẩm hiện có trong cửa hàng
    public void printStore() {
        System.out.println("***********************STORE***********************");
        System.out.println("Available Items in Store:");

        int index = 1;
        for (Media media : itemsInStore) {
            System.out.println(index + ". Media - " + media.toString());
            index++;
        }

        System.out.println("***************************************************");
    }

    // Getter dùng cho StoreScreen
    public ArrayList<Media> getItemsInStore() {
        return itemsInStore;
    }
}