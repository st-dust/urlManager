package com.stdust.urlManager.model;

import org.hibernate.validator.constraints.URL;

import javax.persistence.*;

@Entity
@Table(name = "tile")
public class Tile {
    @Id
    @Column(name = "tile_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "url")
    @URL
    private String url;

    public Tile() {
    }

    public Tile(String name, String description, String url) {
        this.title = name;
        this.description = description;
        this.url = url;
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

    public void setTitle(String name) {
        this.title = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}