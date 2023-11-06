package com.subsidy.server.dto;

import java.sql.Date;
import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private String token;
    private String id;
    private String email;
    private String password;
    private String name;
    private char gender;
    private Date birthday;
    private Timestamp created_at;
    private Timestamp updated_at;

    // 비밀번호 재설정을 위한 변수 entity에는 정의되어있지 않음
    private String currentPassword;
    private String newPassword;
}