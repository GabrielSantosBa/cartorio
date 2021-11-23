package com.backend.cartorios.domain.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;



@Getter
@Setter
@Entity(name = "TB_CARTORIO")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Cartorio implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	private Long id;
	
	@NotBlank
	private String nome;
	
	// A meio de organização estou deixando separada a o Endereço do Cartorio somente na parte de classes, 
	// mas continua junto na parte de SQL, 
	// pois e uma tabela pequena, não irá gerar muitos atributos/colunas. 
	@Embedded
	private Endereco endereco;
	
	@OneToMany(mappedBy = "cartorio", cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonManagedReference
	private List<Certidao> certidoes = new ArrayList<>();
	
	private String telefone;
	
	
	
}
