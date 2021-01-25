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
	public UserModel addUser(UserDto userDto) {
		User user = mapper.convert(userDto, User.class);

		return mapper.convert(userDao.saveUser(user), UserModel.class);
	}

	@Override
	public UserModel getUser(Integer userId) {
		User user = userDao.userById(userId);

		return mapper.convert(user, UserModel.class);
	}

	@Override
	public void deleteUser(Integer userId) {
		userDao.deleteUser(userId);
	}

	@Override
	public List<UserModel> allUsers(Integer page) {

		return mapper.convertToList(userDao.allUsers(page), UserModel.class);
	}
}
