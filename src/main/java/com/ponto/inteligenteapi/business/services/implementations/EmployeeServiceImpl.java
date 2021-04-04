package com.ponto.inteligenteapi.business.services.implementations;

import com.ponto.inteligenteapi.dataproviders.entities.EmployeeEntity;
import com.ponto.inteligenteapi.dataproviders.repositories.EmployeeRepository;
import com.ponto.inteligenteapi.business.services.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * EmployeeServiceImpl
 *
 * @author : Edson Costa
 * @since : 03/04/2021
 **/
@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Override
    public EmployeeEntity save(EmployeeEntity employeeEntity) {
        return this.employeeRepository.save(employeeEntity);
    }

    @Override
    public Optional<EmployeeEntity> searchByCPF(String cpf) {
        return Optional.ofNullable(this.employeeRepository.findByCpf(cpf));
    }

    @Override
    public Optional<EmployeeEntity> searchByEmail(String email) {
        return Optional.ofNullable(this.employeeRepository.findByEmail(email));
    }

    @Override
    public Optional<EmployeeEntity> searchById(Long id) {
        return this.employeeRepository.findById(id);
    }
}
