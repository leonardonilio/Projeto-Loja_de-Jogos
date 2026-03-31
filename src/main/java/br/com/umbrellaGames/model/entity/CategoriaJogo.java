package br.com.umbrellaGames.model.entity;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Categoria_Jogo")
public class CategoriaJogo {

	// Atributos
	
	@Id
	@Embedded
	private CategoriaJogoId id;
	
	// construtores
	public CategoriaJogo() {}
	
	public CategoriaJogo(CategoriaJogoId id) {
		super();
		this.id = id;
	}

	// getters e setters
	public CategoriaJogoId getId() {
		return id;
	}

	public void setId(CategoriaJogoId id) {
		this.id = id;
	}
	
	
	
	
}
