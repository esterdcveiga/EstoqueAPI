package com.estoqueapi.crm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.estoqueapi.crm.entity.Produto;
import com.estoqueapi.crm.repository.ProdutoRepository;
import com.estoqueapi.crm.service.ListarService;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private ListarService listarService;
	
	@GetMapping
	public List<Produto> listarProduto() {
		//return produtoRepository.findAll();
		//return produtoRepository.findByQuantidade(8);
		
		//return listarService.produtosEmFalta();
		
		return produtoRepository.findByCategoriaId(2);
	}
	
	@PostMapping
	public Produto adicionarProduto(@RequestBody Produto produto) {
		return produtoRepository.save(produto);
	}
	
	//@PutMapping
	//public Produto atualizarProduto(long id, long quantidade, double valor) {
		//return produtoRepository.saveAndFlush(produto);
	//}

}
