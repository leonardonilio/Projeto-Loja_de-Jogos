package br.com.umbrellaGames.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "usuarios")
public class Usuario {
	
	// Atributos
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idUsuario;
	private String nomeUsuario;
	private String emailUsuario;
	private String senhaUsuario;
	private boolean administrador;
	
	// Construtores
	
	public Usuario() {}
	
	public Usuario(int idUsuario, String nomeUsuario, String emailUsuario, String senhaUsuario, boolean administrador) {
		super();
		this.idUsuario = idUsuario;
		this.nomeUsuario = nomeUsuario;
		this.emailUsuario = emailUsuario;
		this.senhaUsuario = senhaUsuario;
		this.administrador = administrador;
	}

	// Getters e setters
	
	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNomeUsuario() {
		return nomeUsuario;
	}

	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}

	public String getEmail() {
		return emailUsuario;
	}

	public void setEmail(String emailUsuario) {
		this.emailUsuario = emailUsuario;
	}

	public String getSenha() {
		return senhaUsuario;
	}

	public void setSenha(String senhaUsuario) {
		this.senhaUsuario = senhaUsuario;
	}

	public boolean getAdministrador() {
		return administrador;
	}

	public void setAdministrador(boolean administrador) {
		this.administrador = administrador;
	}

	
}
