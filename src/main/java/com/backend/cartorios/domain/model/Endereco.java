package com.backend.cartorios.domain.model;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Embeddable
public class Endereco {

	@NotBlank
	private String cep;
	
	private String uf;
	private String cidade;
	
	
	
}
