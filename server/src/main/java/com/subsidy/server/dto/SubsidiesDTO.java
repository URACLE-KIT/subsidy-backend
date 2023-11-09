package com.subsidy.server.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SubsidiesDTO {
    private Long id;
    private String title;
    private String category;
    private String detail_information_url;
    private String description;
    private String application_period;
    private String receiving_agency;
    private String telephone_inquiry;
    private String support_type;
    private String application_process;
    private String application_process_url;
    private int views;
    private int numComments;
}