package com.fatecgru.Projeto.Loja.de.Brinquedos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fatecgru.Projeto.Loja.de.Brinquedos.model.entity.Categoria;
import com.fatecgru.Projeto.Loja.de.Brinquedos.repository.CategoriaRepository;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	public List<Categoria> listarTodos(){
		return categoriaRepository.findAll();
	}

}
