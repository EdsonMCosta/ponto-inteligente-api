package com.ponto.inteligenteapi.services.implementations;

import com.ponto.inteligenteapi.entities.CompanyEntity;
import com.ponto.inteligenteapi.services.CompanyService;

import java.util.Optional;

/**
 * CompanyServiceImpl
 *
 * @author : Edson Costa 
 * @since : 03/04/2021
 **/public class CompanyServiceImpl implements CompanyService {
    @Override
    public Optional<CompanyEntity> findByCNPJ(String cnpj) {
        return Optional.empty();
    }

    @Override
    public void save(CompanyEntity companyEntity) {

    }
}
