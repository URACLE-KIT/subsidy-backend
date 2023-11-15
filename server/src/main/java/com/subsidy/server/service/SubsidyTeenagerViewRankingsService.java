package com.subsidy.server.service;

import com.subsidy.server.dto.SubsidyViewRankingsInfoDTO;
import com.subsidy.server.model.SubsidiesEntity;
import com.subsidy.server.model.SubsidyTeenagerViewRankingsEntity;
import com.subsidy.server.persistence.SubsidiesRepository;
import com.subsidy.server.persistence.SubsidyTeenagerViewRankingsRepository;
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
public class SubsidyTeenagerViewRankingsService {
    @Autowired
    private SubsidyTeenagerViewRankingsRepository subsidyTeenagerViewRankingsRepository;


    @Autowired
    private SubsidiesRepository subsidiesRepository;

    @PostConstruct
    public void addSubsidyTeenagerViewRankingsData() {
        for (int i = 1; i <= 240; i++) {
            SubsidyTeenagerViewRankingsEntity subsidyTeenagerViewRankings = new SubsidyTeenagerViewRankingsEntity();

            SubsidiesEntity subsidy = subsidiesRepository.findById((long) i).orElse(null);

            if (subsidy != null) {
                subsidyTeenagerViewRankings.setSubsidy(subsidy);
                subsidyTeenagerViewRankings.setViews(0);
                subsidyTeenagerViewRankingsRepository.save(subsidyTeenagerViewRankings);
            }
        }
    }

    @Transactional
    public void incrementViews(Long subsidyId) {
        SubsidyTeenagerViewRankingsEntity subsidyTeenagerViewRankings = subsidyTeenagerViewRankingsRepository.findBySubsidy_Id(subsidyId);
        if (subsidyTeenagerViewRankings != null) {
            int currentViews = subsidyTeenagerViewRankings.getViews();
            subsidyTeenagerViewRankings.setViews(currentViews + 1);
            subsidyTeenagerViewRankingsRepository.save(subsidyTeenagerViewRankings);
        }
    }


    public List<SubsidyViewRankingsInfoDTO> findTop3SubsidyInfoByTeenagerViews() {
        Pageable pageable = PageRequest.of(0, 3, Sort.by("views").descending());
        return subsidyTeenagerViewRankingsRepository.findTop3SubsidyInfoByViews(pageable).getContent();
    }
}
