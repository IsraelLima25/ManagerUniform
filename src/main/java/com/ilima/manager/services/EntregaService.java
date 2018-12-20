package com.ilima.manager.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ilima.manager.domains.Entrega;
import com.ilima.manager.repositories.EntregaRepository;

@Service
public class EntregaService {

	@Autowired
	private EntregaRepository repo;

	public List<Entrega> findAll() {
		return repo.findAll();
	}
}
