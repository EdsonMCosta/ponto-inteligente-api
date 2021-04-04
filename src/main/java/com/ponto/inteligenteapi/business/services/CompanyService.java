package com.ponto.inteligenteapi.business.services;

import com.ponto.inteligenteapi.dataproviders.entities.CompanyEntity;

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
     * @return CompanyEntity
     */
    CompanyEntity save(CompanyEntity companyEntity);
}
