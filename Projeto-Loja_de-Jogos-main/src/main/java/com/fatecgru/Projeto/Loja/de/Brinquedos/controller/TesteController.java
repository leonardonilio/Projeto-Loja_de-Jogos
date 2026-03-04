package com.fatecgru.Projeto.Loja.de.Brinquedos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fatecgru.Projeto.Loja.de.Brinquedos.model.entity.Jogo;
import com.fatecgru.Projeto.Loja.de.Brinquedos.service.JogoService;

@RestController
@RequestMapping("/api/jogos")
public class TesteController {
	
	@Autowired
	private JogoService jogoService;
	@GetMapping
	public List<Jogo> listarTodos(){
		return jogoService.listarTodos();
	}

}
