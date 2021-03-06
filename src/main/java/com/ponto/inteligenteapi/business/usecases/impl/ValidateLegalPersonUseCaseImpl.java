package com.ponto.inteligenteapi.business.usecases.impl;

import com.ponto.inteligenteapi.business.services.CompanyService;
import com.ponto.inteligenteapi.business.services.EmployeeService;
import com.ponto.inteligenteapi.business.usecases.ValidateLegalPersonUseCase;
import com.ponto.inteligenteapi.entrypoints.dtos.requests.LegalPersonRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

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
    public void validate(LegalPersonRequestDTO requestDTO, BindingResult result) {
        validateIfCompanyAlreadyExists(requestDTO, result);
        validateIfEmployeeAlreadyExistsByCPF(requestDTO, result);
        validateIfEmployeeAlreadyExistsByEmail(requestDTO, result);

    }

    private void validateIfCompanyAlreadyExists(LegalPersonRequestDTO requestDTO, BindingResult result) {
        this.companyService.findByCNPJ(requestDTO.getCnpj())
                .ifPresent(companyEntity ->
                        result.addError(new ObjectError("company", "Company already exists.")));
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
}
