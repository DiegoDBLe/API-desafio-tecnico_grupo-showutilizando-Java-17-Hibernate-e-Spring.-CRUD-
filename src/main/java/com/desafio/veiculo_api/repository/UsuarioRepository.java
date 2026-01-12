package com.desafio.veiculo_api.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.desafio.veiculo_api.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	
	 Optional<Usuario> findByUsername(String username);

}
