package com.subsidy.server.persistence;

import com.subsidy.server.dto.SubsidyViewRankingsInfoDTO;
import com.subsidy.server.model.SubsidySeniorViewRankingsEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface SubsidySeniorViewRankingsRepository extends JpaRepository<SubsidySeniorViewRankingsEntity, Long> {
    SubsidySeniorViewRankingsEntity findBySubsidy_Id(Long subsidyId);

    @Query(value = "SELECT new com.subsidy.server.dto.SubsidyViewRankingsInfoDTO(s.subsidy.id, s.subsidy.title, s.subsidy.description, s.subsidy.application_period, s.views) FROM SubsidySeniorViewRankingsEntity s ORDER BY s.views DESC")
    Page<SubsidyViewRankingsInfoDTO> findTop3SubsidyInfoByViews(Pageable pageable);
}
