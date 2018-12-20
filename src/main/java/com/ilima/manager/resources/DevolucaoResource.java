package com.ilima.manager.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ilima.manager.domains.Devolucao;
import com.ilima.manager.services.DevolucaoService;

@RestController
@RequestMapping(value = "/devolucoes")
public class DevolucaoResource {

	@Autowired
	private DevolucaoService service;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Devolucao>> findAll() {
		List<Devolucao> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}

}
