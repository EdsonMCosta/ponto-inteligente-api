package com.ponto.inteligenteapi.business.services;

import com.ponto.inteligenteapi.dataproviders.entities.ReleaseEntity;
import com.ponto.inteligenteapi.dataproviders.repositories.ReleaseRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Optional;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

/**
 * ReleasesServiceTest
 *
 * @author : Edson Costa
 * @since : 03/04/2021
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class ReleasesServiceTest {

    @MockBean
    private ReleaseRepository releaseRepository;

    @Autowired
    private ReleasesService releasesService;

    @Before
    public void setUp() throws Exception {
        when(this.releaseRepository.findByEmployeeId(Mockito.anyLong(), Mockito.any(PageRequest.class)))
                .thenReturn(new PageImpl<>(new ArrayList<>()));

        when(this.releaseRepository.findById(Mockito.anyLong()))
                .thenReturn(Optional.of(new ReleaseEntity()));

        when(this.releaseRepository.save(Mockito.any(ReleaseEntity.class)))
                .thenReturn(new ReleaseEntity());
    }

    @After
    public void cleanAll() {
        this.releaseRepository.deleteAll();
    }

    @Test
    public void searchReleaseByEmployeeId() {
        final Page<ReleaseEntity> releaseEntities = this.releasesService.searchByEmployeeId(1L, new PageRequest(0, 10));

        assertNotNull(releaseEntities);
    }

    @Test
    public void searchReleaseById() {
        final Optional<ReleaseEntity> releaseEntity = this.releasesService.searchByReleaseId(1L);

        assertTrue(releaseEntity.isPresent());
    }

    @Test
    public void saveRelease() {
        final ReleaseEntity savedEntity = this.releasesService.save(new ReleaseEntity());

        assertNotNull(savedEntity);
    }
    
}