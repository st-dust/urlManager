package com.stdust.urlManager.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "collections")
public class Collection {
    @Id
    @Column(name = "collection_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "title")
    private String title;

    @OneToMany(mappedBy = "collection")
    private List<Tile> tiles;

    public Collection() {
    }

    public Collection(String title, List<Tile> tiles) {
        this.title = title;
        this.tiles = tiles;
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

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Tile> getTiles() {
        return tiles;
    }

    public void setTiles(List<Tile> tiles) {
        this.tiles = tiles;
    }
}
