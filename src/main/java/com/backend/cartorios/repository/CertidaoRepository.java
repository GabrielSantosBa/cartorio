package com.backend.cartorios.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.backend.cartorios.domain.model.Certidao;

@Repository
public interface CertidaoRepository extends JpaRepository<Certidao, Long> {


}
