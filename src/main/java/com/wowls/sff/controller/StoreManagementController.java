package com.wowls.sff.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
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
	
	// 메뉴 등록 
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
	public ResponseEntity<List<Map<String,Object>>> showOwnMenuList(@PathVariable("storeId") String storeId) {
		Map<String,String> storeManagementMap = new HashMap<String,String>();
		storeManagementMap.put("storeId", storeId);
		return new ResponseEntity<>(storeManagementService.showOwnMenuList(storeManagementMap),HttpStatus.OK);
	}
	
	// 가게 정보 수정 
	@PutMapping("/stores/{storeId}")
	public ResponseEntity<List<Map<String,Object>>> modifyStoreInfo(@PathVariable("storeId") String storeId,
															 	    @RequestBody Map<String,String> storeMap) {
		storeMap.put("storeId", storeId);
		storeManagementService.modifyStoreInfo(storeMap);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	// 메뉴 정보 수정 
	@PutMapping("/stores/{storeId}/menus/{menuName}")
	public ResponseEntity<List<Map<String,Object>>> modifyMenuInfo(@PathVariable("storeId") String storeId,
																   @PathVariable("menuName") String menuName,
																   @RequestBody Map<String,String> menuMap) {
		menuMap.put("storeId", storeId);
		menuMap.put("menuName", menuName);
		storeManagementService.modifyMenuInfo(menuMap);
		return new ResponseEntity<>(HttpStatus.OK);
	}		
	
	// 가게 정보 삭제
	@DeleteMapping("/stores/{storeId}")
	public ResponseEntity<List<Map<String,Object>>> removeOwnStoreInfo(@PathVariable("storeId") String storeId) {
		Map<String,String> storeManagementMap = new HashMap<String,String>(); 
		storeManagementMap.put("storeId", storeId);
		return new ResponseEntity<>(storeManagementService.showOwnMenuList(storeManagementMap),HttpStatus.OK);
	}
	
	// 메뉴 정보 삭제 
	@DeleteMapping("/stores/{storeId}/menus/{menuName}")
	public ResponseEntity<List<Map<String,Object>>> removeMenuInfo(@PathVariable("storeId") String storeId,
																   @PathVariable("menuName") String menuName) {
		Map<String,String> menuMap = new HashMap<String,String>(); 
		menuMap.put("storeId", storeId);
		menuMap.put("menuName", menuName);
		storeManagementService.removeMenuInfo(menuMap);
		return new ResponseEntity<>(HttpStatus.OK);
	}		
}
