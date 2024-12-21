package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.store.Store;
import javafx.application.Application;
import javafx.collections.ListChangeListener;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.util.ArrayList;

public class StoreScreen extends Application {
    private Store store;
    private Cart cart;

    public StoreScreen() {
        this.store = initializeStore();
        this.cart = new Cart();
    }

    public StoreScreen(Store store, Cart cart) {
        this.store = store;
        this.cart = cart;
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Store");

        // Create the main layout
        BorderPane mainLayout = new BorderPane();
        mainLayout.setTop(createNorth(primaryStage));
        mainLayout.setCenter(createCenter());

        Scene scene = new Scene(mainLayout, 1024, 768);
        primaryStage.setScene(scene);
        primaryStage.show();

        store.getItemsInStore().addListener((ListChangeListener<Media>) change -> {
            mainLayout.setCenter(createCenter());
        });
    }

    private VBox createNorth(Stage stage) {
        VBox north = new VBox();
        north.getChildren().add(createMenuBar(stage));
        north.getChildren().add(createHeader());
        return north;
    }

    private MenuBar createMenuBar(Stage stage) {
        MenuBar menuBar = new MenuBar();

        Menu optionsMenu = new Menu("Options");

        Menu updateStoreMenu = new Menu("Update Store");
        MenuItem addBook = new MenuItem("Add Book");
        addBook.setOnAction(e -> {
            AddBookToStoreScreen addBookScreen = new AddBookToStoreScreen(store, cart);
            try {
                addBookScreen.start(new Stage());
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        MenuItem addCD = new MenuItem("Add CD");
        addCD.setOnAction(e -> {
            AddCompactDiscToStoreScreen addCDScreen = new AddCompactDiscToStoreScreen(store, cart);
            try {
                addCDScreen.start(new Stage());
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        MenuItem addDVD = new MenuItem("Add DVD");
        addDVD.setOnAction(e -> {
            AddDigitalVideoDiscToStoreScreen addDVDScreen = new AddDigitalVideoDiscToStoreScreen(store, cart);
            try {
                addDVDScreen.start(new Stage());
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        updateStoreMenu.getItems().addAll(addBook, addCD, addDVD);

        MenuItem viewCart = new MenuItem("View Cart");
        viewCart.setOnAction(e -> {
            CartScreen cartScreen = new CartScreen(cart);
            cartScreen.show();
        });

        optionsMenu.getItems().addAll(updateStoreMenu, viewCart);
        menuBar.getMenus().add(optionsMenu);

        return menuBar;
    }

    private HBox createHeader() {
        HBox header = new HBox();
        header.setSpacing(10);

        Label title = new Label("AIMS");
        title.setStyle("-fx-font-size: 50; -fx-text-fill: cyan;");

        Button cartButton = new Button("View Cart");
        cartButton.setOnAction(e -> {
            CartScreen cartScreen = new CartScreen(cart);
            cartScreen.show();
        });

        Region spacer = new Region();
        HBox.setHgrow(spacer, Priority.ALWAYS);

        header.getChildren().addAll(title, spacer, cartButton);
        return header;
    }

    private GridPane createCenter() {
        GridPane center = new GridPane();
        center.setHgap(20);
        center.setVgap(20);
        center.setPadding(new Insets(20, 20, 20, 20));

        ArrayList<Media> mediaInStore = new ArrayList<>(store.getItemsInStore());

        for (int i = 0; i < mediaInStore.size(); i++) {
            Media media = mediaInStore.get(i);
            MediaStore cell = new MediaStore(media, cart, this);
            center.add(cell, i % 3, i / 3);
        }

        return center;
    }

    private Store initializeStore() {
        Store store = new Store();
        store.addMedia(new Book("Book1", "Genre1", 10.0f));
        store.addMedia(new Book("Book2", "Genre2", 12.5f));
        store.addMedia(new DigitalVideoDisc("DVD1", "Action", "Director1", 120, 15.0f));
        store.addMedia(new DigitalVideoDisc("DVD2", "Comedy", "Director2", 90, 18.0f));
        store.addMedia(new CompactDisc("CD1", "Pop", "Artist1", "Artist1", 42, 9.99f));
        store.addMedia(new CompactDisc("CD2", "Rock", "Artist2", "Artist2", 50, 11.99f));
        store.addMedia(new Book("Book3", "Genre3", 8.99f));
        store.addMedia(new DigitalVideoDisc("DVD3", "Thriller", "Director3", 110, 20.0f));
        store.addMedia(new CompactDisc("CD3", "Jazz", "Artist3", "Artist3", 35, 7.99f));
        return store;
    }

    public static void main(String[] args) {
        launch(args);
    }

    public void playMedia(Media media) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Playing Media");
        alert.setHeaderText(null);
        alert.setContentText("Playing: " + media.getTitle());
        alert.showAndWait();
    }
}