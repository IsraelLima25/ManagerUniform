package com.ilima.manager.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ilima.manager.domains.Pedido;
import com.ilima.manager.repositories.PedidoRepository;

@Service
public class PedidoService {

	@Autowired
	private PedidoRepository repo;

	public Pedido find(Integer id) throws Exception {
		Optional<Pedido> obj = repo.findById(id);
		return obj.orElseThrow(() -> new Exception());
	}

}
