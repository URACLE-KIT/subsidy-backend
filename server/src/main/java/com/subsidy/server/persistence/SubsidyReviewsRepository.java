package com.subsidy.server.persistence;

import com.subsidy.server.model.SubsidyReviewCommentsEntity;
import com.subsidy.server.model.SubsidyReviewsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface SubsidyReviewsRepository extends JpaRepository<SubsidyReviewsEntity, Long> {
    List<SubsidyReviewsEntity> findByUserId(String userId);

    List<SubsidyReviewsEntity> findBySubsidyId(Long subsidyReviewId);
}
