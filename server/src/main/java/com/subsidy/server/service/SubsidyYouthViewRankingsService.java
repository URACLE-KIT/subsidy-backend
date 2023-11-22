package com.subsidy.server.service;

import com.subsidy.server.dto.SubsidyViewRankingsInfoDTO;
import com.subsidy.server.model.SubsidiesEntity;
import com.subsidy.server.model.SubsidyYouthViewRankingsEntity;
import com.subsidy.server.persistence.SubsidiesRepository;
import com.subsidy.server.persistence.SubsidyYouthViewRankingsRepository;
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
public class SubsidyYouthViewRankingsService {
    @Autowired
    private SubsidyYouthViewRankingsRepository subsidyYouthViewRankingsRepository;

    @Autowired
    private SubsidiesRepository subsidiesRepository;



    /*
    @PostConstruct
    public void addSubsidyYouthViewRankingsData() {
        for (int i = 1; i <= 11757; i++) {
            SubsidyYouthViewRankingsEntity subsidyYouthViewRankings = new SubsidyYouthViewRankingsEntity();

            SubsidiesEntity subsidy = subsidiesRepository.findById((long) i).orElse(null);

            if (subsidy != null) {
                subsidyYouthViewRankings.setSubsidy(subsidy);
                subsidyYouthViewRankings.setViews(0);
                subsidyYouthViewRankingsRepository.save(subsidyYouthViewRankings);
            }
        }
    }
     */



    @Transactional
    public void incrementViews(Long subsidyId) {
        SubsidyYouthViewRankingsEntity subsidyYouthViewRankings = subsidyYouthViewRankingsRepository.findBySubsidy_Id(subsidyId);
        if (subsidyYouthViewRankings != null) {
            int currentViews = subsidyYouthViewRankings.getViews();
            subsidyYouthViewRankings.setViews(currentViews + 1);
            subsidyYouthViewRankingsRepository.save(subsidyYouthViewRankings);
        }
    }


    public List<SubsidyViewRankingsInfoDTO> findTop3SubsidyInfoByYouthViews() {
        Pageable pageable = PageRequest.of(0, 3, Sort.by("views").descending());
        return subsidyYouthViewRankingsRepository.findTop3SubsidyInfoByViews(pageable).getContent();
    }
}
