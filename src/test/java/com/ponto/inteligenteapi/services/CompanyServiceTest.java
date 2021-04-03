package com.ponto.inteligenteapi.services;

import com.ponto.inteligenteapi.entities.CompanyEntity;
import com.ponto.inteligenteapi.repositories.CompanyRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

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
        final CompanyEntity byCNPJ = this.companyService.findByCNPJ(CNPJ);

        assertEquals(CNPJ, byCNPJ.getCnpj());
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