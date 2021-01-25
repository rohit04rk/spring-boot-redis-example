package com.example.dao;

import java.util.List;

import com.example.entity.User;

public interface UserDao {

	User saveUser(User user);

	User userById(Integer userId);

	void deleteUser(Integer userId);

	List<User> allUsers(Integer page);
}
