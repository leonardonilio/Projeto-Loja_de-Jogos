package br.com.umbrellaGames.repository;

import java.util.List;

import br.com.umbrellaGames.model.entity.CategoriaJogoId;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.umbrellaGames.model.entity.CategoriaJogo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CategoriaJogoRepository extends JpaRepository<CategoriaJogo, CategoriaJogoId>{
    @Query("SELECT cj.id.idJogo FROM CategoriaJogo cj WHERE cj.id.idCategoria = :idCategoria")
    List<Integer> findIdsJogosByCategoriaId(@Param("idCategoria") Integer idCategoria);
  
	void deleteByIdIdCategoriaAndIdIdJogo(int idCategoria, int idJogo);
	
	//Buscar por id da categoria
	List<CategoriaJogo> findByIdIdCategoria(int idCategoria);
	
	//Buscar por id do jogo 
	List<CategoriaJogo> findByIdIdJogo(int idJogo);
	
	CategoriaJogo findByIdIdCategoriaAndIdIdJogo(int IdCategoria, int IdJogo);

}
