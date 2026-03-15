package br.com.umbrellaGames.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.umbrellaGames.model.entity.CategoriaJogo;
import br.com.umbrellaGames.repository.CategoriaJogoRepository;

@Service
public class CategoriaJogoService {

	@Autowired
	private CategoriaJogoRepository categoriaJogoRepository;
	
	public List<CategoriaJogo> findAll(){
		return categoriaJogoRepository.findAll();
	}
}
