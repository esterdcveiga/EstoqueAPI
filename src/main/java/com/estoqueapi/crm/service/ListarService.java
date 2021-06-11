package com.estoqueapi.crm.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.estoqueapi.crm.entity.Categoria;
import com.estoqueapi.crm.entity.Fornecedor;
import com.estoqueapi.crm.entity.Produto;
import com.estoqueapi.crm.model.CategoriaLista;
import com.estoqueapi.crm.model.ProdutoEmFalta;
import com.estoqueapi.crm.repository.CategoriaRepository;
import com.estoqueapi.crm.repository.FornecedorRepository;
import com.estoqueapi.crm.repository.ProdutoRepository;

@Service
public class ListarService {
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private FornecedorRepository fornecedorRepository;
	
	public List<ProdutoEmFalta> produtosEmFalta(){
		List<Produto> produtos = produtoRepository.findByQuantidade(0);
		List<ProdutoEmFalta> nomes = new ArrayList<>();
		
		
		int i = 0;
		while(i < produtos.size()) {
			
			String nome = produtos.get(i).getNome();
			ProdutoEmFalta produto = new ProdutoEmFalta(nome);
			nomes.add(produto);
			
			i++;
		}
		
		return nomes;
	}
	
	public List<String> fornecedoresEmFalta(){
		List<Produto> produtos = produtoRepository.findByQuantidade(0);
		List<String> nomes = new ArrayList<>();
		
		Fornecedor fornecedor;
		
		int i = 0;
		while(i < produtos.size()) {
			long id = produtos.get(i).getFornecedorId();
			
			fornecedor = fornecedorRepository.getById(id);
			
			if(!nomes.contains(fornecedor.getNome()))
				nomes.add(fornecedor.getNome());
			
			i++;
		}
		
		return nomes;
	}
	
	public List<CategoriaLista> listarCategorias() {
		List<CategoriaLista> listaCategorias = new ArrayList();
		List<Produto> produtos = new ArrayList();
		List<Categoria> categorias = categoriaRepository.findAll();
		
		CategoriaLista categoria = new CategoriaLista();
		
		for (int i=0; i<categorias.size(); i++) {
			long id = categorias.get(i).getId();
			String nome = categorias.get(i).getNome();
			long quantidade = 0;
			
			produtos = produtoRepository.findByCategoriaId(id);			
			
			for (int j=0; j<produtos.size(); j++) {
				quantidade += produtos.get(j).getQuantidade();
			}
			
			categoria.setNome(nome);
			categoria.setQuantidade(quantidade);
			listaCategorias.add(categoria);
		}
		
		
		
		return listaCategorias;
	}
	
	

}
