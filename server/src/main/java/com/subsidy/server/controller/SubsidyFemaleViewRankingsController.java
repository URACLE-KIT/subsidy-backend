package com.subsidy.server.controller;

import com.subsidy.server.dto.SubsidyViewRankingsInfoDTO;
import com.subsidy.server.persistence.SubsidyFemaleViewRankingsRepository;
import com.subsidy.server.service.SubsidyFemaleViewRankingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/subsidyFemaleViewRankings")
public class SubsidyFemaleViewRankingsController {

    @Autowired
    private SubsidyFemaleViewRankingsService subsidyFemaleViewRankingsService;

    @GetMapping("/create")
    public String addSubsidyViewRankingsData() {
        subsidyFemaleViewRankingsService.addSubsidyFemaleViewRankingsData();
        return "Data added successfully!";
    }

    @PostMapping("/increment-views")
    public ResponseEntity<String> incrementViews(@RequestParam Long subsidyId) {
        subsidyFemaleViewRankingsService.incrementViews(subsidyId);
        return ResponseEntity.ok("Views incremented for subsidy_id: " + subsidyId);
    }
    @GetMapping("/subsidyRanking_Info")
    public List<SubsidyViewRankingsInfoDTO> getTop3SubsidyInfoByViews() {
        return subsidyFemaleViewRankingsService.findTop3SubsidyFemaleInfoByViews();
    }
}
