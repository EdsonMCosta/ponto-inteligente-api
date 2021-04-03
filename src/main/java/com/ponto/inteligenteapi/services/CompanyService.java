package com.ponto.inteligenteapi.services;

import com.ponto.inteligenteapi.entities.CompanyEntity;

import java.util.Optional;

/**
 * CompanyServices
 *
 * @author : Edson Costa
 * @since : 03/04/2021
 **/
public interface CompanyService {

    /**
     * Find a company by a CNPJ
     *
     * @param cnpj
     * @return Optional<CompanyEntity>
     */
    CompanyEntity findByCNPJ(String cnpj);

    /**
     * @param companyEntity
     * @return void
     */
    CompanyEntity save(CompanyEntity companyEntity);
}
