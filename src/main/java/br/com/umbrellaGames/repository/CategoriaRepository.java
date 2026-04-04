package br.com.umbrellaGames.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.umbrellaGames.model.entity.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {

    public Categoria findByNomeCategoria(String nome_categoria);

    public List<Categoria> findByNomeCategoriaStartsWith(String nome_categoria);

    public List<Categoria> findByNomeCategoriaEndsWith(String nome_categoria);

    public List<Categoria> findByNomeCategoriaContains(String nome_categoria);
}
