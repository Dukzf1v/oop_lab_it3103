package hust.soict.dsai.aims.media;

import hust.soict.dsai.aims.exception.PlayerException;

public class DigitalVideoDisc extends Disc implements Playable {

    public String getType() {
        return "DVD";
    }

    public String getDetails() {
        return "Product ID: " + this.getId()
                + "\n\tTitle: " + this.getTitle()
                + "\n\tCategory: " + this.getCategory()
                + "\n\tDirector: " + this.getDirector()
                + "\n\tLength: " + this.getLength() + " minutes"
                + "\n\tPrice: $" + this.getCost();
    }
    @Override
    public void play() throws PlayerException {
        if (this.getLength() > 0) {
            System.out.println("Playing DVD: " + this.getTitle());
            System.out.println("DVD length: " + this.getLength() + " minutes");
        } else {
            System.err.println("ERROR: DVD length is non-positive!");
            throw new PlayerException("ERROR: DVD length is non-positive!");
        }
    }

    public DigitalVideoDisc(String title) {
        super(title);
    }

    public DigitalVideoDisc(String title, String category, float cost) {
        super(title, category, cost);
    }

    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        super(title, category, cost);
        this.setDirector(director);
        this.setLength(length);
    }
}