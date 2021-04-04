package com.ponto.inteligenteapi.business.services.implementations;

import com.ponto.inteligenteapi.dataproviders.entities.ReleaseEntity;
import com.ponto.inteligenteapi.dataproviders.repositories.ReleaseRepository;
import com.ponto.inteligenteapi.business.services.ReleasesService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * ReleasesServiceImpl
 *
 * @author : Edson Costa
 * @since : 03/04/2021
 **/
@Service
@RequiredArgsConstructor
public class ReleasesServiceImpl implements ReleasesService {

    private final ReleaseRepository releaseRepository;

    @Override
    public Page<ReleaseEntity> searchByEmployeeId(Long employeeId, PageRequest pageRequest) {
        return this.releaseRepository.findByEmployeeId(employeeId, pageRequest);
    }

    @Override
    public Optional<ReleaseEntity> searchByReleaseId(Long id) {
        return this.releaseRepository.findById(id);
    }

    @Override
    public ReleaseEntity save(ReleaseEntity releaseEntity) {
        return this.releaseRepository.save(releaseEntity);
    }

    @Override
    public void removeRelease(Long id) {
        releaseRepository.deleteById(id);

    }
}
