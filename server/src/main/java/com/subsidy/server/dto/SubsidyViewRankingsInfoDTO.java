package com.subsidy.server.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SubsidyViewRankingsInfoDTO {
    private Long subsidyId;
    private String title;
    private String description;
    private String applicationPeriod;
    private int views;

}
