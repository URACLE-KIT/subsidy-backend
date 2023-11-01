package com.subsidy.server.dto;

import java.sql.Date;
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
    private String gender;
    private Date birthday;
    private Date created_at;
    private Date updated_at;
}