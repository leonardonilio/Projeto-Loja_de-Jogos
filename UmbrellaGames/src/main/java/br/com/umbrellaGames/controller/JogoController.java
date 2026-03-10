package br.com.umbrellaGames.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.umbrellaGames.model.entity.Jogo;
import br.com.umbrellaGames.service.JogoService;

@RestController
@RequestMapping("/api/jogos")
public class JogoController {

	@Autowired
	private JogoService jogoService;
	
	@GetMapping
	public List<Jogo> listarTodos(){
		return jogoService.findAll();
	}
}
