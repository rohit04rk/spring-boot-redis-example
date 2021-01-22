package com.example.dao;

import java.util.List;

import com.example.entity.User;
import com.example.model.UserModel;

public interface UserDao {

	UserModel saveUser(User user);

	UserModel userById(Integer userId);

	void deleteUser(Integer userId);

	List<UserModel> allUsers(Integer page);
}
