package com.subsidy.server.controller;


import com.subsidy.server.model.SubsidyCategoryViewRankingsEntity;
import com.subsidy.server.service.SubsidyCategoryViewRankingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/subsidyCategoryViewRankings")
public class SubsidyCategoryViewRankingsController {
    @Autowired
    private SubsidyCategoryViewRankingsService subsidyCategoryViewRankingsService;

    @GetMapping("/views")
    public ResponseEntity<SubsidyCategoryViewRankingsEntity> getEntityById(@RequestParam Long id) {
        SubsidyCategoryViewRankingsEntity entity = subsidyCategoryViewRankingsService.getEntityById(id);
        if (entity != null) {
            return ResponseEntity.ok(entity);
        } else {
            return ResponseEntity.notFound().build();
        }
    }



    // Teenager
    @PutMapping("/increment/teenager/daily-safety")
    public ResponseEntity<SubsidyCategoryViewRankingsEntity> incrementTeenagerDailySafetyView(@RequestParam Long id) {
        SubsidyCategoryViewRankingsEntity views = subsidyCategoryViewRankingsService.incrementTeenagerDailySafetyViews(id);
        if (views != null) {
            return ResponseEntity.ok(views);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PutMapping("/increment/teenager/housing-self-reliance")
    public ResponseEntity<SubsidyCategoryViewRankingsEntity> incrementTeenagerHousingSelfReliance(@RequestParam Long id) {
        SubsidyCategoryViewRankingsEntity views = subsidyCategoryViewRankingsService.incrementTeenagerHousingSelfRelianceViews(id);
        if (views != null) {
            return ResponseEntity.ok(views);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PutMapping("/increment/teenager/child-care-education")
    public ResponseEntity<SubsidyCategoryViewRankingsEntity> incrementTeenagerChildCareEducation(@RequestParam Long id) {
        SubsidyCategoryViewRankingsEntity views = subsidyCategoryViewRankingsService.incrementTeenagerChildCareEducationViews(id);
        if (views != null) {
            return ResponseEntity.ok(views);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PutMapping("/increment/teenager/employment-entrepreneurship")
    public ResponseEntity<SubsidyCategoryViewRankingsEntity> incrementTeenagerEmploymentEntrepreneurship(@RequestParam Long id) {
        SubsidyCategoryViewRankingsEntity views = subsidyCategoryViewRankingsService.incrementTeenagerEmploymentEntrepreneurshipViews(id);
        if (views != null) {
            return ResponseEntity.ok(views);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PutMapping("/increment/teenager/health-care")
    public ResponseEntity<SubsidyCategoryViewRankingsEntity> incrementTeenagerHealthCare(@RequestParam Long id) {
        SubsidyCategoryViewRankingsEntity views = subsidyCategoryViewRankingsService.incrementTeenagerHealthCareViews(id);
        if (views != null) {
            return ResponseEntity.ok(views);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PutMapping("/increment/teenager/admin-strative-safety")
    public ResponseEntity<SubsidyCategoryViewRankingsEntity> incrementTeenagerAdminStrativeSafety(@RequestParam Long id) {
        SubsidyCategoryViewRankingsEntity views = subsidyCategoryViewRankingsService.incrementTeenagerAdminStrativeSafetyViews(id);
        if (views != null) {
            return ResponseEntity.ok(views);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PutMapping("/increment/teenager/pregnancy-childbirth")
    public ResponseEntity<SubsidyCategoryViewRankingsEntity> incrementTeenagerPregnancyChildbirth(@RequestParam Long id) {
        SubsidyCategoryViewRankingsEntity views = subsidyCategoryViewRankingsService.incrementTeenagerPregnancyChildbirthViews(id);
        if (views != null) {
            return ResponseEntity.ok(views);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PutMapping("/increment/teenager/protective-care")
    public ResponseEntity<SubsidyCategoryViewRankingsEntity> incrementTeenagerProtectiveCare(@RequestParam Long id) {
        SubsidyCategoryViewRankingsEntity views = subsidyCategoryViewRankingsService.incrementTeenagerProtectiveCareViews(id);
        if (views != null) {
            return ResponseEntity.ok(views);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PutMapping("/increment/teenager/cultural-environment")
    public ResponseEntity<SubsidyCategoryViewRankingsEntity> incrementTeenagerCulturalEnvironment(@RequestParam Long id) {
        SubsidyCategoryViewRankingsEntity views = subsidyCategoryViewRankingsService.incrementTeenagerCulturalEnvironmentViews(id);
        if (views != null) {
            return ResponseEntity.ok(views);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PutMapping("/increment/teenager/agriculture-livestock-fisheries")
    public ResponseEntity<SubsidyCategoryViewRankingsEntity> incrementTeenagerAgricultureLivestockFisheries(@RequestParam Long id) {
        SubsidyCategoryViewRankingsEntity views = subsidyCategoryViewRankingsService.incrementTeenagerAgricultureLivestockFisheriesViews(id);
        if (views != null) {
            return ResponseEntity.ok(views);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    // Youth
    @PutMapping("/increment/youth/daily-safety")
    public ResponseEntity<SubsidyCategoryViewRankingsEntity> incrementYouthDailySafety(@RequestParam Long id) {
        SubsidyCategoryViewRankingsEntity views = subsidyCategoryViewRankingsService.incrementYouthDailySafetyViews(id);
        if (views != null) {
            return ResponseEntity.ok(views);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PutMapping("/increment/youth/housing-self-reliance")
    public ResponseEntity<SubsidyCategoryViewRankingsEntity> incrementYouthHousingSelfReliance(@RequestParam Long id) {
        SubsidyCategoryViewRankingsEntity views = subsidyCategoryViewRankingsService.incrementYouthHousingSelfRelianceViews(id);
        if (views != null) {
            return ResponseEntity.ok(views);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PutMapping("/increment/youth/child-care-education")
    public ResponseEntity<SubsidyCategoryViewRankingsEntity> incrementYouthChildCareEducation(@RequestParam Long id) {
        SubsidyCategoryViewRankingsEntity views = subsidyCategoryViewRankingsService.incrementYouthChildCareEducationViews(id);
        if (views != null) {
            return ResponseEntity.ok(views);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PutMapping("/increment/youth/employment-entrepreneurship")
    public ResponseEntity<SubsidyCategoryViewRankingsEntity> incrementYouthEmploymentEntrepreneurship(@RequestParam Long id) {
        SubsidyCategoryViewRankingsEntity views = subsidyCategoryViewRankingsService.incrementYouthEmploymentEntrepreneurshipViews(id);
        if (views != null) {
            return ResponseEntity.ok(views);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PutMapping("/increment/youth/health-care")
    public ResponseEntity<SubsidyCategoryViewRankingsEntity> incrementYouthHealthCare(@RequestParam Long id) {
        SubsidyCategoryViewRankingsEntity views = subsidyCategoryViewRankingsService.incrementYouthHealthCareViews(id);
        if (views != null) {
            return ResponseEntity.ok(views);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PutMapping("/increment/youth/admin-strative-safety")
    public ResponseEntity<SubsidyCategoryViewRankingsEntity> incrementYouthAdminStrativeSafety(@RequestParam Long id) {
        SubsidyCategoryViewRankingsEntity views = subsidyCategoryViewRankingsService.incrementYouthAdminStrativeSafetyViews(id);
        if (views != null) {
            return ResponseEntity.ok(views);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PutMapping("/increment/youth/pregnancy-childbirth")
    public ResponseEntity<SubsidyCategoryViewRankingsEntity> incrementYouthPregnancyChildbirth(@RequestParam Long id) {
        SubsidyCategoryViewRankingsEntity views = subsidyCategoryViewRankingsService.incrementYouthPregnancyChildbirthViews(id);
        if (views != null) {
            return ResponseEntity.ok(views);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PutMapping("/increment/youth/protective-care")
    public ResponseEntity<SubsidyCategoryViewRankingsEntity> incrementYouthProtectiveCare(@RequestParam Long id) {
        SubsidyCategoryViewRankingsEntity views = subsidyCategoryViewRankingsService.incrementYouthProtectiveCareViews(id);
        if (views != null) {
            return ResponseEntity.ok(views);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PutMapping("/increment/youth/cultural-environment")
    public ResponseEntity<SubsidyCategoryViewRankingsEntity> incrementYouthCulturalEnvironment(@RequestParam Long id) {
        SubsidyCategoryViewRankingsEntity views = subsidyCategoryViewRankingsService.incrementYouthCulturalEnvironmentViews(id);
        if (views != null) {
            return ResponseEntity.ok(views);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PutMapping("/increment/youth/agriculture-livestock-fisheries")
    public ResponseEntity<SubsidyCategoryViewRankingsEntity> incrementYouthAgricultureLivestockFisheries(@RequestParam Long id) {
        SubsidyCategoryViewRankingsEntity views = subsidyCategoryViewRankingsService.incrementYouthAgricultureLivestockFisheriesViews(id);
        if (views != null) {
            return ResponseEntity.ok(views);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    // Middle Age
    @PutMapping("/increment/middle-age/daily-safety")
    public ResponseEntity<SubsidyCategoryViewRankingsEntity> incrementMiddleAgeDailySafety(@RequestParam Long id) {
        SubsidyCategoryViewRankingsEntity views = subsidyCategoryViewRankingsService.incrementMiddleAgeDailySafetyViews(id);
        if (views != null) {
            return ResponseEntity.ok(views);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PutMapping("/increment/middle-age/housing-self-reliance")
    public ResponseEntity<SubsidyCategoryViewRankingsEntity> incrementMiddleAgeHousingSelfReliance(@RequestParam Long id) {
        SubsidyCategoryViewRankingsEntity views = subsidyCategoryViewRankingsService.incrementMiddleAgeHousingSelfRelianceViews(id);
        if (views != null) {
            return ResponseEntity.ok(views);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PutMapping("/increment/middle-age/child-care-education")
    public ResponseEntity<SubsidyCategoryViewRankingsEntity> incrementMiddleAgeChildCareEducation(@RequestParam Long id) {
        SubsidyCategoryViewRankingsEntity views = subsidyCategoryViewRankingsService.incrementMiddleAgeChildCareEducationViews(id);
        if (views != null) {
            return ResponseEntity.ok(views);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PutMapping("/increment/middle-age/employment-entrepreneurship")
    public ResponseEntity<SubsidyCategoryViewRankingsEntity> incrementMiddleAgeEmploymentEntrepreneurship(@RequestParam Long id) {
        SubsidyCategoryViewRankingsEntity views = subsidyCategoryViewRankingsService.incrementMiddleAgeEmploymentEntrepreneurshipViews(id);
        if (views != null) {
            return ResponseEntity.ok(views);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PutMapping("/increment/middle-age/health-care")
    public ResponseEntity<SubsidyCategoryViewRankingsEntity> incrementMiddleAgeHealthCare(@RequestParam Long id) {
        SubsidyCategoryViewRankingsEntity views = subsidyCategoryViewRankingsService.incrementMiddleAgeHealthCareViews(id);
        if (views != null) {
            return ResponseEntity.ok(views);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PutMapping("/increment/middle-age/admin-strative-safety")
    public ResponseEntity<SubsidyCategoryViewRankingsEntity> incrementMiddleAgeAdminStrativeSafety(@RequestParam Long id) {
        SubsidyCategoryViewRankingsEntity views = subsidyCategoryViewRankingsService.incrementMiddleAgeAdminStrativeSafetyViews(id);
        if (views != null) {
            return ResponseEntity.ok(views);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PutMapping("/increment/middle-age/pregnancy-childbirth")
    public ResponseEntity<SubsidyCategoryViewRankingsEntity> incrementMiddleAgePregnancyChildbirth(@RequestParam Long id) {
        SubsidyCategoryViewRankingsEntity views = subsidyCategoryViewRankingsService.incrementMiddleAgePregnancyChildbirthViews(id);
        if (views != null) {
            return ResponseEntity.ok(views);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PutMapping("/increment/middle-age/protective-care")
    public ResponseEntity<SubsidyCategoryViewRankingsEntity> incrementMiddleAgeProtectiveCare(@RequestParam Long id) {
        SubsidyCategoryViewRankingsEntity views = subsidyCategoryViewRankingsService.incrementMiddleAgeProtectiveCareViews(id);
        if (views != null) {
            return ResponseEntity.ok(views);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PutMapping("/increment/middle-age/cultural-environment")
    public ResponseEntity<SubsidyCategoryViewRankingsEntity> incrementMiddleAgeCulturalEnvironment(@RequestParam Long id) {
        SubsidyCategoryViewRankingsEntity views = subsidyCategoryViewRankingsService.incrementMiddleAgeCulturalEnvironmentViews(id);
        if (views != null) {
            return ResponseEntity.ok(views);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PutMapping("/increment/middle-age/agriculture-livestock-fisheries")
    public ResponseEntity<SubsidyCategoryViewRankingsEntity> incrementMiddleAgeAgricultureLivestockFisheries(@RequestParam Long id) {
        SubsidyCategoryViewRankingsEntity views = subsidyCategoryViewRankingsService.incrementMiddleAgeAgricultureLivestockFisheriesViews(id);
        if (views != null) {
            return ResponseEntity.ok(views);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    // senior
    @PutMapping("/increment/senior/daily-safety")
    public ResponseEntity<SubsidyCategoryViewRankingsEntity> incrementSeniorDailySafety(@RequestParam Long id) {
        SubsidyCategoryViewRankingsEntity views = subsidyCategoryViewRankingsService.incrementSeniorDailySafetyViews(id);
        if (views != null) {
            return ResponseEntity.ok(views);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PutMapping("/increment/senior/housing-self-reliance")
    public ResponseEntity<SubsidyCategoryViewRankingsEntity> incrementSeniorHousingSelfReliance(@RequestParam Long id) {
        SubsidyCategoryViewRankingsEntity views = subsidyCategoryViewRankingsService.incrementSeniorHousingSelfRelianceViews(id);
        if (views != null) {
            return ResponseEntity.ok(views);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PutMapping("/increment/senior/child-care-education")
    public ResponseEntity<SubsidyCategoryViewRankingsEntity> incrementSeniorChildCareEducation(@RequestParam Long id) {
        SubsidyCategoryViewRankingsEntity views = subsidyCategoryViewRankingsService.incrementSeniorChildCareEducationViews(id);
        if (views != null) {
            return ResponseEntity.ok(views);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PutMapping("/increment/senior/employment-entrepreneurship")
    public ResponseEntity<SubsidyCategoryViewRankingsEntity> incrementSeniorEmploymentEntrepreneurship(@RequestParam Long id) {
        SubsidyCategoryViewRankingsEntity views = subsidyCategoryViewRankingsService.incrementSeniorEmploymentEntrepreneurshipViews(id);
        if (views != null) {
            return ResponseEntity.ok(views);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PutMapping("/increment/senior/health-care")
    public ResponseEntity<SubsidyCategoryViewRankingsEntity> incrementSeniorHealthCare(@RequestParam Long id) {
        SubsidyCategoryViewRankingsEntity views = subsidyCategoryViewRankingsService.incrementSeniorHealthCareViews(id);
        if (views != null) {
            return ResponseEntity.ok(views);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PutMapping("/increment/senior/admin-strative-safety")
    public ResponseEntity<SubsidyCategoryViewRankingsEntity> incrementSeniorAdminStrativeSafety(@RequestParam Long id) {
        SubsidyCategoryViewRankingsEntity views = subsidyCategoryViewRankingsService.incrementSeniorAdminStrativeSafetyViews(id);
        if (views != null) {
            return ResponseEntity.ok(views);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PutMapping("/increment/senior/pregnancy-childbirth")
    public ResponseEntity<SubsidyCategoryViewRankingsEntity> incrementSeniorPregnancyChildbirth(@RequestParam Long id) {
        SubsidyCategoryViewRankingsEntity views = subsidyCategoryViewRankingsService.incrementSeniorPregnancyChildbirthViews(id);
        if (views != null) {
            return ResponseEntity.ok(views);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PutMapping("/increment/senior/protective-care")
    public ResponseEntity<SubsidyCategoryViewRankingsEntity> incrementSeniorProtectiveCare(@RequestParam Long id) {
        SubsidyCategoryViewRankingsEntity views = subsidyCategoryViewRankingsService.incrementSeniorProtectiveCareViews(id);
        if (views != null) {
            return ResponseEntity.ok(views);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PutMapping("/increment/senior/cultural-environment")
    public ResponseEntity<SubsidyCategoryViewRankingsEntity> incrementSeniorCulturalEnvironment(@RequestParam Long id) {
        SubsidyCategoryViewRankingsEntity views = subsidyCategoryViewRankingsService.incrementSeniorCulturalEnvironmentViews(id);
        if (views != null) {
            return ResponseEntity.ok(views);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PutMapping("/increment/senior/agriculture-livestock-fisheries")
    public ResponseEntity<SubsidyCategoryViewRankingsEntity> incrementSeniorAgricultureLivestockFisheries(@RequestParam Long id) {
        SubsidyCategoryViewRankingsEntity views = subsidyCategoryViewRankingsService.incrementSeniorAgricultureLivestockFisheriesViews(id);
        if (views != null) {
            return ResponseEntity.ok(views);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    // elderly
    @PutMapping("/increment/elderly/daily-safety")
    public ResponseEntity<SubsidyCategoryViewRankingsEntity> incrementElderlyDailySafety(@RequestParam Long id) {
        SubsidyCategoryViewRankingsEntity views = subsidyCategoryViewRankingsService.incrementElderlyDailySafetyViews(id);
        if (views != null) {
            return ResponseEntity.ok(views);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PutMapping("/increment/elderly/housing-self-reliance")
    public ResponseEntity<SubsidyCategoryViewRankingsEntity> incrementElderlyHousingSelfReliance(@RequestParam Long id) {
        SubsidyCategoryViewRankingsEntity views = subsidyCategoryViewRankingsService.incrementElderlyHousingSelfRelianceViews(id);
        if (views != null) {
            return ResponseEntity.ok(views);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PutMapping("/increment/elderly/child-care-education")
    public ResponseEntity<SubsidyCategoryViewRankingsEntity> incrementElderlyChildCareEducation(@RequestParam Long id) {
        SubsidyCategoryViewRankingsEntity views = subsidyCategoryViewRankingsService.incrementElderlyChildCareEducationViews(id);
        if (views != null) {
            return ResponseEntity.ok(views);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PutMapping("/increment/elderly/employment-entrepreneurship")
    public ResponseEntity<SubsidyCategoryViewRankingsEntity> incrementElderlyEmploymentEntrepreneurship(@RequestParam Long id) {
        SubsidyCategoryViewRankingsEntity views = subsidyCategoryViewRankingsService.incrementElderlyEmploymentEntrepreneurshipViews(id);
        if (views != null) {
            return ResponseEntity.ok(views);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PutMapping("/increment/elderly/health-care")
    public ResponseEntity<SubsidyCategoryViewRankingsEntity> incrementElderlyHealthCare(@RequestParam Long id) {
        SubsidyCategoryViewRankingsEntity views = subsidyCategoryViewRankingsService.incrementElderlyHealthCareViews(id);
        if (views != null) {
            return ResponseEntity.ok(views);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PutMapping("/increment/elderly/admin-strative-safety")
    public ResponseEntity<SubsidyCategoryViewRankingsEntity> incrementElderlyAdminStrativeSafety(@RequestParam Long id) {
        SubsidyCategoryViewRankingsEntity views = subsidyCategoryViewRankingsService.incrementElderlyAdminStrativeSafetyViews(id);
        if (views != null) {
            return ResponseEntity.ok(views);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PutMapping("/increment/elderly/pregnancy-childbirth")
    public ResponseEntity<SubsidyCategoryViewRankingsEntity> incrementElderlyPregnancyChildbirth(@RequestParam Long id) {
        SubsidyCategoryViewRankingsEntity views = subsidyCategoryViewRankingsService.incrementElderlyPregnancyChildbirthViews(id);
        if (views != null) {
            return ResponseEntity.ok(views);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PutMapping("/increment/elderly/protective-care")
    public ResponseEntity<SubsidyCategoryViewRankingsEntity> incrementElderlyProtectiveCare(@RequestParam Long id) {
        SubsidyCategoryViewRankingsEntity views = subsidyCategoryViewRankingsService.incrementElderlyProtectiveCareViews(id);
        if (views != null) {
            return ResponseEntity.ok(views);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PutMapping("/increment/elderly/cultural-environment")
    public ResponseEntity<SubsidyCategoryViewRankingsEntity> incrementElderlyCulturalEnvironment(@RequestParam Long id) {
        SubsidyCategoryViewRankingsEntity views = subsidyCategoryViewRankingsService.incrementElderlyCulturalEnvironmentViews(id);
        if (views != null) {
            return ResponseEntity.ok(views);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PutMapping("/increment/elderly/agriculture-livestock-fisheries")
    public ResponseEntity<SubsidyCategoryViewRankingsEntity> incrementElderlyAgricultureLivestockFisheries(@RequestParam Long id) {
        SubsidyCategoryViewRankingsEntity views = subsidyCategoryViewRankingsService.incrementElderlyAgricultureLivestockFisheriesViews(id);
        if (views != null) {
            return ResponseEntity.ok(views);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }


    // male  Male
    @PutMapping("/increment/male/daily-safety")
    public ResponseEntity<SubsidyCategoryViewRankingsEntity> incrementMaleDailySafety(@RequestParam Long id) {
        SubsidyCategoryViewRankingsEntity views = subsidyCategoryViewRankingsService.incrementMaleDailySafetyViews(id);
        if (views != null) {
            return ResponseEntity.ok(views);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PutMapping("/increment/male/housing-self-reliance")
    public ResponseEntity<SubsidyCategoryViewRankingsEntity> incrementMaleHousingSelfReliance(@RequestParam Long id) {
        SubsidyCategoryViewRankingsEntity views = subsidyCategoryViewRankingsService.incrementMaleHousingSelfRelianceViews(id);
        if (views != null) {
            return ResponseEntity.ok(views);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PutMapping("/increment/male/child-care-education")
    public ResponseEntity<SubsidyCategoryViewRankingsEntity> incrementMaleChildCareEducation(@RequestParam Long id) {
        SubsidyCategoryViewRankingsEntity views = subsidyCategoryViewRankingsService.incrementMaleChildCareEducationViews(id);
        if (views != null) {
            return ResponseEntity.ok(views);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PutMapping("/increment/male/employment-entrepreneurship")
    public ResponseEntity<SubsidyCategoryViewRankingsEntity> incrementMaleEmploymentEntrepreneurship(@RequestParam Long id) {
        SubsidyCategoryViewRankingsEntity views = subsidyCategoryViewRankingsService.incrementMaleEmploymentEntrepreneurshipViews(id);
        if (views != null) {
            return ResponseEntity.ok(views);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PutMapping("/increment/male/health-care")
    public ResponseEntity<SubsidyCategoryViewRankingsEntity> incrementMaleHealthCare(@RequestParam Long id) {
        SubsidyCategoryViewRankingsEntity views = subsidyCategoryViewRankingsService.incrementMaleHealthCareViews(id);
        if (views != null) {
            return ResponseEntity.ok(views);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PutMapping("/increment/male/admin-strative-safety")
    public ResponseEntity<SubsidyCategoryViewRankingsEntity> incrementMaleAdminStrativeSafety(@RequestParam Long id) {
        SubsidyCategoryViewRankingsEntity views = subsidyCategoryViewRankingsService.incrementMaleAdminStrativeSafetyViews(id);
        if (views != null) {
            return ResponseEntity.ok(views);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PutMapping("/increment/male/pregnancy-childbirth")
    public ResponseEntity<SubsidyCategoryViewRankingsEntity> incrementMalePregnancyChildbirth(@RequestParam Long id) {
        SubsidyCategoryViewRankingsEntity views = subsidyCategoryViewRankingsService.incrementMalePregnancyChildbirthViews(id);
        if (views != null) {
            return ResponseEntity.ok(views);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PutMapping("/increment/male/protective-care")
    public ResponseEntity<SubsidyCategoryViewRankingsEntity> incrementMaleProtectiveCare(@RequestParam Long id) {
        SubsidyCategoryViewRankingsEntity views = subsidyCategoryViewRankingsService.incrementMaleProtectiveCareViews(id);
        if (views != null) {
            return ResponseEntity.ok(views);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PutMapping("/increment/male/cultural-environment")
    public ResponseEntity<SubsidyCategoryViewRankingsEntity> incrementMaleCulturalEnvironment(@RequestParam Long id) {
        SubsidyCategoryViewRankingsEntity views = subsidyCategoryViewRankingsService.incrementMaleCulturalEnvironmentViews(id);
        if (views != null) {
            return ResponseEntity.ok(views);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PutMapping("/increment/male/agriculture-livestock-fisheries")
    public ResponseEntity<SubsidyCategoryViewRankingsEntity> incrementMaleAgricultureLivestockFisheries(@RequestParam Long id) {
        SubsidyCategoryViewRankingsEntity views = subsidyCategoryViewRankingsService.incrementMaleAgricultureLivestockFisheriesViews(id);
        if (views != null) {
            return ResponseEntity.ok(views);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }


    // female Female


    @PutMapping("/increment/female/daily-safety")
    public ResponseEntity<SubsidyCategoryViewRankingsEntity> incrementFemaleDailySafety(@RequestParam Long id) {
        SubsidyCategoryViewRankingsEntity views = subsidyCategoryViewRankingsService.incrementFemaleDailySafetyViews(id);
        if (views != null) {
            return ResponseEntity.ok(views);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PutMapping("/increment/female/housing-self-reliance")
    public ResponseEntity<SubsidyCategoryViewRankingsEntity> incrementFemaleHousingSelfReliance(@RequestParam Long id) {
        SubsidyCategoryViewRankingsEntity views = subsidyCategoryViewRankingsService.incrementFemaleHousingSelfRelianceViews(id);
        if (views != null) {
            return ResponseEntity.ok(views);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PutMapping("/increment/female/child-care-education")
    public ResponseEntity<SubsidyCategoryViewRankingsEntity> incrementFemaleChildCareEducation(@RequestParam Long id) {
        SubsidyCategoryViewRankingsEntity views = subsidyCategoryViewRankingsService.incrementFemaleChildCareEducationViews(id);
        if (views != null) {
            return ResponseEntity.ok(views);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PutMapping("/increment/female/employment-entrepreneurship")
    public ResponseEntity<SubsidyCategoryViewRankingsEntity> incrementFemaleEmploymentEntrepreneurship(@RequestParam Long id) {
        SubsidyCategoryViewRankingsEntity views = subsidyCategoryViewRankingsService.incrementFemaleEmploymentEntrepreneurshipViews(id);
        if (views != null) {
            return ResponseEntity.ok(views);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PutMapping("/increment/female/health-care")
    public ResponseEntity<SubsidyCategoryViewRankingsEntity> incrementFemaleHealthCare(@RequestParam Long id) {
        SubsidyCategoryViewRankingsEntity views = subsidyCategoryViewRankingsService.incrementFemaleHealthCareViews(id);
        if (views != null) {
            return ResponseEntity.ok(views);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PutMapping("/increment/female/admin-strative-safety")
    public ResponseEntity<SubsidyCategoryViewRankingsEntity> incrementFemaleAdminStrativeSafety(@RequestParam Long id) {
        SubsidyCategoryViewRankingsEntity views = subsidyCategoryViewRankingsService.incrementFemaleAdminStrativeSafetyViews(id);
        if (views != null) {
            return ResponseEntity.ok(views);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PutMapping("/increment/female/pregnancy-childbirth")
    public ResponseEntity<SubsidyCategoryViewRankingsEntity> incrementFemalePregnancyChildbirth(@RequestParam Long id) {
        SubsidyCategoryViewRankingsEntity views = subsidyCategoryViewRankingsService.incrementFemalePregnancyChildbirthViews(id);
        if (views != null) {
            return ResponseEntity.ok(views);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PutMapping("/increment/female/protective-care")
    public ResponseEntity<SubsidyCategoryViewRankingsEntity> incrementFemaleProtectiveCare(@RequestParam Long id) {
        SubsidyCategoryViewRankingsEntity views = subsidyCategoryViewRankingsService.incrementFemaleProtectiveCareViews(id);
        if (views != null) {
            return ResponseEntity.ok(views);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PutMapping("/increment/female/cultural-environment")
    public ResponseEntity<SubsidyCategoryViewRankingsEntity> incrementFemaleCulturalEnvironment(@RequestParam Long id) {
        SubsidyCategoryViewRankingsEntity views = subsidyCategoryViewRankingsService.incrementFemaleCulturalEnvironmentViews(id);
        if (views != null) {
            return ResponseEntity.ok(views);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PutMapping("/increment/female/agriculture-livestock-fisheries")
    public ResponseEntity<SubsidyCategoryViewRankingsEntity> incrementFemaleAgricultureLivestockFisheries(@RequestParam Long id) {
        SubsidyCategoryViewRankingsEntity views = subsidyCategoryViewRankingsService.incrementFemaleAgricultureLivestockFisheriesViews(id);
        if (views != null) {
            return ResponseEntity.ok(views);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }




































































}
