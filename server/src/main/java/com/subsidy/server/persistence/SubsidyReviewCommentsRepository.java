package com.subsidy.server.persistence;

import com.subsidy.server.model.SubsidyReviewCommentsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SubsidyReviewCommentsRepository extends JpaRepository<SubsidyReviewCommentsEntity, Long> {
    List<SubsidyReviewCommentsEntity> findByUserId(String userId);

}

