package com.subsidy.server.model;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "SUBSIDIES")
public class SubsidiesEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "category", nullable = false)
    private String category;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "detail_information_url", nullable = false)
    private String detail_information_url;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "application_period", nullable = false)
    private String application_period;

    @Column(name = "receiving_agency", nullable = false)
    private String receiving_agency;

    @Column(name = "telephone_inquiry", nullable = false, length = 1000)
    private String telephone_inquiry;

    @Column(name = "support_type", nullable = false)
    private String support_type;

    @Column(name = "application_process", nullable = false)
    private String application_process;

    @Column(name = "application_process_url", nullable = false)
    private String application_process_url;

    @Column(columnDefinition = "INT DEFAULT 0")
    private int views;

    @Column(columnDefinition = "INT DEFAULT 0")
    private int numReviews;
}