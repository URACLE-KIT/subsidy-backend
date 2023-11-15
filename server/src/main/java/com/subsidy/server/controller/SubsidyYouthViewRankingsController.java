package com.subsidy.server.controller;

import com.subsidy.server.dto.SubsidyViewRankingsInfoDTO;
import com.subsidy.server.service.SubsidyYouthViewRankingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/subsidyYouthViewRankings")
public class SubsidyYouthViewRankingsController {
    @Autowired
    private SubsidyYouthViewRankingsService subsidyYouthViewRankingsService;

    @PostMapping("/increment-views")
    public ResponseEntity<String> incrementViews(@RequestParam Long subsidyId) {
        subsidyYouthViewRankingsService.incrementViews(subsidyId);
        return ResponseEntity.ok("Views incremented for subsidy_id: " + subsidyId);
    }
    @GetMapping("/subsidyRanking_Info")
    public List<SubsidyViewRankingsInfoDTO> getTop3SubsidyInfoByViews() {
        return subsidyYouthViewRankingsService.findTop3SubsidyInfoByYouthViews();
    }
}
