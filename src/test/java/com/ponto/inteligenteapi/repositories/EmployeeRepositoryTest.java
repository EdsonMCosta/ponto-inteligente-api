package com.ponto.inteligenteapi.repositories;

import com.ponto.inteligenteapi.entities.CompanyEntity;
import com.ponto.inteligenteapi.entities.EmployeeEntity;
import com.ponto.inteligenteapi.enums.ProfileEnum;
import com.ponto.inteligenteapi.utils.PasswordUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.security.NoSuchAlgorithmException;
import java.util.Date;

import static org.junit.Assert.*;

/**
 * EmployeeRepositoryTest
 *
 * @author : Edson Costa
 * @since : 02/04/2021
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class EmployeeRepositoryTest {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private CompanyRepository companyRepository;

    private static final String EMAIL = "test@test.com";
    private static final String CPF = "98765432100";

    @Before
    public void setUp() throws Exception {
        final CompanyEntity company = this.companyRepository.save(obtainCompanyData());
        final EmployeeEntity employee = obtainDataOfAEmployee(company);
        this.employeeRepository.save(employee);
    }

    @After
    public void cleanAll() {
        this.companyRepository.deleteAll();
    }

    @Test
    public void findEmployeeByEmail() {
        final EmployeeEntity byEmail = this.employeeRepository.findByEmail(EMAIL);

        assertEquals(EMAIL, byEmail.getEmail());
    }

    @Test
    public void findEmployeeByCPF() {
        final EmployeeEntity byCpf = this.employeeRepository.findByCpf(CPF);

        assertEquals(CPF, byCpf.getCpf());
    }

    @Test
    public void findEmployeeByEmailAndCPF() {
        final EmployeeEntity byCpfAndEmail = this.employeeRepository.findByCpfAndEmail(CPF, EMAIL);

        assertNotNull(byCpfAndEmail);
    }

    @Test
    public void findEmployeeByEmailOrCPFForInvalidEmail() {
        final EmployeeEntity byCpfAndEmail = this.employeeRepository.findByCpfAndEmail(CPF, "email@invalid.com");

        assertNull(byCpfAndEmail);
    }

    private EmployeeEntity obtainDataOfAEmployee(CompanyEntity companyEntity) throws NoSuchAlgorithmException {
        EmployeeEntity employeeEntity = new EmployeeEntity();
        employeeEntity.setId(1L);
        employeeEntity.setName("Jack of All Trade");
        employeeEntity.setProfile(ProfileEnum.USER_ROLE);
        employeeEntity.setPassword(PasswordUtils.generateBCrypt("123456"));
        employeeEntity.setCpf(CPF);
        employeeEntity.setEmail(EMAIL);
        employeeEntity.setValueHour(BigDecimal.valueOf(100.00));
        employeeEntity.setCompany(companyEntity);
        employeeEntity.setCreationDate(new Date());
        employeeEntity.setUpdateDate(new Date());
        return employeeEntity;
    }

    private CompanyEntity obtainCompanyData() {
        final CompanyEntity companyEntity = new CompanyEntity();
        companyEntity.setCompanyName("Best Place Ever");
        companyEntity.setCnpj("51463645000100");
        return companyEntity;
    }
}