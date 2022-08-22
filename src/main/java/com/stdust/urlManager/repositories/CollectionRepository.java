package com.stdust.urlManager.repositories;

import com.stdust.urlManager.model.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CollectionRepository extends JpaRepository<Collection, Integer> {
    Optional<Collection> findById(int id);
}
