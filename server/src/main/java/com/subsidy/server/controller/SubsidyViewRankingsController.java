package com.subsidy.server.controller;

import com.subsidy.server.dto.SubsidyViewRankingsInfoDTO;
import com.subsidy.server.service.SubsidyViewRankingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/v1/subsidyViewRankings")
public class SubsidyViewRankingsController {
    @Autowired
    private SubsidyViewRankingsService subsidyViewRankingsService;

    @GetMapping("/create")
    public String addSubsidyViewRankingsData() {
        subsidyViewRankingsService.addSubsidyViewRankingsData();
        return "Data added successfully!";
    }

    @PostMapping("/increment-views")
    public String incrementViews(@RequestParam Long subsidyId) {
        subsidyViewRankingsService.incrementViews(subsidyId);
        return "Views incremented for subsidy_id: " + subsidyId;
    }

    @GetMapping("/subsidyRanking_Info")
    public List<SubsidyViewRankingsInfoDTO> getTop3SubsidyInfoByViews() {
        return subsidyViewRankingsService.findTop3SubsidyInfoByViews();
    }
}
