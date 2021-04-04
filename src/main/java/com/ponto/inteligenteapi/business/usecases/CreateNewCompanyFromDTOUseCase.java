package com.ponto.inteligenteapi.business.usecases;

import com.ponto.inteligenteapi.dataproviders.entities.CompanyEntity;
import com.ponto.inteligenteapi.entrypoints.dtos.requests.LegalPersonRequestDTO;

/**
 * CreateNewCompanyUseCase
 *
 * @author : Edson Costa
 * @since : 04/04/2021
 **/
@FunctionalInterface
public interface CreateNewCompanyFromDTOUseCase {
    CompanyEntity create(LegalPersonRequestDTO requestDTO);
}
