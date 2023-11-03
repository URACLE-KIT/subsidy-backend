package com.subsidy.server.controller;

import java.util.ArrayList;
import java.util.List;

import com.subsidy.server.dto.PromotionDTO;
import com.subsidy.server.service.PromotionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/subsidy/promotion")
public class PromotionController {
    private final PromotionService promotionService;

    @Autowired
    public PromotionController(PromotionService promotionService) {
        this.promotionService = promotionService;
    }

    @PostMapping("/create")
    public ResponseEntity<String> createPromotion(@RequestBody PromotionDTO promotionDTO) {
        try {
            promotionService.createPromotion(promotionDTO);
            return new ResponseEntity<>("홍보글 생성 성공:", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("홍보글 생성 실패: " + e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete/{promotionId}")
    public ResponseEntity<String> deletePromotion(@PathVariable Long promotionId) {
        try {
            promotionService.deletePromotion(promotionId);
            return new ResponseEntity<>("홍보글 삭제 성공: ", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("홍보글 삭제 실패: " + e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/all")
    public ResponseEntity<List<PromotionDTO>> getAllPromotions() {
        try {
            List<PromotionDTO> promotions = promotionService.getAllPromotions();
            return new ResponseEntity<>(promotions, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ArrayList<PromotionDTO>(), HttpStatus.BAD_REQUEST);
        }
    }
}