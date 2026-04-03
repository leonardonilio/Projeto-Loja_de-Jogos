package br.com.umbrellaGames.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.umbrellaGames.model.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
	
	
	//Buscar por nome
	public Usuario findByNomeUsuario(String nomeUsuario);
	
	//buscar por email para login
	public Usuario findByEmailUsuario(String emailUsuario);

}
