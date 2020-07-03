package com.sung2063.slideshowviewsample.model;

public class HorizontalCarouselModel {

    private int backgroundColor;
    private int iconId;
    private int iconColor;
    private String title;
    private String description;

    public HorizontalCarouselModel(int backgroundColor, int iconId, int iconColor, String title, String description) {
        this.backgroundColor = backgroundColor;
        this.iconId = iconId;
        this.iconColor = iconColor;
        this.title = title;
        this.description = description;
    }

    public int getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(int backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    public int getIconId() {
        return iconId;
    }

    public void setIconId(int iconId) {
        this.iconId = iconId;
    }

    public int getIconColor() {
        return iconColor;
    }

    public void setIconColor(int iconColor) {
        this.iconColor = iconColor;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
