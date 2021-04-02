package com.ponto.inteligenteapi.repositories;

import com.ponto.inteligenteapi.entities.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long> {

    EmployeeEntity findByCpf(String cpf);

    EmployeeEntity findByEmail(String email);

    EmployeeEntity findByCpfAndEmail(String cpf, String email);
}
