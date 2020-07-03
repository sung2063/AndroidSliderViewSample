package com.sung2063.slideshowviewsample.model;

public class MainOptionModel {

    private int backgroundId;
    private int iconId;
    private int iconColor;
    private String title;
    private String description;
    private int textColorId;

    public MainOptionModel(int backgroundId, int iconId, int iconColor, String title, String description, int textColorId) {
        this.backgroundId = backgroundId;
        this.iconId = iconId;
        this.iconColor = iconColor;
        this.title = title;
        this.description = description;
        this.textColorId = textColorId;
    }

    public int getBackgroundId() {
        return backgroundId;
    }

    public void setBackgroundId(int backgroundId) {
        this.backgroundId = backgroundId;
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

    public int getTextColorId() {
        return textColorId;
    }

    public void setTextColorId(int textColorId) {
        this.textColorId = textColorId;
    }
}
