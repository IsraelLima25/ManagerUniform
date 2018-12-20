package com.ilima.manager.domains;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class ItemPedido implements Serializable {

	private static final long serialVersionUID = 1L;

	@JsonIgnore
	@EmbeddedId
	private ItemPedidoPk id = new ItemPedidoPk();

	private Integer quantidadePedido;

	public ItemPedido() {

	}

	public ItemPedido(Pedido pedido, Item item, Integer quantidade) {
		id.setPedido(pedido);
		id.setItem(item);
		this.quantidadePedido = quantidade;
	}

	@JsonIgnore
	public Pedido getPedido() {
		return id.getPedido();
	}

	public void setPedido(Pedido obj) {
		id.setPedido(obj);

	}

	public Item getItem() {
		return id.getItem();
	}

	public void setItem(Item obj) {
		id.setItem(obj);
	}

	public Integer getQuantidadePedido() {
		return quantidadePedido;
	}

	public void setQuantidadePedido(Integer quantidade) {
		this.quantidadePedido = quantidade;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ItemPedido other = (ItemPedido) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
