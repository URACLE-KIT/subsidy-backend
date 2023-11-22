package com.subsidy.server.service;

import com.subsidy.server.model.UserEntity;
import com.subsidy.server.persistence.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.Period;
import java.util.Collections;
import java.util.List;

@Slf4j
@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public UserEntity create(final UserEntity userEntity) {
        if (userEntity == null || userEntity.getEmail() == null || userEntity.getName() == null) {
            throw new RuntimeException("이메일 또는 닉네임에 null이 들어갈 수 없음");
        }

        final String email = userEntity.getEmail();

        if (existsByEmail(email)) {
            log.warn("이메일 중복: {}", email);
            throw new RuntimeException("이메일 중복");
        }

        return userRepository.save(userEntity);
    }

    public UserEntity getByCredentials(final String email, final String password, final PasswordEncoder encoder) {
        final UserEntity originalUser = userRepository.findByEmail(email);

        if (originalUser != null &&
                encoder.matches(password,
                        originalUser.getPassword())) {
            return originalUser;
        }
        return null;
    }

    public void updateUser(final UserEntity userEntity) {
        userRepository.save(userEntity);
    }

    public UserEntity getUser(final String email) {
        return userRepository.findByEmail(email);
    }

    public String getUserIdByEmail(String email) {
        UserEntity user = userRepository.findByEmail(email);

        if (user != null) {
            return user.getId();
        } else {
            log.warn("사용자를 찾을 수 없음: {}", email);
            return null;
        }
    }
    public UserEntity getUserById(String id) {
        return userRepository.findUserById(id).orElse(null);
    }

    public UserEntity getUserByEmail(String email) {
        return userRepository.findUserByEmail(email).orElse(null);
    }

    public boolean existsByEmail(String email) {
        return userRepository.existsByEmail(email);
    }

    public boolean isValidAge(LocalDate birthday) {
        int age = calculateAge(birthday);
        return age >= 13;
    }

    private int calculateAge(LocalDate birthday) {
        LocalDate currentDate = LocalDate.now();
        return Period.between(birthday, currentDate).getYears();
    }

    public void addUserCategory(String userId, String category) {
        UserEntity user = userRepository.findById(userId).orElse(null);
        if (user != null) {
            user.addCategory(category);
            userRepository.save(user);
        }
    }

    public void deleteUserCategory(String userId, String category) {
        UserEntity user = userRepository.findById(userId).orElse(null);
        if (user != null) {
            user.removeCategory(category);
            userRepository.save(user);
        }
    }

    public List<String> getUserCategoryList(String userId) {
        UserEntity user = userRepository.findById(userId).orElse(null);

        if (user != null && user.getCategoryList() != null) {
            return user.getCategoryList();
        } else {
            return Collections.emptyList();
        }
    }

    @Transactional
    public void deleteUser(String userId) {
        UserEntity user = userRepository.findById(userId).orElse(null);
        if (user != null) {
            userRepository.delete(user);
        }
    }



}
