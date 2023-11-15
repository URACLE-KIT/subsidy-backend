package com.subsidy.server.service;

import com.subsidy.server.dto.SubsidyViewRankingsInfoDTO;
import com.subsidy.server.model.SubsidiesEntity;
import com.subsidy.server.model.SubsidyMarriedViewRankingsEntity;
import com.subsidy.server.model.SubsidyViewRankingsEntity;
import com.subsidy.server.persistence.SubsidiesRepository;
import com.subsidy.server.persistence.SubsidyMarriedViewRankingsRepository;
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
public class SubsidyMarriedViewRankingsService {
    @Autowired
    private SubsidyMarriedViewRankingsRepository subsidyMarriedViewRankingsRepository;

    @Autowired
    private SubsidiesRepository subsidiesRepository;

    /*
    @PostConstruct
    public void addSubsidyViewRankingsData() {
        for (int i = 1; i <= 240; i++) {
            SubsidyMarriedViewRankingsEntity subsidyMarriedViewRankingsEntity = new SubsidyMarriedViewRankingsEntity();

            SubsidiesEntity subsidy = subsidiesRepository.findById((long) i).orElse(null);

            if (subsidy != null) {
                subsidyMarriedViewRankingsEntity.setSubsidy(subsidy);
                subsidyMarriedViewRankingsEntity.setViews(0);
                subsidyMarriedViewRankingsRepository.save(subsidyMarriedViewRankingsEntity);
            }
        }
    }

     */

    @Transactional
    public void incrementViews(Long subsidyId) {
        SubsidyMarriedViewRankingsEntity subsidyMarriedViewRankings = subsidyMarriedViewRankingsRepository.findBySubsidy_Id(subsidyId);
        if (subsidyMarriedViewRankings != null) {
            int currentViews = subsidyMarriedViewRankings.getViews();
            subsidyMarriedViewRankings.setViews(currentViews + 1);
            subsidyMarriedViewRankingsRepository.save(subsidyMarriedViewRankings);
        }
    }


    public List<SubsidyViewRankingsInfoDTO> findTop3SubsidyInfoByMarriedViews() {
        Pageable pageable = PageRequest.of(0, 3, Sort.by("views").descending());
        return subsidyMarriedViewRankingsRepository.findTop3SubsidyInfoByViews(pageable).getContent();
    }
}
