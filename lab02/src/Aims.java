public class Aims {
    public static void main(String[] args) {
        // Tạo giỏ hàng mới
        Cart anOrder = new Cart();

        // Tạo các đối tượng DVD và thêm vào giỏ
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        anOrder.addDigitalVideoDisc(dvd1);

        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
        anOrder.addDigitalVideoDisc(dvd2);

        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladdin", "Animation", 18.99f);
        anOrder.addDigitalVideoDisc(dvd3);

        // In tổng chi phí ban đầu (Kết quả mong đợi: 63.89)
        System.out.println("Total Cost is: ");
        System.out.println(anOrder.totalCost());
        
        // --- Phần kiểm tra Xóa đĩa (Phần 11) ---
        anOrder.removeDigitalVideoDisc(dvd2);
        System.out.println("Total Cost after removing is: " + anOrder.totalCost());
    }
}
