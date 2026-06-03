package hust.soict.dsai.aims.screen;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.List;
import hust.soict.dsai.aims.media.Book;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.store.Store;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.Track;
public class StoreScreen extends JFrame {

    private Store store;
    private Cart cart;

    public StoreScreen(Store store, Cart cart) {
        this.store = store;
        this.cart = cart;

        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());

        cp.add(createNorth(), BorderLayout.NORTH);
        cp.add(createCenter(), BorderLayout.CENTER);

        setTitle("Store");
        setSize(1024, 768);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    JPanel createNorth() {
        JPanel north = new JPanel();
        north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));

        north.add(createMenuBar());
        north.add(createHeader());

        return north;
    }

    JMenuBar createMenuBar() {
        JMenu menu = new JMenu("Options");
        JMenu smUpdateStore = new JMenu("Update Store");

        JMenuItem addBook = new JMenuItem("Add Book");
        JMenuItem addCD = new JMenuItem("Add CD");
        JMenuItem addDVD = new JMenuItem("Add DVD");

        smUpdateStore.add(addBook);
        smUpdateStore.add(addCD);
        smUpdateStore.add(addDVD);

        addDVD.addActionListener(e -> {
            String title = JOptionPane.showInputDialog(this, "Enter DVD title:");
            String category = JOptionPane.showInputDialog(this, "Enter DVD category:");
            String director = JOptionPane.showInputDialog(this, "Enter DVD director:");
            String lengthStr = JOptionPane.showInputDialog(this, "Enter DVD length:");
            String costStr = JOptionPane.showInputDialog(this, "Enter DVD cost:");

            try {
                int length = Integer.parseInt(lengthStr);
                float cost = Float.parseFloat(costStr);

                DigitalVideoDisc dvd = new DigitalVideoDisc(title, category, director, length, cost);
                store.addMedia(dvd);

                JOptionPane.showMessageDialog(this, "DVD added successfully!");

                getContentPane().removeAll();
                add(createNorth(), BorderLayout.NORTH);
                add(createCenter(), BorderLayout.CENTER);
                revalidate();
                repaint();

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Invalid number format!");
            }
        });
        addBook.addActionListener(e -> {
            String title = JOptionPane.showInputDialog(this, "Enter Book title:");
            String category = JOptionPane.showInputDialog(this, "Enter Book category:");
            String costStr = JOptionPane.showInputDialog(this, "Enter Book cost:");

            try {
                float cost = Float.parseFloat(costStr);

                Book book = new Book(0, title, category, cost);
                store.addMedia(book);

                JOptionPane.showMessageDialog(this, "Book added successfully!");

                getContentPane().removeAll();
                add(createNorth(), BorderLayout.NORTH);
                add(createCenter(), BorderLayout.CENTER);
                revalidate();
                repaint();

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Invalid number format!");
            }
        });
        addCD.addActionListener(e -> {
            String title = JOptionPane.showInputDialog(this, "Enter CD title:");
            String category = JOptionPane.showInputDialog(this, "Enter CD category:");
            String director = JOptionPane.showInputDialog(this, "Enter CD director:");
            String artist = JOptionPane.showInputDialog(this, "Enter CD artist:");
            String costStr = JOptionPane.showInputDialog(this, "Enter CD cost:");

            try {
                float cost = Float.parseFloat(costStr);

                CompactDisc cd = new CompactDisc(0, title, category, cost, 0, director, artist);

                while (true) {
                    String trackTitle = JOptionPane.showInputDialog(this, "Enter track title, or leave blank to finish:");

                    if (trackTitle == null || trackTitle.isBlank()) {
                        break;
                    }

                    String trackLengthStr = JOptionPane.showInputDialog(this, "Enter track length:");

                    int trackLength = Integer.parseInt(trackLengthStr);
                    Track track = new Track(trackTitle, trackLength);
                    cd.addTrack(track);
                }

                store.addMedia(cd);

                JOptionPane.showMessageDialog(this, "CD added successfully!");

                getContentPane().removeAll();
                add(createNorth(), BorderLayout.NORTH);
                add(createCenter(), BorderLayout.CENTER);
                revalidate();
                repaint();

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Invalid number format!");
            }
        });

        JMenuItem viewStore = new JMenuItem("View store");
        JMenuItem viewCart = new JMenuItem("View cart");
        viewCart.addActionListener(e -> {
            new CartScreen(cart);
        });

       

        menu.add(smUpdateStore);
        menu.add(viewStore);
        menu.add(viewCart);

        JMenuBar menuBar = new JMenuBar();
        menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
        menuBar.add(menu);

        return menuBar;
    }

    JPanel createHeader() {
        JPanel header = new JPanel();
        header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));

        JLabel title = new JLabel("AIMS");
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 50));

        JButton cartButton = new JButton("View cart");
        cartButton.setPreferredSize(new Dimension(100, 50));
        cartButton.setMaximumSize(new Dimension(100, 50));

        cartButton.addActionListener(e -> {
            new CartScreen(cart);
        });

        header.add(Box.createRigidArea(new Dimension(10, 10)));
        header.add(title);
        header.add(Box.createHorizontalGlue());
        header.add(cartButton);
        header.add(Box.createRigidArea(new Dimension(10, 10)));

        return header;
    }

    JPanel createCenter() {
        JPanel center = new JPanel();
        center.setLayout(new GridLayout(3, 3, 2, 2));

        List<Media> mediaInStore = store.getItemsInStore();

        int numberOfItems = Math.min(mediaInStore.size(), 9);

        for (int i = 0; i < numberOfItems; i++) {
            MediaStore cell = new MediaStore(mediaInStore.get(i), cart);
            center.add(cell);
        }

        for (int i = numberOfItems; i < 9; i++) {
            center.add(new JPanel());
        }

        return center;
    }
}