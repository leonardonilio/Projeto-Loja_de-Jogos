package br.com.umbrellaGames.controller.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.umbrellaGames.model.entity.Categoria;
import br.com.umbrellaGames.model.entity.Jogo;
import br.com.umbrellaGames.service.CategoriaService;
import br.com.umbrellaGames.service.JogoService;



@Controller
@RequestMapping("/")
public class JogoWebController {

    @Autowired
    private JogoService jogoService;

	@Autowired
	private CategoriaService categoriaService;

	@GetMapping({"/", "/home"})
    public String paginaHome(Model model) {
		List<Categoria> categorias = categoriaService.findAll();
		model.addAttribute("categorias", categorias);
    return "index";
}

@GetMapping("/about")
    public String paginaSobre() {
    return "sobre";
}
	@GetMapping("/categoria")
	public String paginaCategoria(@RequestParam String param) {
		return new String();
	}
	
	@GetMapping("/categoria/{idCategoria}")
	public String paginaCategoriaId(@PathVariable int idCategoria, Model model) {
	//List<CategoriaJogo> jogos = categoriaJogoService.buscarPorIdCategoria(idCategoria);
		List<Jogo> destaque = jogoService.findJogosByCategoria(idCategoria)
		        .stream()
		        .limit(4)
		        .toList();
		model.addAttribute("destaqueJogos", destaque);
	model.addAttribute("jogos", jogoService.findJogosByCategoria(idCategoria)/*.stream().limit(4).toList()*/);
	List<Categoria> categorias = categoriaService.findAll();
	model.addAttribute("categorias", categorias);
	Categoria categoria = categoriaService.buscarPorId(idCategoria);
	model.addAttribute("categoria", categoria);
	return "Categoria";
	}
	
	
	@GetMapping("/jogo/{idJogo}")
	public String infoJogoId(@PathVariable int idJogo, Model model) {
	    Jogo jogo = jogoService.buscarPorId(idJogo);
	    model.addAttribute("jogo", jogo);
	    return "infoJogos";
	}
	
  
	@GetMapping("/admin/1/")
    public String findAll(Model model) {
        List<Jogo> jogos = jogoService.findAll();
		List<Categoria> categorias = categoriaService.findAll();
        model.addAttribute("jogos", jogos);
		model.addAttribute("categorias", categorias);
        return "admin";
    }


@GetMapping("/admin")
public String paginaLogin() {
    return "login";
}

    	@GetMapping("/admin/1/newJogo")
	public String newJogo(Model model) {
		model
			.addAttribute("jogo", new Jogo())
			.addAttribute("novo", true);
		return "formJogo";
	}
	@GetMapping("/admin/1/newCategoria")
	public String newCategoria(Model model) {
		model
			.addAttribute("categoria", new Categoria())
			.addAttribute("novo", true);
		return "formCategoria";
	}
    @GetMapping("/admin/1/{id}/deleteJogo")
	public String deletarJogo(Model model,@PathVariable Integer id) {
		jogoService.deletarJogo(id);
		return "redirect:/admin/1/";
	}
	  @GetMapping("/admin/1/{id}/deleteCategoria")
	public String deletarCategoria(Model model,@PathVariable Integer id) {
		categoriaService.deletarCategoria(id);
		return "redirect:/admin/1/";
	}
    	@GetMapping("/admin/1/{id}/editJogo")
	public String editJogo(Model model, @PathVariable Integer id) {
		Jogo jogo = jogoService.buscarPorId(id);
		model
			.addAttribute("jogo", jogo)
			.addAttribute("novo", false);
		return "formJogo";
	}
	  	@GetMapping("/admin/1/{id}/editCategoria")
	public String editCategoria(Model model, @PathVariable Integer id) {
		Categoria categoria = categoriaService.buscarPorId(id);
		model
			.addAttribute("categoria", categoria)
			.addAttribute("novo", false);
		return "formCategoria";
	}
    	@PostMapping("/admin/1/saveJogo")
		public String editJogo(Jogo jogo) {
			jogoService.salvarJogo(jogo);
			return "redirect:/admin/1/";
	}
		@PostMapping("/admin/1/saveCategoria")
		public String editCategoria(Categoria categoria) {
			categoriaService.salvarCategoria(categoria);
			return "redirect:/admin/1/";
	}
}

