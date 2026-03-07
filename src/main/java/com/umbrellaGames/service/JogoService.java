package com.umbrellaGames.service;

import java.util.List;

import com.umbrellaGames.model.Jogo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.umbrellaGames.repository.JogoRepository;

@Service
public class JogoService {
	
	@Autowired
	private JogoRepository jogoRepository;
	public List<Jogo> listarTodos(){
		return jogoRepository.findAll();
	}

}
