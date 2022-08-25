package com.stdust.urlManager.model;

import org.hibernate.validator.constraints.URL;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "tile")
public class Tile {
    @Id
    @Column(name = "tile_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotEmpty(message = "Tile can't have empty name")
    @Size(min = 2, max = 30, message = "Title should have from 2 to 30 characters")
    @Column(name = "title")
    private String title;

    @Size(max = 100, message = "Description can contain only up to 100 characters")
    @Column(name = "description")
    private String description;

    @NotEmpty(message = "Tile can't have empty URL")
    @URL(message = "Should be in URL format")
    @Column(name = "url")
    private String url;

    @ManyToOne
    @JoinColumn(name = "collection_id", referencedColumnName = "collection_id")
    private Collection collection;

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

    public Collection getCollection() {
        return collection;
    }

    public void setCollection(Collection collection) {
        this.collection = collection;
    }
}
