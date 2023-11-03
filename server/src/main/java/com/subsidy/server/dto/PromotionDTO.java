package com.subsidy.server.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PromotionDTO {
    private Long id;
    private String user_id;
    private String title;
    private String content;
    private String img;
    private int likes;
    private int views;
    private Date created_at;
    private Date updated_at;
}