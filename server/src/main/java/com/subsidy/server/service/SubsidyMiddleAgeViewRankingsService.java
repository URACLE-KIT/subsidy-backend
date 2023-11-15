package com.subsidy.server.service;

import com.subsidy.server.dto.SubsidyViewRankingsInfoDTO;
import com.subsidy.server.model.SubsidiesEntity;
import com.subsidy.server.model.SubsidyMiddleAgeViewRankingsEntity;
import com.subsidy.server.persistence.SubsidiesRepository;
import com.subsidy.server.persistence.SubsidyMiddleAgeViewRankingsRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.List;

@Slf4j
@Service
public class SubsidyMiddleAgeViewRankingsService {
    @Autowired
    private SubsidyMiddleAgeViewRankingsRepository subsidyMiddleAgeViewRankingsRepository;

    @Autowired
    private SubsidiesRepository subsidiesRepository;

    @PostConstruct
    public void addSubsidyMiddleAgeViewRankingsData() {
        for (int i = 1; i <= 240; i++) {
            SubsidyMiddleAgeViewRankingsEntity subsidyMiddleAgeViewRankings = new SubsidyMiddleAgeViewRankingsEntity();

            SubsidiesEntity subsidy = subsidiesRepository.findById((long) i).orElse(null);

            if (subsidy != null) {
                subsidyMiddleAgeViewRankings.setSubsidy(subsidy);
                subsidyMiddleAgeViewRankings.setViews(0);
                subsidyMiddleAgeViewRankingsRepository.save(subsidyMiddleAgeViewRankings);
            }
        }
    }

    @Transactional
    public void incrementViews(Long subsidyId) {
        SubsidyMiddleAgeViewRankingsEntity subsidyMiddleAgeViewRankings = subsidyMiddleAgeViewRankingsRepository.findBySubsidy_Id(subsidyId);
        if (subsidyMiddleAgeViewRankings != null) {
            int currentViews = subsidyMiddleAgeViewRankings.getViews();
            subsidyMiddleAgeViewRankings.setViews(currentViews + 1);
            subsidyMiddleAgeViewRankingsRepository.save(subsidyMiddleAgeViewRankings);
        }
    }


    public List<SubsidyViewRankingsInfoDTO> findTop3SubsidyInfoByMiddleAgeViews() {
        Pageable pageable = PageRequest.of(0, 3, Sort.by("views").descending());
        return subsidyMiddleAgeViewRankingsRepository.findTop3SubsidyInfoByViews(pageable).getContent();
    }


}
