package com.cos.halfPizza.service;

import java.util.List;

import com.cos.halfPizza.domain.menu.Optional;
import com.cos.halfPizza.domain.menu.OptionalRepository;

public class OptionalService {
	private OptionalRepository optionalRepository = new OptionalRepository();
	
	public List<Optional> �߰����ø�ϰ�������() {
		return optionalRepository.findAll();
	}
	
}