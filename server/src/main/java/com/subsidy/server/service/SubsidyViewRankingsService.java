package com.subsidy.server.service;

import com.subsidy.server.dto.SubsidyViewRankingsInfoDTO;
import com.subsidy.server.model.SubsidiesEntity;
import com.subsidy.server.model.SubsidyViewRankingsEntity;
import com.subsidy.server.persistence.SubsidiesRepository;
import com.subsidy.server.persistence.SubsidyViewRankingsRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.List;

@Slf4j
@Service

public class SubsidyViewRankingsService {

    @Autowired
    private SubsidyViewRankingsRepository subsidyViewRankingsRepository;

    @Autowired
    private SubsidiesRepository subsidiesRepository;

    /*
    @PostConstruct
    public void addSubsidyViewRankingsData() {
        for (int i = 1; i <= 240; i++) {
            SubsidyViewRankingsEntity subsidyViewRankings = new SubsidyViewRankingsEntity();

            SubsidiesEntity subsidy = subsidiesRepository.findById((long) i).orElse(null);

            if (subsidy != null) {
                subsidyViewRankings.setSubsidy(subsidy);
                subsidyViewRankings.setViews(0);
                subsidyViewRankingsRepository.save(subsidyViewRankings);
            }
        }
    }
    */
    @Transactional
    public void incrementViews(Long subsidyId) {
        SubsidyViewRankingsEntity subsidyViewRankings = subsidyViewRankingsRepository.findBySubsidy_Id(subsidyId);
        if (subsidyViewRankings != null) {
            int currentViews = subsidyViewRankings.getViews();
            subsidyViewRankings.setViews(currentViews + 1);
            subsidyViewRankingsRepository.save(subsidyViewRankings);
        }
    }


    public List<SubsidyViewRankingsInfoDTO> findTop3SubsidyInfoByViews() {
        Pageable pageable = PageRequest.of(0, 3, Sort.by("views").descending());
        return subsidyViewRankingsRepository.findTop3SubsidyInfoByViews(pageable).getContent();
    }

    // 초 분 시 매주 월요일
    @Scheduled(cron = "0 36 15 ? * MON")
    @Transactional
    public void resetSubsidyViews() {
        try {
            // SubsidyViews 테이블의 모든 레코드의 views를 0으로 초기화
            List<SubsidyViewRankingsEntity> subsidyViewsList = subsidyViewRankingsRepository.findAll();
            for (SubsidyViewRankingsEntity subsidyViews : subsidyViewsList) {
                subsidyViews.setViews(0);
            }
            subsidyViewRankingsRepository.saveAll(subsidyViewsList); // saveAll 메서드 사용

            System.out.println("Subsidy views reset scheduled task executed.");
        } catch (Exception e) {
            // 예외 처리
            e.printStackTrace();
        }
    }

}
