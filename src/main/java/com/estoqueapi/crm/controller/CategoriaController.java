package com.estoqueapi.crm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.estoqueapi.crm.entity.Categoria;
import com.estoqueapi.crm.model.CategoriaLista;
import com.estoqueapi.crm.repository.CategoriaRepository;
import com.estoqueapi.crm.service.ListarService;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private ListarService listaService;
	
	@GetMapping
	public List<CategoriaLista> listarCategorias() {
		return listaService.listarCategorias();
	}
	
	@PostMapping
	public Categoria adicionarCategorias(@RequestBody Categoria categoria) {
		return categoriaRepository.save(categoria);
	}
}
