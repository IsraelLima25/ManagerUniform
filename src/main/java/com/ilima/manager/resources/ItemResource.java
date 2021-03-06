package com.ilima.manager.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ilima.manager.domains.Item;
import com.ilima.manager.services.ItemService;

@RestController
@RequestMapping(value = "/itens")
public class ItemResource {

	@Autowired
	private ItemService service;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Item>> findAll() {
		List<Item> list = service.findAll();		
		return ResponseEntity.ok().body(list);
	}

}
