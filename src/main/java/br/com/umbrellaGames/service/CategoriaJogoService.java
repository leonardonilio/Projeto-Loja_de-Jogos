package br.com.umbrellaGames.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.umbrellaGames.model.entity.CategoriaJogo;
import br.com.umbrellaGames.repository.CategoriaJogoRepository;

@Service
public class CategoriaJogoService {

	@Autowired
	private CategoriaJogoRepository categoriaJogoRepository;
	
	public List<CategoriaJogo> findAll(){
		return categoriaJogoRepository.findAll();
	}
  
  //Código do Alex(não sei se vai atrapalhar - recado do Leo)
  public List<Integer> buscarIdsJogos(Integer id){
     return categoriaJogoRepository.findIdsJogosByCategoriaId(id);
    }
  
	//Create
	public CategoriaJogo saveCategoriaJogo(CategoriaJogo categoriajogo) {
		return categoriaJogoRepository.save(categoriajogo);
	}
	
	//delete
	@Transactional
	public void deleteCategoriaJogo(int idCategoria, int idJogo) {
		categoriaJogoRepository.deleteByIdIdCategoriaAndIdIdJogo(idCategoria, idJogo);
	}
	
	//Buscar por id da categoria
	public List<CategoriaJogo> buscarPorIdCategoria(int idCategoria) {
	    return categoriaJogoRepository.findByIdIdCategoria(idCategoria);
	}
	
	//Buscar por id do jogo 
	public List<CategoriaJogo> buscarPorIdJogo(int idJogo) {
	    return categoriaJogoRepository.findByIdIdJogo(idJogo);
	}
	
	//buscar pot id da categoria e do jogo
	public CategoriaJogo buscarPorAmbos(int IdCategoria, int IdJogo) {
		return categoriaJogoRepository.findByIdIdCategoriaAndIdIdJogo(IdCategoria, IdJogo);
	}
}
