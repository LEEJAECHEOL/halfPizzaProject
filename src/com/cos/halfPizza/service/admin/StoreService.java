package com.cos.halfPizza.service.admin;

import java.util.List;

import com.cos.halfPizza.domain.admin.StoreRepository;
import com.cos.halfPizza.domain.admin.dto.StoreDeleteReqDto;
import com.cos.halfPizza.domain.admin.dto.StoreSaveReqDto;
import com.cos.halfPizza.domain.store.Store;
import com.cos.halfPizza.domain.store.dto.SelectAreaReqDto;
import com.cos.halfPizza.domain.store.dto.SelectAreaRespDto;
import com.cos.halfPizza.domain.store.dto.SelectReqDto;

public class StoreService {
	private StoreRepository storeRepository = new StoreRepository();
	
	public Store 스토어하나가져오기() {
		return storeRepository.selectOne();
	}
	
	public List<Store> 스토어리스트가져오기() {
		return storeRepository.findAll();
	}
	
	public int 스토어저장(StoreSaveReqDto dto) {
		return storeRepository.save(dto);
	}
	
	public int 스토어삭제(StoreDeleteReqDto dto) {
		return storeRepository.deleteById(dto);
	}
	
	public List<SelectAreaRespDto> 스토어지역찾기(SelectAreaReqDto dto) {
		return storeRepository.findByArea(dto);
	}
	public Store 스토어찾기(SelectReqDto dto) {
		return storeRepository.findById(dto);
	}
}
