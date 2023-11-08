package com.subsidy.server.persistence;

import com.subsidy.server.model.SubsidyReviewcommentsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SubsidyReviewCommentsRepository extends JpaRepository<SubsidyReviewcommentsEntity, Long> {
    List<SubsidyReviewcommentsEntity> findByUserId(String userId);

}

