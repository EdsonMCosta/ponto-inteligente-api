package com.ponto.inteligenteapi.business.services;

import com.ponto.inteligenteapi.dataproviders.entities.CompanyEntity;
import com.ponto.inteligenteapi.dataproviders.repositories.CompanyRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.Assert.*;

/**
 * CompanyServiceTest
 *
 * @author : Edson Costa
 * @since : 03/04/2021
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class CompanyServiceTest {

    @Autowired
    private CompanyRepository repository;

    @Autowired
    private CompanyService companyService;

    private static final String CNPJ = "51463645000100";

    @Before
    public void setUp() throws Exception {
        repository.save(obtainCompanyData());
    }

    @After
    public void cleaAll() throws Exception {
        repository.deleteAll();
    }

    @Test
    public void testFindCompanyByCNPJ() {
        final Optional<CompanyEntity> byCNPJ = this.companyService.findByCNPJ(CNPJ);

        assertTrue(byCNPJ.isPresent());
    }

    @Test
    public void testSaveCompany() {
        CompanyEntity entity = companyService.save(obtainCompanyData());

        assertNotNull(entity);
    }

    private CompanyEntity obtainCompanyData() {
        final CompanyEntity companyEntity = new CompanyEntity();
        companyEntity.setCompanyName("Best Place Ever");
        companyEntity.setCnpj(CNPJ);
        return companyEntity;
    }
}