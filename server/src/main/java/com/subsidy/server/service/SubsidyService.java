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

    public void createSubsidy(SubsidyDTO reportDTO) {
        SubsidyEntity subsidyEntity = new SubsidyEntity();
        subsidyEntity.setTitle(reportDTO.getTitle());
        subsidyEntity.setDetail_information_url(reportDTO.getDetail_information_url());
        subsidyEntity.setDescription(reportDTO.getDescription());
        subsidyEntity.setApplication_period(reportDTO.getApplication_period());
        subsidyEntity.setReceiving_agency(reportDTO.getReceiving_agency());
        subsidyEntity.setTelephone_inquiry(reportDTO.getTelephone_inquiry());
        subsidyEntity.setSupport_type(reportDTO.getSupport_type());
        subsidyEntity.setApplication_process(reportDTO.getApplication_process());
        subsidyEntity.setApplication_process_url(reportDTO.getApplication_process_url());

        subsidyRepository.save(subsidyEntity);
    }

    public void deleteSubsidy(Long reportId) {
        Optional<SubsidyEntity> optionalReportEntity = subsidyRepository.findById(reportId);
        if (optionalReportEntity.isPresent()) {
            subsidyRepository.delete(optionalReportEntity.get());
        } else {
            throw new RuntimeException("보조금 삭제 실패: " + reportId);
        }
    }

    public List<SubsidyDTO> getAllSubsidies() {
        List<SubsidyEntity> reportEntities = subsidyRepository.findAll();
        return reportEntities.stream()
                .map(reportEntity -> {
                    SubsidyDTO subsidyDTO = new SubsidyDTO();
                    subsidyDTO.setId(reportEntity.getId());
                    subsidyDTO.setTitle(reportEntity.getTitle());
                    subsidyDTO.setDetail_information_url(reportEntity.getDetail_information_url());
                    subsidyDTO.setDescription(reportEntity.getDescription());
                    subsidyDTO.setApplication_period(reportEntity.getApplication_period());
                    subsidyDTO.setReceiving_agency(reportEntity.getReceiving_agency());
                    subsidyDTO.setTelephone_inquiry(reportEntity.getTelephone_inquiry());
                    subsidyDTO.setSupport_type(reportEntity.getSupport_type());
                    subsidyDTO.setApplication_process(reportEntity.getApplication_process());
                    subsidyDTO.setApplication_process_url(reportEntity.getApplication_process_url());
                    return subsidyDTO;
                })
                .collect(Collectors.toList());
    }
}