package com.desafio.veiculo_api.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.desafio.veiculo_api.entity.Veiculo;

@Repository
public interface VeiculoRepository extends JpaRepository<Veiculo, Long>{
	
	Optional<Veiculo> findByPlaca(String placa);
	
	boolean existsByPlaca(String placa);
	
	List<Veiculo> findByClienteId(Long clienteId);
	
	boolean existsByClienteId(Long clienteId);

}
