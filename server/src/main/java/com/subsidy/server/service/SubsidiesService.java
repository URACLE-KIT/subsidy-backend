package com.subsidy.server.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.subsidy.server.persistence.SubsidiesRepository;
import com.subsidy.server.dto.SubsidiesDTO;
import com.subsidy.server.model.SubsidiesEntity;


@Slf4j
@Service
public class SubsidiesService {
    private final SubsidiesRepository subsidyRepository;

    @Autowired
    public SubsidiesService(SubsidiesRepository subsidyRepository) {
        this.subsidyRepository = subsidyRepository;
    }

    public List<SubsidiesDTO> getAllSubsidies() {
        List<SubsidiesEntity> subsidyEntities = subsidyRepository.findAll();
        return subsidyEntities.stream()
                .map(this::mapSubsidiesEntityToDTO)
                .collect(Collectors.toList());
    }

    public List<SubsidiesDTO> searchSubsidyByTitleList(String title) {
        List<SubsidiesEntity> subsidyEntities = subsidyRepository.findByTitleContaining(title);
        return subsidyEntities.stream()
                .map(this::mapSubsidiesEntityToDTO)
                .collect(Collectors.toList());
    }

    public List<SubsidiesDTO> searchSubsidyByCategoryList(String category) {
        List<SubsidiesEntity> subsidyEntities = subsidyRepository.findByCategoryContaining(category);
        return subsidyEntities.stream()
                .map(this::mapSubsidiesEntityToDTO)
                .collect(Collectors.toList());
    }
    public List<SubsidiesDTO> searchSubsidyByDescriptionList(String category) {
        List<SubsidiesEntity> subsidyEntities = subsidyRepository.findByDescriptionContaining(category);
        return subsidyEntities.stream()
                .map(this::mapSubsidiesEntityToDTO)
                .collect(Collectors.toList());
    }

    public Optional<SubsidiesEntity> getSubsidyById(Long id) {
        return subsidyRepository.findById(id);
    }

    private SubsidiesDTO mapSubsidiesEntityToDTO(SubsidiesEntity subsidyEntity) {
        SubsidiesDTO subsidyDTO = new SubsidiesDTO();
        subsidyDTO.setId(subsidyEntity.getId());
        subsidyDTO.setCategory(subsidyEntity.getCategory());
        subsidyDTO.setTitle(subsidyEntity.getTitle());
        subsidyDTO.setDetail_information_url(subsidyEntity.getDetail_information_url());
        subsidyDTO.setDescription(subsidyEntity.getDescription());
        subsidyDTO.setApplication_period(subsidyEntity.getApplication_period());
        subsidyDTO.setReceiving_agency(subsidyEntity.getReceiving_agency());
        subsidyDTO.setTelephone_inquiry(subsidyEntity.getTelephone_inquiry());
        subsidyDTO.setSupport_type(subsidyEntity.getSupport_type());
        subsidyDTO.setApplication_process(subsidyEntity.getApplication_process());
        subsidyDTO.setApplication_process_url(subsidyEntity.getApplication_process_url());
        subsidyDTO.setViews(subsidyEntity.getViews());
        subsidyDTO.setNumComments(subsidyEntity.getNumComments());
        return subsidyDTO;
    }


    public SubsidiesEntity incrementViews(Long id) {
        SubsidiesEntity subsidy = subsidyRepository.findById(id).orElse(null);
        if (subsidy != null) {
            subsidy.setViews(subsidy.getViews() + 1);
            return subsidyRepository.save(subsidy);
        } else {
            return null;
        }
    }





}