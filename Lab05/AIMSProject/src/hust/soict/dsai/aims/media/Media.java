package hust.soict.dsai.aims.media;

import java.time.LocalDate;
import java.util.Comparator;

public abstract class Media {
    private int id;
    private String title;
    private String category;
    private LocalDate dateAdded;
    private float cost;

    public static final Comparator<Media> COMPARE_BY_TITLE_COST = new MediaComparatorByTitleCost();
    public static final Comparator<Media> COMPARE_BY_COST_TITLE = new MediaComparatorByCostTitle();

    public Media() {
    }

    public Media(int id, String title, String category, float cost) {
        this(category, title, cost);
        this.setId(id);
    }

    public Media(String title) {
        this.setTitle(title);
    }

    public Media(String title, String category, float cost) {
        this(title);
        this.setCategory(category);
        this.setCost(cost);
    }

    public Media(String title, float cost) {
        this(title);
        this.setCost(cost);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    public boolean isMatch(String title) {
        return this.getTitle().equals(title);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof Media)) {
            return false;
        }
        Media other = (Media) obj;
        if (this.title == null) {
            return other.title == null;
        }
        return this.title.equals(other.title);
    }

    public int compareTo(Media obj) throws NullPointerException {
        try {
            for (int i = 0; i < this.title.length() && i < obj.getTitle().length(); i++) {
                if ((int) this.title.charAt(i) == (int) obj.getTitle().charAt(i)) {
                    continue;
                } else {
                    return ((int) this.title.charAt(i) - (int) obj.getTitle().charAt(i));
                }
            }
            if (!(this.title.length() == obj.getTitle().length())) {
                return (this.title.length() - obj.getTitle().length());
            }
            for (int i = 0; i < this.category.length() && i < obj.getCategory().length(); i++) {
                if ((int) this.category.charAt(i) == (int) obj.getCategory().charAt(i)) {
                    continue;
                } else {
                    return ((int) this.category.charAt(i) - (int) obj.getTitle().charAt(i));
                }
            }
            if (!(this.category.length() == obj.getCategory().length())) {
                return (this.category.length() - obj.getCategory().length());
            }
            return 0;
        } catch (NullPointerException e) {
            throw e;
        }
    }

    public boolean search(String title) {
        return this.title.toLowerCase().contains(title.toLowerCase());
    }

    public LocalDate getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(LocalDate date) {
        this.dateAdded = date;
    }

    public abstract String getType();

    public abstract String getDetails();

    public String toString() {
        return this.getDetails();
    }
}