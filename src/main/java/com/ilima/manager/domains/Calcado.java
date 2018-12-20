package com.ilima.manager.domains;

import java.util.Date;

import javax.persistence.Entity;

@Entity
public class Calcado extends Item {

	private static final long serialVersionUID = 1L;

	private Integer numero;

	public Calcado() {

	}

	public Calcado(Integer id, String descricao, Date instante, String cor, Integer quantidade,
			Integer quantidadeDeRisco, Integer tamanho) {
		super(id, descricao, instante, cor, quantidade, quantidadeDeRisco);
		this.numero = tamanho;

	}

	public Integer getNumero() {
		return numero;
	}

	public void setTamanho(Integer numero) {
		this.numero = numero;
	}

}
