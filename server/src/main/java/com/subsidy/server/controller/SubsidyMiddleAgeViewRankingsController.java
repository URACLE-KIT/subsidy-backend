package com.subsidy.server.controller;


import com.subsidy.server.dto.SubsidyViewRankingsInfoDTO;
import com.subsidy.server.service.SubsidyMiddleAgeViewRankingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/subsidyMiddleAgeViewRankings")
public class SubsidyMiddleAgeViewRankingsController {
    @Autowired
    private SubsidyMiddleAgeViewRankingsService subsidyMiddleAgeViewRankingsService;

    @PostMapping("/increment-views")
    public ResponseEntity<String> incrementViews(@RequestParam Long subsidyId) {
        subsidyMiddleAgeViewRankingsService.incrementViews(subsidyId);
        return ResponseEntity.ok("Views incremented for subsidy_id: " + subsidyId);
    }
    @GetMapping("/subsidyRanking_Info")
    public List<SubsidyViewRankingsInfoDTO> getTop3SubsidyInfoByViews() {
        return subsidyMiddleAgeViewRankingsService.findTop3SubsidyInfoByMiddleAgeViews();
    }
}
