package hust.soict.dsai.test;

import java.util.List;

import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Track;

import java.util.ArrayList;

public class Polymorphism {

    public static void main(String[] args) {
        List<Media> mediae = new ArrayList<Media>();
        ArrayList<Track> tracks = new ArrayList<Track>();   
        tracks.add(new Track("Song of Hope", 3.0f));  
        tracks.add(new Track("Rhythm of Life", 4.0f));  
        CompactDisc cd = new CompactDisc(1, "Timeless Tunes", "Music", 15.0f, "Legendary Artist", tracks);  
        DigitalVideoDisc dvd = new DigitalVideoDisc(2, "The Great Adventure", "Action", 25.0f, "Famous Director", 150);  
        Book book = new Book(3, "The Ultimate Journey", "Adventure", 12.0f, List.of("Author 1", "Author 2")); 
        mediae.add(cd);
        mediae.add(dvd);
        mediae.add(book);
        for(Media m: mediae) {
            System.out.println(m.toString());
        }
    }

}
