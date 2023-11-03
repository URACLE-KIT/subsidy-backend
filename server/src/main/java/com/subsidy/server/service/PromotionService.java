package com.subsidy.server.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.subsidy.server.model.PromotionEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.subsidy.server.persistence.PromotionRepository;
import com.subsidy.server.dto.PromotionDTO;

@Service
public class PromotionService {
    private final PromotionRepository promotionRepository;

    @Autowired
    public PromotionService(PromotionRepository promotionRepository) {
        this.promotionRepository = promotionRepository;
    }

    public void createPromotion(PromotionDTO promotionDTO) {
        PromotionEntity promotionEntity = new PromotionEntity();
        promotionEntity.setUser_id(promotionDTO.getUser_id());
        promotionEntity.setTitle(promotionDTO.getTitle());
        promotionEntity.setContent(promotionDTO.getContent());
        promotionEntity.setImg(promotionDTO.getImg());
        promotionEntity.setLikes(promotionDTO.getLikes());
        promotionEntity.setViews(promotionDTO.getViews());
        promotionEntity.setCreated_at(promotionDTO.getCreated_at());
        promotionEntity.setUpdated_at(promotionDTO.getUpdated_at());

        promotionRepository.save(promotionEntity);
    }

    public void deletePromotion(Long promotionId) {
        Optional<PromotionEntity> optionalPromotionEntity = promotionRepository.findById(promotionId);
        if (optionalPromotionEntity.isPresent()) {
            promotionRepository.delete(optionalPromotionEntity.get());
        } else {
            throw new RuntimeException("홍보글 삭제 실패: " + promotionId);
        }
    }

    public List<PromotionDTO> getAllPromotions() {
        List<PromotionEntity> promotionEntities = promotionRepository.findAll();
        return promotionEntities.stream()
                .map(promotionEntity -> {
                    PromotionDTO promotionDTO = new PromotionDTO();
                    promotionDTO.setId(promotionEntity.getId());
                    promotionDTO.setUser_id(promotionEntity.getUser_id());
                    promotionDTO.setTitle(promotionEntity.getTitle());
                    return promotionDTO;
                })
                .collect(Collectors.toList());
    }
}