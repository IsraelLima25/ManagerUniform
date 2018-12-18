package com.ilima.manager.enuns;

public enum TamanhoItem {

	P(1, "Tamanho P"), M(2, "Tamanho M"), G(3, "Tamanho G"), GG(4, "Tamanho GG");

	private Integer cod;
	private String descricao;

	private TamanhoItem(Integer id, String descricao) {
		this.cod = id;
		this.descricao = descricao;

	}

	public Integer getCod() {
		return cod;
	}

	public void setCod(Integer id) {
		this.cod = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public static TamanhoItem toEnum(Integer cod) {

		if (cod == null) {
			return null;
		}

		for (TamanhoItem ti : TamanhoItem.values()) {
			if (cod.equals(ti.getCod())) {
				return ti;
			}
		}

		throw new IllegalArgumentException("Codigo Inválido " + cod);

	}

}
