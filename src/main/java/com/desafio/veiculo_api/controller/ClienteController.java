package com.desafio.veiculo_api.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

import com.desafio.veiculo_api.dto.ClienteRequestDTO;
import com.desafio.veiculo_api.dto.ClienteResponseDTO;
import com.desafio.veiculo_api.entity.Cliente;
import com.desafio.veiculo_api.service.ClienteService;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
    	
        this.clienteService = clienteService;
 
    }

    // CREATE
    @PostMapping
    public ResponseEntity<ClienteResponseDTO> criar(@Valid @RequestBody ClienteRequestDTO dto) {

        Cliente cliente = new Cliente();
        cliente.setNome(dto.getNome());
        cliente.setCpf(dto.getCpf());
        cliente.setEmail(dto.getEmail());
        cliente.setTelefone(dto.getTelefone());

        Cliente salvo = clienteService.criar(cliente);

        return ResponseEntity.status(HttpStatus.CREATED).body(toResponseDTO(salvo));
    
    }

    // READ - buscar por id
    @GetMapping("/{id}")
    public ResponseEntity<ClienteResponseDTO> buscarPorId(@PathVariable Long id) {

        Cliente cliente = clienteService.buscarPorId(id);
       
        return ResponseEntity.ok(toResponseDTO(cliente));
   
    }

    // READ - listar todos
    @GetMapping
    public ResponseEntity<List<ClienteResponseDTO>> listarTodos() {

        List<ClienteResponseDTO> lista = clienteService.listarTodos()
                .stream()
                .map(this::toResponseDTO)
                .collect(Collectors.toList());

        return ResponseEntity.ok(lista);
    
    }

    // UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<ClienteResponseDTO> atualizar(@PathVariable Long id, @Valid @RequestBody ClienteRequestDTO dto) {

        Cliente cliente = new Cliente();
        cliente.setNome(dto.getNome());
        cliente.setEmail(dto.getEmail());
        cliente.setTelefone(dto.getTelefone());

        Cliente atualizado = clienteService.atualizar(id, cliente);
        
        return ResponseEntity.ok(toResponseDTO(atualizado));
    }

    // DELETE
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(@PathVariable Long id) {
      
    	clienteService.deletar(id);

    }

    // MÉTODO DE CONVERSÃO
    private ClienteResponseDTO toResponseDTO(Cliente cliente) {

        ClienteResponseDTO dto = new ClienteResponseDTO();
        dto.setId(cliente.getId());
        dto.setNome(cliente.getNome());
        dto.setCpf(cliente.getCpf());
        dto.setEmail(cliente.getEmail());
        dto.setTelefone(cliente.getTelefone());
        dto.setDataCadastro(cliente.getDataCadastro());

        return dto;
    }
}
