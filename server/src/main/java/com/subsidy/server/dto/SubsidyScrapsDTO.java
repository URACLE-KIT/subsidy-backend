package com.subsidy.server.dto;

import com.subsidy.server.model.SubsidiesEntity;
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
public class SubsidyScrapsDTO {
    private Long id;
    private UserEntity user;
    private SubsidiesEntity subsidy;
    private Timestamp created_at;
    private Timestamp updated_at;
}
