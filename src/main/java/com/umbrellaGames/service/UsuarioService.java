package com.umbrellaGames.service;

import java.util.List;

import com.umbrellaGames.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.umbrellaGames.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	public List<Usuario> listarTodos(){
		return usuarioRepository.findAll();
	}

}

//  
