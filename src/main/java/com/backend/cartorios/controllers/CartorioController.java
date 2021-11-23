package com.backend.cartorios.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.backend.cartorios.domain.model.Cartorio;
import com.backend.cartorios.repository.CartorioRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Controller
@RequestMapping("cartorio")
public class CartorioController {

	private CartorioRepository cartorioRepository;

	@GetMapping("/")
	public String listar(Model model) {
		List<Cartorio> cartorios = cartorioRepository.findAll();
		model.addAttribute("cartorios", cartorios);
		
		return "index";
	}
	
	@GetMapping("cartorios")
	public String cartorios(Model model) {
		List<Cartorio> cartorios = cartorioRepository.findAll();
		model.addAttribute("cartorios", cartorios);
		return "cartorio/cartorios";
	}

	

	@GetMapping("/cartorio-certidao/{id}")
	public String buscarPorId(@PathVariable("id") Long id, Model model) {
		
		Cartorio cartorio = cartorioRepository.findById(id).get();		
		model.addAttribute("cartorio", cartorio );		
		return"cartorio/cartorio-certidoes";
	}

	
	@GetMapping("/cadastrar")
	public String cadastrar(Cartorio cartorio) {
		return "cartorio/form-cadastro";
	}
	
	@PostMapping("/cadastrar-cartorio")
	@ResponseStatus(HttpStatus.CREATED)
	public String cadastrar(@Valid Cartorio cartorio, BindingResult result, Model model) {

				
		if (result.hasErrors()) {			
			return "cartorio/form-cadastro";
		}
		cartorioRepository.save(cartorio);
		model.addAttribute("cartorio", cartorio);
		
		cartorio.setEndereco(null);//Criar metodo para fazer um reset dos campos
		cartorio.setNome(null);
		cartorio.setTelefone(null);
		
		return "cartorio/form-cadastro";
	}

	@GetMapping("/atualizar/{id}")
	public String atualizar(@PathVariable("id") Long id, Model model) {
		
		Cartorio cartorio = cartorioRepository.findById(id)
				.orElseThrow(()-> new IllegalArgumentException("identificador invalido"));
		
		model.addAttribute("cartorio", cartorio);
		return "/cartorio/form-cadastro";
	}

	@GetMapping("deletar/{id}")
	public String deletar(@PathVariable("id") Long id) {

		Cartorio cartorio = cartorioRepository.findById(id).get();
		cartorioRepository.delete(cartorio);
		return "redirect:/cartorio/cartorios";

	}
	

}
