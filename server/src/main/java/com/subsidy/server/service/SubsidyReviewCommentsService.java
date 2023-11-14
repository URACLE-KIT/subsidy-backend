package com.subsidy.server.service;

import com.subsidy.server.model.SubsidyReviewCommentsEntity;
import com.subsidy.server.model.SubsidyReviewsEntity;
import com.subsidy.server.model.UserEntity;
import com.subsidy.server.persistence.SubsidyReviewCommentsRepository;
import com.subsidy.server.persistence.SubsidyReviewsRepository;
import com.subsidy.server.persistence.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class SubsidyReviewCommentsService {

    private final SubsidyReviewCommentsRepository subsidyReviewCommentsRepository;

    @Autowired
    public SubsidyReviewCommentsService(SubsidyReviewCommentsRepository subsidyReviewCommentsRepository) {
        this.subsidyReviewCommentsRepository = subsidyReviewCommentsRepository;
    }

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SubsidyReviewsRepository subsidyReviewsRepository;

    public SubsidyReviewCommentsEntity createReviewComment(String userId, Long reviewId, SubsidyReviewCommentsEntity reviewComments) {
        UserEntity user = userRepository.findById(userId).orElse(null);
        SubsidyReviewsEntity review = subsidyReviewsRepository.findById(reviewId).orElse(null);

        if (user != null && review != null) {
            SubsidyReviewCommentsEntity comments = new SubsidyReviewCommentsEntity();
            comments.setUser(user);
            comments.setReviews(review);
            comments.setContent(reviewComments.getContent());
            return subsidyReviewCommentsRepository.save(comments);
        } else {
            return null;
        }
    }

    public SubsidyReviewCommentsEntity getCommentById(Long commentId) {
        return subsidyReviewCommentsRepository.findById(commentId).orElse(null);
    }

    public SubsidyReviewCommentsEntity updateReviewcomment(SubsidyReviewCommentsEntity comments) {
        return subsidyReviewCommentsRepository.save(comments);
    }

    public void deleteSubsidyReviewComment(Long commentId) {
        subsidyReviewCommentsRepository.deleteById(commentId);
    }

    public List<SubsidyReviewCommentsEntity> getCommentsByUserId(String userId) {
        return subsidyReviewCommentsRepository.findByUserId(userId);
    }

    public List<SubsidyReviewCommentsEntity> getCommentsBySubsidyReviewId(Long subsidyReviewId) {
        return subsidyReviewCommentsRepository.findByReviewsId(subsidyReviewId);
    }

    public List<SubsidyReviewCommentsEntity> getAllComments() {
        return subsidyReviewCommentsRepository.findAll();
    }

}
