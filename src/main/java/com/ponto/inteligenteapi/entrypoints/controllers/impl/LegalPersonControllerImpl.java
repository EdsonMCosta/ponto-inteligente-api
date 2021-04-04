package com.ponto.inteligenteapi.entrypoints.controllers.impl;

import com.ponto.inteligenteapi.business.services.CompanyService;
import com.ponto.inteligenteapi.business.services.EmployeeService;
import com.ponto.inteligenteapi.business.usecases.ValidateLegalPersonUseCase;
import com.ponto.inteligenteapi.dataproviders.entities.CompanyEntity;
import com.ponto.inteligenteapi.dataproviders.entities.EmployeeEntity;
import com.ponto.inteligenteapi.entrypoints.controllers.LegalPersonController;
import com.ponto.inteligenteapi.entrypoints.dtos.requests.LegalPersonRequestDTO;
import com.ponto.inteligenteapi.entrypoints.dtos.responses.Response;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.security.NoSuchAlgorithmException;

import static com.ponto.inteligenteapi.dataproviders.converter.Converter.*;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

/**
 * LegalPersonControllerImpl
 *
 * @author : Edson Costa
 * @since : 04/04/2021
 **/
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api/lp")
@RequiredArgsConstructor
public class LegalPersonControllerImpl implements LegalPersonController {

    private static final Logger log = LoggerFactory.getLogger(LegalPersonControllerImpl.class);

    private final ValidateLegalPersonUseCase validateLegalPersonUseCase;
    private final CompanyService companyService;
    private final EmployeeService employeeService;

    @Override
    @PostMapping(value = "/register", consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<Response<LegalPersonRequestDTO>> register(@Valid @RequestBody LegalPersonRequestDTO requestDTO,
                                                                    BindingResult result) throws NoSuchAlgorithmException {

        log.info("Registering new Legal Person: {}", requestDTO.toString());

        validateLegalPersonUseCase.validate(requestDTO, result);
        final CompanyEntity companyEntity = convertCompanyFromDTO(requestDTO);
        final EmployeeEntity employeeEntity = convertEmployeeFromDTO(requestDTO);

        final Response<LegalPersonRequestDTO> dtoResponse = new Response<>();

        if (result.hasErrors()) {
            result.getAllErrors().forEach(error -> dtoResponse.getErrors().add(error.getDefaultMessage()));
            return ResponseEntity.badRequest().body(dtoResponse);
        }

        companyService.save(companyEntity);

        employeeEntity.setCompany(companyEntity);
        employeeService.save(employeeEntity);

        dtoResponse.setData(convertToDTO(employeeEntity));

        return ResponseEntity
                .created(URI.create(dtoResponse.getData().getCompanyName()))
                .build();
    }
}
