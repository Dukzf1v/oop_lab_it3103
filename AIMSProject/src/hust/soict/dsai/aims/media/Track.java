package hust.soict.dsai.aims.media;

public class Track {
    private String title;
    private float length;

    public float getLength() {
        return length;
    }

    public String getTitle() {
        return title;
    }

    public Track(String title, float length) {
        this.title = title;
        this.length = length;
    }

    public void play() {
        System.out.println("Playing track: " + this.getTitle());
        System.out.println("Track length: " + this.getLength());
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if(obj == null || getClass() != obj.getClass()) return false;
        Track track = (Track) obj;
        return title.equals(track.title) && length == track.length;
    }
}