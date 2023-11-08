package com.subsidy.server.controller;

import com.subsidy.server.dto.SubsidyReviewcommentsDTO;
import com.subsidy.server.model.SubsidyReviewcommentsEntity;
import com.subsidy.server.service.SubsidyReviewCommentsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/subsidy-reviewcomments")
public class SubsidyReviewCommentsController {

    private final SubsidyReviewCommentsService subsidyReviewCommentsService;

    public SubsidyReviewCommentsController(SubsidyReviewCommentsService subsidyReviewCommentsService) {
        this.subsidyReviewCommentsService = subsidyReviewCommentsService;
    }

    @PostMapping("/create")
    public ResponseEntity<SubsidyReviewcommentsEntity> createReviewComment(
            @RequestParam String userId,
            @RequestParam Long reviewId,
            @RequestBody SubsidyReviewcommentsEntity reviewComments
    ) {
        SubsidyReviewcommentsEntity reviewcommentsEntity = subsidyReviewCommentsService.createReviewComment(userId, reviewId, reviewComments);

        if (reviewcommentsEntity != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(reviewcommentsEntity);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @PatchMapping("/update")
    public ResponseEntity<SubsidyReviewcommentsEntity> updateReviewComment(
            @RequestParam Long commentId,
            @RequestBody SubsidyReviewcommentsEntity reviewComment
    ) {
        SubsidyReviewcommentsEntity existingComment = subsidyReviewCommentsService.getCommentById(commentId);

        if (existingComment != null) {
            if (reviewComment.getContent() != null) {
                existingComment.setContent(reviewComment.getContent());
            }

            SubsidyReviewcommentsEntity updatedComment = subsidyReviewCommentsService.updateReviewcomment(existingComment);
            return ResponseEntity.ok(updatedComment);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteReviewComment(
            @RequestParam Long commentId
    ) {
        SubsidyReviewcommentsEntity existingComment = subsidyReviewCommentsService.getCommentById(commentId);

        if (existingComment != null) {
            subsidyReviewCommentsService.deleteSubsidyReview(commentId);
            return ResponseEntity.status(HttpStatus.OK).body("Comment with ID " + commentId + " has been deleted.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Comment with ID " + commentId + " was not found or could not be deleted.");
        }
    }

    @GetMapping("/search/user")
    public ResponseEntity<List<SubsidyReviewcommentsEntity>> getCommentsByUserId(@RequestParam String userId) {
        List<SubsidyReviewcommentsEntity> comments = subsidyReviewCommentsService.getCommentsByUserId(userId);

        if (comments != null && !comments.isEmpty()) {
            return ResponseEntity.ok(comments);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @GetMapping("/all")
    public ResponseEntity<List<SubsidyReviewcommentsEntity>> getAllComments() {
        List<SubsidyReviewcommentsEntity> comments = subsidyReviewCommentsService.getAllComments();
        if (comments != null && !comments.isEmpty()) {
            return ResponseEntity.ok(comments);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
}
