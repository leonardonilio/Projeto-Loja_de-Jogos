package br.com.umbrellaGames.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.umbrellaGames.model.entity.Jogo;
import org.springframework.data.jpa.repository.Query;

public interface JogoRepository extends JpaRepository<Jogo, Integer>{

    public Jogo findByNomeJogo(String nome_jogo);

    public List<Jogo> findByNomeJogoStartsWith(String nome_jogo);

    public List<Jogo> findByNomeJogoEndsWith(String nome_jogo);

    public List<Jogo> findByNomeJogoContains(String nome_jogo);
    
    List<Jogo> findByDesenvolvedora(String desenvolvedora);
    
    @Query("SELECT 	DISTINCT j.desenvolvedora FROM Jogo j")
    List<String> findTodasDesenvolvedoras();
    
    public List<Jogo> findAllByIdCategoria(int id_categoria);
    
    List<Jogo> findByDesenvolvedoraOrderByNotaDesc(String desenvolvedora);

    List<Jogo> findByDesenvolvedoraOrderByValorAsc(String desenvolvedora);
}