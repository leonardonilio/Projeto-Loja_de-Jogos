package br.com.umbrellaGames.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "CategoriaJogo")
public class CategoriaJogo {

	// Atributos
	
	private int idJogo;
	
	@Id
	private int idCategoria;
	
	// Construtores
	public CategoriaJogo() {}

	public CategoriaJogo(int idJogo, int idCategoria) {
		super();
		this.idJogo = idJogo;
		this.idCategoria = idCategoria;
	}

	// Getters e Setters
	public int getIdJogo() {
		return idJogo;
	}

	public void setIdJogo(int idJogo) {
		this.idJogo = idJogo;
	}

	public int getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(int idCategoria) {
		this.idCategoria = idCategoria;
	}
	
	
}
