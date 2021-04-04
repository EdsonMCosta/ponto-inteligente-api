package com.ponto.inteligenteapi.dataproviders.repositories;

import com.ponto.inteligenteapi.dataproviders.entities.ReleaseEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import java.util.List;

@Transactional(readOnly = true)
@NamedQueries({
        @NamedQuery(name = "ReleaseRepository.findByEmployeeId",
                query = "Select rel FROM releases rel WHERE rel.employee.id = :employeeId")})
public interface ReleaseRepository extends JpaRepository<ReleaseEntity, Long> {

    List<ReleaseEntity> findByEmployeeId(@Param("employeeId") Long employeeId);

    Page<ReleaseEntity> findByEmployeeId(@Param("employeeId") Long employeeId, Pageable pageable);
}
