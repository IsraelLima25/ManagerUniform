package com.ilima.manager;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ilima.manager.domains.Camisa;
import com.ilima.manager.enuns.TamanhoItem;
import com.ilima.manager.services.ItemService;

@SpringBootApplication
public class ManagerUniformApplication implements CommandLineRunner {

	@Autowired
	private ItemService repoItem;

	public static void main(String[] args) {
		SpringApplication.run(ManagerUniformApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Camisa c1 = new Camisa(null,"Camisa Farda",new Date(),"Marrom",50,5,TamanhoItem.M);
		repoItem.insert(c1);
	}

}
