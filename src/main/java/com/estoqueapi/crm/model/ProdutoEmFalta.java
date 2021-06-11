package com.estoqueapi.crm.model;

import java.io.Serializable;

public class ProdutoEmFalta implements Serializable {
	private String nome;

	public ProdutoEmFalta(String nome) {
		this.nome = nome;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
