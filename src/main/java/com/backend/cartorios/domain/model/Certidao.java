package com.backend.cartorios.domain.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity(name = "TB_CERTIDAO")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Certidao implements Serializable {

	
	private static final long serialVersionUID = 1L;

	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	private Long id;
	
	@NotBlank	
	private String nome;
	
	@ManyToOne
    @JoinColumn(name = "cartorio_id") 
	@JsonBackReference
	private Cartorio cartorio;

	@Override
	public String toString() {
		return "Certidao [id=" + id + ", nome=" + nome + ", cartorio=" + cartorio + "]";
	}
	
	
	
	
}
