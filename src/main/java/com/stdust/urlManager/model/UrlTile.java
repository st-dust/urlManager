package com.stdust.urlManager.model;

import org.hibernate.validator.constraints.URL;

import javax.persistence.*;

@Entity
public class UrlTile {
    @Id
    @Column(name = "tile_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "url")
    @URL
    private String url;

    public UrlTile() {
    }

    public UrlTile(String name, String description, String url) {
        this.name = name;
        this.description = description;
        this.url = url;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
