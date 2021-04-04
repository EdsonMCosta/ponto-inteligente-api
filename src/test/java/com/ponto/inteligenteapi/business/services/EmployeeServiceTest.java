package com.ponto.inteligenteapi.business.services;

import com.ponto.inteligenteapi.dataproviders.entities.EmployeeEntity;
import com.ponto.inteligenteapi.dataproviders.repositories.EmployeeRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

/**
 * EmployeeServiceTest
 *
 * @author : Edson Costa
 * @since : 03/04/2021
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class EmployeeServiceTest {

    @MockBean
    private EmployeeRepository employeeRepository;

    @Autowired
    private EmployeeService employeeService;

    private static final String EMAIL_TEST = "test@test.com";
    private static final String CPF_TEST = "98765432100";

    @Before
    public void setUp() throws Exception {
        BDDMockito.given(this.employeeRepository.save(Mockito.any(EmployeeEntity.class)))
                .willReturn(new EmployeeEntity());

        BDDMockito.given(this.employeeRepository.findById(Mockito.anyLong()))
                .willReturn(java.util.Optional.of(new EmployeeEntity()));

        when(this.employeeRepository.findByEmail(Mockito.anyString()))
                .thenReturn(new EmployeeEntity());

        when(this.employeeRepository.findByCpf(Mockito.anyString()))
                .thenReturn(new EmployeeEntity());
    }

    @After
    public void cleaAll() throws Exception {
        employeeRepository.deleteAll();
    }

    @Test
    public void testSaveEmployee() {
        final EmployeeEntity entity = this.employeeService.save(new EmployeeEntity());

        assertNotNull(entity);
    }

    @Test
    public void testSearchByEmployeeById() {
        final Optional<EmployeeEntity> employeeEntity = this.employeeService.searchById(1L);

        assertTrue(employeeEntity.isPresent());
    }

    @Test
    public void testSearchByEmployeeEmail() {
        final Optional<EmployeeEntity> employeeEntity = this.employeeService.searchByEmail(EMAIL_TEST);

        assertTrue(employeeEntity.isPresent());
    }

    @Test
    public void testSearchByEmployeeCpf() {
        final Optional<EmployeeEntity> employeeEntity = this.employeeService.searchByCPF(CPF_TEST);

        assertTrue(employeeEntity.isPresent());
    }
}