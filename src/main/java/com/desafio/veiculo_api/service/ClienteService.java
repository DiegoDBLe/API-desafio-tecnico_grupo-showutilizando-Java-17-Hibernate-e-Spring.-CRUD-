package com.desafio.veiculo_api.service;

import java.util.List;

import com.desafio.veiculo_api.entity.Cliente;

public interface ClienteService {
	
	Cliente criar(Cliente cliente);
	
	Cliente buscarPorId(Long id);
	
	List<Cliente> listarTodos();
	
	Cliente atualizar(long id, Cliente cliente);
	
	void deletar(Long id);

}
