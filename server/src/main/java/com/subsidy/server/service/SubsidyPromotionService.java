package com.subsidy.server.service;


import com.subsidy.server.dto.SubsidyPromotionDTO;
import com.subsidy.server.model.SubsidyPromotionEntity;
import com.subsidy.server.model.UserEntity;
import com.subsidy.server.persistence.SubsidyPromotionRepository;
import com.subsidy.server.persistence.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class SubsidyPromotionService {

    private final SubsidyPromotionRepository subsidyPromotionRepository;

    @Autowired
    public SubsidyPromotionService(SubsidyPromotionRepository subsidyPromotionRepository) {
        this.subsidyPromotionRepository = subsidyPromotionRepository;
    }

    @Autowired
    private UserRepository userRepository;
    public SubsidyPromotionEntity createSubsidyPromotion(String userId, SubsidyPromotionDTO subsidyPromotionDTO) {
        UserEntity user = userRepository.findById(userId).orElse(null);
        if (user != null) {
            SubsidyPromotionEntity promotion = new SubsidyPromotionEntity();
            promotion.setUser(user);
            promotion.setTitle(subsidyPromotionDTO.getTitle());
            promotion.setContent(subsidyPromotionDTO.getContent());
            promotion.setImg(subsidyPromotionDTO.getImg());
            promotion.setViews(subsidyPromotionDTO.getViews());
            promotion.setLikes(subsidyPromotionDTO.getLikes());
            return subsidyPromotionRepository.save(promotion);
        } else {
            return null;
        }
    }

    public SubsidyPromotionEntity updateSubsidyPromotion(SubsidyPromotionEntity promotion) {
        return subsidyPromotionRepository.save(promotion);
    }

    public void deleteSubsidyPromotion(Long subsidyPromotionId){
        subsidyPromotionRepository.deleteById(subsidyPromotionId);
    }

    public SubsidyPromotionEntity getSubsidyPromotionId(Long subsidyPromotionId) {
        return subsidyPromotionRepository.findById(subsidyPromotionId).orElse(null);
    }

    public List<SubsidyPromotionEntity> getSubsidyPromotionByUserId(String userId) {
        return subsidyPromotionRepository.findByUserId(userId);
    }

    public List<SubsidyPromotionEntity> getAllSubsidyPromotion() {
        return subsidyPromotionRepository.findAll();
    }

    public SubsidyPromotionEntity incrementViews(Long id) {
        SubsidyPromotionEntity promotion = subsidyPromotionRepository.findById(id).orElse(null);
        if (promotion != null) {
            promotion.setViews(promotion.getViews() + 1);
            return subsidyPromotionRepository.save(promotion);
        } else {
            return null;
        }
    }

    public SubsidyPromotionEntity incrementLikes(Long id) {
        SubsidyPromotionEntity promotion = subsidyPromotionRepository.findById(id).orElse(null);
        if (promotion != null) {
            promotion.setLikes(promotion.getLikes() + 1);
            return subsidyPromotionRepository.save(promotion);
        } else {
            return null;
        }
    }
}
