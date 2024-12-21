
package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.store.Store;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class AddDigitalVideoDiscToStoreScreen extends AddItemToStoreScreen {

    public AddDigitalVideoDiscToStoreScreen(Store store, Cart cart) {
        super(store, cart);
    }

    @Override
    protected VBox createForm() {
        VBox form = new VBox(10);
        form.setAlignment(Pos.CENTER);
        form.setPadding(new Insets(20));

        Label header = new Label("Add Digital Video Disc to Store");
        header.setStyle("-fx-font-size: 20px; -fx-font-weight: bold;");

        TextField titleField = new TextField();
        titleField.setPromptText("Title");

        TextField categoryField = new TextField();
        categoryField.setPromptText("Category");

        TextField directorField = new TextField();
        directorField.setPromptText("Director");

        TextField lengthField = new TextField();
        lengthField.setPromptText("Length (minutes)");

        TextField costField = new TextField();
        costField.setPromptText("Cost");

        Button addButton = new Button("Add DVD");
        addButton.setOnAction(e -> {
            String title = titleField.getText();
            String category = categoryField.getText();
            String director = directorField.getText();
            String lengthText = lengthField.getText();
            String costText = costField.getText();

            if(title.isEmpty() || category.isEmpty() || director.isEmpty() || lengthText.isEmpty() || costText.isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Input Error");
                alert.setHeaderText(null);
                alert.setContentText("Please fill all fields.");
                alert.showAndWait();
                return;
            }

            try {
                int length = Integer.parseInt(lengthText);
                float cost = Float.parseFloat(costText);

                DigitalVideoDisc dvd = new DigitalVideoDisc(title, category, director, length, cost);
                store.addMedia(dvd);

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Success");
                alert.setHeaderText(null);
                alert.setContentText("DVD added to store successfully!");
                alert.showAndWait();

                // Clear fields after adding
                titleField.clear();
                categoryField.clear();
                directorField.clear();
                lengthField.clear();
                costField.clear();
            } catch (NumberFormatException ex) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Input Error");
                alert.setHeaderText(null);
                alert.setContentText("Length must be an integer and cost must be a number.");
                alert.showAndWait();
            }
        });

        form.getChildren().addAll(header, titleField, categoryField, directorField, lengthField, costField, addButton);
        return form;
    }
}