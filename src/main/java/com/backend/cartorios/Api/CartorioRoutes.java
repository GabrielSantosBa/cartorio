package com.backend.cartorios.Api;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.backend.cartorios.Api.Service.CartorioService;
import com.backend.cartorios.domain.model.Cartorio;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("api/cartorio")
public class CartorioRoutes {

	private CartorioService cartorioService;

	@GetMapping
	public List<Cartorio> listar(Model model) {
		return cartorioService.buscarTodos();
	}
	

	@GetMapping("/{id}")
	public Cartorio buscarPorId(@PathVariable("id") Long id) {
		return cartorioService.buscarPorId(id);
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Cartorio cadastrar(@RequestBody @Valid Cartorio cartorio) {
		return cartorioService.salvar(cartorio);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Cartorio> atualizar(@PathVariable("id") Long id, 
			@Valid @RequestBody Cartorio cartorio) {
		return cartorioService.atualizarCartorio(id,cartorio);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletar(@PathVariable("id") Long id) {
		cartorioService.excluir(id);
		return ResponseEntity.noContent().build();

	}

}
