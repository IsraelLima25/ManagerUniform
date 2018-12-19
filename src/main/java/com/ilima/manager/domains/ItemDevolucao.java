package com.ilima.manager.domains;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class ItemDevolucao {

	@EmbeddedId
	private ItemDevolucaoPK id;

	private Integer quantidade;

	public ItemDevolucao() {

	}

	public ItemDevolucao(ItemDevolucaoPK id, Integer quantidade) {
		this.id = id;
		this.quantidade = quantidade;
	}

	public ItemDevolucaoPK getId() {
		return id;
	}

	public void setId(ItemDevolucaoPK id) {
		this.id = id;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

}
