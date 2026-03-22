package br.com.umbrellaGames.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

// create
	@PostMapping
	public CategoriaJogo Insert(@RequestBody CategoriaJogo categoriajogo) {
		return categoriaJogoService.saveCategoriaJogo(categoriajogo);
	}
	
	//delete
	@DeleteMapping("/delete/{idCategoria}/{idJogo}")
	public String delete(@PathVariable int idCategoria,@PathVariable int idJogo) {
		categoriaJogoService.deleteCategoriaJogo(idCategoria, idJogo);
		return "Deletado com sucesso";
	}
	
	//Buscar por id da categoria
	@GetMapping("/categoriaC/{IdCategoria}")
	public List<CategoriaJogo> buscarPorIdCategoria(@PathVariable int IdCategoria) {
	    return categoriaJogoService.buscarPorIdCategoria(IdCategoria);
	}
	
	//Buscar por id do jogo 
	@GetMapping("/categoriaJ/{IdJogo}")
	public List<CategoriaJogo> buscarPorIdJogo(@PathVariable int IdJogo) {
	    return categoriaJogoService.buscarPorIdJogo(IdJogo);
	}
	
	@GetMapping("/categoriaA/{IdCategoria}/{IdJogo}")
	public CategoriaJogo buscarPorAmbos(@PathVariable int IdCategoria, @PathVariable int IdJogo) {
		 CategoriaJogo  categoriajogo = categoriaJogoService.buscarPorAmbos(IdCategoria, IdJogo);
		 return  categoriajogo;
	}
}
