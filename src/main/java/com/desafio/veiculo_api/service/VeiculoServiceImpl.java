package com.desafio.veiculo_api.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.desafio.veiculo_api.entity.Cliente;
import com.desafio.veiculo_api.entity.Veiculo;
import com.desafio.veiculo_api.exception.ResourceNotFoundException;
import com.desafio.veiculo_api.repository.ClienteRepository;
import com.desafio.veiculo_api.repository.VeiculoRepository;

@Service
@Transactional
public class VeiculoServiceImpl implements VeiculoService{
	
	private final VeiculoRepository veiculoRepository;
	private final ClienteRepository clienteRepository;
	
	public VeiculoServiceImpl(VeiculoRepository veiculoRepository,
							   ClienteRepository clienteRepository) {
		
		this.veiculoRepository = veiculoRepository;
		this.clienteRepository = clienteRepository;
		
	}

	@Override
	public Veiculo criar(Long clienteId, Veiculo veiculo) {
		
		Cliente cliente = clienteRepository.findById(clienteId)
				.orElseThrow(() -> new ResourceNotFoundException("Cliente Não encontrado!"));
		
		veiculo.setCliente(cliente);
		
		return veiculoRepository.save(veiculo);

	}

	@Override
	@Transactional(readOnly = true)
	public Veiculo buscarPorId(Long id) {
		
		return veiculoRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Veiculo não encontrado"));
	
	}

	@Override
	@Transactional(readOnly = true)
	public List<Veiculo> listarTodos() {
		
		return veiculoRepository.findAll();
	
	}

	@Override
	public Veiculo atualizar(Long id, Veiculo veiculo) {
		
		Veiculo veiculoExistente = buscarPorId(id);
		
		veiculoExistente.setMarca(veiculo.getMarca());
		veiculoExistente.setModelo(veiculo.getModelo());
		veiculoExistente.setAno(veiculo.getAno());
		veiculoExistente.setPlaca(veiculo.getPlaca());
		
		return veiculoRepository.save(veiculoExistente);
	
	}

	@Override
	public void deletar(Long id) {
		
		Veiculo veiculo = buscarPorId(id);
		veiculoRepository.delete(veiculo);
		
	}
	
}
