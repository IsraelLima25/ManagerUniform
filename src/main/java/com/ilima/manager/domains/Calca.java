package com.ilima.manager.domains;

import java.util.Date;

import javax.persistence.Entity;

import com.ilima.manager.enuns.TamanhoItem;

@Entity
public class Calca extends Item {

	private static final long serialVersionUID = 1L;

	private TamanhoItem tamanho;

	public Calca() {

	}

	public Calca(Integer id, String descricao, Date instante, String cor, Integer quantidade, Integer quantidadeDeRisco,
			TamanhoItem tamanho) {
		super(id, descricao, instante, cor, quantidade, quantidadeDeRisco);
		this.tamanho = tamanho;

	}

	public TamanhoItem getTamanho() {
		return tamanho;
	}

	public void setTamanho(TamanhoItem tamanho) {
		this.tamanho = tamanho;
	}

}
