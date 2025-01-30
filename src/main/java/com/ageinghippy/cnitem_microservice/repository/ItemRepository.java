package com.ageinghippy.cnitem_microservice.repository;

import com.ageinghippy.cnitem_microservice.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
}
