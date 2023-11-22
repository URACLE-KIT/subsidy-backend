package com.subsidy.server.service;


import com.subsidy.server.dto.SubsidyViewRankingsInfoDTO;
import com.subsidy.server.model.SubsidiesEntity;
import com.subsidy.server.model.SubsidyFemaleViewRankingsEntity;
import com.subsidy.server.model.SubsidyMaleViewRankingsEntity;
import com.subsidy.server.persistence.SubsidiesRepository;
import com.subsidy.server.persistence.SubsidyFemaleViewRankingsRepository;
import com.subsidy.server.persistence.SubsidyMaleViewRankingsRepository;
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
public class SubsidyFemaleViewRankingsService {
    @Autowired
    private SubsidyFemaleViewRankingsRepository subsidyFemaleViewRankingsRepository;

    @Autowired
    private SubsidiesRepository subsidiesRepository;


    /*
    @PostConstruct
    public void addSubsidyFemaleViewRankingsData() {
        for (int i = 1; i <= 11757; i++) {
            SubsidyFemaleViewRankingsEntity subsidyFemaleViewRankings = new SubsidyFemaleViewRankingsEntity();

            SubsidiesEntity subsidy = subsidiesRepository.findById((long) i).orElse(null);

            if (subsidy != null) {
                subsidyFemaleViewRankings.setSubsidy(subsidy);
                subsidyFemaleViewRankings.setViews(0);
                subsidyFemaleViewRankingsRepository.save(subsidyFemaleViewRankings);
            }
        }
    }
    */



    @Transactional
    public void incrementViews(Long subsidyId) {
        SubsidyFemaleViewRankingsEntity subsidyFemaleViewRankings = subsidyFemaleViewRankingsRepository.findBySubsidy_Id(subsidyId);

        if (subsidyFemaleViewRankings != null) {
            int currentViews = subsidyFemaleViewRankings.getViews();
            subsidyFemaleViewRankings.setViews(currentViews + 1);
            subsidyFemaleViewRankingsRepository.save(subsidyFemaleViewRankings);
        }
    }

    public List<SubsidyViewRankingsInfoDTO> findTop3SubsidyInfoByFemaleViews() {
        Pageable pageable = PageRequest.of(0, 3, Sort.by("views").descending());
        return subsidyFemaleViewRankingsRepository.findTop3SubsidyInfoByViews(pageable).getContent();
    }




}
