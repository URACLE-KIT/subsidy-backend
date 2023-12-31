package com.subsidy.server.controller;

import com.subsidy.server.model.SubsidiesEntity;
import com.subsidy.server.model.SubsidyScrapsEntity;
import com.subsidy.server.service.SubsidyScrapsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/subsidyscraps")
public class SubsidyScrapsController {

    @Autowired
    private SubsidyScrapsService subsidyScrapsService;

    @PostMapping("/create")
    public ResponseEntity<String> createSubsidyScrap(
            @RequestParam String userId,
            @RequestParam Long subsidyId
    ) {
        SubsidyScrapsEntity createdScrap = subsidyScrapsService.createSubsidyScrap(userId, subsidyId);

        if (createdScrap != null) {
            return ResponseEntity.ok("Subsidy Scrap created successfully.");
        } else {
            return ResponseEntity.badRequest().body("User or Subsidy not found.");
        }
    }

    @GetMapping("/search/subsidyinfo")
    public ResponseEntity<List<SubsidiesEntity>> getSubsidyInfoByUserId(@RequestParam String userId) {
        List<SubsidiesEntity> subsidiesList = subsidyScrapsService.getSubsidyInfoByUserId(userId);

        if (subsidiesList.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(subsidiesList);
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteSubsidyScrapsBySubsidyId(@RequestParam Long subsidyId) {
        subsidyScrapsService.deleteSubsidyScrapsBySubsidyId(subsidyId);
        return ResponseEntity.ok("Subsidy scraps deleted successfully.");
    }






}
