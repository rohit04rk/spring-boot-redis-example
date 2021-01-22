package com.example.model;

import java.util.List;

import lombok.Getter;

@Getter
public class UserDto {

	private String firstName;

	private String lastName;

	private String email;

	private String mobile;

	private List<AddressDto> address;
}
