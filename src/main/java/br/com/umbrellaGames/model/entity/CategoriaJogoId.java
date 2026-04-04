package br.com.umbrellaGames.model.entity;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Table;

@Embeddable
public class CategoriaJogoId {
	
	// atributos
	private int idJogo;
	private int idCategoria;
	
	// construtores
	public CategoriaJogoId () {}
	
	public CategoriaJogoId(int idJogo, int idCategoria) {
		super();
		this.idJogo = idJogo;
		this.idCategoria = idCategoria;
	}
	
	// getters e setters
	public int getIdJogo() {
		return idJogo;
	}
	public void setIdJogo(int idJogo) {
		this.idJogo = idJogo;
	}
	public int getIdCategoria() {
		return idCategoria;
	}
	public void setIdCategoria(int categoriaId) {
		this.idCategoria = categoriaId;
	}
	
	
}
