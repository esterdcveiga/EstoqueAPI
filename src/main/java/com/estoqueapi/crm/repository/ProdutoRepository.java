package com.estoqueapi.crm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.estoqueapi.crm.entity.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
	List<Produto> findByQuantidade(long quantidade);
	List<Produto> findByCategoriaId(long id);

}
