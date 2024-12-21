package hust.soict.dsai.aims.store;

import hust.soict.dsai.aims.media.Media;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Store {
    private ObservableList<Media> itemsInStore = FXCollections.observableArrayList();
    private int nbItems = 0;

    public void addMedia(Media media) {
        itemsInStore.add(media);
        nbItems += 1;
        System.out.println("The media is added to store!");
    }

    public void removeMedia(Media media) {
        if (itemsInStore.remove(media)) {
            nbItems -= 1;
            System.out.println("The media is removed from store!");
        } else {
            System.out.println("Media does not exist!");
        }
    }

    public Media searchMedia(String title) {
        for (Media medium : itemsInStore) {
            if (medium.getTitle().equalsIgnoreCase(title)) {
                return medium;
            }
        }
        return null;
    }

    public ObservableList<Media> getItemsInStore() {
        return itemsInStore;
    }

    public void print() {
        System.out.println("\n***********************STORE***********************");
        for (int i = 0; i < itemsInStore.size(); i++) {
            System.out.println((i + 1) + ".\t" + itemsInStore.get(i).getDetails() + "\n");
        }
        System.out.println("***************************************************\n");
    }
}