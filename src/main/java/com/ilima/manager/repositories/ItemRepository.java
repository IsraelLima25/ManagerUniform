package com.ilima.manager.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ilima.manager.domains.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, Integer> {

}
