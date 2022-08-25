package com.stdust.urlManager.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "collection")
public class Collection {
    @Id
    @Column(name = "collection_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotEmpty(message = "Collection can't have empty name")
    @Size(min = 2, max = 50, message = "Title of collection should have from 2 to 50 characters")
    @Column(name = "title")
    private String title;

    @OneToMany(mappedBy = "collection")
    private List<Tile> tiles;

    @ManyToOne
    @JoinColumn(name = "person_id", referencedColumnName = "person_id")
    private Person collectionOwner;

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

    public Person getCollectionOwner() {
        return collectionOwner;
    }

    public void setCollectionOwner(Person collectionOwner) {
        this.collectionOwner = collectionOwner;
    }

    public boolean collectionIsOwnedBy(int ownerId) {
        return this.getCollectionOwner().getPersonId() == ownerId;
    }
}
