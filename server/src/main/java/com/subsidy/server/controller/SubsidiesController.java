package com.subsidy.server.controller;

import java.util.ArrayList;
import java.util.List;

import com.subsidy.server.dto.SubsidiesDTO;
import com.subsidy.server.model.SubsidiesEntity;
import com.subsidy.server.service.SubsidiesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/subsidies")
public class SubsidiesController {
    private final SubsidiesService subsidyService;

    @Autowired
    public SubsidiesController(SubsidiesService subsidyService) {
        this.subsidyService = subsidyService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<SubsidiesDTO>> getAllSubsidies() {
        try {
            List<SubsidiesDTO> subsidies = subsidyService.getAllSubsidies();
            return new ResponseEntity<>(subsidies, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ArrayList<SubsidiesDTO>(), HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("/search/title")
    public ResponseEntity<List<SubsidiesDTO>> searchSubsidiesByTitle(@RequestParam(name = "title") String title) {
        try {
            List<SubsidiesDTO> subsidies = subsidyService.searchSubsidyByTitleList(title);
            return new ResponseEntity<>(subsidies, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ArrayList<SubsidiesDTO>(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/search/category")
    public ResponseEntity<List<SubsidiesDTO>> searchSubsidyByCategory(@RequestParam(name = "category") String category) {
        try {
            List<SubsidiesDTO> subsidies = subsidyService.searchSubsidyByCategoryList(category);
            return new ResponseEntity<>(subsidies, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ArrayList<SubsidiesDTO>(), HttpStatus.BAD_REQUEST);
        }
    }
}