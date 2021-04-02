package com.ponto.inteligenteapi.repositories;

import com.ponto.inteligenteapi.entities.CompanyEntity;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

/**
 * CompanyRepositoryTest
 *
 * @author : Edson Costa
 * @since : 02/04/2021
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class CompanyRepositoryTest {

    @Autowired
    private CompanyRepository repository;

    private static final String CNPJ = "51463645000100";

    @Before
    public void setUp() {
        CompanyEntity company = new CompanyEntity();
        company.setCompanyName("Example SA");
        company.setCnpj(CNPJ);
        this.repository.save(company);
    }

    @After
    public void cleanAll() {
        this.repository.deleteAll();
    }

    @Test
    public void testFindByCNPJ() {
        final CompanyEntity byCnpj = this.repository.findByCnpj(CNPJ);

        assertEquals(CNPJ, byCnpj.getCnpj());
    }
}
