package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.UserDao;
import com.example.entity.User;
import com.example.model.UserDto;
import com.example.model.UserModel;
import com.example.util.Mapper;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	@Autowired
	private Mapper mapper;

	@Override
	public void addUser(UserDto userDto) {
		User user = mapper.convert(userDto, User.class);

		userDao.saveUser(user);
	}

	@Override
	public UserModel getUser(Integer userId) {

		return userDao.userById(userId);
	}

	@Override
	public void deleteUser(Integer userId) {
		userDao.deleteUser(userId);
	}

	@Override
	public List<UserModel> allUsers(Integer page) {
		
		return userDao.allUsers(page);
	}
}
