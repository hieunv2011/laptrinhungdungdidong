package com.example.tuorguide;

import androidx.annotation.NonNull;

import java.io.Serializable;

public class Place implements Serializable {
    private String placeName;
    private String description;
    private Integer placeId;

    public Place(String placeName, String description, Integer placeId) {
        this.placeName = placeName;
        this.description = description;
        this.placeId=placeId;
    }

    public Integer getPlaceId() {
        return placeId;
    }

    public String getPlaceName() {
        return placeName;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @NonNull
    @Override
    public String toString() {

        return "Họ và tên: " + placeName +"Mã số sinh viên: "+description;
    }
}
