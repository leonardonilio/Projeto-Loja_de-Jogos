package br.com.umbrellaGames.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.umbrellaGames.model.entity.Categoria;
import br.com.umbrellaGames.model.entity.Jogo;
import br.com.umbrellaGames.service.CategoriaService;

@RestController
@RequestMapping("/api/categorias")
public class CategoriaController {

	@Autowired
	private CategoriaService categoriaService;
	
	@GetMapping
	public List<Categoria> listarTodos(){
		return categoriaService.findAll();
	}

		@GetMapping("/id/{id}")
	public Categoria buscarPorId(@PathVariable int id){
		Categoria categoria = categoriaService.buscarPorId(id);
		return categoria;
	}

	@GetMapping("/nome_categoria/{nome_categoria}")
	public Categoria buscarPorNome_Categoria(@PathVariable String nome_categoria){
		Categoria categoria = categoriaService.buscarPorNome(nome_categoria);
		return categoria;
	}

	@GetMapping("/primeiro_nome/{nome_categoria}")
	public List<Categoria> buscarPorPrimeiroNome(@PathVariable String nome_categoria){
		return categoriaService.buscarPorPrimeiroNome(nome_categoria);
	}

	@GetMapping("/ultimo_nome/{nome_categoria}")
	public List<Categoria> buscarPorUltimoNome(@PathVariable String nome_categoria) {
		return categoriaService.buscarPorUltimoNome(nome_categoria);
	}

	@GetMapping("/letra-do-nome/{nome_categoria}")
	public List<Categoria> buscarPorLetraDoNome(@PathVariable String nome_categoria) {
		return categoriaService.buscarPorLetraNoNome(nome_categoria);
	}
	
	@DeleteMapping("/{id}")
	public String deletar(@PathVariable int id){
		categoriaService.deletarCategoria(id);
		return "Categoria Deletada com Sucesso!!!";
	}

	@PostMapping
	public Categoria inserir(@RequestBody Categoria categoria){
		return categoriaService.salvarCategoria(categoria);
	}

	@PutMapping("/id/{id}")
	public Categoria atualizar(@RequestBody Categoria categoria, @PathVariable Integer id){
		Categoria categoriaAtualizar = categoriaService.buscarPorId(id);
		categoriaAtualizar.setIdCategoria(categoria.getIdCategoria());
		categoriaAtualizar.setNomeCategoria(categoria.getNomeCategoria());
	
		return categoriaService.salvarCategoria(categoriaAtualizar);
	}
}
