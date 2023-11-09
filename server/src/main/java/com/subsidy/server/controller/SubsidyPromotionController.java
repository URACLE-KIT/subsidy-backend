package com.subsidy.server.controller;


import com.subsidy.server.dto.SubsidyPromotionDTO;
import com.subsidy.server.model.SubsidyPromotionEntity;
import com.subsidy.server.service.SubsidyPromotionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/subsidies-promotion")
public class SubsidyPromotionController {
    private final SubsidyPromotionService subsidyPromotionService;

    @Autowired
    public SubsidyPromotionController(SubsidyPromotionService subsidyPromotionService) {
        this.subsidyPromotionService = subsidyPromotionService;
    }


    @PostMapping("/create")
    public ResponseEntity<SubsidyPromotionEntity> createReview(@RequestParam String userId,@RequestBody SubsidyPromotionDTO subsidyPromotionDTO) {

        SubsidyPromotionEntity createdPromotion = subsidyPromotionService.createSubsidyPromotion(userId,subsidyPromotionDTO );

        if (createdPromotion != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(createdPromotion);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }


    @PatchMapping("/update")
    public ResponseEntity<SubsidyPromotionEntity> updateSubsidyPromotion(@RequestParam Long subsidyPromotionId, @RequestBody SubsidyPromotionEntity subsidyPromotion) {
        SubsidyPromotionEntity existingPromotion = subsidyPromotionService.getSubsidyPromotionId(subsidyPromotionId);

        if (existingPromotion != null) {
            // Check if the fields in the request body are not null and update them
            if (subsidyPromotion.getTitle() != null) {
                existingPromotion.setTitle(subsidyPromotion.getTitle());
            }
            if (subsidyPromotion.getContent() != null) {
                existingPromotion.setContent(subsidyPromotion.getContent());
            }
            if (subsidyPromotion.getImg() != null) {
                existingPromotion.setImg(subsidyPromotion.getImg());
            }

            SubsidyPromotionEntity updatedPromotion = subsidyPromotionService.updateSubsidyPromotion(existingPromotion);
            return ResponseEntity.ok(updatedPromotion);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteReview(@RequestParam Long subsidyPromotionId){
        SubsidyPromotionEntity existingPromotion = subsidyPromotionService.getSubsidyPromotionId(subsidyPromotionId);

        if (existingPromotion != null) {
            subsidyPromotionService.deleteSubsidyPromotion(subsidyPromotionId);
            return ResponseEntity.status(HttpStatus.OK).body("Review with ID " + subsidyPromotionId + " deleted successfully.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Review with ID " + subsidyPromotionId + " not found or couldn't be deleted.");
        }

    }

    @GetMapping("/all")
    public ResponseEntity<List<SubsidyPromotionEntity>> getAllReviews() {
        List<SubsidyPromotionEntity> promotions = subsidyPromotionService.getAllSubsidyPromotion();
        if (promotions != null && !promotions.isEmpty()) {
            return ResponseEntity.ok(promotions);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @GetMapping("/search/userId")
    public ResponseEntity<List<SubsidyPromotionEntity>> getSubsidyPromotionsByUserId(@RequestParam String userId) {
        List<SubsidyPromotionEntity> promotions = subsidyPromotionService.getSubsidyPromotionByUserId(userId);

        if (promotions != null && !promotions.isEmpty()) {
            return ResponseEntity.ok(promotions);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }


    @PutMapping("/increment-views")
    public ResponseEntity<SubsidyPromotionEntity> incrementViews(@RequestParam Long id) {
        SubsidyPromotionEntity promotion = subsidyPromotionService.incrementViews(id);
        if (promotion != null) {
            return ResponseEntity.ok(promotion);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PutMapping("/increment-likes")
    public ResponseEntity<SubsidyPromotionEntity> incrementLikes(@RequestParam Long id) {
        SubsidyPromotionEntity promotion = subsidyPromotionService.incrementLikes(id);
        if (promotion != null) {
            return ResponseEntity.ok(promotion);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }


}
