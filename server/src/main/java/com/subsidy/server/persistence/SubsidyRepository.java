package com.subsidy.server.persistence;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.subsidy.server.model.SubsidyEntity;

@Repository
public interface SubsidyRepository extends JpaRepository<SubsidyEntity, Long> {
    Optional<SubsidyEntity> findById(Long id);
}