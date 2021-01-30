package com.cos.halfPizza.web;

import java.util.List;

import com.cos.halfPizza.anno.RequestMapping;
import com.cos.halfPizza.anno.RestController;
import com.cos.halfPizza.domain.CommonDto;
import com.cos.halfPizza.domain.store.Store;
import com.cos.halfPizza.domain.store.dto.SelectAreaReqDto;
import com.cos.halfPizza.domain.store.dto.SelectAreaRespDto;
import com.cos.halfPizza.domain.store.dto.SelectReqDto;
import com.cos.halfPizza.service.admin.StoreService;
import com.google.gson.Gson;

@RestController
public class StoreRestController {
	
	private StoreService storeService = new StoreService();
	
	@RequestMapping("/store/findPoint")
	public String findPoint(SelectAreaReqDto dto) {
		List<SelectAreaRespDto> entityDto = storeService.스토어지역찾기(dto);
		CommonDto<List<SelectAreaRespDto>> jsonData = new CommonDto<>();
		jsonData.setStatusCode(200);
		jsonData.setData(entityDto);
		Gson gson = new Gson();
		
		return gson.toJson(jsonData);
	}
	@RequestMapping("/store/findStore")
	public String findStore(SelectReqDto dto) {
		Store entityDto = storeService.스토어찾기(dto);
		CommonDto<Store> jsonData = new CommonDto<>();
		jsonData.setStatusCode(200);
		jsonData.setData(entityDto);
		Gson gson = new Gson();
		return gson.toJson(jsonData);
	}
}
