package com.subsidy.server.dto;


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
public class SubsidyPromotionDTO {
    private Long id;
    private UserEntity user;
    private String title;
    private String content;
    private String img;
    private int likes;
    private int views;
    private Timestamp created_at;
    private Timestamp updated_at;
}
