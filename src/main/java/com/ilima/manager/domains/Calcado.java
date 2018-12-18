package com.ilima.manager.domains;

import java.util.Date;

import javax.persistence.Entity;

import com.ilima.manager.enuns.TamanhoItem;

@Entity
public class Calcado extends Item {

	private static final long serialVersionUID = 1L;

	private Integer numero;

	public Calcado() {

	}

	public Calcado(Integer id, String descricao, Date instante, String cor, Integer quantidade,
			Integer quantidadeDeRisco, TamanhoItem tamanho) {
		super(id, descricao, instante, cor, quantidade, quantidadeDeRisco);
		this.numero = tamanho.getCod();

	}

	public Integer getTamanho() {
		return numero;
	}

	public void setTamanho(Integer tamanho) {
		this.numero = tamanho;
	}

}
