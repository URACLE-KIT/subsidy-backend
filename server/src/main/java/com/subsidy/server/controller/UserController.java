package com.subsidy.server.controller;

import java.sql.Date;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.subsidy.server.dto.ResponseDTO;
import com.subsidy.server.dto.UserDTO;
import com.subsidy.server.model.UserEntity;
import com.subsidy.server.security.TokenProvider;
import com.subsidy.server.service.UserService;

@RestController
@RequestMapping("/auth")
public class UserController {
	@Autowired
	private UserService userService;
	
	@Autowired
	private TokenProvider tokenProvider;
	
	private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	
	@PostMapping("/signup")
	public ResponseEntity<?> registerUser(@RequestBody UserDTO userDTO) {
	    try {
	        if (userService.existsByEmail(userDTO.getEmail())) {
	            throw new Exception("이미 가입된 이메일 주소");
	        }

	        UserEntity user = UserEntity.builder()
	                .email(userDTO.getEmail())
	                .password(passwordEncoder.encode(userDTO.getPassword()))
					.name(userDTO.getName())
					.created_at(userDTO.getCreated_at())
					.updated_at(userDTO.getUpdated_at())
	                .build();

	        UserEntity registeredUser = userService.create(user);
	        UserDTO responseUserDTO = UserDTO.builder()
					.id(registeredUser.getId())
					.email(userDTO.getEmail())
					.password(passwordEncoder.encode(userDTO.getPassword()))
					.name(userDTO.getName())
					.created_at(userDTO.getCreated_at())
					.updated_at(userDTO.getUpdated_at())
	                .build();
	        return ResponseEntity.ok().body(responseUserDTO);
	    } catch (Exception e) {
	        ResponseDTO responseDTO = ResponseDTO.builder().error(e.getMessage()).build();
	        return ResponseEntity.badRequest().body(responseDTO);
	    }
	}
	
	@PostMapping("/signin")
	public ResponseEntity<?> authenticate(@RequestBody UserDTO userDTO) {
	    try {
	        UserEntity user = userService.getByCredentials(
	                userDTO.getEmail(),
	                userDTO.getPassword(),
	                passwordEncoder);

	        if (user == null) {
	            throw new Exception("로그인 실패");
	        }

	        final String token = tokenProvider.create(user);
	        final UserDTO responseUserDTO = UserDTO.builder()
	                .email(user.getEmail())
	                .id(user.getId())
	                .name(user.getName())
	                .token(token)
	                .build();

	        return ResponseEntity.ok().body(responseUserDTO);
	    } catch (Exception e) {
	        ResponseDTO responseDTO = ResponseDTO.builder()
	                .error(e.getMessage())
	                .build();
	        return ResponseEntity.badRequest().body(responseDTO);
	    }
	}

	@PatchMapping("/update/{id}")
	public ResponseEntity<?> updateUser(@PathVariable String id, @RequestBody UserDTO userDTO) {
	    try {
	        UserEntity existingUser = userService.getUserById(id);

	        if (existingUser == null) {
	            return ResponseEntity.notFound().build();
	        }

	        if (userDTO.getName() != null) {
	            existingUser.setName(userDTO.getName());
	        }

	        if (userDTO.getPassword() != null) {
	            existingUser.setPassword(passwordEncoder.encode(userDTO.getPassword()));
	        }

			if (userDTO.getUpdated_at() != null) {
				existingUser.setUpdated_at(userDTO.getUpdated_at());
			}

	        userService.updateUser(existingUser);

	        UserDTO responseUserDTO = UserDTO.builder()
	            .email(existingUser.getEmail())
	            .id(existingUser.getId())
	            .name(existingUser.getName())
				.password(passwordEncoder.encode(userDTO.getPassword()))
				.created_at(userDTO.getCreated_at())
				.updated_at(userDTO.getUpdated_at())
	            .build();

	        return ResponseEntity.ok().body(responseUserDTO);
	    } catch (Exception e) {
	        ResponseDTO responseDTO = ResponseDTO.builder().error(e.getMessage()).build();
	        return ResponseEntity.badRequest().body(responseDTO);
	    }
	}
	
	@DeleteMapping("/withdrawal")
	public ResponseEntity<?> deleteUser(@RequestBody UserDTO userDTO) {
	    try {
	        boolean deleted = userService.deleteUser(
	                userDTO.getEmail(), 
	                userDTO.getPassword(), 
	                passwordEncoder);

	        if (!deleted) {
	            throw new Exception("이메일 또는 비밀번호가 올바르지 않습니다.");
	        }

	        return ResponseEntity.ok().body(ResponseDTO.builder().message("Successfully deleted user").build());
	    } catch (Exception e) {
	        ResponseDTO responseDTO = ResponseDTO.builder().error(e.getMessage()).build();
	        return ResponseEntity.badRequest().body(responseDTO);
	    }
	}
	
	@GetMapping("/find/{email}")
    public ResponseEntity<?> findUserIdByEmail(@PathVariable String email) {
        try {
            String userId = userService.getUserIdByEmail(email);

            if (userId != null) {
                return ResponseEntity.ok(Map.of("id", userId));
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
	
	@PostMapping("/reset")
    public ResponseEntity<?> resetPassword(@RequestParam String id, @RequestParam String newPassword) {
        try {
            UserEntity user = userService.getUserById(id);

            if (user != null) {
                user.setPassword(passwordEncoder.encode(newPassword));
                userService.updateUser(user);
                return ResponseEntity.ok(ResponseDTO.builder().message("비밀번호 변경 성공").build());
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            ResponseDTO responseDTO = ResponseDTO.builder().error(e.getMessage()).build();
            return ResponseEntity.badRequest().body(responseDTO);
        }
    }
	
	@GetMapping("/checkUsername/{name}")
	public ResponseEntity<?> checkUsername(@PathVariable String name) {
	    boolean usernameExists = userService.existsByName(name);

	    if (usernameExists) {
	        return ResponseEntity.ok(Map.of("exists", true));
	    } else {
	        return ResponseEntity.ok(Map.of("exists", false));
	    }
	}
	
	@GetMapping("/checkEmail/{email}")
	public ResponseEntity<?> checkEmail(@PathVariable String email) {
	    boolean emailExists = userService.existsByEmail(email);

	    if (emailExists) {
	        return ResponseEntity.ok(Map.of("exists", true));
	    } else {
	        return ResponseEntity.ok(Map.of("exists", false));
	    }
	}
}