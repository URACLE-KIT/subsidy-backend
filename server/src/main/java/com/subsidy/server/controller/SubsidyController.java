package com.subsidy.server.controller;

import java.util.ArrayList;
import java.util.List;

import com.subsidy.server.dto.SubsidyDTO;
import com.subsidy.server.service.SubsidyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/subsidy")
public class SubsidyController {
    private final SubsidyService subsidyService;

    @Autowired
    public SubsidyController(SubsidyService subsidyService) {
        this.subsidyService = subsidyService;
    }

    @PostMapping("/create")
    public ResponseEntity<String> createSubsidy(@RequestBody SubsidyDTO subsidyDTO) {
        try {
            subsidyService.createSubsidy(subsidyDTO);
            return new ResponseEntity<>("보조금 생성 성공:", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("보조금 생성 실패: " + e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete/{subsidyId}")
    public ResponseEntity<String> deleteSubsidy(@PathVariable Long subsidyId) {
        try {
            subsidyService.deleteSubsidy(subsidyId);
            return new ResponseEntity<>("보조금 삭제 성공: ", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("보조금 삭제 실패: " + e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/all")
    public ResponseEntity<List<SubsidyDTO>> getAllReports() {
        try {
            List<SubsidyDTO> reports = subsidyService.getAllSubsidies();
            return new ResponseEntity<>(reports, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ArrayList<SubsidyDTO>(), HttpStatus.BAD_REQUEST);
        }
    }
}