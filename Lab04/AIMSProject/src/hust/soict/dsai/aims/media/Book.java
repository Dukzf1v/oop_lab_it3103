package hust.soict.dsai.aims.media;

import java.util.*; 

public class Book extends Media {
    private List<String> authors = new ArrayList<String>();
 
    public Book(int id, String title, String category, float cost, List<String> authors) {
        super(id, title, category, cost);
        this.authors = authors;
    }

    public Book(int id, String title, String category, float cost) {
        super(id, title, category, cost);
    }

    public List<String> getAuthors() {
        return authors;
    }

    public void setAuthors(List<String> authors) {
        this.authors = authors;
    }

    public void addAuthor(String authorName) {
        if(authors.contains(authorName)) {
            System.out.println(authorName + " is already in the list");
        } else {
            authors.add(authorName);
            System.out.println("Author added");
        }
    }

    public void removeAuthor(String authorName) {
        if(authors.contains(authorName)) {
            authors.remove(authorName);
        } else {
            System.out.println(authorName + " is not in the list");
        }
    }

    @Override
    public String toString() {
        return "Book - " + this.getTitle() + " - " + this.getCategory() + " - " + this.getCost() + " - " + this.getAuthors();
    }
}