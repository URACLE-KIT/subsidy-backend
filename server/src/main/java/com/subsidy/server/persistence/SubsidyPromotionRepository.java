package com.subsidy.server.persistence;

import com.subsidy.server.model.SubsidyPromotionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SubsidyPromotionRepository extends JpaRepository<SubsidyPromotionEntity, Long> {
    List<SubsidyPromotionEntity> findByUserId(String userId);
}
