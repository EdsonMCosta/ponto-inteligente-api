package com.ponto.inteligenteapi.dataproviders.converter;

import com.ponto.inteligenteapi.business.utils.PasswordUtils;
import com.ponto.inteligenteapi.dataproviders.entities.CompanyEntity;
import com.ponto.inteligenteapi.dataproviders.entities.EmployeeEntity;
import com.ponto.inteligenteapi.dataproviders.enums.ProfileEnum;
import com.ponto.inteligenteapi.entrypoints.dtos.requests.LegalPersonRequestDTO;

import java.util.Date;

/**
 * Converter
 *
 * @author : Edson Costa
 * @since : 04/04/2021
 **/
public class Converter {

    public static CompanyEntity convertCompanyFromDTO(LegalPersonRequestDTO requestDTO) {
        return CompanyEntity.of(
                requestDTO.getCompanyName(),
                requestDTO.getCnpj(),
                new Date(),
                new Date());
    }

    public static EmployeeEntity convertEmployeeFromDTO(LegalPersonRequestDTO requestDTO) {
        return EmployeeEntity.of(
                requestDTO.getName(),
                requestDTO.getEmail(),
                PasswordUtils.generateBCrypt(requestDTO.getPassword()),
                requestDTO.getCpf(),
                ProfileEnum.MANAGER_ROLE,
                new Date(),
                new Date()
        );
    }

    public static LegalPersonRequestDTO convertToDTO(EmployeeEntity employeeEntity) {
        final LegalPersonRequestDTO legalPersonRequestDTO = new LegalPersonRequestDTO();
        legalPersonRequestDTO.setId(employeeEntity.getId());
        legalPersonRequestDTO.setName(employeeEntity.getName());
        legalPersonRequestDTO.setEmail(employeeEntity.getEmail());
        legalPersonRequestDTO.setCpf(employeeEntity.getCpf());
        legalPersonRequestDTO.setCompanyName(employeeEntity.getCompany().getCompanyName());
        legalPersonRequestDTO.setCnpj(employeeEntity.getCompany().getCnpj());

        return legalPersonRequestDTO;
    }
}
