package com.cos.halfPizza.service.admin;

import java.util.List;

import com.cos.halfPizza.domain.admin.StoreRepository;
import com.cos.halfPizza.domain.admin.dto.StoreDeleteReqDto;
import com.cos.halfPizza.domain.admin.dto.StoreSaveReqDto;
import com.cos.halfPizza.domain.store.Store;

public class StoreService {
	private StoreRepository storeRepository = new StoreRepository();
	
	public List<Store> 스토어리스트가져오기() {
		return storeRepository.findAll();
	}
	
	public int 스토어저장(StoreSaveReqDto dto) {
		return storeRepository.save(dto);
	}
	
	public int 스토어삭제(StoreDeleteReqDto dto) {
		return storeRepository.deleteById(dto);
	}
}
