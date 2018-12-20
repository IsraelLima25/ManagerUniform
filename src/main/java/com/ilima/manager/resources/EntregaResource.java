package com.ilima.manager.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ilima.manager.domains.Entrega;
import com.ilima.manager.services.EntregaService;

@RestController
@RequestMapping(value = "/entregas")
public class EntregaResource {

	@Autowired
	private EntregaService service;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Entrega>> findAll() {
		List<Entrega> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}

}
