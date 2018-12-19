package com.ilima.manager.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ilima.manager.domains.Devolucao;

@Repository
public interface DevolucaoRepository extends JpaRepository<Devolucao, Integer> {

}
