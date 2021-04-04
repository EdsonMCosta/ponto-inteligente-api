package com.ponto.inteligenteapi.business.usecases.impl;

import com.ponto.inteligenteapi.business.usecases.CreateNewCompanyFromDTOUseCase;
import com.ponto.inteligenteapi.dataproviders.entities.CompanyEntity;
import com.ponto.inteligenteapi.entrypoints.dtos.requests.LegalPersonRequestDTO;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * CreateNewCompanyUseCaseImpl
 *
 * @author : Edson Costa
 * @since : 04/04/2021
 **/
@Component
public class CreateNewCompanyFromDTOUseCaseImpl implements CreateNewCompanyFromDTOUseCase {

    @Override
    public CompanyEntity create(LegalPersonRequestDTO requestDTO) {
        return CompanyEntity.of(
                requestDTO.getCompanyName(),
                requestDTO.getCnpj(),
                new Date(),
                new Date());
    }
}
