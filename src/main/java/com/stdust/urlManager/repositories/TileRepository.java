package com.stdust.urlManager.repositories;

import com.stdust.urlManager.model.Tile;
import com.stdust.urlManager.service.CollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Repository
public interface TileRepository extends JpaRepository<Tile, Integer> {
    List<Tile> findByOrderByIdAsc();
}
