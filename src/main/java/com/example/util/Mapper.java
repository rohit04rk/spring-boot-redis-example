package com.example.util;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.example.exception.CustomException;

@Component
public class Mapper {

	public <T> T convert(Object srcObj, Class<T> targetClass) {
		T response = null;

		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setAmbiguityIgnored(true);

		try {
			response = modelMapper.map(srcObj, targetClass);
		} catch (Exception e) {
			throw new CustomException(e.getMessage(), 500);
		}

		return response;
	}

	public <S, T> List<T> convertToList(List<S> srcList, Class<T> targetClass) {
		List<T> response = new ArrayList<>();

		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setAmbiguityIgnored(true);

		try {
			srcList.stream().forEach(source -> response.add(modelMapper.map(source, targetClass)));
		} catch (Exception e) {
			throw new CustomException(e.getMessage(), 500);
		}

		return response;
	}
}
