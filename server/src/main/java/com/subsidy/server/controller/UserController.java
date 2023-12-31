package com.subsidy.server.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
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
					.lifecycle(user.getLifeCycle())
					.age(user.getAge())

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

			LocalDate birthday = userDTO.getBirthday();

			// 회원가입 시 나이 검증
			if (userService.isValidAge(birthday)) {
				UserEntity user = UserEntity.builder()
						.email(userDTO.getEmail())
						.password(passwordEncoder.encode(userDTO.getPassword()))
						.name(userDTO.getName())
						.gender(userDTO.getGender())
						.birthday(birthday)
						.created_at(userDTO.getCreated_at())
						.updated_at(userDTO.getUpdated_at())
						.maritalStatus(userDTO.getMaritalStatus())
						.build();

				UserEntity registeredUser = userService.create(user);
				UserDTO responseUserDTO = UserDTO.builder()
						.id(registeredUser.getId())
						.email(registeredUser.getEmail())
						.password(passwordEncoder.encode(registeredUser.getPassword()))
						.gender(registeredUser.getGender())
						.birthday(birthday)
						.name(registeredUser.getName())
						.created_at(registeredUser.getCreated_at())
						.updated_at(registeredUser.getUpdated_at())
						.maritalStatus(userDTO.getMaritalStatus())
						.build();
				return ResponseEntity.ok().body(responseUserDTO);
			} else {
				throw new Exception("13세 미만의 회원은 가입할 수 없습니다.");
			}
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

			if(userDTO.getAge() > 12){
				existingUser.setAge(userDTO.getAge());
			}

			if(userDTO.getMaritalStatus() == 'M' || userDTO.getMaritalStatus() == 'S'){
				existingUser.setMaritalStatus(userDTO.getMaritalStatus());
			}


			userService.updateUser(existingUser);

			UserDTO responseUserDTO = UserDTO.builder()
					.email(existingUser.getEmail())
					.id(existingUser.getId())
					.name(existingUser.getName())
					.gender(existingUser.getGender())
					.created_at(existingUser.getCreated_at())
					.updated_at(existingUser.getUpdated_at())
					.password(null)
					.lifecycle(existingUser.getLifeCycle())
					.birthday(existingUser.getBirthday())
					.age(existingUser.getAge())
					.maritalStatus(existingUser.getMaritalStatus())
					.build();

			return ResponseEntity.ok().body(responseUserDTO);
		} catch (Exception e) {
			ResponseDTO responseDTO = ResponseDTO.builder().error(e.getMessage()).build();
			return ResponseEntity.badRequest().body(responseDTO);
		}
	}

	@PostMapping("/update/password")
	public ResponseEntity<?> updatePassword(@RequestBody UserDTO userDTO) {
		try {
			UserEntity user = userService.getUserById(userDTO.getId());

			if (user != null) {
				user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
				userService.updateUser(user);
				return ResponseEntity.ok(ResponseDTO.builder().message("Password change successful").build());
			} else {
				return ResponseEntity.notFound().build();
			}
		} catch (Exception e) {
			ResponseDTO responseDTO = ResponseDTO.builder().error(e.getMessage()).build();
			return ResponseEntity.badRequest().body(responseDTO);
		}
	}

	@GetMapping("/find/userId")
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


	@PostMapping("/add-category")
	public ResponseEntity<String> addUserCategory(@RequestParam String userId, @RequestParam String category) {
		userService.addUserCategory(userId, category);
		return ResponseEntity.ok("Category added successfully");
	}



	@DeleteMapping("/delete-category")
	public ResponseEntity<String> removeUserCategory(@RequestParam String userId, @RequestParam String category) {
		userService.deleteUserCategory(userId, category);
		return ResponseEntity.ok("Category removed successfully");
	}

	@GetMapping("/category-list")
	public ResponseEntity<List<String>> getUserCategoryList(@RequestParam String userId) {
		UserEntity user = userService.getUserById(userId);

		if (user != null && user.getCategoryList() != null) {
			return ResponseEntity.ok(user.getCategoryList());
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/delete")
	public ResponseEntity<String> deleteUser(@RequestParam String userId) {
		try {
			userService.deleteUser(userId);
			return new ResponseEntity<>("User deleted successfully", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>("Error deleting user: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}