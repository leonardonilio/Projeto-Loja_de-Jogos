package br.com.umbrellaGames.controller.web;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import br.com.umbrellaGames.model.entity.Categoria;
import br.com.umbrellaGames.model.entity.Jogo;
import br.com.umbrellaGames.model.entity.Usuario;
import br.com.umbrellaGames.repository.JogoRepository;
import br.com.umbrellaGames.service.CategoriaService;
import br.com.umbrellaGames.service.JogoService;
import br.com.umbrellaGames.service.UsuarioService;

@Controller
@RequestMapping("/")
public class JogoWebController {

    private final JogoRepository jogoRepository;

    @Autowired
    private JogoService jogoService;

	@Autowired
	private CategoriaService categoriaService;

	@Autowired
    private UsuarioService usuarioService;


    JogoWebController(JogoRepository jogoRepository) {
        this.jogoRepository = jogoRepository;
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

@GetMapping("/admin")
public String paginaLogin(Model model) {
	List<Categoria> categorias = categoriaService.findAll();
	model.addAttribute("categorias", categorias);
	List<String> desenvolvedoras = jogoService.listarDesenvolvedoras();
    model.addAttribute("desenvolvedoras", desenvolvedoras);
    return "login";
}

	@GetMapping("/admin/verificacao")
	public String verificacao(Model model, @RequestParam(name = "email") String email, @RequestParam(name = "senha") String senha){

		List<Usuario> usuarios = usuarioService.findAll();

		for(Usuario usuario : usuarios){
			if(usuario.getEmail().equals(email)){
				if(usuario.getSenha().equals(senha)){
					List<Jogo> jogos = jogoService.findAll();
					List<Categoria> categorias = categoriaService.findAll();
					model.addAttribute("jogos", jogos);
					model.addAttribute("categorias", categorias);
					model.addAttribute("categorias", categorias);
					List<String> desenvolvedoras = jogoService.listarDesenvolvedoras();
					model.addAttribute("desenvolvedoras", desenvolvedoras);
					return "admin";
				}
			}
		}
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
			model.addAttribute("categorias", categorias);
			List<String> desenvolvedoras = jogoService.listarDesenvolvedoras();
			model.addAttribute("desenvolvedoras", desenvolvedoras);
		return "formJogo";
	}
	@GetMapping("/admin/1/newCategoria")
	public String newCategoria(Model model) {
		model
			.addAttribute("categoria", new Categoria())
			.addAttribute("novo", true);
		List<Categoria> categorias = categoriaService.findAll();
		model.addAttribute("categorias", categorias);
		List<String> desenvolvedoras = jogoService.listarDesenvolvedoras();
		model.addAttribute("desenvolvedoras", desenvolvedoras);
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
	public String editJogo(Model model, @PathVariable int id) {
		Jogo jogo = jogoService.buscarPorId(id);
		List<Categoria> categorias = categoriaService.findAll();
		model
		.addAttribute("categoria", categorias)
			.addAttribute("jogo", jogo)
			.addAttribute("novo", false);
			model.addAttribute("categorias", categorias);
			List<String> desenvolvedoras = jogoService.listarDesenvolvedoras();
			model.addAttribute("desenvolvedoras", desenvolvedoras);
		return "formJogo";
	}
	  	@GetMapping("/admin/1/{id}/editCategoria")
	public String editCategoria(Model model, @PathVariable Integer id) {
		Categoria categoria = categoriaService.buscarPorId(id);
		model
			.addAttribute("categoria", categoria)
			.addAttribute("novo", false);
			List<Categoria> categorias = categoriaService.findAll();
			model.addAttribute("categorias", categorias);
			List<String> desenvolvedoras = jogoService.listarDesenvolvedoras();
			model.addAttribute("desenvolvedoras", desenvolvedoras);
		return "formCategoria";
	}
@PostMapping("/admin/1/saveJogo")
public String editJogo(Jogo jogo,
                       @RequestParam("file") MultipartFile file) {

    try {

        // 👉 Se enviou nova imagem
        if (file != null && !file.isEmpty()) {

            String pasta = "src/main/resources/imagem/capa/";
            String nomeArquivo = System.currentTimeMillis() + "_" + file.getOriginalFilename();

            Path caminhoArquivo = Paths.get(pasta, nomeArquivo);
            Files.write(caminhoArquivo, file.getBytes());

            jogo.setImagem(nomeArquivo);

        } else {
            // 👉 NÃO enviou imagem → manter antiga

            if (jogo.getIdJogo() != 0) {

                Jogo jogoExistente = jogoRepository.findById(jogo.getIdJogo())
                        .orElseThrow(() -> new RuntimeException("Jogo não encontrado: " + jogo.getIdJogo()));

                jogo.setImagem(jogoExistente.getImagem());
            }
        }

        jogoRepository.save(jogo);
		System.out.println("ID recebido: " + jogo.getIdJogo());

    } catch (Exception e) {
        e.printStackTrace();
    }

    return "redirect:/admin/1";
}
		@PostMapping("/admin/1/saveCategoria")
		public String editCategoria(Categoria categoria) {
			categoriaService.salvarCategoria(categoria);
			return "redirect:/admin/1";
	}
}

