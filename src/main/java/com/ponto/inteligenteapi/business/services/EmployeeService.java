package com.ponto.inteligenteapi.business.services;

import com.ponto.inteligenteapi.dataproviders.entities.EmployeeEntity;

import java.util.Optional;

/**
 * EmployeeService
 *
 * @author : Edson Costa
 * @since : 03/04/2021
 **/
public interface EmployeeService {

    /**
     * Save a new employee.
     *
     * @param employeeEntity
     * @return EmployeeEntity
     */
    EmployeeEntity save(EmployeeEntity employeeEntity);

    /**
     * Search and find a employee by CPF.
     *
     * @param cpf
     * @return Optional<EmployeeEntity>
     */
    Optional<EmployeeEntity> searchByCPF(String cpf);

    /**
     * Search and find a employee by Email.
     *
     * @param email
     * @return Optional<EmployeeEntity>
     */
    Optional<EmployeeEntity> searchByEmail(String email);

    /**
     * Search and find a employee by id.
     *
     * @param id
     * @return Optional<EmployeeEntity>
     */
    Optional<EmployeeEntity> searchById(Long id);
}
