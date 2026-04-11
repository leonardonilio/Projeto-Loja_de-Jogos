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
}
