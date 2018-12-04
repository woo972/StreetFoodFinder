package com.wowls.sff.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wowls.sff.service.StoreManagementService;

@RestController
@RequestMapping("/storeManagement/*")
public class StoreManagementController {
	
	@Autowired
	private StoreManagementService storeManagementService;
	
	// 점주가 보유한 가게 목록 가져오기
	@GetMapping("/owner/{ownerId}")
	public ResponseEntity<List<Map<String,String>>> showStoreList(@PathVariable("ownerId") String ownerId) {
		Map<String,String> storeManagementMap = new HashMap<String,String>();
		storeManagementMap.put("ownerId", ownerId);
		return new ResponseEntity<>(storeManagementService.showOwnStoreList(storeManagementMap),HttpStatus.OK);
	}
	
	// 가게가 보유한 메뉴 가져오기
	@GetMapping("/owner/{ownerId}/store/{storeId}")
	public ResponseEntity<List<Map<String,String>>> showOwnMenuList(@PathVariable("ownerId") String ownerId,
																 @PathVariable("storeId") String storeId) {
		Map<String,String> storeManagementMap = new HashMap<String,String>();
		storeManagementMap.put("ownerId", ownerId);
		storeManagementMap.put("storeId", storeId);
		return new ResponseEntity<>(storeManagementService.showOwnMenuList(storeManagementMap),HttpStatus.OK);
	}	
}
