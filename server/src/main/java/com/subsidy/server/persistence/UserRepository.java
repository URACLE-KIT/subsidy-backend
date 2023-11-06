package com.subsidy.server.persistence;

import java.util.Optional;

import com.subsidy.server.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, String> {
    UserEntity findByEmail(String email);
    Optional<UserEntity> findUserById(String id);
    Optional<UserEntity> findUserByEmail(String email);
    Boolean existsByEmail(String email);
}
