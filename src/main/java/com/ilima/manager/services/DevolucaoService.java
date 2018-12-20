package com.ilima.manager.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ilima.manager.domains.Devolucao;
import com.ilima.manager.repositories.DevolucaoRepository;

@Service
public class DevolucaoService {

	@Autowired
	private DevolucaoRepository repo;

	public List<Devolucao> findAll() {

		return repo.findAll();

	}
}
