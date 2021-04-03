package com.ponto.inteligenteapi.services.implementations;

import com.ponto.inteligenteapi.entities.CompanyEntity;
import com.ponto.inteligenteapi.repositories.CompanyRepository;
import com.ponto.inteligenteapi.services.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * CompanyServiceImpl
 *
 * @author : Edson Costa
 * @since : 03/04/2021
 **/
@Service
@RequiredArgsConstructor
public class CompanyServiceImpl implements CompanyService {

    private CompanyRepository companyRepository;

    @Override
    public CompanyEntity findByCNPJ(final String cnpj) {
        return companyRepository.findByCNPJ(cnpj)
                .orElseThrow(() -> new InvalidCNPJException("Invalid CNPJ."));
    }

    @Override
    public void save(final CompanyEntity companyEntity) {
        companyRepository.save(companyEntity);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public static class InvalidCNPJException extends RuntimeException {
        public InvalidCNPJException(String message) {
            super(message);
        }
    }
}