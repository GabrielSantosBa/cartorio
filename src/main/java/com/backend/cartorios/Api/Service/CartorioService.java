package com.backend.cartorios.Api.Service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.backend.cartorios.Api.Exception.RegrasNegocioException;
import com.backend.cartorios.domain.model.Cartorio;
import com.backend.cartorios.repository.CartorioRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CartorioService {

	private CartorioRepository cartorioRepository;
	
	
	public List<Cartorio> buscarTodos() {
		return cartorioRepository.findAll();
	}
	
	public Cartorio buscarPorId(Long id) {
		return cartorioRepository.findById(id)
				.orElseThrow(() -> new RegrasNegocioException("Cliente não encontrado"));
	}
	
	@Transactional
	public Cartorio salvar(Cartorio Cartorio) {
		return cartorioRepository.save(Cartorio);
	}
	
	@Transactional
	public ResponseEntity<Cartorio> atualizarCartorio(Long id, Cartorio cartorio) {
		
		
		if(!cartorioRepository.existsById(id)) {
			throw new RegrasNegocioException("Cliente não encontrado.");
		}
		cartorio.setId(id);
		cartorioRepository.save(cartorio);
		return ResponseEntity.ok(cartorio);
	}
	
	@Transactional
	public void excluir(Long CartorioId) {
		cartorioRepository.deleteById(CartorioId);
	}
	
	
	
	
}
