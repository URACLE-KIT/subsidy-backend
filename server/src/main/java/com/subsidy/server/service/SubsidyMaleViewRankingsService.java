package com.subsidy.server.service;


import com.subsidy.server.dto.SubsidyViewRankingsInfoDTO;
import com.subsidy.server.model.SubsidiesEntity;
import com.subsidy.server.model.SubsidyMaleViewRankingsEntity;
import com.subsidy.server.persistence.SubsidiesRepository;
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
public class SubsidyMaleViewRankingsService {
    @Autowired
    private SubsidyMaleViewRankingsRepository subsidyMaleViewRankingsRepository;

    @Autowired
    private SubsidiesRepository subsidiesRepository;

    /*
    @PostConstruct
    public void addSubsidyMaleViewRankingsData() {
        for (int i = 1; i <= 240; i++) {
            SubsidyMaleViewRankingsEntity subsidyMaleViewRankings = new SubsidyMaleViewRankingsEntity();

            SubsidiesEntity subsidy = subsidiesRepository.findById((long) i).orElse(null);

            if (subsidy != null) {
                subsidyMaleViewRankings.setSubsidy(subsidy);
                subsidyMaleViewRankings.setViews(0);
                subsidyMaleViewRankingsRepository.save(subsidyMaleViewRankings);
            }
        }
    }

     */
    @Transactional
    public void incrementViews(Long subsidyId) {
        SubsidyMaleViewRankingsEntity subsidyMaleViewRankings = subsidyMaleViewRankingsRepository.findBySubsidy_Id(subsidyId);

        if (subsidyMaleViewRankings != null) {
            int currentViews = subsidyMaleViewRankings.getViews();
            subsidyMaleViewRankings.setViews(currentViews + 1);
            subsidyMaleViewRankingsRepository.save(subsidyMaleViewRankings);
        }
    }



    public List<SubsidyViewRankingsInfoDTO> findTop3SubsidyInfoByMaleViews() {
        Pageable pageable = PageRequest.of(0, 3, Sort.by("views").descending());
        return subsidyMaleViewRankingsRepository.findTop3SubsidyInfoByViews(pageable).getContent();
    }


}
