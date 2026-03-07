package com.umbrellaGames.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.umbrellaGames.model.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{

}
