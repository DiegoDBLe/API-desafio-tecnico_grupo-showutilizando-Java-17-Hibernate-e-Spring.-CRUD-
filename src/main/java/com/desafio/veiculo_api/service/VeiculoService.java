package com.desafio.veiculo_api.service;

import java.util.List;

import com.desafio.veiculo_api.entity.Veiculo;

public interface VeiculoService {
	
	Veiculo criar(Long clienteId, Veiculo veiculo);
	
	Veiculo buscarPorId(Long id);
	
	List<Veiculo> listarTodos();
	
	Veiculo atualizar(Long id, Veiculo veiculo);
	
	void deletar(Long id);

}
