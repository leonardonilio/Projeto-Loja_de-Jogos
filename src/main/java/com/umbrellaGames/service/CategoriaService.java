package com.umbrellaGames.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.umbrellaGames.model.entity.Categoria;
import com.umbrellaGames.repository.CategoriaRepository;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	public List<Categoria> listarTodos(){
		return categoriaRepository.findAll();
	}

}
