package br.com.umbrellaGames.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.umbrellaGames.model.entity.Usuario;
import br.com.umbrellaGames.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public List<Usuario> findAll(){
		return usuarioRepository.findAll();
	}
	
	//buscar por id 
	public Usuario buscarPorId(int idUsuario) {
		return usuarioRepository.findById(idUsuario).get();
	}
	
	//Buscar por nome
	public Usuario buscarPorNome(String nomeUsuario) {
		return usuarioRepository.findByNomeUsuario(nomeUsuario);
	}
	
	//Create e update
	public Usuario saveUsuario(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}
	
	//Delete
	public void deleteUsuario(int idUsuario) {
		usuarioRepository.deleteById(idUsuario);
	}
	
}
