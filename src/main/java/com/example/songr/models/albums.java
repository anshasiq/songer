package com.example.songr.models;

import javax.persistence.*;
import java.util.List;

@Entity
//@Table(name = "employees")

public class albums {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String artist;
    private int songCount;
    private int length;
    private String imageUrl;

    @OneToMany(mappedBy = "songAt", cascade = CascadeType.ALL)
    private List <Song> songs;

    public albums(String title, String artist, int songCount, int length, String imageUrl) {
        this.title = title;
        this.artist = artist;
        this.songCount = songCount;
        this.length = length;
        this.imageUrl = imageUrl;
    }

    public List<Song> getSongs() {
        return songs;
    }

    public albums() {
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public int getSongCount() {
        return songCount;
    }

    public int getLength() {
        return length;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public void setSongCount(int songCount) {
        this.songCount = songCount;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
