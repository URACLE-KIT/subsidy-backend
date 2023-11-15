package com.subsidy.server.persistence;

import com.subsidy.server.dto.SubsidyViewRankingsInfoDTO;
import com.subsidy.server.model.SubsidyYouthViewRankingsEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface SubsidyYouthViewRankingsRepository extends JpaRepository<SubsidyYouthViewRankingsEntity, Long> {
    SubsidyYouthViewRankingsEntity findBySubsidy_Id(Long subsidyId);

    @Query(value = "SELECT new com.subsidy.server.dto.SubsidyViewRankingsInfoDTO(s.subsidy.id, s.subsidy.title, s.subsidy.description, s.subsidy.application_period, s.views) FROM SubsidyYouthViewRankingsEntity s ORDER BY s.views DESC")
    Page<SubsidyViewRankingsInfoDTO> findTop3SubsidyInfoByViews(Pageable pageable);
}
