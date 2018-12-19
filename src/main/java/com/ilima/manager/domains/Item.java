package com.ilima.manager.domains;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Item implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String descricao;
	private Date instante;
	private String cor;
	private Integer quantidade;
	private Integer quantidadeDeRisco;

	@JsonIgnore
	@OneToMany(mappedBy = "id.item")
	private Set<ItemPedido> pedido = new HashSet<>();
	
	@JsonIgnore
	@OneToMany(mappedBy = "id.entrega")
	private Set<ItemEntrega> entrega = new HashSet<>();
	
	@JsonIgnore
	@OneToMany(mappedBy = "id.devolucao")
	private Set<ItemDevolucao> devolucao = new HashSet<>();

	public Item() {

	}

	public Item(Integer id, String descricao, Date instante, String cor, Integer quantidade,
			Integer quantidadeDeRisco) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.instante = instante;
		this.cor = cor;
		this.quantidade = quantidade;
		this.quantidadeDeRisco = quantidadeDeRisco;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Date getInstante() {
		return instante;
	}

	public void setInstante(Date instante) {
		this.instante = instante;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Integer getQuantidadeDeRisco() {
		return quantidadeDeRisco;
	}

	public void setQuantidadeDeRisco(Integer quantidadeDeRisco) {
		this.quantidadeDeRisco = quantidadeDeRisco;
	}

	public Set<ItemPedido> getPedidos() {
		return pedido;
	}

	public void setPedidos(Set<ItemPedido> pedidos) {
		this.pedido = pedidos;
	}

	public Set<ItemEntrega> getEntrega() {
		return entrega;
	}

	public void setEntrega(Set<ItemEntrega> entrega) {
		this.entrega = entrega;
	}

	public Set<ItemDevolucao> getDevolucao() {
		return devolucao;
	}

	public void setDevolucao(Set<ItemDevolucao> devolucao) {
		this.devolucao = devolucao;
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
		Item other = (Item) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
