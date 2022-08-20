package com.stdust.urlManager.service;

import com.stdust.urlManager.model.Collection;
import com.stdust.urlManager.model.Tile;
import com.stdust.urlManager.repositories.CollectionRepository;
import com.stdust.urlManager.repositories.TileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

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
}
