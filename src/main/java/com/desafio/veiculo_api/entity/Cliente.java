package com.desafio.veiculo_api.entity;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "clientes")
@Getter
@Setter
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	@Size(min = 3, max = 100)
	@Column(nullable = false)
	private String nome;
	
	@NotBlank
	@Size(min = 11, max = 11)
	@Column(nullable = false, unique = true, length = 11)
	private String cpf;
	
	@NotBlank
    @Email
    @Column(nullable = false, unique = true)
    private String email;

    @NotBlank
    @Size(min = 10, max = 15)
    @Column(nullable = false)
    private String telefone;

    @Column(name = "data_cadastro", nullable = false, updatable = false)
    private LocalDateTime dataCadastro;
    
    @OneToMany(mappedBy = "cliente", fetch = FetchType.LAZY)
    private List<Veiculo> veiculos;

    @PrePersist
    public void prePersist() {
        
    	this.dataCadastro = LocalDateTime.now();
  
    }
    
	
}
