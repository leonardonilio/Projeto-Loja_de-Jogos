package com.fatecgru.Projeto.Loja.de.Brinquedos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fatecgru.Projeto.Loja.de.Brinquedos.model.entity.Usuario;
import com.fatecgru.Projeto.Loja.de.Brinquedos.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	public List<Usuario> listarTodos(){
		return usuarioRepository.findAll();
	}

}

//  
