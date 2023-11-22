package com.subsidy.server.service;

import com.subsidy.server.dto.SubsidyViewRankingsInfoDTO;
import com.subsidy.server.model.SubsidiesEntity;
import com.subsidy.server.model.SubsidySeniorViewRankingsEntity;
import com.subsidy.server.persistence.SubsidiesRepository;
import com.subsidy.server.persistence.SubsidySeniorViewRankingsRepository;
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
public class SubsidySeniorViewRankingsService {
    @Autowired
    private SubsidySeniorViewRankingsRepository subsidySeniorViewRankingsRepository;

    @Autowired
    private SubsidiesRepository subsidiesRepository;


    /*
    @PostConstruct
    public void addSubsidySeniorViewRankingsData() {
        for (int i = 1; i <= 11757; i++) {
            SubsidySeniorViewRankingsEntity subsidySeniorViewRankings = new SubsidySeniorViewRankingsEntity();

            SubsidiesEntity subsidy = subsidiesRepository.findById((long) i).orElse(null);

            if (subsidy != null) {
                subsidySeniorViewRankings.setSubsidy(subsidy);
                subsidySeniorViewRankings.setViews(0);
                subsidySeniorViewRankingsRepository.save(subsidySeniorViewRankings);
            }
        }
    }

     */



    @Transactional
    public void incrementViews(Long subsidyId) {
        SubsidySeniorViewRankingsEntity subsidySeniorViewRankings = subsidySeniorViewRankingsRepository.findBySubsidy_Id(subsidyId);
        if (subsidySeniorViewRankings != null) {
            int currentViews = subsidySeniorViewRankings.getViews();
            subsidySeniorViewRankings.setViews(currentViews + 1);
            subsidySeniorViewRankingsRepository.save(subsidySeniorViewRankings);
        }
    }


    public List<SubsidyViewRankingsInfoDTO> findTop3SubsidyInfoBySeniorViews() {
        Pageable pageable = PageRequest.of(0, 3, Sort.by("views").descending());
        return subsidySeniorViewRankingsRepository.findTop3SubsidyInfoByViews(pageable).getContent();
    }
}
