package com.subsidy.server.persistence;

import com.subsidy.server.model.SubsidyReviewsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface SubsidyReviewsRepository extends JpaRepository<SubsidyReviewsEntity, Long> {
    List<SubsidyReviewsEntity> findByUserId(String userId);

}
