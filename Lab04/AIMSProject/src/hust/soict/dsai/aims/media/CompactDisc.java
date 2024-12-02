package hust.soict.dsai.aims.media;

import java.util.ArrayList;

public class CompactDisc extends Disc implements Playable {

    private String artist;
    private ArrayList<Track> tracks;

    public CompactDisc(int id, String title, String category, float cost, String artist, ArrayList<Track> tracks) {
        super(id, title, category, cost);
        this.tracks = tracks;
        this.artist = artist;
        this.setLength(getLength());
    }

    public CompactDisc(int id, String title, String category, float cost) {
        super(id, title, category, cost);
    }

    public String getArtist() {
        return artist;
    }

    public void addTrack(Track song) {
        if (tracks.contains(song)) {
            System.out.println(song.getTitle() + " is already in the CD");
        } else {
            tracks.add(song);
            System.out.println("Track added");
        }
    }

    public void removeTrack(Track song) {
        if (tracks.contains(song)) {
            tracks.remove(song);
        } else {
            System.out.println(song.getTitle() + " is not in the CD");
        }
    }

    @Override
    public String toString() {
        return "CD - " + this.getTitle() + " - " + this.getCategory() + " - " + this.getCost() + " - " + this.getDirector() + " - " + this.getLength() + " - " + this.getArtist();
    }

    public void play() {
        System.out.println("\nTitle: " + getTitle() + "\nArtist: " + getArtist());
        for (Track track : tracks) {
            track.play();
        }
    }
  }