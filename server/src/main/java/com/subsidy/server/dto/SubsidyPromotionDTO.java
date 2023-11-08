package com.subsidy.server.dto;


import com.subsidy.server.model.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
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
    private Timestamp created_at;
    private Timestamp updated_at;
}
