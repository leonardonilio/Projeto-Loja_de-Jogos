package br.com.umbrellaGames.controller.web;

import java.util.List;
import java.util.*;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.ResponseBody;

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
import br.com.umbrellaGames.model.entity.Usuario;
import br.com.umbrellaGames.repository.UsuarioRepository;
import br.com.umbrellaGames.service.CategoriaService;
import br.com.umbrellaGames.service.JogoService;



@Controller
@RequestMapping("/")
public class JogoWebController {

    @Autowired
    private JogoService jogoService;

	@Autowired
	private CategoriaService categoriaService;

	@Autowired
	private UsuarioRepository usuarioRepository;

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
		Categoria categoria = categoriaService.buscarPorId(jogo.getIdCategoria());
		model.addAttribute("categoria", categoria);
		List<Categoria> categorias = categoriaService.findAll();
		model.addAttribute("categorias", categorias);
		List<String> desenvolvedoras = jogoService.listarDesenvolvedoras();
	    model.addAttribute("desenvolvedoras", desenvolvedoras);
		// lista segura para edição
		List<Jogo> mesmaCategoria = jogoService
				.findJogosByCategoria(jogo.getIdCategoria())
				.stream()
				.filter(j -> j.getIdJogo() != jogo.getIdJogo()) // remove o atual
				.collect(Collectors.toList());

		// Se tiver menos de 5, buscar os top avaliados
		List<Jogo> melhoresAvaliados = Collections.emptyList();

		if (mesmaCategoria.size() < 5) {
			melhoresAvaliados = jogoService.findAll().stream()
					.filter(j -> j.getIdJogo() != jogo.getIdJogo()) // remove o atual
					.filter(j -> !mesmaCategoria.contains(j))        // não repetir
					.sorted(Comparator.comparingDouble(Jogo::getNota).reversed()) // ordem decrescente
					.limit(5 - mesmaCategoria.size())
					.collect(Collectors.toList());
		}

		// Une os dois
		List<Jogo> recomendados = new ArrayList<>();
		recomendados.addAll(mesmaCategoria);
		recomendados.addAll(melhoresAvaliados);

		// Garante no máximo 5
		recomendados = recomendados.stream()
				.limit(5)
				.toList();
		model.addAttribute("jogosCategoria", recomendados);

		Map<Integer, Categoria> categoriasMap = new HashMap<>();

		for (Jogo j : recomendados) {
			Categoria cat = categoriaService.buscarPorId(j.getIdCategoria());
			categoriasMap.put(j.getIdJogo(), cat);
		}

		model.addAttribute("categoriasJogos", categoriasMap);

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
	
	@GetMapping("/desenvolvedora/{nomeDev}")
	public String jogosPorDesenvolvedora(@PathVariable String nomeDev,@RequestParam(defaultValue = "todos") String exibicao, Model model) {
		List<Jogo> jogos;
	    switch (exibicao) {
	        case "avaliacao":
	            jogos = jogoService.buscarPorDesenvolvedoraOrdenarPorNota(nomeDev);
	            break;
	        case "preco":
	            jogos = jogoService.buscarPorDesenvolvedoraOrdenarPorPreco(nomeDev);
	            break;
	        default:
	            jogos = jogoService.buscarPorDesenvolvedora(nomeDev);
	            break;
	    }
	    model.addAttribute("jogos", jogos);
	    model.addAttribute("exibicao", exibicao);
	    List<Categoria> categorias = categoriaService.findAll();
		model.addAttribute("categorias", categorias);
		List<String> desenvolvedoras = jogoService.listarDesenvolvedoras();
	    model.addAttribute("desenvolvedoras", desenvolvedoras);
	    model.addAttribute("nomeDev", nomeDev);
	    return "desenvolvedora";
	}


@GetMapping("/admin/1")
public String paginaLogin() {
    return "login";
}

	@GetMapping("/admin/verificacao")
	public String verificacao(Model model, @RequestParam(name = "email") String email, @RequestParam(name = "senha") String senha) {

		List<Usuario> usuarios = usuarioRepository.findAll();

		for (Usuario usuario : usuarios) {
			String emailUsuario = usuario.getEmail();
			String senhaUsuario = usuario.getSenha();
			if(emailUsuario.equals(email)){
				if(senhaUsuario.equals(senha)){
					List<Jogo> jogos = jogoService.findAll();
					List<Categoria> categorias = categoriaService.findAll();
					model.addAttribute("jogos", jogos);
					model.addAttribute("categorias", categorias);
					return "admin";
				}
			}
		}
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

