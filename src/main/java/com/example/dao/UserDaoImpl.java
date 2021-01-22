package com.example.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;

import com.example.entity.User;
import com.example.exception.CustomException;
import com.example.model.UserModel;
import com.example.repository.UserRepo;
import com.example.util.Mapper;

@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	private Mapper mapper;

	@Autowired
	private UserRepo userRepo;

	@Override
	@CachePut(value = "user", key = "#user.getUserId()")
	public UserModel saveUser(User user) {
		try {
			return mapper.convert(userRepo.save(user), UserModel.class);
		} catch (Exception e) {
			throw new CustomException("Error while saving user", 500);
		}
	}

	@Override
	@Cacheable(value = "user", key = "#userId")
	public UserModel userById(Integer userId) {

		Optional<User> optional = userRepo.findByUserId(userId);
		if (optional.isPresent()) {

			return mapper.convert(optional.get(), UserModel.class);
		} else {
			throw new CustomException("User not found", 400);
		}
	}

	@Override
	@Caching(evict = { @CacheEvict(value = "usersList", allEntries = true),
			@CacheEvict(value = "user", key = "#userId"), })
	public void deleteUser(Integer userId) {
		try {
			userRepo.deleteById(userId);
		} catch (Exception e) {
			throw new CustomException("Error while deleting user", 500);
		}
	}

	@Override
	@Cacheable(value = "usersList", key = "#page")
	public List<UserModel> allUsers(Integer page) {

		Page<User> users = userRepo.findAll(PageRequest.of(--page, 5));

		if (users.isEmpty()) {
			throw new CustomException("Users not found", 400);
		}

		return mapper.convertToList(users.getContent(), UserModel.class);
	}
}
