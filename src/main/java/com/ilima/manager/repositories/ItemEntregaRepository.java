package com.ilima.manager.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ilima.manager.domains.ItemEntrega;

@Repository
public interface ItemEntregaRepository extends JpaRepository<ItemEntrega, Integer> {

}
