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
@Table(name = "SUBSIDYELDERLYVIEWRANKINGS")

public class SubsidyElderlyViewRankingsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "subsidy_id", referencedColumnName = "id")
    private SubsidiesEntity subsidy;

    @Column(name = "subsidy_elderly_views", columnDefinition = "INT DEFAULT 0")
    private int views;
}
