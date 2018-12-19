package com.ilima.manager.enuns;

public enum EstadoPedido {

	PENDENTE(1, "Pendente"), RECEBIDO(2, "Recebido");

	private Integer cod;
	private String descricao;

	private EstadoPedido(Integer cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}

	public Integer getCod() {
		return cod;
	}

	public void setCod(Integer cod) {
		this.cod = cod;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public static EstadoPedido toEnum(Integer cod) {

		if (cod == null) {
			return null;
		}

		for (EstadoPedido ep : EstadoPedido.values()) {
			if (cod.equals(ep.getCod())) {
				return ep;
			}
		}

		throw new IllegalArgumentException("Codigo Inválido " + cod);

	}

}
