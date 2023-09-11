package com.example.songr.models;

import javax.persistence.*;

@Entity
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private int length_in_seconds;
    private int trackNumber;

    @ManyToOne
    private albums songAt;

    public Song() {
    }

    public Song(String title, int length_in_seconds, int trackNumber, albums songAt) {
        this.title = title;
        this.length_in_seconds = length_in_seconds;
        this.trackNumber = trackNumber;
        this.songAt = songAt;
    }

    public String getTitle() {
        return title;
    }

//    public void setTitle(String title) {
//        this.title = title;
//    }

    public int getLength_in_seconds() {
        return length_in_seconds;
    }

    public void setLength_in_seconds(int length_in_seconds) {
        this.length_in_seconds = length_in_seconds;
    }

    public int getTrackNumber() {
        return trackNumber;
    }

    public void setTrackNumber(int trackNumber) {
        this.trackNumber = trackNumber;
    }

    public albums getSongAt() {
        return songAt;
    }

    public void setSongAt(albums songAt) {
        this.songAt = songAt;
    }
}
