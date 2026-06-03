package hust.soict.dsai.aims.screen;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Playable;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class CartScreenController {

    private Cart cart;

    @FXML
    private TableView<Media> tblMedia;

    @FXML
    private TableColumn<Media, String> colMediaTitle;

    @FXML
    private TableColumn<Media, String> colMediaCategory;

    @FXML
    private TableColumn<Media, Float> colMediaCost;

    @FXML
    private Button btnPlay;

    @FXML
    private Button btnRemove;

    @FXML
    private Button btnPlaceOrder;

    @FXML
    private Label lblTotalCost;

    @FXML
    private TextField tfFilter;

    @FXML
    private RadioButton radioBtnFilterId;

    @FXML
    private RadioButton radioBtnFilterTitle;

    private FilteredList<Media> filteredList;

    public CartScreenController(Cart cart) {
        this.cart = cart;
    }

    @FXML
    private void initialize() {
        colMediaTitle.setCellValueFactory(new PropertyValueFactory<Media, String>("title"));
        colMediaCategory.setCellValueFactory(new PropertyValueFactory<Media, String>("category"));
        colMediaCost.setCellValueFactory(new PropertyValueFactory<Media, Float>("cost"));

        filteredList = new FilteredList<Media>(cart.getItemsOrdered(), p -> true);
        tblMedia.setItems(filteredList);

        btnPlay.setVisible(false);
        btnRemove.setVisible(false);

        updateTotalCost();

        tblMedia.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> {
                    if (newValue != null) {
                        updateButtonBar(newValue);
                    }
                }
        );

        tfFilter.textProperty().addListener(
                (observable, oldValue, newValue) -> showFilteredMedia(newValue)
        );
    }

    private void updateButtonBar(Media media) {
        btnRemove.setVisible(true);

        if (media instanceof Playable) {
            btnPlay.setVisible(true);
        } else {
            btnPlay.setVisible(false);
        }
    }

    private void updateTotalCost() {
        lblTotalCost.setText(String.format("%.2f $", cart.totalCost()));
    }

    private void showFilteredMedia(String filter) {
        filteredList.setPredicate(media -> {
            if (filter == null || filter.isEmpty()) {
                return true;
            }

            String lowerCaseFilter = filter.toLowerCase();

            if (radioBtnFilterTitle.isSelected()) {
                return media.getTitle().toLowerCase().contains(lowerCaseFilter);
            } else {
                return String.valueOf(media.getId()).contains(lowerCaseFilter);
            }
        });
    }

    @FXML
    void removePressed(ActionEvent event) {
        Media media = tblMedia.getSelectionModel().getSelectedItem();

        if (media != null) {
            cart.removeMedia(media);
            updateTotalCost();
        }
    }

    @FXML
    void playPressed(ActionEvent event) {
        Media media = tblMedia.getSelectionModel().getSelectedItem();

        if (media instanceof Playable) {
            try {
                ((Playable) media).play();

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Play");
                alert.setHeaderText(null);
                alert.setContentText("Playing: " + media.getTitle());
                alert.showAndWait();

            } catch (Exception e) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Play Error");
                alert.setHeaderText(null);
                alert.setContentText(e.getMessage());
                alert.showAndWait();
            }
        }
    }

    @FXML
    void placeOrderPressed(ActionEvent event) {
        cart.getItemsOrdered().clear();
        updateTotalCost();

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Order");
        alert.setHeaderText(null);
        alert.setContentText("Order has been placed successfully!");
        alert.showAndWait();
    }
}