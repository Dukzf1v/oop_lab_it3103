package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Playable;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

import javax.naming.LimitExceededException;

public class MediaStore extends VBox {
    private Media media;
    private Cart cart;
    private StoreScreen storeScreen;

    public MediaStore(Media media, Cart cart, StoreScreen storeScreen) {
        this.media = media;
        this.cart = cart;
        this.storeScreen = storeScreen;

        this.setAlignment(Pos.CENTER);
        this.setSpacing(10);
        this.setStyle("-fx-border-color: black; -fx-padding: 10;");

        // Create title label
        Label title = new Label(media.getTitle());
        title.setFont(new Font(20));

        // Create cost label
        Label cost = new Label(media.getCost() + " $");

        // Create buttons
        HBox buttonContainer = new HBox();
        buttonContainer.setAlignment(Pos.CENTER);
        buttonContainer.setSpacing(10);

        Button addToCartButton = new Button("Add to cart");
        addToCartButton.setOnAction(e -> {
            try {
                cart.addMedia(media);
            } catch (LimitExceededException ex) {
                throw new RuntimeException(ex);
            }
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Cart Update");
            alert.setHeaderText(null);
            alert.setContentText(media.getTitle() + " has been added to the cart.");
            alert.showAndWait();
        });
        buttonContainer.getChildren().add(addToCartButton);

        // Play button if media is playable
        if (media instanceof Playable) {
            Button playButton = new Button("Play");
            playButton.setOnAction(e -> storeScreen.playMedia(media));
            buttonContainer.getChildren().add(playButton);
        }

        // Add components to the VBox
        this.getChildren().addAll(title, cost, buttonContainer);
    }
}