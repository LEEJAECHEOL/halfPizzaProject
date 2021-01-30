package com.cos.halfPizza.web;

import com.cos.halfPizza.anno.RequestMapping;
import com.cos.halfPizza.anno.RestController;
import com.cos.halfPizza.domain.CommonDto;
import com.cos.halfPizza.domain.admin.dto.StoreDeleteReqDto;
import com.cos.halfPizza.service.admin.StoreService;
import com.google.gson.Gson;

@RestController
public class AdminStoreRestController {
	
	private StoreService storeService = new StoreService();
	
	@RequestMapping("/admin/store/delete")
	public String delete(StoreDeleteReqDto dto) {
		int result = storeService.스토어삭제(dto);
		CommonDto<String> data = new CommonDto<String>();
		if(result == 1) {
			data.setStatusCode(200);
			data.setData("ok");
		}else {
			data.setStatusCode(400);
			data.setData("no");
		}
		Gson gson = new Gson();
		String json = gson.toJson(data);
		return json;
	}
}
