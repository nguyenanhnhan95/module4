package com.example.music_information.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(columnDefinition = "longtext", nullable = false)
    private String nameMusic;
    @Column(columnDefinition = "longtext", nullable = false)
    private String singer;
    @Column(columnDefinition = "longtext", nullable = false)
    private String typeSing;
    private boolean flagDelete = false;

    public Song() {
    }

    public Song(int id, String nameMusic, String singer, String typeSing, boolean flagDelete) {
        this.id = id;
        this.nameMusic = nameMusic;
        this.singer = singer;
        this.typeSing = typeSing;
        this.flagDelete = flagDelete;
    }

    public Song(int id, String nameMusic, String singer, String typeSing) {
        this.id = id;
        this.nameMusic = nameMusic;
        this.singer = singer;
        this.typeSing = typeSing;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameMusic() {
        return nameMusic;
    }

    public void setNameMusic(String nameMusic) {
        this.nameMusic = nameMusic;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getTypeSing() {
        return typeSing;
    }

    public void setTypeSing(String typeSing) {
        this.typeSing = typeSing;
    }

    public boolean isFlagDelete() {
        return flagDelete;
    }

    public void setFlagDelete(boolean flagDelete) {
        this.flagDelete = flagDelete;
    }
}
