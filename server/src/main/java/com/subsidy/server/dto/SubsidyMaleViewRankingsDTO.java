package com.subsidy.server.dto;

import com.subsidy.server.model.SubsidiesEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SubsidyMaleViewRankingsDTO {
    private Long id;
    private SubsidiesEntity subsidy;
    private int views;
}
