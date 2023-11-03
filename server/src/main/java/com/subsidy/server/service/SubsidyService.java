package com.subsidy.server.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.subsidy.server.persistence.SubsidyRepository;
import com.subsidy.server.dto.SubsidyDTO;
import com.subsidy.server.model.SubsidyEntity;

@Service
public class SubsidyService {
    private final SubsidyRepository subsidyRepository;

    @Autowired
    public SubsidyService(SubsidyRepository subsidyRepository) {
        this.subsidyRepository = subsidyRepository;
    }

    public void createSubsidy(SubsidyDTO subsidyDTO) {
        SubsidyEntity subsidyEntity = new SubsidyEntity();
        subsidyEntity.setTitle(subsidyDTO.getTitle());
        subsidyEntity.setDetail_information_url(subsidyDTO.getDetail_information_url());
        subsidyEntity.setDescription(subsidyDTO.getDescription());
        subsidyEntity.setApplication_period(subsidyDTO.getApplication_period());
        subsidyEntity.setReceiving_agency(subsidyDTO.getReceiving_agency());
        subsidyEntity.setTelephone_inquiry(subsidyDTO.getTelephone_inquiry());
        subsidyEntity.setSupport_type(subsidyDTO.getSupport_type());
        subsidyEntity.setApplication_process(subsidyDTO.getApplication_process());
        subsidyEntity.setApplication_process_url(subsidyDTO.getApplication_process_url());

        subsidyRepository.save(subsidyEntity);
    }

    public void deleteSubsidy(Long subsidyId) {
        Optional<SubsidyEntity> optionalSubsidyEntity = subsidyRepository.findById(subsidyId);
        if (optionalSubsidyEntity.isPresent()) {
            subsidyRepository.delete(optionalSubsidyEntity.get());
        } else {
            throw new RuntimeException("보조금 삭제 실패: " + subsidyId);
        }
    }

    public List<SubsidyDTO> getAllSubsidies() {
        List<SubsidyEntity> promotionEntities = subsidyRepository.findAll();
        return promotionEntities.stream()
                .map(subsidyEntity -> {
                    SubsidyDTO subsidyDTO = new SubsidyDTO();
                    subsidyDTO.setId(subsidyEntity.getId());
                    subsidyDTO.setTitle(subsidyEntity.getTitle());
                    subsidyDTO.setDetail_information_url(subsidyEntity.getDetail_information_url());
                    subsidyDTO.setDescription(subsidyEntity.getDescription());
                    subsidyDTO.setApplication_period(subsidyEntity.getApplication_period());
                    subsidyDTO.setReceiving_agency(subsidyEntity.getReceiving_agency());
                    subsidyDTO.setTelephone_inquiry(subsidyEntity.getTelephone_inquiry());
                    subsidyDTO.setSupport_type(subsidyEntity.getSupport_type());
                    subsidyDTO.setApplication_process(subsidyEntity.getApplication_process());
                    subsidyDTO.setApplication_process_url(subsidyEntity.getApplication_process_url());
                    return subsidyDTO;
                })
                .collect(Collectors.toList());
    }
}