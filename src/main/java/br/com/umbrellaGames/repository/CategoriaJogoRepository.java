package br.com.umbrellaGames.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.umbrellaGames.model.entity.CategoriaJogo;

public interface CategoriaJogoRepository extends JpaRepository<CategoriaJogo, Integer>{

	void deleteByIdCategoriaAndIdJogo(int idCategoria, int idJogo);
	
	//Buscar por id da categoria
	List<CategoriaJogo> findByIdCategoria(int idCategoria);
	
	//Buscar por id do jogo 
	List<CategoriaJogo> findByIdJogo(int idJogo);
	
	CategoriaJogo findByIdCategoriaAndIdJogo(int IdCategoria, int IdJogo);

}
