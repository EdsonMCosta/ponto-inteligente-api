package com.ponto.inteligenteapi.business.services.implementations;

import com.ponto.inteligenteapi.dataproviders.entities.CompanyEntity;
import com.ponto.inteligenteapi.dataproviders.repositories.CompanyRepository;
import com.ponto.inteligenteapi.business.services.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Optional;

/**
 * CompanyServiceImpl
 *
 * @author : Edson Costa
 * @since : 03/04/2021
 **/
@Service
@RequiredArgsConstructor
public class CompanyServiceImpl implements CompanyService {

    private final CompanyRepository companyRepository;

    @Override
    public Optional<CompanyEntity> findByCNPJ(String cnpj) {
        return companyRepository.findByCnpj(cnpj);
    }

    @Override
    public CompanyEntity save(CompanyEntity companyEntity) {
        return companyRepository.save(companyEntity);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public static class InvalidCNPJException extends RuntimeException {
        public InvalidCNPJException(String message) {
            super(message);
        }
    }
}
