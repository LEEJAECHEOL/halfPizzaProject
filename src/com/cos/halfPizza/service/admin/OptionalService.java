package com.cos.halfPizza.service.admin;

import java.util.List;

import com.cos.halfPizza.domain.admin.OptionalRepository;
import com.cos.halfPizza.domain.admin.dto.RegistOptionalReqDto;
import com.cos.halfPizza.domain.menu.Optional;

public class OptionalService {
	
	OptionalRepository optionalRepository = new OptionalRepository();
	
	public int 추가선택등록하기(RegistOptionalReqDto dto) {
		return optionalRepository.save(dto);
	}

	public List<Optional> 추가선택목록가져오기() {
		return optionalRepository.findAll();
	}

}
