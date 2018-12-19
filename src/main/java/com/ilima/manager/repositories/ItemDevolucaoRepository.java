package com.ilima.manager.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ilima.manager.domains.ItemDevolucao;

@Repository
public interface ItemDevolucaoRepository extends JpaRepository<ItemDevolucao, Integer> {

}
