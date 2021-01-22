package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.UserDto;
import com.example.model.UserModel;
import com.example.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("add-user")
	public ResponseEntity<String> addUser(@RequestBody UserDto userDto) {

		userService.addUser(userDto);

		return new ResponseEntity<String>("User added successfully", HttpStatus.OK);
	}

	@GetMapping("users/{userId}")
	public ResponseEntity<UserModel> getUser(@PathVariable Integer userId) {

		UserModel userModel = userService.getUser(userId);

		return new ResponseEntity<UserModel>(userModel, HttpStatus.OK);
	}

	@DeleteMapping("users/{userId}")
	public ResponseEntity<String> deleteUser(@PathVariable Integer userId) {

		userService.deleteUser(userId);

		return new ResponseEntity<String>("User deleted successfully", HttpStatus.OK);
	}

	@GetMapping("users")
	public ResponseEntity<List<UserModel>> allUsers(@RequestParam(defaultValue = "1") Integer page) {

		List<UserModel> userModels = userService.allUsers(page);

		return new ResponseEntity<List<UserModel>>(userModels, HttpStatus.OK);
	}
}
