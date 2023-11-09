package com.subsidy.server.controller;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
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
@RequestMapping("v1/users")
public class UserController {
	@Autowired
	private UserService userService;
	
	@Autowired
	private TokenProvider tokenProvider;
	
	private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
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
					.gender(user.getGender())
					.birthday(user.getBirthday())
					.created_at(user.getCreated_at())
					.updated_at(user.getUpdated_at())
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
					.gender(userDTO.getGender())
					.birthday(userDTO.getBirthday())
					.created_at(userDTO.getCreated_at())
					.updated_at(userDTO.getUpdated_at())
	                .build();

	        UserEntity registeredUser = userService.create(user);
	        UserDTO responseUserDTO = UserDTO.builder()
					.id(registeredUser.getId())
					.email(userDTO.getEmail())
					.password(passwordEncoder.encode(userDTO.getPassword()))
					.gender(userDTO.getGender())
					.birthday(userDTO.getBirthday())
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


	@PatchMapping("/update")
	public ResponseEntity<?> updateUser(@RequestParam String id, @RequestBody UserDTO userDTO) {
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

			if (userDTO.getBirthday() != null) {
				existingUser.setBirthday(userDTO.getBirthday());
			}

			userService.updateUser(existingUser);

			UserDTO responseUserDTO = UserDTO.builder()
					.email(existingUser.getEmail())
					.id(existingUser.getId())
					.name(existingUser.getName())
					.birthday(existingUser.getBirthday())
					.password(null)
					.created_at(userDTO.getCreated_at())
					.updated_at(userDTO.getUpdated_at())
					.build();

			return ResponseEntity.ok().body(responseUserDTO);
		} catch (Exception e) {
			ResponseDTO responseDTO = ResponseDTO.builder().error(e.getMessage()).build();
			return ResponseEntity.badRequest().body(responseDTO);
		}
	}

	@DeleteMapping("/delete")
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


	@PostMapping("/update/password")
	public ResponseEntity<?> updatePassword(@RequestBody UserDTO userDTO) {
		try {
			UserEntity user = userService.getUserByEmail(userDTO.getEmail());


			if (user != null) {
				if (passwordEncoder.matches(userDTO.getCurrentPassword(), user.getPassword())) {
					user.setPassword(passwordEncoder.encode(userDTO.getNewPassword()));
					userService.updateUser(user);
					return ResponseEntity.ok(ResponseDTO.builder().message("Password change successful").build());
				} else {
					return ResponseEntity.badRequest().body(ResponseDTO.builder().error("Current password is incorrect").build());
				}
			} else {
				return ResponseEntity.notFound().build();
			}
		} catch (Exception e) {
			ResponseDTO responseDTO = ResponseDTO.builder().error(e.getMessage()).build();
			return ResponseEntity.badRequest().body(responseDTO);
		}
	}


	@GetMapping("/find/userid")
	public ResponseEntity<?> findUserIdByEmail(@RequestParam String email) {
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


	@GetMapping("/check/email")
	public ResponseEntity<?> checkEmail(@RequestParam String email) {
		boolean emailExists = userService.existsByEmail(email);

		if (emailExists) {
			return ResponseEntity.ok(Map.of("exists", true));
		} else {
			return ResponseEntity.ok(Map.of("exists", false));
		}
	}

}