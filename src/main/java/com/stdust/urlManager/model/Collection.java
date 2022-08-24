package com.stdust.urlManager.model;

import javax.persistence.*;
import java.util.ArrayList;
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

    @ManyToOne
    @JoinColumn(name = "person_id", referencedColumnName = "person_id")
    private Person tileOwner;

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

    public Person getTileOwner() {
        return tileOwner;
    }

    public void setTileOwner(Person tileOwner) {
        this.tileOwner = tileOwner;
    }

    public boolean isOwnedBy(int ownerId) {
        return this.getTileOwner().getPersonId() == ownerId;
    }
}
