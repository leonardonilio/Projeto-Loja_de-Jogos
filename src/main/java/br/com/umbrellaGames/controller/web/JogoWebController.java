package br.com.umbrellaGames.controller.web;

import java.util.List;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.springframework.web.multipart.MultipartFile;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;



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
		List<String> desenvolvedoras = jogoService.listarDesenvolvedoras();
	    model.addAttribute("desenvolvedoras", desenvolvedoras);
    return "index";
}

@GetMapping("/about")
    public String paginaSobre(Model model) {
	List<Categoria> categorias = categoriaService.findAll();
	model.addAttribute("categorias", categorias);
	List<String> desenvolvedoras = jogoService.listarDesenvolvedoras();
    model.addAttribute("desenvolvedoras", desenvolvedoras);
    return "sobre";
}
	@GetMapping("/categoria")
	public String paginaCategoria(@RequestParam String param) {
		return new String();
	}
	
	@GetMapping("/categoria/{idCategoria}")
	public String paginaCategoriaId(@PathVariable int idCategoria, Model model) {
	//List<CategoriaJogo> jogos = categoriaJogoService.buscarPorIdCategoria(idCategoria);
		List<Jogo> destaque = jogoService.findJogosByCategoria(idCategoria).stream().limit(4).toList();
		model.addAttribute("destaqueJogos", destaque);
	    model.addAttribute("jogos", jogoService.findJogosByCategoria(idCategoria));
	    List<Categoria> categorias = categoriaService.findAll();
	    model.addAttribute("categorias", categorias);
	    Categoria categoria = categoriaService.buscarPorId(idCategoria);
	    model.addAttribute("categoria", categoria);
	    List<String> desenvolvedoras = jogoService.listarDesenvolvedoras();
	    model.addAttribute("desenvolvedoras", desenvolvedoras);
	    return "Categoria";
	}
	
	
	@GetMapping("/jogo/{idJogo}")
	public String infoJogoId(@PathVariable int idJogo, Model model) {
	    Jogo jogo = jogoService.buscarPorId(idJogo);
	    model.addAttribute("jogo", jogo);
	    List<Categoria> categorias = categoriaService.findAll();
		model.addAttribute("categorias", categorias);
		List<String> desenvolvedoras = jogoService.listarDesenvolvedoras();
	    model.addAttribute("desenvolvedoras", desenvolvedoras);
	    return "infoJogos";
	}
	
	@GetMapping("/buscarDropdown")
	@ResponseBody
	public List<Jogo> buscarJogoDropdown(@RequestParam String nome) {
	    return jogoService.buscarPorLetraNoNome(nome);
	}
	
  
	@GetMapping("/admin/1")
    public String findAll(Model model) {
        List<Jogo> jogos = jogoService.findAll();
		List<Categoria> categorias = categoriaService.findAll();
        model.addAttribute("jogos", jogos);
		model.addAttribute("categorias", categorias);
        return "admin";
    }
	
	@GetMapping("/desenvolvedora/{nomeDev}")
	public String jogosPorDesenvolvedora(@PathVariable String nomeDev, Model model) {
	    List<Jogo> jogos = jogoService.buscarPorDesenvolvedora(nomeDev);
	    model.addAttribute("jogos", jogos);
	    List<Categoria> categorias = categoriaService.findAll();
		model.addAttribute("categorias", categorias);
		List<String> desenvolvedoras = jogoService.listarDesenvolvedoras();
	    model.addAttribute("desenvolvedoras", desenvolvedoras);
	    return "desenvolvedora";
	}

@GetMapping("/admin")
public String paginaLogin(Model model) {
	List<Categoria> categorias = categoriaService.findAll();
	model.addAttribute("categorias", categorias);
	List<String> desenvolvedoras = jogoService.listarDesenvolvedoras();
    model.addAttribute("desenvolvedoras", desenvolvedoras);
    return "login";
}

    	@GetMapping("/admin/1/newJogo")
	public String newJogo(Model model) {
		List<Categoria> categorias = categoriaService.findAll();
		model
		.addAttribute("categoria", categorias)
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
		return "redirect:/admin/1";
	}
	  @GetMapping("/admin/1/{id}/deleteCategoria")
	public String deletarCategoria(Model model,@PathVariable Integer id) {
		categoriaService.deletarCategoria(id);
		return "redirect:/admin/1";
	}
    	@GetMapping("/admin/1/{id}/editJogo")
	public String editJogo(Model model, @PathVariable Integer id) {
		Jogo jogo = jogoService.buscarPorId(id);
		List<Categoria> categorias = categoriaService.findAll();
		model
		.addAttribute("categoria", categorias)
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
public String editJogo(Jogo jogo,
        @RequestParam("file") MultipartFile file) {

    if (file != null && !file.isEmpty()) {
        try {
            String pasta = "src/main/resources/static/assents/img/capas/";

            String nomeArquivo = System.currentTimeMillis() + "_" + file.getOriginalFilename();

            Path caminho = Paths.get(pasta + nomeArquivo);
            Files.write(caminho, file.getBytes());

            jogo.setImagem(nomeArquivo);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    jogoService.salvarJogo(jogo);
    return "redirect:/admin/1";
}
	
		@PostMapping("/admin/1/saveCategoria")
		public String editCategoria(Categoria categoria) {
			categoriaService.salvarCategoria(categoria);
			return "redirect:/admin/1";
	}
}

