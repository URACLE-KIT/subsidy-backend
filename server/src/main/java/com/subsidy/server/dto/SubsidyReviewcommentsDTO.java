package com.subsidy.server.dto;

import com.subsidy.server.model.SubsidyReviewsEntity;
import com.subsidy.server.model.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SubsidyReviewCommentsDTO {
    private Long id;
    private UserEntity user;
    private SubsidyReviewsEntity reviews;
    private String content;
    private Timestamp created_at;
    private Timestamp updated_at;
}
