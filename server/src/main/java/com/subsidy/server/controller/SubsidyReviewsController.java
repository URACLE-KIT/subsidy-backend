package com.subsidy.server.controller;


import com.subsidy.server.model.SubsidyReviewsEntity;
import com.subsidy.server.service.SubsidyReviewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/subsidies-review")
public class SubsidyReviewsController {

    @Autowired
    private SubsidyReviewsService subsidyReviewsService;

    @PostMapping("/create")
    public ResponseEntity<SubsidyReviewsEntity> createReview(@RequestParam String userId, @RequestParam Long subsidyId ,@RequestBody SubsidyReviewsEntity subsidyReview) {
        SubsidyReviewsEntity review = new SubsidyReviewsEntity();
        review.setTitle(subsidyReview.getTitle());
        review.setContent(subsidyReview.getContent());

        SubsidyReviewsEntity createdReview = subsidyReviewsService.createSubsidyReview(userId, subsidyId , review);

        if (createdReview != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(createdReview);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @PatchMapping("/update")
    public ResponseEntity<SubsidyReviewsEntity> updateReview(@RequestParam Long reviewId, @RequestBody SubsidyReviewsEntity subsidyreview) {
        SubsidyReviewsEntity existingReview = subsidyReviewsService.getReviewById(reviewId);

        if (existingReview != null) {

            if (subsidyreview.getTitle() != null) {
                existingReview.setTitle(subsidyreview.getTitle());
            }
            if (subsidyreview.getContent() != null) {
                existingReview.setContent(subsidyreview.getContent());
            }

            SubsidyReviewsEntity updatedReview = subsidyReviewsService.updateSubsidyReview(existingReview);
            return ResponseEntity.ok(updatedReview);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }


    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteReview(@RequestParam Long reviewId){
        SubsidyReviewsEntity existingReview = subsidyReviewsService.getReviewById(reviewId);

        if (existingReview != null) {
            subsidyReviewsService.deleteSubsidyReview(reviewId);
            return ResponseEntity.status(HttpStatus.OK).body("Review with ID " + reviewId + " deleted successfully.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Review with ID " + reviewId + " not found or couldn't be deleted.");
        }

    }

    @GetMapping("/search/userId")
    public ResponseEntity<List<SubsidyReviewsEntity>> getReviewsByUserId(@RequestParam String userId) {
        List<SubsidyReviewsEntity> reviews = subsidyReviewsService.getReviewsByUserId(userId);

        if (reviews != null && !reviews.isEmpty()) {
            return ResponseEntity.ok(reviews);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @GetMapping("/search/reviewId")
    public ResponseEntity<SubsidyReviewsEntity> getReviewByReviewId(@RequestParam Long reviewId) {
        SubsidyReviewsEntity review = subsidyReviewsService.getReviewById(reviewId);

        if (review != null) {
            return ResponseEntity.ok(review);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @GetMapping("/search/subsidyId")
    public ResponseEntity<List<SubsidyReviewsEntity>> getReviewsByUserId(@RequestParam Long subsidyId) {
        List<SubsidyReviewsEntity> reviews = subsidyReviewsService.getReviewsBySubsidyId(subsidyId);

        if (reviews != null && !reviews.isEmpty()) {
            return ResponseEntity.ok(reviews);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }


    @PutMapping("/increment-views")
    public ResponseEntity<SubsidyReviewsEntity> incrementViews(@RequestParam Long id) {
        SubsidyReviewsEntity review = subsidyReviewsService.incrementViews(id);
        if (review != null) {
            return ResponseEntity.ok(review);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PutMapping("/increment-likes")
    public ResponseEntity<SubsidyReviewsEntity> incrementLikes(@RequestParam Long id) {
        SubsidyReviewsEntity review = subsidyReviewsService.incrementLikes(id);
        if (review != null) {
            return ResponseEntity.ok(review);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }


    @PutMapping("/increment-numComments")
    public ResponseEntity<SubsidyReviewsEntity> incrementNumComments(@RequestParam Long id) {
        SubsidyReviewsEntity review = subsidyReviewsService.incrementNumComments(id);
        if (review != null) {
            return ResponseEntity.ok(review);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PutMapping("/decrement-numComments")
    public ResponseEntity<SubsidyReviewsEntity> decrementNumComments(@RequestParam Long id) {
        SubsidyReviewsEntity review = subsidyReviewsService.decrementNumComments(id);
        if (review != null) {
            return ResponseEntity.ok(review);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @GetMapping("/all")
    public ResponseEntity<List<SubsidyReviewsEntity>> getAllReviews() {
        List<SubsidyReviewsEntity> reviews = subsidyReviewsService.getAllSubsidyReviews();
        if (reviews != null && !reviews.isEmpty()) {
            return ResponseEntity.ok(reviews);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }




}
