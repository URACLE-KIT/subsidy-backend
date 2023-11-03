package com.subsidy.server.model;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "SUBSIDIES")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SubsidyEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "S_ID")
    private Long id;

    @Column(name = "S_TITLE", nullable = false)
    private String title;

    @Column(name = "S_URL", nullable = false)
    private String detail_information_url;

    @Column(name = "S_DESC", nullable = false)
    private String description;

    @Column(name = "S_PERIOD", nullable = false)
    private String application_period;

    @Column(name = "S_AGENCY", nullable = false)
    private String receiving_agency;

    @Column(name = "S_TEL", nullable = false)
    private String telephone_inquiry;

    @Column(name = "S_TYPE", nullable = false)
    private String support_type;

    @Column(name = "S_PROCESS", nullable = false)
    private String application_process;

    @Column(name = "S_PROCESS_URL", nullable = false)
    private String application_process_url;
}