package br.com.umbrellaGames.repository;

import br.com.umbrellaGames.model.entity.CategoriaJogoId;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.umbrellaGames.model.entity.CategoriaJogo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CategoriaJogoRepository extends JpaRepository<CategoriaJogo, CategoriaJogoId>{
    @Query("SELECT cj.id.idJogo FROM CategoriaJogo cj WHERE cj.id.idCategoria = :idCategoria")
    List<Integer> findIdsJogosByCategoriaId(@Param("idCategoria") Integer idCategoria);
}
