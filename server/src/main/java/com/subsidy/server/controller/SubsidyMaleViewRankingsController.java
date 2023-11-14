package com.subsidy.server.controller;

import com.subsidy.server.dto.SubsidyViewRankingsInfoDTO;
import com.subsidy.server.service.SubsidyMaleViewRankingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/subsidyMaleViewRankings")
public class SubsidyMaleViewRankingsController {

    @Autowired
    private SubsidyMaleViewRankingsService subsidyMaleViewRankingsService;

    @GetMapping("/create")
    public String addSubsidyViewRankingsData() {
        subsidyMaleViewRankingsService.addSubsidyMaleViewRankingsData();
        return "Data added successfully!";
    }

    @PostMapping("/increment-views")
    public ResponseEntity<String> incrementViews(@RequestParam Long subsidyId) {
        subsidyMaleViewRankingsService.incrementViews(subsidyId);
        return ResponseEntity.ok("Views incremented for subsidy_id: " + subsidyId);
    }
    @GetMapping("/subsidyRanking_Info")
    public List<SubsidyViewRankingsInfoDTO> getTop3SubsidyInfoByViews() {
        return subsidyMaleViewRankingsService.findTop3SubsidyMaleInfoByViews();
    }

}
