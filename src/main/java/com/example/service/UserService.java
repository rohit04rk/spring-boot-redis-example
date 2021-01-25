package com.example.service;

import java.util.List;

import com.example.model.UserDto;
import com.example.model.UserModel;

public interface UserService {

	UserModel addUser(UserDto userDto);

	UserModel getUser(Integer userId);

	void deleteUser(Integer userId);

	List<UserModel> allUsers(Integer page);

}
