package com.desafio.veiculo_api.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VeiculoResponseDTO {

    private Long id;
    private String marca;
    private String modelo;
    private Integer ano;
    private String placa;
    private Long clienteId;
    private String clienteNome;

}
