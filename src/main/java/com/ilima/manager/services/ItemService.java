package com.ilima.manager.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ilima.manager.domains.Item;
import com.ilima.manager.repositories.ItemRepository;

@Service
public class ItemService {

	@Autowired
	private ItemRepository repo;

	public Item insert(Item obj) {
		return repo.save(obj);
	}

	public List<Item> findAll() {
		return repo.findAll();
	}
}
