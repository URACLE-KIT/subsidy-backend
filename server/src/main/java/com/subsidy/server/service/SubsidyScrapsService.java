package com.subsidy.server.service;

import com.subsidy.server.model.SubsidiesEntity;
import com.subsidy.server.model.SubsidyScrapsEntity;
import com.subsidy.server.model.UserEntity;
import com.subsidy.server.persistence.SubsidiesRepository;
import com.subsidy.server.persistence.SubsidyScrapsRepository;
import com.subsidy.server.persistence.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.*;

@Slf4j
@Service
public class SubsidyScrapsService {

    private final SubsidyScrapsRepository subsidyScrapsRepository;

    @Autowired
    public SubsidyScrapsService(SubsidyScrapsRepository subsidyScrapsRepository) {
        this.subsidyScrapsRepository = subsidyScrapsRepository;
    }

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SubsidiesRepository subsidiesRepository;

    public SubsidyScrapsEntity createSubsidyScrap(String userId, Long subsidyId) {
        UserEntity user = userRepository.findById(userId).orElse(null);
        SubsidiesEntity subsidy = subsidiesRepository.findById(subsidyId).orElse(null);

        if (user != null && subsidy != null) {
            SubsidyScrapsEntity scrap = new SubsidyScrapsEntity();
            scrap.setUser(user);
            scrap.setSubsidy(subsidy);
            return subsidyScrapsRepository.save(scrap);
        } else {
            return null;
        }
    }

    public List<SubsidiesEntity> getSubsidyInfoByUserId(String userId) {
        List<SubsidiesEntity> subsidiesList = new ArrayList<>();

        List<SubsidyScrapsEntity> scraps = subsidyScrapsRepository.findByUserId(userId);

        for (SubsidyScrapsEntity scrap : scraps) {
            SubsidiesEntity subsidy = scrap.getSubsidy();

            if (subsidy != null) {
                subsidiesList.add(subsidy);
            }
        }
        return subsidiesList;
    }

    public boolean deleteScrapById(Long scrapId) {
        if (scrapId != null) {
            if (subsidyScrapsRepository.existsById(scrapId)) {
                subsidyScrapsRepository.deleteById(scrapId);
                return true;
            }
        }
        return false;
    }

    @Transactional
    public void deleteSubsidyScrapsBySubsidyId(Long subsidyId) {
        subsidyScrapsRepository.deleteBySubsidyId(subsidyId);
    }



}
