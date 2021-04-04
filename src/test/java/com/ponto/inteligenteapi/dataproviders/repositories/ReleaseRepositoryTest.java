package com.ponto.inteligenteapi.dataproviders.repositories;

import com.ponto.inteligenteapi.dataproviders.entities.CompanyEntity;
import com.ponto.inteligenteapi.dataproviders.entities.EmployeeEntity;
import com.ponto.inteligenteapi.dataproviders.entities.ReleaseEntity;
import com.ponto.inteligenteapi.dataproviders.enums.ProfileEnum;
import com.ponto.inteligenteapi.dataproviders.enums.TypeEnum;
import com.ponto.inteligenteapi.business.utils.PasswordUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * ReleaseRepositoryTest
 *
 * @author : Edson Costa
 * @since : 03/04/2021
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class ReleaseRepositoryTest {

    @Autowired
    private ReleaseRepository releaseRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private CompanyRepository companyRepository;

    private Long employeeId;

    @Before
    public void setUp() throws Exception {
        final CompanyEntity company = this.companyRepository.save(obtainCompanyData());

        final EmployeeEntity employee = obtainDataOfAEmployee(company);
        this.employeeRepository.save(employee);
        this.employeeId = employee.getId();

        this.releaseRepository.save(obtainDataRelease(employee));
        this.releaseRepository.save(obtainDataRelease(employee));
    }

    @After
    public void cleanAll() throws Exception {
        this.companyRepository.deleteAll();
    }

    @Test
    public void testFindReleaseByEmployeeId() {
        final List<ReleaseEntity> byEmployeeId = this.releaseRepository.findByEmployeeId(employeeId);

        assertEquals(2, byEmployeeId.size());
    }

    @Test
    public void testFindReleaseByEmployeeIdPaginated() {
        final PageRequest pageRequest = new PageRequest(0, 10);
        final Page<ReleaseEntity> byEmployeeId = this.releaseRepository.findByEmployeeId(employeeId, pageRequest);

        assertEquals(2, byEmployeeId.getTotalElements());
    }

    private ReleaseEntity obtainDataRelease(EmployeeEntity employeeEntity) {
        ReleaseEntity releaseEntity = new ReleaseEntity();
        releaseEntity.setDate(new Date());
        releaseEntity.setCreationDate(new Date());
        releaseEntity.setUpdateDate(new Date());
        releaseEntity.setType(TypeEnum.START_LUNCH);
        releaseEntity.setEmployee(employeeEntity);
        return releaseEntity;
    }

    private EmployeeEntity obtainDataOfAEmployee(CompanyEntity companyEntity) throws NoSuchAlgorithmException {
        final String EMAIL = "test@test.com";
        final String CPF = "98765432100";

        EmployeeEntity employeeEntity = new EmployeeEntity();
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