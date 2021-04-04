package com.ponto.inteligenteapi.entrypoints.controllers;

import com.ponto.inteligenteapi.entrypoints.dtos.requests.LegalPersonRequestDTO;
import com.ponto.inteligenteapi.entrypoints.dtos.responses.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;

import java.security.NoSuchAlgorithmException;

/**
 * LegalPersonController
 *
 * @author : Edson Costa
 * @since : 04/04/2021
 **/
public interface LegalPersonController {

    /**
     * Register a new Legal Person in the system.
     *
     * @param requestDTO
     * @param result
     * @return ResponseEntity<Response < LegalPersonRequestDTO>>
     * @throws NoSuchAlgorithmException
     */
    ResponseEntity<Response<LegalPersonRequestDTO>> register(LegalPersonRequestDTO requestDTO, BindingResult result)
            throws NoSuchAlgorithmException;
}
