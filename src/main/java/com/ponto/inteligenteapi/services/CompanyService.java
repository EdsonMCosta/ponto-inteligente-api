package com.ponto.inteligenteapi.services;

import com.ponto.inteligenteapi.entities.CompanyEntity;

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
    CompanyEntity findByCNPJ(final String cnpj);

    /**
     * @param companyEntity
     * @return void
     */
    void save(final CompanyEntity companyEntity);
}
