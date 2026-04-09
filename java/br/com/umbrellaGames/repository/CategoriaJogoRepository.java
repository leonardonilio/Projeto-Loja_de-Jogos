package br.com.umbrellaGames.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.umbrellaGames.model.entity.CategoriaJogo;
import br.com.umbrellaGames.model.entity.CategoriaJogoId;

public interface CategoriaJogoRepository extends JpaRepository<CategoriaJogo, CategoriaJogoId>{

}
