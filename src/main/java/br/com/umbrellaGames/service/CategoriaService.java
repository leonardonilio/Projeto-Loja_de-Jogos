

package br.com.umbrellaGames.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.umbrellaGames.model.entity.Categoria;
import br.com.umbrellaGames.model.entity.Jogo;
import br.com.umbrellaGames.repository.CategoriaRepository;
import br.com.umbrellaGames.repository.JogoRepository;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private JogoRepository jogoRepository;
	
	public List<Categoria> findAll(){
		return categoriaRepository.findAll();
	}

	public Categoria buscarPorId(int id){
		return categoriaRepository.findById(id).get();
	}

	public Categoria buscarPorNome(String categoria_nome){
		return categoriaRepository.findByNomeCategoria(categoria_nome);
	}

	public List <Categoria> buscarPorPrimeiroNome(String categoria_nome){
		return categoriaRepository.findByNomeCategoriaStartsWith(categoria_nome);
	}

	public List <Categoria> buscarPorUltimoNome(String categoria_nome){
		return categoriaRepository.findByNomeCategoriaEndsWith(categoria_nome);
	}

	public List <Categoria> buscarPorLetraNoNome(String categoria_nome){
		return categoriaRepository.findByNomeCategoriaContains(categoria_nome);
	}

	public void deletarCategoria(int id){

		List<Jogo> jogos = jogoRepository.findAllByIdCategoria(id);

		for (Jogo jogo : jogos) {
			jogo.setIdCategoria();
			jogoRepository.save(jogo);
		}

		categoriaRepository.deleteById(id);
	}

	public Categoria salvarCategoria(Categoria categoria){
		return categoriaRepository.save(categoria);
	}
}

