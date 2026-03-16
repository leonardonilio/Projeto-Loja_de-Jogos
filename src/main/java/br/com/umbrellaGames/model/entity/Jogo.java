package br.com.umbrellaGames.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "jogos")
public class Jogo {
	
	// Atributos
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idJogo;
	private String nomeJogo;
	private String desenvolvedora;
	private String imagem;
	private String detalhes;
	private double valor;
	
	// Construtores
	
	public Jogo() {}
	
	public Jogo(Integer idJogo, String nomeJogo, String desenvolvedora, String imagem, String detalhes, double valor) {
		super();
		this.idJogo = idJogo;
		this.nomeJogo = nomeJogo;
		this.desenvolvedora = desenvolvedora;
		this.imagem = imagem;
		this.detalhes = detalhes;
		this.valor = valor;
	}

	// Getters e Setters
	
	public Integer getIdJogo() {
		return idJogo;
	}

	public void setIdJogo(int idJogo) {
		this.idJogo = idJogo;
	}

	public String getNomeJogo() {
		return nomeJogo;
	}

	public void setNomeJogo(String nomeJogo) {
		this.nomeJogo = nomeJogo;
	}

	public String getDesenvolvedora() {
		return desenvolvedora;
	}

	public void setDesenvolvedora(String desenvolvedora) {
		this.desenvolvedora = desenvolvedora;
	}

	public String getImagem() {
		return imagem;
	}

	public void setImagem(String imagem) {
		this.imagem = imagem;
	}

	public String getDetalhes() {
		return detalhes;
	}

	public void setDetalhes(String detalhes) {
		this.detalhes = detalhes;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}	
	
}
