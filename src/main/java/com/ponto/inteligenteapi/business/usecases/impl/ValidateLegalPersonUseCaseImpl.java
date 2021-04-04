package com.ponto.inteligenteapi.business.usecases.impl;

import com.ponto.inteligenteapi.business.services.CompanyService;
import com.ponto.inteligenteapi.business.services.EmployeeService;
import com.ponto.inteligenteapi.business.usecases.ValidateLegalPersonUseCase;
import com.ponto.inteligenteapi.dataproviders.entities.CompanyEntity;
import com.ponto.inteligenteapi.entrypoints.dtos.requests.LegalPersonRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * ValidateLegalPersonUseCaseImpl
 *
 * @author : Edson Costa
 * @since : 04/04/2021
 **/
@Component
@RequiredArgsConstructor
public class ValidateLegalPersonUseCaseImpl implements ValidateLegalPersonUseCase {

    private final CompanyService companyService;
    private final EmployeeService employeeService;

    @Override
    public void validateDataForLegalPerson(LegalPersonRequestDTO requestDTO, BindingResult result) {
        validateIfCompanyAlreadyExists(requestDTO, result);
        validateIfEmployeeAlreadyExistsByCPF(requestDTO, result);

    }

    private void validateIfCompanyAlreadyExists(LegalPersonRequestDTO requestDTO, BindingResult result) {
        final CompanyEntity byCNPJ = this.companyService.findByCNPJ(requestDTO.getCnpj());
        if (!(byCNPJ == null)) {
            throw new CompanyAlreadyExistsException("Company already registered.");
        }
    }

    private void validateIfEmployeeAlreadyExistsByCPF(LegalPersonRequestDTO requestDTO, BindingResult result) {
        this.employeeService.searchByCPF(requestDTO.getCpf())
                .ifPresent(employeeEntity ->
                        result.addError(new ObjectError("employee", "Employee already exists by CPF.")));
    }

    private void validateIfEmployeeAlreadyExistsByEmail(LegalPersonRequestDTO requestDTO, BindingResult result) {
        this.employeeService.searchByCPF(requestDTO.getEmail())
                .ifPresent(employeeEntity ->
                        result.addError(new ObjectError("employee", "Employee already exists by E-mail.")));
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    private static class CompanyAlreadyExistsException extends RuntimeException {
        public CompanyAlreadyExistsException(String message) {
            super(message);
        }
    }
}
