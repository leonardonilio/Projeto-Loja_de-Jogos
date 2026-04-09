package br.com.umbrellaGames.model.entity;

public class LoginDTO {
	
	private String emailUsuario;
	private String senhaUsuario;
	
	//construtor
	
	public LoginDTO () {}
	
	public LoginDTO(String emailUsuario, String senhaUsuario) {
		super();
		this.emailUsuario = emailUsuario;
		this.senhaUsuario = senhaUsuario;
	}
	
	
	//getters e setters

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
	
	
	

}
