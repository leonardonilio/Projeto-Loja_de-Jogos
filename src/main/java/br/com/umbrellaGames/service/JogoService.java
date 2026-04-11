package br.com.umbrellaGames.service;

import java.util.List;

import org.jspecify.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.umbrellaGames.model.entity.Jogo;
import br.com.umbrellaGames.repository.JogoRepository;

@Service
public class JogoService {

	@Autowired
	private JogoRepository jogoRepository;
	
	public List<Jogo> findAll(){
        List<Jogo> jogos = jogoRepository.findAll();

        for (Jogo jogo : jogos) {
            String caminho = jogo.getImagem();

            // a bosta do resources no caminho estava atrapalhando o aparecimento das imagens
            caminho = caminho.replace("/resources", "");

            jogo.setImagem(caminho);
        }
        return jogos;
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

    public List<Jogo> buscarGratuitos(){
        return jogoRepository.findAll().stream().filter(jogo -> jogo.getValor() == 0).toList(); //verifica jogos gratuitos
    }

    public List<Jogo> buscarPromocao(){
        return jogoRepository.findAll().stream().filter(jogo -> jogo.getValor() <= 30 && jogo.getValor() != 0).toList(); // quais jogos estão em promoção
    }

    public List<Jogo> buscarDestaques() {
        return jogoRepository.findAll().stream().filter(jogo -> jogo.getNota() == 10).toList(); // quais jogos são destaque
    }
}