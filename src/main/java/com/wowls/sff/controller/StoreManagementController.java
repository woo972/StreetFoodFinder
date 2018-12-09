package com.wowls.sff.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wowls.sff.service.StoreManagementService;

@RestController
@RequestMapping("/store-management*")
public class StoreManagementController {
	
	@Autowired
	private StoreManagementService storeManagementService;
	
	// 가게 등록 
	@PostMapping("/owners/{ownerId}")
	public ResponseEntity<List<Map<String,Object>>> saveStoreInfo(@PathVariable("ownerId") String ownerId,
																  @RequestBody Map<String,String> storeMap) {
		storeMap.put("ownerId", ownerId);
		storeManagementService.saveStoreInfo(storeMap);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}		
	
	// 특정 가게에 메뉴 등록 
	@PostMapping("/stores/{storeId}")
	public ResponseEntity<List<Map<String,Object>>> saveMenuInfo(@PathVariable("storeId") String storeId,
																 @RequestBody Map<String,String> menuMap) {
		menuMap.put("storeId", storeId);
		storeManagementService.saveMenuInfo(menuMap);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}		
	
	// 점주가 보유한 가게 목록 가져오기
	@GetMapping("/owners/{ownerId}")
	public ResponseEntity<List<Map<String,Object>>> showStoreList(@PathVariable("ownerId") String ownerId) {
		Map<String,String> storeManagementMap = new HashMap<String,String>();
		storeManagementMap.put("ownerId", ownerId);
		return new ResponseEntity<>(storeManagementService.showOwnStoreList(storeManagementMap),HttpStatus.OK);
	}
	
	// 가게가 보유한 메뉴 가져오기
	@GetMapping("/stores/{storeId}")
	public ResponseEntity<List<Map<String,Object>>> showOwnMenuList(@PathVariable("ownerId") String ownerId,
																    @PathVariable("storeId") String storeId) {
		Map<String,String> storeManagementMap = new HashMap<String,String>();
		storeManagementMap.put("ownerId", ownerId);
		storeManagementMap.put("storeId", storeId);
		return new ResponseEntity<>(storeManagementService.showOwnMenuList(storeManagementMap),HttpStatus.OK);
	}
	
	// 가게 정보 / 메뉴 정보 수정 
	@PutMapping("/stores/{storeId}")
	public ResponseEntity<List<Map<String,Object>>> modifyStoreInfo(@PathVariable("storeId") String storeId,
															 	    @RequestBody Map<String,String> storeMap) {
		storeMap.put("storeId", storeId);
		storeManagementService.modifyStoreInfo(storeMap);
		storeManagementService.modifyMenuInfo(storeMap);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}		
	
//	// 가게 정보 삭제
//	@DeleteMapping("/owners/{ownerId}/stores/{storeId}")
//	public ResponseEntity<List<Map<String,Object>>> removeOwnStoreInfo(@PathVariable("ownerId") String ownerId,
//																	   @PathVariable("storeId") String storeId) {
//		Map<String,String> storeManagementMap = new HashMap<String,String>(); 
//		storeManagementMap.put("ownerId", ownerId);
//		storeManagementMap.put("storeId", storeId);
//		return new ResponseEntity<>(storeManagementService.showOwnMenuList(storeManagementMap),HttpStatus.OK);
//	}
//	
//	// 메뉴 정보 삭제 
//	@DeleteMapping("/stores/{storeId}/menus/")
//	public ResponseEntity<List<Map<String,Object>>> modifyStoreInfo(@PathVariable("storeId") String storeId,
//																    @RequestBody Map<String,String> storeMap) {
//		storeMap.put("storeId", storeId);
//		storeManagementService.modifyStoreInfo(storeMap);
//		storeManagementService.modifyMenuInfo(storeMap);
//		return new ResponseEntity<>(HttpStatus.CREATED);
//	}		
}
