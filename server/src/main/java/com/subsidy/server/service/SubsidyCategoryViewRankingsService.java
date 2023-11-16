package com.subsidy.server.service;

import com.subsidy.server.model.SubsidyCategoryViewRankingsEntity;
import com.subsidy.server.persistence.SubsidyCategoryViewRankingsRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Slf4j
@Service
public class SubsidyCategoryViewRankingsService {

    @Autowired
    private SubsidyCategoryViewRankingsRepository subsidyCategoryViewRankingsRepository;


    @PostConstruct
    public void addSubsidyCategoryViewRankingsData() {
            SubsidyCategoryViewRankingsEntity subsidyCategoryViewRankings = new SubsidyCategoryViewRankingsEntity();
            subsidyCategoryViewRankingsRepository.save(subsidyCategoryViewRankings);
    }



    // Teenager
    public SubsidyCategoryViewRankingsEntity incrementTeenagerDailySafetyViews(Long id) {
        SubsidyCategoryViewRankingsEntity views = subsidyCategoryViewRankingsRepository.findById(id).orElse(null);
        if (views != null) {
            views.setTeenager_DailySafety_Views(views.getTeenager_DailySafety_Views() + 1);
            return subsidyCategoryViewRankingsRepository.save(views);
        } else {
            return null;
        }
    }

    public SubsidyCategoryViewRankingsEntity incrementTeenagerHousingSelfRelianceViews(Long id) {
        SubsidyCategoryViewRankingsEntity views = subsidyCategoryViewRankingsRepository.findById(id).orElse(null);
        if (views != null) {
            views.setTeenager_HousingSelfReliance_Views(views.getTeenager_HousingSelfReliance_Views() + 1);
            return subsidyCategoryViewRankingsRepository.save(views);
        } else {
            return null;
        }
    }

    public SubsidyCategoryViewRankingsEntity incrementTeenagerChildCareEducationViews(Long id) {
        SubsidyCategoryViewRankingsEntity views = subsidyCategoryViewRankingsRepository.findById(id).orElse(null);
        if (views != null) {
            views.setTeenager_ChildCareEducation_Views(views.getTeenager_ChildCareEducation_Views() + 1);
            return subsidyCategoryViewRankingsRepository.save(views);
        } else {
            return null;
        }
    }

    public SubsidyCategoryViewRankingsEntity incrementTeenagerEmploymentEntrepreneurshipViews(Long id) {
        SubsidyCategoryViewRankingsEntity views = subsidyCategoryViewRankingsRepository.findById(id).orElse(null);
        if (views != null) {
            views.setTeenager_EmploymentEntrepreneurship_Views(views.getTeenager_EmploymentEntrepreneurship_Views() + 1);
            return subsidyCategoryViewRankingsRepository.save(views);
        } else {
            return null;
        }
    }

    public SubsidyCategoryViewRankingsEntity incrementTeenagerHealthCareViews(Long id) {
        SubsidyCategoryViewRankingsEntity views = subsidyCategoryViewRankingsRepository.findById(id).orElse(null);
        if (views != null) {
            views.setTeenager_HealthCare_Views(views.getTeenager_HealthCare_Views() + 1);
            return subsidyCategoryViewRankingsRepository.save(views);
        } else {
            return null;
        }
    }

    public SubsidyCategoryViewRankingsEntity incrementTeenagerAdminStrativeSafetyViews(Long id) {
        SubsidyCategoryViewRankingsEntity views = subsidyCategoryViewRankingsRepository.findById(id).orElse(null);
        if (views != null) {
            views.setTeenager_AdminStrativeSafety_Views(views.getTeenager_AdminStrativeSafety_Views() + 1);
            return subsidyCategoryViewRankingsRepository.save(views);
        } else {
            return null;
        }
    }

    public SubsidyCategoryViewRankingsEntity incrementTeenagerPregnancyChildbirthViews(Long id) {
        SubsidyCategoryViewRankingsEntity views = subsidyCategoryViewRankingsRepository.findById(id).orElse(null);
        if (views != null) {
            views.setTeenager_PregnancyChildbirth_Views(views.getTeenager_PregnancyChildbirth_Views() + 1);
            return subsidyCategoryViewRankingsRepository.save(views);
        } else {
            return null;
        }
    }

    public SubsidyCategoryViewRankingsEntity incrementTeenagerProtectiveCareViews(Long id) {
        SubsidyCategoryViewRankingsEntity views = subsidyCategoryViewRankingsRepository.findById(id).orElse(null);
        if (views != null) {
            views.setTeenager_ProtectiveCare_Views(views.getTeenager_ProtectiveCare_Views() + 1);
            return subsidyCategoryViewRankingsRepository.save(views);
        } else {
            return null;
        }
    }

    public SubsidyCategoryViewRankingsEntity incrementTeenagerCulturalEnvironmentViews(Long id) {
        SubsidyCategoryViewRankingsEntity views = subsidyCategoryViewRankingsRepository.findById(id).orElse(null);
        if (views != null) {
            views.setTeenager_CulturalEnvironment_Views(views.getTeenager_CulturalEnvironment_Views() + 1);
            return subsidyCategoryViewRankingsRepository.save(views);
        } else {
            return null;
        }
    }

    public SubsidyCategoryViewRankingsEntity incrementTeenagerAgricultureLivestockFisheriesViews(Long id) {
        SubsidyCategoryViewRankingsEntity views = subsidyCategoryViewRankingsRepository.findById(id).orElse(null);
        if (views != null) {
            views.setTeenager_AgricultureLivestockFisheries_Views(views.getTeenager_AgricultureLivestockFisheries_Views() + 1);
            return subsidyCategoryViewRankingsRepository.save(views);
        } else {
            return null;
        }
    }




    // Youth
    public SubsidyCategoryViewRankingsEntity incrementYouthDailySafetyViews(Long id) {
        SubsidyCategoryViewRankingsEntity views = subsidyCategoryViewRankingsRepository.findById(id).orElse(null);
        if (views != null) {
            views.setYouth_DailySafety_Views(views.getYouth_DailySafety_Views() + 1);
            return subsidyCategoryViewRankingsRepository.save(views);
        } else {
            return null;
        }
    }

    public SubsidyCategoryViewRankingsEntity incrementYouthHousingSelfRelianceViews(Long id) {
        SubsidyCategoryViewRankingsEntity views = subsidyCategoryViewRankingsRepository.findById(id).orElse(null);
        if (views != null) {
            views.setYouth_HousingSelfReliance_Views(views.getYouth_HousingSelfReliance_Views() + 1);
            return subsidyCategoryViewRankingsRepository.save(views);
        } else {
            return null;
        }
    }

    public SubsidyCategoryViewRankingsEntity incrementYouthChildCareEducationViews(Long id) {
        SubsidyCategoryViewRankingsEntity views = subsidyCategoryViewRankingsRepository.findById(id).orElse(null);
        if (views != null) {
            views.setYouth_ChildCareEducation_Views(views.getYouth_ChildCareEducation_Views() + 1);
            return subsidyCategoryViewRankingsRepository.save(views);
        } else {
            return null;
        }
    }

    public SubsidyCategoryViewRankingsEntity incrementYouthEmploymentEntrepreneurshipViews(Long id) {
        SubsidyCategoryViewRankingsEntity views = subsidyCategoryViewRankingsRepository.findById(id).orElse(null);
        if (views != null) {
            views.setYouth_EmploymentEntrepreneurship_Views(views.getYouth_EmploymentEntrepreneurship_Views() + 1);
            return subsidyCategoryViewRankingsRepository.save(views);
        } else {
            return null;
        }
    }

    public SubsidyCategoryViewRankingsEntity incrementYouthHealthCareViews(Long id) {
        SubsidyCategoryViewRankingsEntity views = subsidyCategoryViewRankingsRepository.findById(id).orElse(null);
        if (views != null) {
            views.setYouth_HealthCare_Views(views.getYouth_HealthCare_Views() + 1);
            return subsidyCategoryViewRankingsRepository.save(views);
        } else {
            return null;
        }
    }


    public SubsidyCategoryViewRankingsEntity incrementYouthAdminStrativeSafetyViews(Long id) {
        SubsidyCategoryViewRankingsEntity views = subsidyCategoryViewRankingsRepository.findById(id).orElse(null);
        if (views != null) {
            views.setYouth_AdminStrativeSafety_Views(views.getYouth_AdminStrativeSafety_Views() + 1);
            return subsidyCategoryViewRankingsRepository.save(views);
        } else {
            return null;
        }
    }

    public SubsidyCategoryViewRankingsEntity incrementYouthPregnancyChildbirthViews(Long id) {
        SubsidyCategoryViewRankingsEntity views = subsidyCategoryViewRankingsRepository.findById(id).orElse(null);
        if (views != null) {
            views.setYouth_PregnancyChildbirth_Views(views.getYouth_PregnancyChildbirth_Views() + 1);
            return subsidyCategoryViewRankingsRepository.save(views);
        } else {
            return null;
        }
    }

    public SubsidyCategoryViewRankingsEntity incrementYouthProtectiveCareViews(Long id) {
        SubsidyCategoryViewRankingsEntity views = subsidyCategoryViewRankingsRepository.findById(id).orElse(null);
        if (views != null) {
            views.setYouth_ProtectiveCare_Views(views.getYouth_ProtectiveCare_Views() + 1);
            return subsidyCategoryViewRankingsRepository.save(views);
        } else {
            return null;
        }
    }

    public SubsidyCategoryViewRankingsEntity incrementYouthCulturalEnvironmentViews(Long id) {
        SubsidyCategoryViewRankingsEntity views = subsidyCategoryViewRankingsRepository.findById(id).orElse(null);
        if (views != null) {
            views.setYouth_CulturalEnvironment_Views(views.getYouth_CulturalEnvironment_Views() + 1);
            return subsidyCategoryViewRankingsRepository.save(views);
        } else {
            return null;
        }
    }

    public SubsidyCategoryViewRankingsEntity incrementYouthAgricultureLivestockFisheriesViews(Long id) {
        SubsidyCategoryViewRankingsEntity views = subsidyCategoryViewRankingsRepository.findById(id).orElse(null);
        if (views != null) {
            views.setYouth_AgricultureLivestockFisheries_Views(views.getYouth_AgricultureLivestockFisheries_Views() + 1);
            return subsidyCategoryViewRankingsRepository.save(views);
        } else {
            return null;
        }
    }

    // Middle Age
    public SubsidyCategoryViewRankingsEntity incrementMiddleAgeDailySafetyViews(Long id) {
        SubsidyCategoryViewRankingsEntity views = subsidyCategoryViewRankingsRepository.findById(id).orElse(null);
        if (views != null) {
            views.setMiddleAge_DailySafety_Views(views.getMiddleAge_DailySafety_Views() + 1);
            return subsidyCategoryViewRankingsRepository.save(views);
        } else {
            return null;
        }
    }

    public SubsidyCategoryViewRankingsEntity incrementMiddleAgeHousingSelfRelianceViews(Long id) {
        SubsidyCategoryViewRankingsEntity views = subsidyCategoryViewRankingsRepository.findById(id).orElse(null);
        if (views != null) {
            views.setMiddleAge_HousingSelfReliance_Views(views.getMiddleAge_HousingSelfReliance_Views() + 1);
            return subsidyCategoryViewRankingsRepository.save(views);
        } else {
            return null;
        }
    }

    public SubsidyCategoryViewRankingsEntity incrementMiddleAgeChildCareEducationViews(Long id) {
        SubsidyCategoryViewRankingsEntity views = subsidyCategoryViewRankingsRepository.findById(id).orElse(null);
        if (views != null) {
            views.setMiddleAge_ChildCareEducation_Views(views.getMiddleAge_ChildCareEducation_Views() + 1);
            return subsidyCategoryViewRankingsRepository.save(views);
        } else {
            return null;
        }
    }

    public SubsidyCategoryViewRankingsEntity incrementMiddleAgeEmploymentEntrepreneurshipViews(Long id) {
        SubsidyCategoryViewRankingsEntity views = subsidyCategoryViewRankingsRepository.findById(id).orElse(null);
        if (views != null) {
            views.setMiddleAge_EmploymentEntrepreneurship_Views(views.getMiddleAge_EmploymentEntrepreneurship_Views() + 1);
            return subsidyCategoryViewRankingsRepository.save(views);
        } else {
            return null;
        }
    }



    public SubsidyCategoryViewRankingsEntity incrementMiddleAgeHealthCareViews(Long id) {
        SubsidyCategoryViewRankingsEntity views = subsidyCategoryViewRankingsRepository.findById(id).orElse(null);
        if (views != null) {
            views.setMiddleAge_HealthCare_Views(views.getMiddleAge_HealthCare_Views() + 1);
            return subsidyCategoryViewRankingsRepository.save(views);
        } else {
            return null;
        }
    }


    public SubsidyCategoryViewRankingsEntity incrementMiddleAgeAdminStrativeSafetyViews(Long id) {
        SubsidyCategoryViewRankingsEntity views = subsidyCategoryViewRankingsRepository.findById(id).orElse(null);
        if (views != null) {
            views.setMiddleAge_AdminStrativeSafety_Views(views.getMiddleAge_AdminStrativeSafety_Views() + 1);
            return subsidyCategoryViewRankingsRepository.save(views);
        } else {
            return null;
        }
    }

    public SubsidyCategoryViewRankingsEntity incrementMiddleAgePregnancyChildbirthViews(Long id) {
        SubsidyCategoryViewRankingsEntity views = subsidyCategoryViewRankingsRepository.findById(id).orElse(null);
        if (views != null) {
            views.setMiddleAge_PregnancyChildbirth_Views(views.getMiddleAge_PregnancyChildbirth_Views() + 1);
            return subsidyCategoryViewRankingsRepository.save(views);
        } else {
            return null;
        }
    }

    public SubsidyCategoryViewRankingsEntity incrementMiddleAgeProtectiveCareViews(Long id) {
        SubsidyCategoryViewRankingsEntity views = subsidyCategoryViewRankingsRepository.findById(id).orElse(null);
        if (views != null) {
            views.setMiddleAge_ProtectiveCare_Views(views.getMiddleAge_ProtectiveCare_Views() + 1);
            return subsidyCategoryViewRankingsRepository.save(views);
        } else {
            return null;
        }
    }

    public SubsidyCategoryViewRankingsEntity incrementMiddleAgeCulturalEnvironmentViews(Long id) {
        SubsidyCategoryViewRankingsEntity views = subsidyCategoryViewRankingsRepository.findById(id).orElse(null);
        if (views != null) {
            views.setMiddleAge_CulturalEnvironment_Views(views.getMiddleAge_CulturalEnvironment_Views() + 1);
            return subsidyCategoryViewRankingsRepository.save(views);
        } else {
            return null;
        }
    }

    public SubsidyCategoryViewRankingsEntity incrementMiddleAgeAgricultureLivestockFisheriesViews(Long id) {
        SubsidyCategoryViewRankingsEntity views = subsidyCategoryViewRankingsRepository.findById(id).orElse(null);
        if (views != null) {
            views.setMiddleAge_AgricultureLivestockFisheries_Views(views.getMiddleAge_AgricultureLivestockFisheries_Views() + 1);
            return subsidyCategoryViewRankingsRepository.save(views);
        } else {
            return null;
        }
    }

    //Senior
    public SubsidyCategoryViewRankingsEntity incrementSeniorDailySafetyViews(Long id) {
        SubsidyCategoryViewRankingsEntity views = subsidyCategoryViewRankingsRepository.findById(id).orElse(null);
        if (views != null) {
            views.setSenior_DailySafety_Views(views.getSenior_DailySafety_Views() + 1);
            return subsidyCategoryViewRankingsRepository.save(views);
        } else {
            return null;
        }
    }

    public SubsidyCategoryViewRankingsEntity incrementSeniorHousingSelfRelianceViews(Long id) {
        SubsidyCategoryViewRankingsEntity views = subsidyCategoryViewRankingsRepository.findById(id).orElse(null);
        if (views != null) {
            views.setSenior_HousingSelfReliance_Views(views.getSenior_HousingSelfReliance_Views() + 1);
            return subsidyCategoryViewRankingsRepository.save(views);
        } else {
            return null;
        }
    }

    public SubsidyCategoryViewRankingsEntity incrementSeniorChildCareEducationViews(Long id) {
        SubsidyCategoryViewRankingsEntity views = subsidyCategoryViewRankingsRepository.findById(id).orElse(null);
        if (views != null) {
            views.setSenior_ChildCareEducation_Views(views.getSenior_ChildCareEducation_Views() + 1);
            return subsidyCategoryViewRankingsRepository.save(views);
        } else {
            return null;
        }
    }

    public SubsidyCategoryViewRankingsEntity incrementSeniorEmploymentEntrepreneurshipViews(Long id) {
        SubsidyCategoryViewRankingsEntity views = subsidyCategoryViewRankingsRepository.findById(id).orElse(null);
        if (views != null) {
            views.setSenior_EmploymentEntrepreneurship_Views(views.getSenior_EmploymentEntrepreneurship_Views() + 1);
            return subsidyCategoryViewRankingsRepository.save(views);
        } else {
            return null;
        }
    }

    public SubsidyCategoryViewRankingsEntity incrementSeniorHealthCareViews(Long id) {
        SubsidyCategoryViewRankingsEntity views = subsidyCategoryViewRankingsRepository.findById(id).orElse(null);
        if (views != null) {
            views.setSenior_HealthCare_Views(views.getSenior_HealthCare_Views() + 1);
            return subsidyCategoryViewRankingsRepository.save(views);
        } else {
            return null;
        }
    }

    public SubsidyCategoryViewRankingsEntity incrementSeniorAdminStrativeSafetyViews(Long id) {
        SubsidyCategoryViewRankingsEntity views = subsidyCategoryViewRankingsRepository.findById(id).orElse(null);
        if (views != null) {
            views.setSenior_AdminStrativeSafety_Views(views.getSenior_AdminStrativeSafety_Views() + 1);
            return subsidyCategoryViewRankingsRepository.save(views);
        } else {
            return null;
        }
    }

    public SubsidyCategoryViewRankingsEntity incrementSeniorPregnancyChildbirthViews(Long id) {
        SubsidyCategoryViewRankingsEntity views = subsidyCategoryViewRankingsRepository.findById(id).orElse(null);
        if (views != null) {
            views.setSenior_PregnancyChildbirth_Views(views.getSenior_PregnancyChildbirth_Views() + 1);
            return subsidyCategoryViewRankingsRepository.save(views);
        } else {
            return null;
        }
    }

    public SubsidyCategoryViewRankingsEntity incrementSeniorProtectiveCareViews(Long id) {
        SubsidyCategoryViewRankingsEntity views = subsidyCategoryViewRankingsRepository.findById(id).orElse(null);
        if (views != null) {
            views.setSenior_ProtectiveCare_Views(views.getSenior_ProtectiveCare_Views() + 1);
            return subsidyCategoryViewRankingsRepository.save(views);
        } else {
            return null;
        }
    }

    public SubsidyCategoryViewRankingsEntity incrementSeniorCulturalEnvironmentViews(Long id) {
        SubsidyCategoryViewRankingsEntity views = subsidyCategoryViewRankingsRepository.findById(id).orElse(null);
        if (views != null) {
            views.setSenior_CulturalEnvironment_Views(views.getSenior_CulturalEnvironment_Views() + 1);
            return subsidyCategoryViewRankingsRepository.save(views);
        } else {
            return null;
        }
    }

    public SubsidyCategoryViewRankingsEntity incrementSeniorAgricultureLivestockFisheriesViews(Long id) {
        SubsidyCategoryViewRankingsEntity views = subsidyCategoryViewRankingsRepository.findById(id).orElse(null);
        if (views != null) {
            views.setSenior_AgricultureLivestockFisheries_Views(views.getSenior_AgricultureLivestockFisheries_Views() + 1);
            return subsidyCategoryViewRankingsRepository.save(views);
        } else {
            return null;
        }
    }

    // Elderly
    public SubsidyCategoryViewRankingsEntity incrementElderlyDailySafetyViews(Long id) {
        SubsidyCategoryViewRankingsEntity views = subsidyCategoryViewRankingsRepository.findById(id).orElse(null);
        if (views != null) {
            views.setElderly_DailySafety_Views(views.getElderly_DailySafety_Views() + 1);
            return subsidyCategoryViewRankingsRepository.save(views);
        } else {
            return null;
        }
    }

    public SubsidyCategoryViewRankingsEntity incrementElderlyHousingSelfRelianceViews(Long id) {
        SubsidyCategoryViewRankingsEntity views = subsidyCategoryViewRankingsRepository.findById(id).orElse(null);
        if (views != null) {
            views.setElderly_HousingSelfReliance_Views(views.getElderly_HousingSelfReliance_Views() + 1);
            return subsidyCategoryViewRankingsRepository.save(views);
        } else {
            return null;
        }
    }

    public SubsidyCategoryViewRankingsEntity incrementElderlyChildCareEducationViews(Long id) {
        SubsidyCategoryViewRankingsEntity views = subsidyCategoryViewRankingsRepository.findById(id).orElse(null);
        if (views != null) {
            views.setElderly_ChildCareEducation_Views(views.getElderly_ChildCareEducation_Views() + 1);
            return subsidyCategoryViewRankingsRepository.save(views);
        } else {
            return null;
        }
    }

    public SubsidyCategoryViewRankingsEntity incrementElderlyEmploymentEntrepreneurshipViews(Long id) {
        SubsidyCategoryViewRankingsEntity views = subsidyCategoryViewRankingsRepository.findById(id).orElse(null);
        if (views != null) {
            views.setElderly_EmploymentEntrepreneurship_Views(views.getElderly_EmploymentEntrepreneurship_Views() + 1);
            return subsidyCategoryViewRankingsRepository.save(views);
        } else {
            return null;
        }
    }

    public SubsidyCategoryViewRankingsEntity incrementElderlyHealthCareViews(Long id) {
        SubsidyCategoryViewRankingsEntity views = subsidyCategoryViewRankingsRepository.findById(id).orElse(null);
        if (views != null) {
            views.setElderly_HealthCare_Views(views.getElderly_HealthCare_Views() + 1);
            return subsidyCategoryViewRankingsRepository.save(views);
        } else {
            return null;
        }
    }

    public SubsidyCategoryViewRankingsEntity incrementElderlyAdminStrativeSafetyViews(Long id) {
        SubsidyCategoryViewRankingsEntity views = subsidyCategoryViewRankingsRepository.findById(id).orElse(null);
        if (views != null) {
            views.setElderly_AdminStrativeSafety_Views(views.getElderly_AdminStrativeSafety_Views() + 1);
            return subsidyCategoryViewRankingsRepository.save(views);
        } else {
            return null;
        }
    }

    public SubsidyCategoryViewRankingsEntity incrementElderlyPregnancyChildbirthViews(Long id) {
        SubsidyCategoryViewRankingsEntity views = subsidyCategoryViewRankingsRepository.findById(id).orElse(null);
        if (views != null) {
            views.setElderly_PregnancyChildbirth_Views(views.getElderly_PregnancyChildbirth_Views() + 1);
            return subsidyCategoryViewRankingsRepository.save(views);
        } else {
            return null;
        }
    }

    public SubsidyCategoryViewRankingsEntity incrementElderlyProtectiveCareViews(Long id) {
        SubsidyCategoryViewRankingsEntity views = subsidyCategoryViewRankingsRepository.findById(id).orElse(null);
        if (views != null) {
            views.setElderly_ProtectiveCare_Views(views.getElderly_ProtectiveCare_Views() + 1);
            return subsidyCategoryViewRankingsRepository.save(views);
        } else {
            return null;
        }
    }

    public SubsidyCategoryViewRankingsEntity incrementElderlyCulturalEnvironmentViews(Long id) {
        SubsidyCategoryViewRankingsEntity views = subsidyCategoryViewRankingsRepository.findById(id).orElse(null);
        if (views != null) {
            views.setElderly_CulturalEnvironment_Views(views.getElderly_CulturalEnvironment_Views() + 1);
            return subsidyCategoryViewRankingsRepository.save(views);
        } else {
            return null;
        }
    }

    public SubsidyCategoryViewRankingsEntity incrementElderlyAgricultureLivestockFisheriesViews(Long id) {
        SubsidyCategoryViewRankingsEntity views = subsidyCategoryViewRankingsRepository.findById(id).orElse(null);
        if (views != null) {
            views.setElderly_AgricultureLivestockFisheries_Views(views.getElderly_AgricultureLivestockFisheries_Views() + 1);
            return subsidyCategoryViewRankingsRepository.save(views);
        } else {
            return null;
        }
    }

    // Male
    public SubsidyCategoryViewRankingsEntity incrementMaleDailySafetyViews(Long id) {
        SubsidyCategoryViewRankingsEntity views = subsidyCategoryViewRankingsRepository.findById(id).orElse(null);
        if (views != null) {
            views.setMale_DailySafety_Views(views.getMale_DailySafety_Views() + 1);
            return subsidyCategoryViewRankingsRepository.save(views);
        } else {
            return null;
        }
    }

    public SubsidyCategoryViewRankingsEntity incrementMaleHousingSelfRelianceViews(Long id) {
        SubsidyCategoryViewRankingsEntity views = subsidyCategoryViewRankingsRepository.findById(id).orElse(null);
        if (views != null) {
            views.setMale_HousingSelfReliance_Views(views.getMale_HousingSelfReliance_Views()s + 1);
            return subsidyCategoryViewRankingsRepository.save(views);
        } else {
            return null;
        }
    }

    public SubsidyCategoryViewRankingsEntity incrementMaleChildCareEducationViews(Long id) {
        SubsidyCategoryViewRankingsEntity views = subsidyCategoryViewRankingsRepository.findById(id).orElse(null);
        if (views != null) {
            views.setMale_ChildCareEducation_Views(views.getMale_ChildCareEducation_Views() + 1);
            return subsidyCategoryViewRankingsRepository.save(views);
        } else {
            return null;
        }
    }

    public SubsidyCategoryViewRankingsEntity incrementMaleEmploymentEntrepreneurshipViews(Long id) {
        SubsidyCategoryViewRankingsEntity views = subsidyCategoryViewRankingsRepository.findById(id).orElse(null);
        if (views != null) {
            views.setMale_EmploymentEntrepreneurship_Views(views.getMale_EmploymentEntrepreneurship_Views() + 1);
            return subsidyCategoryViewRankingsRepository.save(views);
        } else {
            return null;
        }
    }

    public SubsidyCategoryViewRankingsEntity incrementMaleHealthCareViews(Long id) {
        SubsidyCategoryViewRankingsEntity views = subsidyCategoryViewRankingsRepository.findById(id).orElse(null);
        if (views != null) {
            views.setMale_HealthCare_Views(views.getMale_HealthCare_Views() + 1);
            return subsidyCategoryViewRankingsRepository.save(views);
        } else {
            return null;
        }
    }

    public SubsidyCategoryViewRankingsEntity incrementMaleAdminStrativeSafetyViews(Long id) {
        SubsidyCategoryViewRankingsEntity views = subsidyCategoryViewRankingsRepository.findById(id).orElse(null);
        if (views != null) {
            views.setMale_AdminStrativeSafety_Views(views.getMale_AdminStrativeSafety_Views() + 1);
            return subsidyCategoryViewRankingsRepository.save(views);
        } else {
            return null;
        }
    }

    public SubsidyCategoryViewRankingsEntity incrementMalePregnancyChildbirthViews(Long id) {
        SubsidyCategoryViewRankingsEntity views = subsidyCategoryViewRankingsRepository.findById(id).orElse(null);
        if (views != null) {
            views.setMale_PregnancyChildbirth_Views(views.getMale_PregnancyChildbirth_Views() + 1);
            return subsidyCategoryViewRankingsRepository.save(views);
        } else {
            return null;
        }
    }

    public SubsidyCategoryViewRankingsEntity incrementMaleProtectiveCareViews(Long id) {
        SubsidyCategoryViewRankingsEntity views = subsidyCategoryViewRankingsRepository.findById(id).orElse(null);
        if (views != null) {
            views.setMale_ProtectiveCare_Views(views.getMale_ProtectiveCare_Views() + 1);
            return subsidyCategoryViewRankingsRepository.save(views);
        } else {
            return null;
        }
    }

    public SubsidyCategoryViewRankingsEntity incrementMaleCulturalEnvironmentViews(Long id) {
        SubsidyCategoryViewRankingsEntity views = subsidyCategoryViewRankingsRepository.findById(id).orElse(null);
        if (views != null) {
            views.setMale_CulturalEnvironment_Views(views.getMale_CulturalEnvironment_Views() + 1);
            return subsidyCategoryViewRankingsRepository.save(views);
        } else {
            return null;
        }
    }

    public SubsidyCategoryViewRankingsEntity incrementMaleAgricultureLivestockFisheriesViews(Long id) {
        SubsidyCategoryViewRankingsEntity views = subsidyCategoryViewRankingsRepository.findById(id).orElse(null);
        if (views != null) {
            views.setMale_AgricultureLivestockFisheries_Views(views.getMale_AgricultureLivestockFisheries_Views() + 1);
            return subsidyCategoryViewRankingsRepository.save(views);
        } else {
            return null;
        }
    }

    // Female
    public SubsidyCategoryViewRankingsEntity incrementFemaleDailySafetyViews(Long id) {
        SubsidyCategoryViewRankingsEntity views = subsidyCategoryViewRankingsRepository.findById(id).orElse(null);
        if (views != null) {
            views.setFemale_DailySafety_Views(views.getFemale_DailySafety_Views() + 1);
            return subsidyCategoryViewRankingsRepository.save(views);
        } else {
            return null;
        }
    }

    public SubsidyCategoryViewRankingsEntity incrementFemaleHousingSelfRelianceViews(Long id) {
        SubsidyCategoryViewRankingsEntity views = subsidyCategoryViewRankingsRepository.findById(id).orElse(null);
        if (views != null) {
            views.setFemale_HousingSelfReliance_Views(views.getFemale_HousingSelfReliance_Views() + 1);
            return subsidyCategoryViewRankingsRepository.save(views);
        } else {
            return null;
        }
    }

    public SubsidyCategoryViewRankingsEntity incrementFemaleChildCareEducationViews(Long id) {
        SubsidyCategoryViewRankingsEntity views = subsidyCategoryViewRankingsRepository.findById(id).orElse(null);
        if (views != null) {
            views.setFemale_ChildCareEducation_Views(views.getFemale_ChildCareEducation_Views() + 1);
            return subsidyCategoryViewRankingsRepository.save(views);
        } else {
            return null;
        }
    }

    public SubsidyCategoryViewRankingsEntity incrementFemaleEmploymentEntrepreneurshipViews(Long id) {
        SubsidyCategoryViewRankingsEntity views = subsidyCategoryViewRankingsRepository.findById(id).orElse(null);
        if (views != null) {
            views.setFemale_EmploymentEntrepreneurship_Views(views.getFemale_EmploymentEntrepreneurship_Views() + 1);
            return subsidyCategoryViewRankingsRepository.save(views);
        } else {
            return null;
        }
    }

    public SubsidyCategoryViewRankingsEntity incrementFemaleHealthCareViews(Long id) {
        SubsidyCategoryViewRankingsEntity views = subsidyCategoryViewRankingsRepository.findById(id).orElse(null);
        if (views != null) {
            views.setFemale_HealthCare_Views(views.getFemale_HealthCare_Views() + 1);
            return subsidyCategoryViewRankingsRepository.save(views);
        } else {
            return null;
        }
    }

    public SubsidyCategoryViewRankingsEntity incrementFemaleAdminStrativeSafetyViews(Long id) {
        SubsidyCategoryViewRankingsEntity views = subsidyCategoryViewRankingsRepository.findById(id).orElse(null);
        if (views != null) {
            views.setFemale_AdminStrativeSafety_Views(views.getFemale_AdminStrativeSafety_Views() + 1);
            return subsidyCategoryViewRankingsRepository.save(views);
        } else {
            return null;
        }
    }

    public SubsidyCategoryViewRankingsEntity incrementFemalePregnancyChildbirthViews(Long id) {
        SubsidyCategoryViewRankingsEntity views = subsidyCategoryViewRankingsRepository.findById(id).orElse(null);
        if (views != null) {
            views.setFemale_PregnancyChildbirth_Views(views.getFemale_PregnancyChildbirth_Views() + 1);
            return subsidyCategoryViewRankingsRepository.save(views);
        } else {
            return null;
        }
    }

    public SubsidyCategoryViewRankingsEntity incrementFemaleProtectiveCareViews(Long id) {
        SubsidyCategoryViewRankingsEntity views = subsidyCategoryViewRankingsRepository.findById(id).orElse(null);
        if (views != null) {
            views.setFemale_ProtectiveCare_Views(views.getFemale_ProtectiveCare_Views() + 1);
            return subsidyCategoryViewRankingsRepository.save(views);
        } else {
            return null;
        }
    }

    public SubsidyCategoryViewRankingsEntity incrementFemaleCulturalEnvironmentViews(Long id) {
        SubsidyCategoryViewRankingsEntity views = subsidyCategoryViewRankingsRepository.findById(id).orElse(null);
        if (views != null) {
            views.setFemale_CulturalEnvironment_Views(views.getFemale_CulturalEnvironment_Views() + 1);
            return subsidyCategoryViewRankingsRepository.save(views);
        } else {
            return null;
        }
    }

    public SubsidyCategoryViewRankingsEntity incrementFemaleAgricultureLivestockFisheriesViews(Long id) {
        SubsidyCategoryViewRankingsEntity views = subsidyCategoryViewRankingsRepository.findById(id).orElse(null);
        if (views != null) {
            views.setFemale_AgricultureLivestockFisheries_Views(views.getFemale_AgricultureLivestockFisheries_Views() + 1);
            return subsidyCategoryViewRankingsRepository.save(views);
        } else {
            return null;
        }
    }











































































































}
