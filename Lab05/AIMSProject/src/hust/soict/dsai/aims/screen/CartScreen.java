package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.screen.fxml.CartScreenController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class CartScreen {
    private Cart cart;

    public CartScreen(Cart cart) {
        this.cart = cart;
    }

    public void show() {
        Stage cartStage = new Stage();
        cartStage.setTitle("Cart");

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/hust/soict/dsai/aims/screen/fxml/cart.fxml"));
            Parent root = loader.load();

            // Get the controller and set the Cart
            CartScreenController controller = loader.getController();
            controller.setCart(cart);

            cartStage.setScene(new Scene(root));
            cartStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}