package hust.soict.dsai.aims;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.*;
import hust.soict.dsai.aims.store.Store;
import hust.soict.dsai.aims.exception.PlayerException;
import javafx.scene.control.Alert;

import javax.naming.LimitExceededException;
import java.util.Scanner;

public class Aims {
    private static Store store = new Store();
    private static Cart cart = new Cart();
    private static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        try {
            showMenu();
        } catch (Exception e) {
            e.printStackTrace();
            showExceptionDialog(e);
        }
    }

    public static void showMenu() {
        try {
            System.out.println("AIMS: ");
            System.out.println("--------------------------------");
            System.out.println("1. View store");
            System.out.println("2. Update store");
            System.out.println("3. See current cart");
            System.out.println("0. Exit");
            System.out.println("--------------------------------");
            System.out.println("Please choose a number: 0-1-2-3");

            int choice = scan.nextInt();
            scan.nextLine();

            // Invalid input
            while (choice != 0 && choice != 1 && choice != 2 && choice != 3) {
                System.out.println("Please choose a valid number.");
                choice = scan.nextInt();
                scan.nextLine();
            }

            // View store
            if (choice == 1) {
                storeMenu();
            }

            // Update store
            else if (choice == 2) {
                updateStoreMenu();
            }

            // See current cart
            else if (choice == 3) {
                cartMenu();
            }

            // Exit
            else if (choice == 0) {
                System.out.println("Thank you for using our service. We hope to see you again.");
                System.exit(0);
            }
        } catch (Exception e) {
            try {
                throw e;
            } catch (LimitExceededException ex) {
                throw new RuntimeException(ex);
            }
        }
    }

    public static void storeMenu() throws LimitExceededException {
        try {
            store.print();

            System.out.println("Options: ");
            System.out.println("--------------------------------");
            System.out.println("1. See a media's details");
            System.out.println("2. Add a media to cart");
            System.out.println("3. Play a media");
            System.out.println("4. See current cart");
            System.out.println("0. Exit");
            System.out.println("--------------------------------");
            System.out.println("Please choose a number: 0-1-2-3-4");

            int choice = scan.nextInt();
            scan.nextLine();

            // Invalid input
            while (choice != 0 && choice != 1 && choice != 2 && choice != 3 && choice != 4) {
                System.out.println("Please choose a valid number.");
                choice = scan.nextInt();
                scan.nextLine();
            }

            // Exit
            if (choice == 0) {
                showMenu();
            }

            // See a media's details
            else if (choice == 1) {
                System.out.println("Please enter the title of the media you want to see details of: ");
                String title = scan.nextLine();
                Media medium = store.searchMedia(title);
                // Invalid name
                while (medium == null) {
                    System.out.println("Please enter a valid product name.");
                    title = scan.nextLine();
                    medium = store.searchMedia(title);
                }
                seeMediaMenu(medium);
            }

            // Add a media to cart
            else if (choice == 2) {
                System.out.println("Please enter the title of the media you want to add to cart: ");
                String title = scan.nextLine();
                Media medium = store.searchMedia(title);

                // Invalid name
                while (medium == null) {
                    System.out.println("Please enter a valid product name.");
                    title = scan.nextLine();
                    medium = store.searchMedia(title);
                }

                cart.addMedia(medium);
                System.out.println("Total number of media in cart: " + cart.getSize());
                System.out.println("Enter any key to continue");
                scan.nextLine();
                storeMenu();
            }

            // Play a media
            else if (choice == 3) {
                System.out.println("Please enter the title of the media you want to play: ");
                String title = scan.nextLine();
                Media medium = store.searchMedia(title);

                // Invalid name
                while (!(medium instanceof Playable)) {
                    System.out.println("Please enter a valid product name.");
                    title = scan.nextLine();
                    medium = store.searchMedia(title);
                }
                Playable playable = (Playable) medium;

                try {
                    playable.play();
                } catch (PlayerException e) {
                    System.err.println(e.getMessage());
                    System.err.println(e.toString());
                    e.printStackTrace();
                    showExceptionDialog(e);
                }

                System.out.println("Enter any key to continue");
                scan.nextLine();
                storeMenu();
            }

            // See current cart
            else if (choice == 4) {
                cartMenu();
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public static void cartMenu() {
        try {
            cart.print();

            System.out.println("Options: ");
            System.out.println("--------------------------------");
            System.out.println("1. Filter medias in cart");
            System.out.println("2. Sort medias in cart");
            System.out.println("3. Remove media from cart");
            System.out.println("4. Play a media");
            System.out.println("5. Place order");
            System.out.println("0. Exit");
            System.out.println("--------------------------------");
            System.out.println("Please choose a number: 0-1-2-3-4-5");

            int choice = scan.nextInt();
            scan.nextLine();

            // Invalid input
            while (choice != 0 && choice != 1 && choice != 2 && choice != 3 && choice != 4 && choice != 5) {
                System.out.println("Please choose a valid number.");
                choice = scan.nextInt();
                scan.nextLine();
            }

            // Exit
            if (choice == 0) {
                showMenu();
            }

            // Filter media
            else if (choice == 1) {
                filterCartMenu();
            }

            // Sort media
            else if (choice == 2) {
                sortCartMenu();
            }

            // Remove media from cart
            else if (choice == 3) {
                System.out.println("Please enter the title of the media you want to remove: ");
                String title = scan.nextLine();
                Media medium = cart.searchMedia(title);
                // Invalid name
                while (medium == null) {
                    System.out.println("Please enter a valid product name.");
                    title = scan.nextLine();
                    medium = cart.searchMedia(title);
                }
                cart.removeMedia(medium);
                System.out.println("Media removed. Enter any key to continue");
                scan.nextLine();
                cartMenu();
            }

            // Play media
            else if (choice == 4) {
                System.out.println("Please enter the title of the media you want to play: ");
                String title = scan.nextLine();
                Media medium = cart.searchMedia(title);

                // Invalid name
                while (!(medium instanceof Playable)) {
                    System.out.println("Please enter a valid product name.");
                    title = scan.nextLine();
                    medium = cart.searchMedia(title);
                }
                Playable playable = (Playable) medium;

                try {
                    playable.play();
                } catch (PlayerException e) {
                    System.err.println(e.getMessage());
                    System.err.println(e.toString());
                    e.printStackTrace();
                    showExceptionDialog(e);
                }

                System.out.println("Enter any key to continue");
                scan.nextLine();
                cartMenu();
            }

            // Place order
            else if (choice == 5) {
                if (cart.getSize() == 0) {
                    System.out.println("You cannot place an empty order\n");
                    cartMenu();
                } else {
                    cart = new Cart();
                    System.out.println("Your order has been placed\n");
                    showMenu();
                }
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public static void updateStoreMenu() {
        try {
            store.print();

            System.out.println("Options: ");
            System.out.println("--------------------------------");
            System.out.println("1. Add media to the store");
            System.out.println("2. Remove media from the store");
            System.out.println("0. Exit");
            System.out.println("--------------------------------");
            System.out.println("Please choose a number: 0-1-2");

            int choice = scan.nextInt();
            scan.nextLine();

            // Invalid input
            while (choice != 0 && choice != 1 && choice != 2) {
                System.out.println("Please choose a valid number.");
                choice = scan.nextInt();
                scan.nextLine();
            }

            // Exit
            if (choice == 0) {
                showMenu();
            }

            // Add media
            else if (choice == 1) {
                addToStoreMenu();
            }

            // Remove media
            else if (choice == 2) {
                removeFromStoreMenu();
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public static void filterCartMenu() {
        try {
            System.out.println("Options: ");
            System.out.println("--------------------------------");
            System.out.println("1. Filter by ID");
            System.out.println("2. Filter by title");
            System.out.println("0. Exit");
            System.out.println("--------------------------------");
            System.out.println("Please choose a number: 0-1-2");

            int choice = scan.nextInt();
            scan.nextLine();

            // Invalid input
            while (choice != 0 && choice != 1 && choice != 2) {
                System.out.println("Please choose a valid number.");
                choice = scan.nextInt();
                scan.nextLine();
            }

            // Exit
            if (choice == 0) {
                cartMenu();
            }

            // ID
            else if (choice == 1) {
                System.out.println("Please enter ID number");
                int id = scan.nextInt();
                scan.nextLine();
                cart.filterMedia(id);
                System.out.println("Enter any key to continue");
                scan.nextLine();
                cartMenu();
            }

            // Title
            else if (choice == 2) {
                System.out.println("Please enter keyword");
                String keyword = scan.nextLine();
                cart.filterMedia(keyword);
                System.out.println("Enter any key to continue");
                scan.nextLine();
                cartMenu();
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public static void sortCartMenu() {
        try {
            System.out.println("Options: ");
            System.out.println("--------------------------------");
            System.out.println("1. Sort by title");
            System.out.println("2. Sort by cost");
            System.out.println("0. Exit");
            System.out.println("--------------------------------");
            System.out.println("Please choose a number: 0-1-2");

            int choice = scan.nextInt();
            scan.nextLine();

            // Invalid input
            while (choice != 0 && choice != 1 && choice != 2) {
                System.out.println("Please choose a valid number.");
                choice = scan.nextInt();
                scan.nextLine();
            }

            // Exit
            if (choice == 0) {
                cartMenu();
            }

            // Sort by title
            else if (choice == 1) {
                cart.sortByTitle();
                System.out.println("Your cart has been sorted by title\n");
                cart.print();
                System.out.println("Enter any key to continue");
                scan.nextLine();
                cartMenu();
            }

            // Sort by cost
            else if (choice == 2) {
                cart.sortByCost();
                System.out.println("Your cart has been sorted by cost\n");
                cart.print();
                System.out.println("Enter any key to continue");
                scan.nextLine();
                cartMenu();
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public static void seeMediaMenu(Media medium) {
        try {
            // Book
            if (medium instanceof Book) {
                System.out.println("\t" + medium.getDetails());
                System.out.println("\tDate added: " + medium.getDateAdded());
                System.out.println("Options: ");
                System.out.println("--------------------------------");
                System.out.println("1. Add this product to cart");
                System.out.println("0. Exit");
                System.out.println("--------------------------------");
                System.out.println("Please choose a number: 0-1");
                int choice = scan.nextInt();
                scan.nextLine();
                while (choice != 0 && choice != 1) {
                    System.out.println("Please enter a valid number.");
                    choice = scan.nextInt();
                    scan.nextLine();
                }
                if (choice == 1) {
                    cart.addMedia((Book) medium);
                    System.out.println("Enter any key to continue");
                    scan.nextLine();

                    storeMenu();
                } else if (choice == 0) {
                    storeMenu();
                }
            }

            // CD or DVD
            else if (medium instanceof Disc) {
                System.out.println("\t" + medium.getDetails());
                System.out.println("\tDate added: " + medium.getDateAdded());
                System.out.println("Options: ");
                System.out.println("--------------------------------");
                System.out.println("1. Add this product to cart");
                System.out.println("2. Play this media");
                System.out.println("0. Exit");
                System.out.println("--------------------------------");
                System.out.println("Please choose a number: 0-1-2");
                int choice = scan.nextInt();
                scan.nextLine();
                while (choice != 0 && choice != 1 && choice != 2) {
                    System.out.println("Please enter a valid number.");
                    choice = scan.nextInt();
                    scan.nextLine();
                }
                if (choice == 1) {
                    cart.addMedia((Disc) medium);
                    System.out.println("Enter any key to continue");
                    scan.nextLine();

                    storeMenu();
                } else if (choice == 2) {
                    Playable playable = (Playable) medium;
                    try {
                        playable.play();
                    } catch (PlayerException e) {
                        System.err.println(e.getMessage());
                        System.err.println(e.toString());
                        e.printStackTrace();
                        showExceptionDialog(e);
                    }
                    System.out.println("Enter any key to continue");
                    scan.nextLine();
                    storeMenu();
                } else if (choice == 0) {
                    storeMenu();
                }
            }
        } catch (Exception e) {
            try {
                throw e;
            } catch (LimitExceededException ex) {
                throw new RuntimeException(ex);
            }
        }
    }

    public static void addToStoreMenu() {
        try {
            System.out.println("Options: ");
            System.out.println("--------------------------------");
            System.out.println("1. Add a new CD to the store");
            System.out.println("2. Add a new DVD to the store");
            System.out.println("3. Add a new book to the store");
            System.out.println("0. Exit");
            System.out.println("--------------------------------");
            System.out.println("Please choose a number: 0-1-2-3");

            int choice = scan.nextInt();
            scan.nextLine();

            while (choice != 0 && choice != 1 && choice != 2 && choice != 3) {
                System.out.println("Please choose a valid number.");
                choice = scan.nextInt();
                scan.nextLine();
            }

            if (choice == 0) {
                updateStoreMenu();
            }

            // Add CD
            else if (choice == 1) {
                System.out.println("Please enter the information of the new CD");
                System.out.println("Title: ");
                String title = scan.nextLine();
                System.out.println("Category: ");
                String category = scan.nextLine();
                System.out.println("Artist: ");
                String artist = scan.nextLine();
                System.out.println("Director: ");
                String director = scan.nextLine();
                System.out.println("Length: ");
                int length = scan.nextInt();
                scan.nextLine();
                System.out.println("Price: ");
                float price = Float.parseFloat(scan.nextLine());
                store.addMedia(new CompactDisc(title, category, artist, director, length, price));
                System.out.println("CD added. Enter any key to continue");
                scan.nextLine();
                updateStoreMenu();
            }

            // Add DVD
            else if (choice == 2) {
                System.out.println("Please enter the information of the new DVD");
                System.out.println("Title: ");
                String title = scan.nextLine();
                System.out.println("Category: ");
                String category = scan.nextLine();
                System.out.println("Director: ");
                String director = scan.nextLine();
                System.out.println("Length: ");
                int length = scan.nextInt();
                scan.nextLine();
                System.out.println("Price: ");
                float price = Float.parseFloat(scan.nextLine());
                store.addMedia(new DigitalVideoDisc(title, category, director, length, price));
                System.out.println("DVD added. Enter any key to continue");
                scan.nextLine();
                updateStoreMenu();
            }

            // Add Book
            else if (choice == 3) {
                System.out.println("Please enter the information of the new book");
                System.out.println("Title: ");
                String title = scan.nextLine();
                System.out.println("Category: ");
                String category = scan.nextLine();
                System.out.println("Number of pages: ");
                int numPages = scan.nextInt();
                scan.nextLine();
                System.out.println("Price: ");
                float price = Float.parseFloat(scan.nextLine());
                store.addMedia(new Book(title, category, numPages, price));
                System.out.println("Book added. Enter any key to continue");
                scan.nextLine();
                updateStoreMenu();
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public static void removeFromStoreMenu() {
        try {
            store.print();

            System.out.println("Please enter the title of the media you want to remove: ");
            String title = scan.nextLine();
            Media medium = store.searchMedia(title);
            while (medium == null) {
                System.out.println("Please enter a valid product name.");
                title = scan.nextLine();
                medium = store.searchMedia(title);
            }
            store.removeMedia(medium);
            System.out.println("Media removed. Enter any key to continue");
            scan.nextLine();
            updateStoreMenu();
        } catch (Exception e) {
            throw e;
        }
    }

    private static void showExceptionDialog(Exception e) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Exception Dialog");
        alert.setHeaderText("An error occurred");
        alert.setContentText(e.getMessage());

        e.printStackTrace();

        alert.showAndWait();
    }
}