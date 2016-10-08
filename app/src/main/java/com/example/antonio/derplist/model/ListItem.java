package com.example.antonio.derplist.model;

/**
 * Created by Antonio on 08-10-2016.
 */

public class ListItem {

    private String title;
    private String subtitle;
    private int image;
    private boolean favorite = false;

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public boolean isFavorite() {
        return favorite;
    }

    public void setFavorite(boolean favorite) {
        this.favorite = favorite;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public ListItem(String title, int image) {
        this.title = title;
        this.image = image;
    }
    public ListItem() {

    }
}
