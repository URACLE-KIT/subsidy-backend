package com.subsidy.server.controller;

import com.subsidy.server.model.SubsidyReviewCommentsEntity;
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
    public ResponseEntity<SubsidyReviewCommentsEntity> createReviewComment(
            @RequestParam String userId,
            @RequestParam Long reviewId,
            @RequestBody SubsidyReviewCommentsEntity reviewComments
    ) {
        SubsidyReviewCommentsEntity reviewcommentsEntity = subsidyReviewCommentsService.createReviewComment(userId, reviewId, reviewComments);

        if (reviewcommentsEntity != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(reviewcommentsEntity);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @PatchMapping("/update")
    public ResponseEntity<SubsidyReviewCommentsEntity> updateReviewComment(
            @RequestParam Long commentId,
            @RequestBody SubsidyReviewCommentsEntity reviewComment
    ) {
        SubsidyReviewCommentsEntity existingComment = subsidyReviewCommentsService.getCommentById(commentId);

        if (existingComment != null) {
            if (reviewComment.getContent() != null) {
                existingComment.setContent(reviewComment.getContent());
            }

            SubsidyReviewCommentsEntity updatedComment = subsidyReviewCommentsService.updateReviewcomment(existingComment);
            return ResponseEntity.ok(updatedComment);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteReviewComment(@RequestParam Long commentId) {
        SubsidyReviewCommentsEntity existingComment = subsidyReviewCommentsService.getCommentById(commentId);

        if (existingComment != null) {
            subsidyReviewCommentsService.deleteSubsidyReview(commentId);
            return ResponseEntity.status(HttpStatus.OK).body("Comment with ID " + commentId + " has been deleted.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Comment with ID " + commentId + " was not found or could not be deleted.");
        }
    }

    @GetMapping("/search/userId")
    public ResponseEntity<List<SubsidyReviewCommentsEntity>> getCommentsByUserId(@RequestParam String userId) {
        List<SubsidyReviewCommentsEntity> comments = subsidyReviewCommentsService.getCommentsByUserId(userId);

        if (comments != null && !comments.isEmpty()) {
            return ResponseEntity.ok(comments);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @GetMapping("/search/subsidyReviewId")
    public ResponseEntity<List<SubsidyReviewCommentsEntity>> getCommentsBySubsidyReviewId(@RequestParam Long subsidyReviewId) {
        List<SubsidyReviewCommentsEntity> comments = subsidyReviewCommentsService.getCommentsBySubsidyReviewId(subsidyReviewId);

        if (comments != null && !comments.isEmpty()) {
            return ResponseEntity.ok(comments);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }





    @GetMapping("/all")
    public ResponseEntity<List<SubsidyReviewCommentsEntity>> getAllComments() {
        List<SubsidyReviewCommentsEntity> comments = subsidyReviewCommentsService.getAllComments();
        if (comments != null && !comments.isEmpty()) {
            return ResponseEntity.ok(comments);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
}
