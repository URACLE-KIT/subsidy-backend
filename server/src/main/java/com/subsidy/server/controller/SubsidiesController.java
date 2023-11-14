package com.subsidy.server.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    @GetMapping("/search/description")
    public ResponseEntity<List<SubsidiesDTO>> searchSubsidyByDescription(@RequestParam(name = "description") String description) {
        try {
            List<SubsidiesDTO> subsidies = subsidyService.searchSubsidyByDescriptionList(description);
            return new ResponseEntity<>(subsidies, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ArrayList<SubsidiesDTO>(), HttpStatus.BAD_REQUEST);
        }
    }


    @GetMapping("/subsidyId")
    public ResponseEntity<SubsidiesDTO> getSubsidyById(@RequestParam Long id) {
        Optional<SubsidiesEntity> subsidyOptional = subsidyService.getSubsidyById(id);

        if (subsidyOptional.isPresent()) {
            SubsidiesEntity subsidy = subsidyOptional.get();
            SubsidiesDTO subsidyDTO = new SubsidiesDTO();
            subsidyDTO.setId(subsidy.getId());
            subsidyDTO.setTitle(subsidy.getTitle());
            subsidyDTO.setCategory(subsidy.getCategory());
            subsidyDTO.setDetail_information_url(subsidy.getDetail_information_url());
            subsidyDTO.setDescription(subsidy.getDescription());
            subsidyDTO.setApplication_period(subsidy.getApplication_period());
            subsidyDTO.setReceiving_agency(subsidy.getReceiving_agency());
            subsidyDTO.setTelephone_inquiry(subsidy.getTelephone_inquiry());
            subsidyDTO.setSupport_type(subsidy.getSupport_type());
            subsidyDTO.setApplication_process(subsidy.getApplication_process());
            subsidyDTO.setApplication_process_url(subsidy.getApplication_process_url());
            subsidyDTO.setViews(subsidy.getViews());
            subsidyDTO.setNumReviews(subsidy.getNumReviews());

            return ResponseEntity.ok(subsidyDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/increment-views")
    public ResponseEntity<SubsidiesEntity> incrementLikes(@RequestParam Long id) {
        SubsidiesEntity subsidy = subsidyService.incrementViews(id);
        if (subsidy != null) {
            return ResponseEntity.ok(subsidy);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PostMapping("/reset-views")
    public void resetAllViewsToZero() {
        subsidyService.resetAllViewsToZero();
    }


}