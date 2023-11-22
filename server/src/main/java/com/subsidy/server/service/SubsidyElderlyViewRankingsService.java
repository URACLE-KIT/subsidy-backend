package com.subsidy.server.service;

import com.subsidy.server.dto.SubsidyViewRankingsInfoDTO;
import com.subsidy.server.model.SubsidiesEntity;
import com.subsidy.server.model.SubsidyElderlyViewRankingsEntity;
import com.subsidy.server.persistence.SubsidiesRepository;
import com.subsidy.server.persistence.SubsidyElderlyViewRankingsRepository;
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
public class SubsidyElderlyViewRankingsService {
    @Autowired
    private SubsidyElderlyViewRankingsRepository subsidyElderlyViewRankingsRepository;

    @Autowired
    private SubsidiesRepository subsidiesRepository;


    /*
    @PostConstruct
    public void addSubsidyElderlyViewRankingsData() {
        for (int i = 1; i <= 11757; i++) {
            SubsidyElderlyViewRankingsEntity subsidyElderlyViewRankings = new SubsidyElderlyViewRankingsEntity();

            SubsidiesEntity subsidy = subsidiesRepository.findById((long) i).orElse(null);

            if (subsidy != null) {
                subsidyElderlyViewRankings.setSubsidy(subsidy);
                subsidyElderlyViewRankings.setViews(0);
                subsidyElderlyViewRankingsRepository.save(subsidyElderlyViewRankings);
            }
        }
    }
     */




    @Transactional
    public void incrementViews(Long subsidyId) {
        SubsidyElderlyViewRankingsEntity subsidyelderlyViewRankings = subsidyElderlyViewRankingsRepository.findBySubsidy_Id(subsidyId);
        if (subsidyelderlyViewRankings != null) {
            int currentViews = subsidyelderlyViewRankings.getViews();
            subsidyelderlyViewRankings.setViews(currentViews + 1);
            subsidyElderlyViewRankingsRepository.save(subsidyelderlyViewRankings);
        }
    }


    public List<SubsidyViewRankingsInfoDTO> findTop3SubsidyInfoByElderlyViews() {
        Pageable pageable = PageRequest.of(0, 3, Sort.by("views").descending());
        return subsidyElderlyViewRankingsRepository.findTop3SubsidyInfoByViews(pageable).getContent();
    }
}
