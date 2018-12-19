package com.ilima.manager.domains;

import java.util.Date;

import javax.persistence.Entity;

@Entity
public class Boina extends Item {

	private static final long serialVersionUID = 1L;

	public Boina() {

	}

	public Boina(Integer id, String descricao, Date instante, String cor, Integer quantidade, Integer quantidadeDeRisco
			) {
		super(id, descricao, instante, cor, quantidade, quantidadeDeRisco);

	}
}
