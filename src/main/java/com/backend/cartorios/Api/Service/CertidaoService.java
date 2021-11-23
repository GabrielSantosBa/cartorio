package com.backend.cartorios.Api.Service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import com.backend.cartorios.domain.model.Certidao;
import com.backend.cartorios.repository.CertidaoRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CertidaoService {

	private CertidaoRepository certidaoRepository;
	
	
	public List<Certidao> buscarTodos() {
		return certidaoRepository.findAll();
	}
	
	public ResponseEntity<Certidao> buscarPorId(Long id) {
		return certidaoRepository.findById(id).map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}
	
	@Transactional
	public Certidao salvar(Certidao Certidao) {
		return certidaoRepository.save(Certidao);
	}
	
	@Transactional
	public ResponseEntity<Certidao> atualizarCertidao(Long id) {
		Certidao certidao = certidaoRepository.findById(id).get();
		
		if(certidao == null) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Não foi possivel atualizar a Certidao");
		}
		certidao.setId(certidao.getId());
		certidaoRepository.save(certidao);
		return ResponseEntity.ok(certidao);
	}
	
	@Transactional
	public void excluir(Long CertidaoId) {
		certidaoRepository.deleteById(CertidaoId);
	}
	
	
	
}
