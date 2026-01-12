package com.desafio.veiculo_api.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.desafio.veiculo_api.entity.Cliente;
import com.desafio.veiculo_api.exception.ResourceNotFoundException;
import com.desafio.veiculo_api.repository.ClienteRepository;
import com.desafio.veiculo_api.repository.VeiculoRepository;


@Service
@Transactional
public class ClienteServiceImpl implements ClienteService{
	
	 private final ClienteRepository clienteRepository;
	    private final VeiculoRepository veiculoRepository;

	    public ClienteServiceImpl(ClienteRepository clienteRepository,
	                              VeiculoRepository veiculoRepository) {
	        this.clienteRepository = clienteRepository;
	        this.veiculoRepository = veiculoRepository;
	    }

	@Override
	public Cliente criar(Cliente cliente) {
		
		if(clienteRepository.existsByCpf(cliente.getCpf())) {
			
			throw new ResourceNotFoundException("CPF já cadastrado");
			
		}
		
		return clienteRepository.save(cliente);
	
	}

	@Override
	@Transactional(readOnly = true)
	public Cliente buscarPorId(Long id) {
	
		return clienteRepository.findById(id)
				.orElseThrow( () -> new ResourceNotFoundException("Cliente não encontrado"));
	
	}

	@Override
	@Transactional(readOnly = true)
	public List<Cliente> listarTodos() {
		
		return clienteRepository.findAll();
	
	}

	@Override
	public Cliente atualizar(long id, Cliente cliente) {
		
		Cliente clienteExistente = buscarPorId(id);
		
		clienteExistente.setNome(cliente.getNome());
		clienteExistente.setEmail(cliente.getEmail());
		clienteExistente.setTelefone(cliente.getTelefone());

		return clienteRepository.save(clienteExistente);
	
	}

	@Override
	public void deletar(Long id) {
		
		buscarPorId(id);
		
		if (veiculoRepository.existsByClienteId(id)) {
			
			throw new ResourceNotFoundException("Cliente possui veiculos associados e não pode ser removido");
		
		}
		
		clienteRepository.deleteById(id);
		
	}

}
