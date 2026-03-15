package br.com.umbrellaGames.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.umbrellaGames.model.entity.CategoriaJogo;
import br.com.umbrellaGames.service.CategoriaJogoService;

@RestController
@RequestMapping("/api/categoriaJogo")
public class CategoriaJogoController {

	@Autowired
	private CategoriaJogoService categoriaJogoService;
	
	@GetMapping
	private List<CategoriaJogo> listarTodos() {
		return categoriaJogoService.findAll();
	}
}
