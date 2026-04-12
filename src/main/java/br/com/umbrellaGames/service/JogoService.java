package br.com.umbrellaGames.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.umbrellaGames.model.entity.Jogo;
import br.com.umbrellaGames.repository.JogoRepository;

@Service
public class JogoService {

	@Autowired
	private JogoRepository jogoRepository;
	
	public List<Jogo> findAll(){
		return jogoRepository.findAll();
	}
	
	public List<Jogo> findJogosByCategoria(int idCategoria) {
	    return jogoRepository.findByCategoria(idCategoria);
	}

	public Jogo buscarPorId(int id){
		return jogoRepository.findById(id).get();
	}

	public Jogo buscarPorNome(String nome_jogo){
		return jogoRepository.findByNomeJogo(nome_jogo);
	}

	public List<Jogo> buscarPorPrimeiroNome(String nome_jogo){
		return jogoRepository.findByNomeJogoStartsWith(nome_jogo);
	}

	public List<Jogo> buscarPorUltimoNome(String nome_jogo){
		return jogoRepository.findByNomeJogoEndsWith(nome_jogo);
	}

	public List<Jogo> buscarPorLetraNoNome(String nome_jogo){
		return jogoRepository.findByNomeJogoContains(nome_jogo);
	}
	
	public void deletarJogo(int id){
		jogoRepository.deleteById(id);
	}

	public Jogo salvarJogo(Jogo jogo){
		return jogoRepository.save(jogo);
	}
	
	public List<Jogo> buscarPorDesenvolvedora(String desenvolvedora) {
        return jogoRepository.findByDesenvolvedora(desenvolvedora);
    }

    public List<String> listarDesenvolvedoras() {
        return jogoRepository.findTodasDesenvolvedoras();
    }
}