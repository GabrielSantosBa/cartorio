package com.backend.cartorios.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.backend.cartorios.domain.model.Cartorio;

@Repository
public interface CartorioRepository extends JpaRepository<Cartorio, Long> {

//	@Query("select c from tb_cartorio c join tb_certidao where c.id = :id");
//	List<Cartorio> findByCartorioAndCertidao(Long id);


}
