package br.com.umbrellaGames.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.umbrellaGames.model.entity.Jogo;
import br.com.umbrellaGames.repository.JogoRepository;

@Service
public class JogoService {

	@Autowired
	private JogoRepository jogoRepository;
	
	public List<Jogo> findAll(){
		return jogoRepository.findAll();
	}
}
