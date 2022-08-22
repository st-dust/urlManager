package com.stdust.urlManager.service;

import com.stdust.urlManager.model.Collection;
import com.stdust.urlManager.model.Tile;
import com.stdust.urlManager.repositories.CollectionRepository;
import com.stdust.urlManager.repositories.TileRepository;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@Transactional(readOnly = true)
public class CollectionService {
    private final CollectionRepository collectionRepository;

    @Autowired
    public CollectionService(CollectionRepository collectionRepository) {
        this.collectionRepository = collectionRepository;
    }

    public List<Collection> findAll() {
        return collectionRepository.findAll();
    }

    public Collection findById(int id) {
        Optional<Collection> foundCollection = collectionRepository.findById(id);
        return foundCollection.orElse(null);
    }

    @Transactional
    public void save(Collection collection) {
        collectionRepository.save(collection);
    }

    @Transactional
    public void update(int id, Collection updatedCollection) {
        updatedCollection.setId(id);
        collectionRepository.save(updatedCollection);
    }

    @Transactional
    public void delete(int id) {
        collectionRepository.deleteById(id);
    }

    public List<Tile> getTilesByCollectionId(int id) {
        Optional<Collection> collection = collectionRepository.findById(id);

        if (collection.isPresent()) {
            Hibernate.initialize(collection.get().getTiles());
            return collection.get().getTiles();
        } else {
            return null;
        }
    }

    public Map<Collection, List<Tile>> collection2tiles() {
        Map<Collection,List<Tile>> map = new HashMap<>();
        Collection foundCollection;
        List<Tile> tilesOfCollection;

        for (Collection collection : collectionRepository.findAll()) {
            tilesOfCollection =
                    getTilesByCollectionId(collection.getId());
            //Check if collection has any Tiles at all
            if (tilesOfCollection != null) {
                foundCollection = collection;
                map.put(foundCollection, tilesOfCollection);
            }
        }
        return map;
    }
}
