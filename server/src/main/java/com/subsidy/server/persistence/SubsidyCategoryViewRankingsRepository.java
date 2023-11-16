package com.subsidy.server.persistence;

import com.subsidy.server.model.SubsidyCategoryViewRankingsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubsidyCategoryViewRankingsRepository extends JpaRepository<SubsidyCategoryViewRankingsEntity, Long> {
}
