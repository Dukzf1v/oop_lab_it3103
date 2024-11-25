package hust.soict.dsai.aims.store;
import hust.soict.dsai.aims.disc.DigitalVideoDisc;

public class Store {
    private DigitalVideoDisc[] itemsInStore = new DigitalVideoDisc[50];  
    private int numberOfItems = 0;  

    public void addDVD(DigitalVideoDisc dvd) {
        if (numberOfItems < itemsInStore.length) {
            itemsInStore[numberOfItems] = dvd;
            numberOfItems++;
            System.out.println("DVD " + dvd.getTitle() + " has been added to the store.");
        } else {
            System.out.println("The store is full, cannot add more DVDs.");
        }
    }

    public void removeDVD(DigitalVideoDisc dvd) {
        boolean found = false;
        for (int i = 0; i < numberOfItems; i++) {
            if (itemsInStore[i].equals(dvd)) {
                for (int j = i; j < numberOfItems - 1; j++) {
                    itemsInStore[j] = itemsInStore[j + 1];
                }
                itemsInStore[numberOfItems - 1] = null;  
                numberOfItems--;
                System.out.println("DVD " + dvd.getTitle() + " has been removed from the store.");
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("DVD " + dvd.getTitle() + " not found in the store.");
        }
    }

    public void printStoreDetails() {
        System.out.println("***********************STORE***********************");
        if (numberOfItems == 0) {
            System.out.println("No DVDs available in the store.");
        } else {
            for (int i = 0; i < numberOfItems; i++) {
                DigitalVideoDisc dvd = itemsInStore[i];
                System.out.println((i + 1) + ". DVD - " + dvd.getTitle() + " - " + dvd.getCategory() + " - " + dvd.getDirector() + " - " + dvd.getLength() + " mins: " + dvd.getCost() + " $");
            }
        }
        System.out.println("***************************************************");
    }
}
