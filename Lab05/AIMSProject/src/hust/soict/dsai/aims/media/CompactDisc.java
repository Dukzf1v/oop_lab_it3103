package hust.soict.dsai.aims.media;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import hust.soict.dsai.aims.exception.PlayerException;

public class CompactDisc extends Disc implements Playable {

    private String artist;
    private int length;
    private List<Track> tracks = new ArrayList<Track>();

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public List<Track> getTracks() {
        return this.tracks;
    }

    public void setTracks(List<Track> tracks) {
        this.tracks = tracks;
    }

    public void addTrack(Track track) {
        if (tracks.contains(track)) {
            System.out.println("This track already exists!");
            return;
        }
        tracks.add(track);
        System.out.println("The track: " + track.getTitle() + " added to list!");
    }

    public void removeTrack(Track track) {
        if (tracks.contains(track)) {
            tracks.remove(track);
            System.out.println("The track: " + track.getTitle() + " removed from list!");
            return;
        }
        System.out.println("Track not found in the list!");
    }

    public int getLength() {
        int totalLength = 0;
        for (Track track : tracks) {
            totalLength += track.getLength();
        }
        return totalLength;
    }

    // Constructor
    public CompactDisc(int id, String title, String category, float cost, int length, String director, String artist, List<Track> track) {
        super(String.valueOf(id), title, category, cost);
        this.artist = artist;
        this.tracks = track;
    }

    public CompactDisc(int id, String title, String category, float cost) {
        super(String.valueOf(id), title, category, cost);
    }

    public CompactDisc(String title) {
        super(title);
    }

    public CompactDisc(String title, String category, String artist, String director, int length, float cost) {
        super(title, category, director, cost);
        this.artist = artist;
        this.length = length;
    }

    public CompactDisc(String title, String author, String director, float cost) {
        super(title, author, director, cost);
    }

@Override
    public void play() throws PlayerException {
        if (this.getLength() > 0) {
            System.out.println("Playing CD: " + this.getTitle());
            System.out.println("CD length: " + getLength() + " minutes");

            for (Track track : tracks) {
                try {
                    track.play();
                } catch (PlayerException e) {
                    throw new PlayerException("ERROR: Track \"" + track.getTitle() + "\" cannot be played.");
                }
            }
        } else {
            System.err.println("ERROR: CD length is non-positive!");
            throw new PlayerException("ERROR: CD length is non-positive!");
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Compact Disc Information:\n");
        sb.append("Title: ").append(getTitle()).append("\n");
        sb.append("Category: ").append(getCategory()).append("\n");
        sb.append("Cost: ").append(getCost()).append("\n");
        sb.append("Artist: ").append(artist).append("\n");
        sb.append("Number of Tracks: ").append(tracks.size()).append("\n");
        sb.append("Total Length: ").append(getLength()).append(" minutes").append("\n");
        return sb.toString();
    }

    @Override
    public String getType() {
        return "Compact Disc";
    }

    @Override
    public String getDetails() {
        return this.toString();
    }
}