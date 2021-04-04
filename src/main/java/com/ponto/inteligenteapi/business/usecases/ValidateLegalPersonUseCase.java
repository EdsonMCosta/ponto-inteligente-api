package com.ponto.inteligenteapi.business.usecases;

import com.ponto.inteligenteapi.entrypoints.dtos.requests.LegalPersonRequestDTO;
import org.springframework.validation.BindingResult;

/**
 * ValidateLegalPersonUseCase
 *
 * @author : Edson Costa
 * @since : 04/04/2021
 **/
@FunctionalInterface
public interface ValidateLegalPersonUseCase {

    /**
     * Verify if the company or employee already exists in database.
     *
     * @param requestDTO
     * @param result
     */
    void validateDataForLegalPerson(LegalPersonRequestDTO requestDTO, BindingResult result);
}
