package com.example.model;

import java.io.Serializable;

import lombok.Data;

@Data
public class UserModel implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer userId;

	private String firstName;

	private String lastName;

	private String email;

	private String mobile;

}
