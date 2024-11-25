package hust.soict.dsai.aims.disc;

public class DigitalVideoDisc {

    private static int nbDigitalVideoDiscs = 0;  

    private int id;  
    private String title;
    private String category;
    private String director;
    private int length;
    private float cost;

    public DigitalVideoDisc(String title) {
        this.title = title;
        this.id = ++nbDigitalVideoDiscs; 
    }

    public DigitalVideoDisc(String title, String category, float cost) {
        this.title = title;
        this.category = category;
        this.cost = cost;
        this.id = ++nbDigitalVideoDiscs;  
    }

    public DigitalVideoDisc(String title, String category, String director, float cost) {
        this.title = title;
        this.category = category;
        this.director = director;
        this.cost = cost;
        this.id = ++nbDigitalVideoDiscs; 
    }

    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        this.title = title;
        this.category = category;
        this.director = director;
        this.length = length;
        this.cost = cost;
        this.id = ++nbDigitalVideoDiscs; 
    }

    public void setTitle(String title) {
		this.title = title;
	}
    
    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getCategory() {
        return category;
    }

    public String getDirector() {
        return director;
    }

    public int getLength() {
        return length;
    }

    public float getCost() {
        return cost;
    }

    public static int getTotalDVDsCreated() {
        return nbDigitalVideoDiscs;
    }

    public String toString() {
        return "DVD - " + title + " - " + category + " - " + director + " - " + length + " mins: " + cost + " $";
    }

    public boolean isMatch(String title) {
        return this.title.equalsIgnoreCase(title);
    }
}
