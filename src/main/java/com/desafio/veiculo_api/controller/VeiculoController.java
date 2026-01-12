package com.desafio.veiculo_api.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.desafio.veiculo_api.dto.VeiculoRequestDTO;
import com.desafio.veiculo_api.dto.VeiculoResponseDTO;
import com.desafio.veiculo_api.entity.Veiculo;
import com.desafio.veiculo_api.service.VeiculoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/veiculos")
public class VeiculoController {

    private final VeiculoService veiculoService;

    public VeiculoController(VeiculoService veiculoService) {
        this.veiculoService = veiculoService;
    }

    // CREATE — veículo sempre associado a um cliente
    @PostMapping("/cliente/{clienteId}")
    public ResponseEntity<VeiculoResponseDTO> criar(@PathVariable Long clienteId, @Valid @RequestBody VeiculoRequestDTO dto) {

        Veiculo veiculo = new Veiculo();
        veiculo.setMarca(dto.getMarca());
        veiculo.setModelo(dto.getModelo());
        veiculo.setAno(dto.getAno());
        veiculo.setPlaca(dto.getPlaca());

        Veiculo salvo = veiculoService.criar(clienteId, veiculo);

        return ResponseEntity.status(HttpStatus.CREATED).body(toResponseDTO(salvo));
    }

    // READ — buscar por id
    @GetMapping("/{id}")
    public ResponseEntity<VeiculoResponseDTO> buscarPorId(@PathVariable Long id) {

        Veiculo veiculo = veiculoService.buscarPorId(id);
       
        return ResponseEntity.ok(toResponseDTO(veiculo));
    
    }

    // READ — listar todos
    @GetMapping
    public ResponseEntity<List<VeiculoResponseDTO>> listarTodos() {

        List<VeiculoResponseDTO> lista = veiculoService.listarTodos()
                .stream()
                .map(this::toResponseDTO)
                .collect(Collectors.toList());

        return ResponseEntity.ok(lista);
   
    }

    // UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<VeiculoResponseDTO> atualizar(@PathVariable Long id, @Valid @RequestBody VeiculoRequestDTO dto) {

        Veiculo veiculo = new Veiculo();
        veiculo.setMarca(dto.getMarca());
        veiculo.setModelo(dto.getModelo());
        veiculo.setAno(dto.getAno());
        veiculo.setPlaca(dto.getPlaca());

        Veiculo atualizado = veiculoService.atualizar(id, veiculo);

        return ResponseEntity.ok(toResponseDTO(atualizado));
    
    }

    // DELETE
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(@PathVariable Long id) {
    	
    	veiculoService.deletar(id);
    
    }

    // MÉTODO DE CONVERSÃO
    private VeiculoResponseDTO toResponseDTO(Veiculo veiculo) {

        VeiculoResponseDTO dto = new VeiculoResponseDTO();
        dto.setId(veiculo.getId());
        dto.setMarca(veiculo.getMarca());
        dto.setModelo(veiculo.getModelo());
        dto.setAno(veiculo.getAno());
        dto.setPlaca(veiculo.getPlaca());

        if (veiculo.getCliente() != null) {
            dto.setClienteId(veiculo.getCliente().getId());
            dto.setClienteNome(veiculo.getCliente().getNome());
        }

        return dto;
    }
    
}

