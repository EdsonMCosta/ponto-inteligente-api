package com.ponto.inteligenteapi.business.services;

import com.ponto.inteligenteapi.dataproviders.entities.ReleaseEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.Optional;

/**
 * ReleasesService
 *
 * @author : Edson Costa
 * @since : 03/04/2021
 **/
public interface ReleasesService {

    /**
     * Return a page list of releases of an specific employee by your Id.
     *
     * @param employeeId
     * @param pageRequest
     * @return Page<ReleaseEntity>
     */
    Page<ReleaseEntity> searchByEmployeeId(Long employeeId, PageRequest pageRequest);

    /**
     * Return a release by your Id.
     *
     * @param id
     * @return Optional<ReleaseEntity>
     */
    Optional<ReleaseEntity> searchByReleaseId(Long id);

    /**
     * Save a release.
     *
     * @param releaseEntity
     * @return ReleaseEntity
     */
    ReleaseEntity save(ReleaseEntity releaseEntity);

    /**
     * Remove a release by Id.
     *
     * @param id
     */
    void removeRelease(Long id);
}
