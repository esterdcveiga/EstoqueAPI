package com.estoqueapi.crm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.estoqueapi.crm.entity.Fornecedor;
import com.estoqueapi.crm.repository.FornecedorRepository;
import com.estoqueapi.crm.service.ListarService;

@RestController
@RequestMapping("/fornecedores")
public class FornecedorController {
	
	@Autowired
	private FornecedorRepository fornecedorRepository;
	
	@Autowired
	private ListarService listarService;
	
	@GetMapping
	public List<String> listarProduto() {
		//return fornecedorRepository.findAll();
		return listarService.fornecedoresEmFalta();
	}
	
	@PostMapping
	public Fornecedor adicionarProduto(@RequestBody Fornecedor fornecedor) {
		return fornecedorRepository.save(fornecedor);
	}

}
