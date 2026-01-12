package com.desafio.veiculo_api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VeiculoRequestDTO {

    @NotBlank
    @Size(min = 2, max = 50)
    private String marca;

    @NotBlank
    @Size(min = 2, max = 50)
    private String modelo;

    @NotNull
    private Integer ano;

    @NotBlank
    @Size(min = 7, max = 7)
    private String placa;

}
