package com.subsidy.server.model;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Entity
@Table(name = "SUBSIDYPROMOTION")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PromotionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "P_ID")
    private Long id;

    @Column(name = "P_USERID", nullable = false)
    private String user_id;

    @Column(name = "P_TITLE", nullable = false)
    private String title;

    @Column(name = "P_CONTENT", nullable = false)
    private String content;

    @Column(name = "P_IMG", nullable = false)
    private String img;

    @Column(name = "P_LIKES", nullable = false)
    private int likes;

    @Column(name = "P_VIEWS", nullable = false)
    private int views;

    @Column(name = "P_CREATED", nullable = false)
    private Date created_at;

    @Column(name = "P_UPDATED", nullable = false)
    private Date updated_at;
}