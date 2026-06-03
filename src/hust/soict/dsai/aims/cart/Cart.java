package hust.soict.dsai.aims.cart;

import hust.soict.dsai.aims.media.Media;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Cart {

    public static final int MAX_NUMBERS_ORDERED = 20;

    private ObservableList<Media> itemsOrdered = FXCollections.observableArrayList();

    // Hàm thêm sản phẩm chung
    public void addMedia(Media media) {
        if (itemsOrdered.size() < MAX_NUMBERS_ORDERED) {
            if (!itemsOrdered.contains(media)) {
                itemsOrdered.add(media);
                System.out.println("The media \"" + media.getTitle() + "\" has been added.");
            } else {
                System.out.println("The media \"" + media.getTitle() + "\" is already in the cart.");
            }
        } else {
            System.out.println("The cart is almost full.");
        }
    }

    // Hàm xóa sản phẩm chung
    public void removeMedia(Media media) {
        if (itemsOrdered.contains(media)) {
            itemsOrdered.remove(media);
            System.out.println("The media \"" + media.getTitle() + "\" has been removed.");
        } else {
            System.out.println("The media \"" + media.getTitle() + "\" was not found in the cart.");
        }
    }

    public float totalCost() {
        float total = 0;

        for (Media media : itemsOrdered) {
            total += media.getCost();
        }

        return total;
    }

    public void printCart() {
        System.out.println("***********************CART***********************");
        System.out.println("Ordered Items:");

        int index = 1;
        for (Media media : itemsOrdered) {
            System.out.println(index + ". " + media.toString());
            index++;
        }

        System.out.println("Total cost: " + totalCost() + " $");
        System.out.println("**************************************************");
    }

    public ObservableList<Media> getItemsOrdered() {
        return itemsOrdered;
    }
}