package com.stdust.urlManager.service;

import com.stdust.urlManager.model.Tile;
import com.stdust.urlManager.repositories.TileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class TileService {
    private final TileRepository tileRepository;

    @Autowired
    public TileService(TileRepository tileRepository) {
        this.tileRepository = tileRepository;
    }

    public List<Tile> findAll() {
        return tileRepository.findAll();
    }

    public Tile findById(int id) {
        Optional<Tile> foundTile = tileRepository.findById(id);
        return foundTile.orElse(null);
    }

    @Transactional
    public void save(Tile tile) {
        tileRepository.save(tile);
    }

    @Transactional
    public void update(int id, Tile updatedTile) {
        updatedTile.setId(id);
        tileRepository.save(updatedTile);
    }

    @Transactional
    public void delete(int id) {
        tileRepository.deleteById(id);
    }
}
