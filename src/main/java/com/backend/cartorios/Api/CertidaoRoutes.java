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

import com.backend.cartorios.Api.Service.CertidaoService;
import com.backend.cartorios.domain.model.Certidao;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("api/certidao")
public class CertidaoRoutes {

	private CertidaoService certidaoService;

	@GetMapping
	public List<Certidao> listar(Model model) {
		return certidaoService.buscarTodos();
	}
	

	@GetMapping("/{id}")
	public ResponseEntity<Certidao> buscarPorId(@PathVariable Long id) {
		return certidaoService.buscarPorId(id);
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Certidao cadastrar(@RequestBody @Valid Certidao certidao) {
		return certidaoService.salvar(certidao);
	}

	@PutMapping("/{clienteId}")
	public ResponseEntity<Certidao> atualizar(@PathVariable Long id, 
			@Valid @RequestBody Certidao Certidao) {
		return certidaoService.atualizarCertidao(id);
	}

	@DeleteMapping("deletar/{id}")
	public ResponseEntity<Void> deletar(@PathVariable("id") Long id) {
		certidaoService.excluir(id);
		return ResponseEntity.noContent().build();

	}

}
