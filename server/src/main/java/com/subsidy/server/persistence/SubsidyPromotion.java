package com.subsidy.server.persistence;

import com.subsidy.server.model.SubsidyPromotionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubsidyPromotion extends JpaRepository<SubsidyPromotionEntity, Long> {
}
