package com.subsidy.server.service;


import com.subsidy.server.model.SubsidiesEntity;
import com.subsidy.server.model.SubsidyReviewsEntity;
import com.subsidy.server.model.UserEntity;
import com.subsidy.server.persistence.SubsidiesRepository;
import com.subsidy.server.persistence.SubsidyReviewsRepository;
import com.subsidy.server.persistence.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Slf4j
@Service
public class SubsidyReviewsService {

    private final SubsidyReviewsRepository subsidyReviewsRepository;

    @Autowired
    public SubsidyReviewsService(SubsidyReviewsRepository subsidyReviewsRepository) {
        this.subsidyReviewsRepository = subsidyReviewsRepository;
    }

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SubsidiesRepository subsidiesRepository;

    public SubsidyReviewsEntity createSubsidyReview(String userId, Long subsidyId , SubsidyReviewsEntity subsidyReview) {
        UserEntity user = userRepository.findById(userId).orElse(null);
        SubsidiesEntity subsidy = subsidiesRepository.findById(subsidyId).orElse(null);

        if (user != null && subsidy != null) {
            SubsidyReviewsEntity review = new SubsidyReviewsEntity();
            review.setUser(user);
            review.setSubsidy(subsidy);
            review.setTitle(subsidyReview.getTitle());
            review.setContent(subsidyReview.getContent());
            review.setNumComments(subsidyReview.getNumComments());
            return subsidyReviewsRepository.save(review);
        } else {
            return null;
        }
    }


    public SubsidyReviewsEntity updateSubsidyReview(SubsidyReviewsEntity review) {
        return subsidyReviewsRepository.save(review);
    }

    public void deleteSubsidyReview(Long reviewId){
        subsidyReviewsRepository.deleteById(reviewId);
    }


    public SubsidyReviewsEntity getReviewById(Long reviewId) {
        return subsidyReviewsRepository.findById(reviewId).orElse(null);
    }

    public List<SubsidyReviewsEntity> getReviewsByUserId(String userId) {
        return subsidyReviewsRepository.findByUserId(userId);
    }

    public List<SubsidyReviewsEntity> getReviewsBySubsidyId(Long subsidyId){
        return subsidyReviewsRepository.findBySubsidyId(subsidyId);
    }

    public List<SubsidyReviewsEntity> getAllSubsidyReviews() {
        return subsidyReviewsRepository.findAll();
    }

    public SubsidyReviewsEntity incrementViews(Long id) {
        SubsidyReviewsEntity review = subsidyReviewsRepository.findById(id).orElse(null);
        if (review != null) {
            review.setViews(review.getViews() + 1);
            return subsidyReviewsRepository.save(review);
        } else {
            return null;
        }
    }

    public SubsidyReviewsEntity incrementLikes(Long id) {
        SubsidyReviewsEntity review = subsidyReviewsRepository.findById(id).orElse(null);
        if (review != null) {
            review.setLikes(review.getLikes() + 1);
            return subsidyReviewsRepository.save(review);
        } else {
            return null;
        }
    }





}
