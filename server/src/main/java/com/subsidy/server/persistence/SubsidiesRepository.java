package com.subsidy.server.persistence;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.subsidy.server.model.SubsidiesEntity;

@Repository
public interface SubsidiesRepository extends JpaRepository<SubsidiesEntity, Long> {
    List<SubsidiesEntity> findByTitleContaining(String title);
    List<SubsidiesEntity> findByCategoryContaining(String category);
    List<SubsidiesEntity> findByDescriptionContaining(String description);



}