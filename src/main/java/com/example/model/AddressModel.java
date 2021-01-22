package com.example.model;

import java.io.Serializable;

import lombok.Data;

@Data
public class AddressModel implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer addressId;

	private String country;

	private String state;

	private String city;
}
