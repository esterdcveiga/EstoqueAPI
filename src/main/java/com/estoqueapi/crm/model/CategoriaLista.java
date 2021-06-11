package com.estoqueapi.crm.model;

import java.io.Serializable;

public class CategoriaLista implements Serializable{
	
	private String nome;
	private long quantidade;
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public long getQuantidade() {
		return quantidade;
	}
	
	public void setQuantidade(long quantidade) {
		this.quantidade = quantidade;
	}

}
