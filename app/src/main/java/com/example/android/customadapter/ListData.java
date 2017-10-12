package com.example.android.customadapter;

/**
 * Created by Ahmad Siafaddin on 10/10/2017.
 */

public class ListData {

    private String nameOfArtists;
    private int imageResource;
    private String nameOfSong;

    public ListData() {
    }

    public ListData(String nameOfArtists, int imageResource, String nameOfSong) {
        this.nameOfArtists = nameOfArtists;
        this.imageResource = imageResource;
        this.nameOfSong = nameOfSong;
    }


    public String getNameOfArtists() {
        return nameOfArtists;
    }

    public void setNameOfArtists(String nameOfArtists) {
        this.nameOfArtists = nameOfArtists;
    }

    public int getImageResource() {
        return imageResource;
    }

    public void setImageResource(int imageResource) {
        this.imageResource = imageResource;
    }

    public String getNameOfSong() {
        return nameOfSong;
    }

    public void setNameOfSong(String nameOfSong) {
        this.nameOfSong = nameOfSong;
    }



}
