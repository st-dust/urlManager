package com.stdust.urlManager.repositories;

import com.stdust.urlManager.model.Tile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TileRepository extends JpaRepository<Tile, Integer> {
//    private List<Tile> getallby
}
