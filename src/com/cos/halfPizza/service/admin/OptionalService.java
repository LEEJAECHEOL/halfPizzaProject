package com.cos.halfPizza.service.admin;

import java.util.List;

import com.cos.halfPizza.domain.admin.OptionalRepository;
import com.cos.halfPizza.domain.admin.dto.RegistOptionalReqDto;
import com.cos.halfPizza.domain.menu.Optional;

public class OptionalService {
	
	OptionalRepository optionalRepository = new OptionalRepository();
	
	public int �߰����õ���ϱ�(RegistOptionalReqDto dto) {
		return optionalRepository.save(dto);
	}

	public List<Optional> �߰����ø�ϰ�������() {
		return optionalRepository.findAll();
	}

}