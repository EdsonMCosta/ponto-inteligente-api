package com.ponto.inteligenteapi.repositories;

import com.ponto.inteligenteapi.entities.CompanyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface CompanyRepository extends JpaRepository<CompanyEntity, Long> {

    @Transactional(readOnly = true)
    Optional<CompanyEntity> findByCNPJ(String cnpj);

}
