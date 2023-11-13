package com.subsidy.server.model;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UpdateTimestamp;


@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "USERS", uniqueConstraints = {@UniqueConstraint(columnNames = "email")})
public class UserEntity {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @Column(name = "id")
    private String id;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "gender", nullable = false)
    private char gender;

    @Column(name = "birthday")
    private LocalDate birthday;

    @Column(name = "created_at", nullable = false, updatable = false)
    @CreationTimestamp
    private Timestamp created_at;

    @Column(name = "updated_at", nullable = false)
    @UpdateTimestamp
    private Timestamp updated_at;

    @Column(name = "age")
    private int age;

    @Enumerated(EnumType.STRING)
    private LifeCycle lifeCycle;

    @Column(name = "marital_status")
    private boolean maritalStatus;

    @ElementCollection
    @CollectionTable(name = "category_list", joinColumns = @JoinColumn(name = "user_id"))
    @Column(name = "category")
    private List<String> categoryList;

    @PrePersist
    @PreUpdate
    private void calculateAgeAndLifeCycle() {
        if (birthday != null) {
            LocalDate currentDate = LocalDate.now();
            LocalDate birthDate = birthday;
            this.age = Period.between(birthDate, currentDate).getYears();
            calculateLifeCycleEnum();
        }
    }

    private void calculateLifeCycleEnum() {
        if (age >= 13 && age < 19) {
            lifeCycle = LifeCycle.Teenager;
        } else if (age >= 19 && age < 30) {
            lifeCycle = LifeCycle.Youth;
        } else if (age >= 30 && age < 50) {
            lifeCycle = LifeCycle.MiddleAge;
        } else if (age >= 50 && age < 65) {
            lifeCycle = LifeCycle.Senior;
        } else if (age >= 65) {
            lifeCycle = LifeCycle.Elderly;
        }
    }


    public void addCategory(String category) {
        if (this.categoryList == null) {
            this.categoryList = new ArrayList<>();
        }
        this.categoryList.add(category);
    }

    public void removeCategory(String category) {
        if (this.categoryList != null) {
            this.categoryList.remove(category);
        }
    }


}