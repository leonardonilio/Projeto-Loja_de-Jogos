package br.com.umbrellaGames.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.umbrellaGames.model.entity.Jogo;

public interface JogoRepository extends JpaRepository<Jogo, Integer>{

}
