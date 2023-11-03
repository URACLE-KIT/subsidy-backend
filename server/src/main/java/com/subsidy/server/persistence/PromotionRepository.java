package com.subsidy.server.persistence;

import java.util.Optional;

import com.subsidy.server.model.PromotionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PromotionRepository extends JpaRepository<PromotionEntity, Long> {
    Optional<PromotionEntity> findById(Long id);
}