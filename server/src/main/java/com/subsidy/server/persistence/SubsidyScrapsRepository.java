package com.subsidy.server.persistence;

import com.subsidy.server.model.SubsidyScrapsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface SubsidyScrapsRepository extends JpaRepository<SubsidyScrapsEntity, Long> {

    Optional<SubsidyScrapsEntity> findById(Long id);
    List<SubsidyScrapsEntity> findByUserId(String userId);
    @Transactional
    void deleteBySubsidyId(Long subsidyId);


}

