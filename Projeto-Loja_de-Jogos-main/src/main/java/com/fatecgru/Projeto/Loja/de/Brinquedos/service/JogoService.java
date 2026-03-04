package com.fatecgru.Projeto.Loja.de.Brinquedos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fatecgru.Projeto.Loja.de.Brinquedos.model.entity.Jogo;
import com.fatecgru.Projeto.Loja.de.Brinquedos.repository.JogoRepository;

@Service
public class JogoService {
	
	@Autowired
	private JogoRepository jogoRepository;
	public List<Jogo> listarTodos(){
		return jogoRepository.findAll();
	}

}
