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

	@GetMapping("/id/{id}")
	public Jogo buscarPorId(@PathVariable int id){
		Jogo jogo = jogoService.buscarPorId(id);
		return jogo;
	}

	@GetMapping("/nome_jogo/{nome_jogo}")
	public Jogo buscarPorNome_Jogo(@PathVariable String nome_jogo){
		Jogo jogo = jogoService.buscarPorNome(nome_jogo);
		return jogo;
	}

	@GetMapping("/primeiro_nome/{nome_jogo}")
	public List<Jogo> buscarPorPrimeiroNome(@PathVariable String nome_jogo){
		return jogoService.buscarPorPrimeiroNome(nome_jogo);
	}

	@GetMapping("/ultimo_nome/{nome_jogo}")
	public List<Jogo> buscarPorUltimoNome(@PathVariable String nome_jogo) {
		return jogoService.buscarPorUltimoNome(nome_jogo);
	}

	@GetMapping("/letra-do-nome/{nome_jogo}")
	public List<Jogo> buscarPorLetraDoNome(@PathVariable String nome_jogo) {
		return jogoService.buscarPorLetraNoNome(nome_jogo);
	}
	
	@DeleteMapping("/{id}")
	public String deletar(@PathVariable int id){
		jogoService.deletarJogo(id);
		return "Jogo Deletado com Sucesso!!!";
	}

	@PostMapping
	public Jogo inserir(@RequestBody Jogo jogo){
		return jogoService.salvarJogo(jogo);
	}

	@PutMapping("/id/{id}")
	public Jogo atualizar(@RequestBody Jogo jogo, @PathVariable Integer id){
		Jogo jogoAtualizar = jogoService.buscarPorId(id);
		jogoAtualizar.setIdJogo(jogo.getIdJogo());
		jogoAtualizar.setNomeJogo(jogo.getNomeJogo());
		jogoAtualizar.setDesenvolvedora(jogo.getDesenvolvedora());
		jogoAtualizar.setImagem(jogo.getImagem());
		jogoAtualizar.setDetalhes(jogo.getDetalhes());
		jogoAtualizar.setValor(jogo.getValor());
		return jogoService.salvarJogo(jogoAtualizar);
	}
}
