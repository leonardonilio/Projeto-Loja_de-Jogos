package br.com.umbrellaGames.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.umbrellaGames.model.entity.Jogo;

public interface JogoRepository extends JpaRepository<Jogo, Integer>{
	
	
	@Query("SELECT j FROM Jogo j JOIN CategoriaJogo cj ON j.id = cj.id.idJogo WHERE cj.id.idCategoria = :idCategoria")
	public List<Jogo> findByCategoria(@Param("idCategoria") int idCategoria);

    public Jogo findByNomeJogo(String nome_jogo);

    public List<Jogo> findByNomeJogoStartsWith(String nome_jogo);

    public List<Jogo> findByNomeJogoEndsWith(String nome_jogo);

    public List<Jogo> findByNomeJogoContains(String nome_jogo);
}