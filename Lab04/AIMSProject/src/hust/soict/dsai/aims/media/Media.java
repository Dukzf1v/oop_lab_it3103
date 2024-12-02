package hust.soict.dsai.aims.media;

import java.util.*;

public abstract class Media {
    private int id;
    private String title;
    private String category;
    private float cost;

    public static final Comparator<Media> COMPARE_BY_TITLE_COST = new MediaComparatorByTitleCost();
    public static final Comparator<Media> COMPARE_BY_COST_TITLE = new MediaComparatorByCostTitle();
        
    public Media(int id, String title, String category, float cost) {
        this.setId(id);
        this.setTitle(title);
        this.setCategory(category);
        this.setCost(cost);
    }

    public Media(String title){
        this.setTitle(title);
    }

    public Media(String title, String category, float cost){
        this(title);
        this.setCategory(category);
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

    public boolean equals(Media obj) {
        return this.getTitle().equals(obj.getTitle());
    }

    @Override
    public String toString() {
        return "Media - " + this.getTitle() + " - " + this.getCategory() + " - " + this.getCost();
    }
}