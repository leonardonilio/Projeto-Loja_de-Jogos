package br.com.umbrellaGames.controller.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.umbrellaGames.model.entity.Categoria;
import br.com.umbrellaGames.model.entity.Jogo;
import br.com.umbrellaGames.service.CategoriaService;
import br.com.umbrellaGames.service.JogoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
@RequestMapping("/admin")
public class JogoWebController {

    @Autowired
    private JogoService jogoService;

	@Autowired
	private CategoriaService categoriaService;
  
	@GetMapping("/")
    public String findAll(Model model) {
        List<Jogo> jogos = jogoService.findAll();
		List<Categoria> categorias = categoriaService.findAll();
        model.addAttribute("jogos", jogos);
		model.addAttribute("categorias", categorias);
        return "admin";
    }

    	@GetMapping("/newJogo")
	public String newJogo(Model model) {
		model
			.addAttribute("jogo", new Jogo())
			.addAttribute("novo", true);
		return "formJogo";
	}
	@GetMapping("/newCategoria")
	public String newCategoria(Model model) {
		model
			.addAttribute("categoria", new Categoria())
			.addAttribute("novo", true);
		return "formCategoria";
	}
    @GetMapping("/{id}/deleteJogo")
	public String deletarJogo(Model model,@PathVariable Integer id) {
		jogoService.deletarJogo(id);
		return "redirect:/admin/";
	}
	  @GetMapping("/{id}/deleteCategoria")
	public String deletarCategoria(Model model,@PathVariable Integer id) {
		categoriaService.deletarCategoria(id);
		return "redirect:/admin/";
	}
    	@GetMapping("/{id}/editJogo")
	public String editJogo(Model model, @PathVariable Integer id) {
		Jogo jogo = jogoService.buscarPorId(id);
		model
			.addAttribute("jogo", jogo)
			.addAttribute("novo", false);
		return "formJogo";
	}
	  	@GetMapping("/{id}/editCategoria")
	public String editCategoria(Model model, @PathVariable Integer id) {
		Categoria categoria = categoriaService.buscarPorId(id);
		model
			.addAttribute("categoria", categoria)
			.addAttribute("novo", false);
		return "formCategoria";
	}
    	@PostMapping("/saveJogo")
		public String editJogo(Jogo jogo) {
			jogoService.salvarJogo(jogo);
			return "redirect:/admin/";
	}
		@PostMapping("/saveCategoria")
		public String editCategoria(Categoria categoria) {
			categoriaService.salvarCategoria(categoria);
			return "redirect:/admin/";
	}
}

