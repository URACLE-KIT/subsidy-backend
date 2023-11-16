package com.subsidy.server.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "SUBSIDYCATEGORYVIEWRANKINGS")

public class SubsidyCategoryViewRankingsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "INT DEFAULT 0")
    private int Teenager_DailySafety_Views;

    @Column(columnDefinition = "INT DEFAULT 0")
    private int Teenager_HousingSelfReliance_Views;

    @Column(columnDefinition = "INT DEFAULT 0")
    private int Teenager_ChildCareEducation_Views;

    @Column(columnDefinition = "INT DEFAULT 0")
    private int Teenager_EmploymentEntrepreneurship_Views;

    @Column(columnDefinition = "INT DEFAULT 0")
    private int Teenager_HealthCare_Views;

    @Column(columnDefinition = "INT DEFAULT 0")
    private int Teenager_AdminStrativeSafety_Views;

    @Column(columnDefinition = "INT DEFAULT 0")
    private int Teenager_PregnancyChildbirth_Views;

    @Column(columnDefinition = "INT DEFAULT 0")
    private int Teenager_ProtectiveCare_Views;

    @Column(columnDefinition = "INT DEFAULT 0")
    private int Teenager_CulturalEnvironment_Views;

    @Column(columnDefinition = "INT DEFAULT 0")
    private int Teenager_AgricultureLivestockFisheries_Views;



    @Column(columnDefinition = "INT DEFAULT 0")
    private int Youth_DailySafety_Views;

    @Column(columnDefinition = "INT DEFAULT 0")
    private int Youth_HousingSelfReliance_Views;

    @Column(columnDefinition = "INT DEFAULT 0")
    private int Youth_ChildCareEducation_Views;

    @Column(columnDefinition = "INT DEFAULT 0")
    private int Youth_EmploymentEntrepreneurship_Views;

    @Column(columnDefinition = "INT DEFAULT 0")
    private int Youth_HealthCare_Views;

    @Column(columnDefinition = "INT DEFAULT 0")
    private int Youth_AdminStrativeSafety_Views;

    @Column(columnDefinition = "INT DEFAULT 0")
    private int Youth_PregnancyChildbirth_Views;

    @Column(columnDefinition = "INT DEFAULT 0")
    private int Youth_ProtectiveCare_Views;

    @Column(columnDefinition = "INT DEFAULT 0")
    private int Youth_CulturalEnvironment_Views;

    @Column(columnDefinition = "INT DEFAULT 0")
    private int Youth_AgricultureLivestockFisheries_Views;



    @Column(columnDefinition = "INT DEFAULT 0")
    private int MiddleAge_DailySafety_Views;

    @Column(columnDefinition = "INT DEFAULT 0")
    private int MiddleAge_HousingSelfReliance_Views;

    @Column(columnDefinition = "INT DEFAULT 0")
    private int MiddleAge_ChildCareEducation_Views;

    @Column(columnDefinition = "INT DEFAULT 0")
    private int MiddleAge_EmploymentEntrepreneurship_Views;

    @Column(columnDefinition = "INT DEFAULT 0")
    private int MiddleAge_HealthCare_Views;

    @Column(columnDefinition = "INT DEFAULT 0")
    private int MiddleAge_AdminStrativeSafety_Views;

    @Column(columnDefinition = "INT DEFAULT 0")
    private int MiddleAge_PregnancyChildbirth_Views;

    @Column(columnDefinition = "INT DEFAULT 0")
    private int MiddleAge_ProtectiveCare_Views;

    @Column(columnDefinition = "INT DEFAULT 0")
    private int MiddleAge_CulturalEnvironment_Views;

    @Column(columnDefinition = "INT DEFAULT 0")
    private int MiddleAge_AgricultureLivestockFisheries_Views;


    @Column(columnDefinition = "INT DEFAULT 0")
    private int Senior_DailySafety_Views;

    @Column(columnDefinition = "INT DEFAULT 0")
    private int Senior_HousingSelfReliance_Views;

    @Column(columnDefinition = "INT DEFAULT 0")
    private int Senior_ChildCareEducation_Views;

    @Column(columnDefinition = "INT DEFAULT 0")
    private int Senior_EmploymentEntrepreneurship_Views;

    @Column(columnDefinition = "INT DEFAULT 0")
    private int Senior_HealthCare_Views;

    @Column(columnDefinition = "INT DEFAULT 0")
    private int Senior_AdminStrativeSafety_Views;

    @Column(columnDefinition = "INT DEFAULT 0")
    private int Senior_PregnancyChildbirth_Views;

    @Column(columnDefinition = "INT DEFAULT 0")
    private int Senior_ProtectiveCare_Views;

    @Column(columnDefinition = "INT DEFAULT 0")
    private int Senior_CulturalEnvironment_Views;

    @Column(columnDefinition = "INT DEFAULT 0")
    private int Senior_AgricultureLivestockFisheries_Views;


    @Column(columnDefinition = "INT DEFAULT 0")
    private int Elderly_DailySafety_Views;

    @Column(columnDefinition = "INT DEFAULT 0")
    private int Elderly_HousingSelfReliance_Views;

    @Column(columnDefinition = "INT DEFAULT 0")
    private int Elderly_ChildCareEducation_Views;

    @Column(columnDefinition = "INT DEFAULT 0")
    private int Elderly_EmploymentEntrepreneurship_Views;

    @Column(columnDefinition = "INT DEFAULT 0")
    private int Elderly_HealthCare_Views;

    @Column(columnDefinition = "INT DEFAULT 0")
    private int Elderly_AdminStrativeSafety_Views;

    @Column(columnDefinition = "INT DEFAULT 0")
    private int Elderly_PregnancyChildbirth_Views;

    @Column(columnDefinition = "INT DEFAULT 0")
    private int Elderly_ProtectiveCare_Views;

    @Column(columnDefinition = "INT DEFAULT 0")
    private int Elderly_CulturalEnvironment_Views;

    @Column(columnDefinition = "INT DEFAULT 0")
    private int Elderly_AgricultureLivestockFisheries_Views;


    @Column(columnDefinition = "INT DEFAULT 0")
    private int Male_DailySafety_Views;

    @Column(columnDefinition = "INT DEFAULT 0")
    private int Male_HousingSelfReliance_Views;

    @Column(columnDefinition = "INT DEFAULT 0")
    private int Male_ChildCareEducation_Views;

    @Column(columnDefinition = "INT DEFAULT 0")
    private int Male_EmploymentEntrepreneurship_Views;

    @Column(columnDefinition = "INT DEFAULT 0")
    private int Male_HealthCare_Views;

    @Column(columnDefinition = "INT DEFAULT 0")
    private int Male_AdminStrativeSafety_Views;

    @Column(columnDefinition = "INT DEFAULT 0")
    private int Male_PregnancyChildbirth_Views;

    @Column(columnDefinition = "INT DEFAULT 0")
    private int Male_ProtectiveCare_Views;

    @Column(columnDefinition = "INT DEFAULT 0")
    private int Male_CulturalEnvironment_Views;

    @Column(columnDefinition = "INT DEFAULT 0")
    private int Male_AgricultureLivestockFisheries_Views;


    @Column(columnDefinition = "INT DEFAULT 0")
    private int Female_DailySafety_Views;

    @Column(columnDefinition = "INT DEFAULT 0")
    private int Female_HousingSelfReliance_Views;

    @Column(columnDefinition = "INT DEFAULT 0")
    private int Female_ChildCareEducation_Views;

    @Column(columnDefinition = "INT DEFAULT 0")
    private int Female_EmploymentEntrepreneurship_Views;

    @Column(columnDefinition = "INT DEFAULT 0")
    private int Female_HealthCare_Views;

    @Column(columnDefinition = "INT DEFAULT 0")
    private int Female_AdminStrativeSafety_Views;

    @Column(columnDefinition = "INT DEFAULT 0")
    private int Female_PregnancyChildbirth_Views;

    @Column(columnDefinition = "INT DEFAULT 0")
    private int Female_ProtectiveCare_Views;

    @Column(columnDefinition = "INT DEFAULT 0")
    private int Female_CulturalEnvironment_Views;

    @Column(columnDefinition = "INT DEFAULT 0")
    private int Female_AgricultureLivestockFisheries_Views;

}
