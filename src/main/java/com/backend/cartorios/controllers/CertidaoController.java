package com.backend.cartorios.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.backend.cartorios.domain.model.Certidao;
import com.backend.cartorios.repository.CartorioRepository;
import com.backend.cartorios.repository.CertidaoRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Controller
@RequestMapping("certidao")
public class CertidaoController {

	private CertidaoRepository certidaoRepository;
	private CartorioRepository cartorioRepository;

	@GetMapping("/")
	public String listar(Model model) {
		List<Certidao> certidoes = certidaoRepository.findAll();
		model.addAttribute("certidoes", certidoes);		
		return "certidao/certidoes";
	}

	@GetMapping("certidoes")
	public String cartorios(Model model) {
		List<Certidao> certidoes = certidaoRepository.findAll();
		model.addAttribute("certidoes", certidoes);
		return "certidao/certidoes";
	}

	@GetMapping("/{id}")
	public ResponseEntity<Certidao> buscarPorId(@PathVariable Long id) {
		return certidaoRepository.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/cadastrar")
	public String cadastrar(Certidao certidao, Model model) {
		
		model.addAttribute("cartorios", cartorioRepository.findAll());
		
		return "certidao/form-cadastro";
	}

	@PostMapping("/cadastrar-certidao")
	@ResponseStatus(HttpStatus.CREATED)
	public String cadastrar(@Valid Certidao certidao, BindingResult result, Model model) {

		if (result.hasErrors()) {
			return "certidao/form-cadastro";
		}
		
		model.addAttribute("certidao", certidao);
		
		certidaoRepository.save(certidao);
		return "certidao/form-cadastro";
	}

	@GetMapping("/atualizar/{id}")
	public String atualizar(@PathVariable("id") Long id, Model model) {
		
		Certidao certidao = certidaoRepository.findById(id)
				.orElseThrow(()-> new IllegalArgumentException("identificador invalido"));
		
		model.addAttribute("certidao", certidao);
		return "/certidao/form-cadastro";
	}

	@GetMapping("deletar/{id}")
	public String deletar(@PathVariable("id") Long id) {

		Certidao certidao = certidaoRepository.findById(id).get();
		certidaoRepository.delete(certidao);
		return "redirect:/certidao/certidoes";

	}
	


}
