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
import com.wowls.sff.service.UserService;

@RestController
@RequestMapping("/store-management*")
public class StoreManagementController {
	
	@Autowired
	private StoreManagementService storeManagementService;
	private UserService userService;
	
	// 가게 등록 
	@PostMapping("/owners/{ownerId}")
	public ResponseEntity<List<Map<String,Object>>> saveStoreInfo(@PathVariable("ownerId") String ownerId,
																  @RequestBody Map<String,String> storeMap) {
		// 존재하는 유저만이 상점 개설 가능
		storeMap.put("userId", ownerId);
		if(!userService.showUserInfo(storeMap).isEmpty()) {
			storeMap.put("ownerId", ownerId);
			int rsltCode = storeManagementService.saveStoreInfo(storeMap);
			if(rsltCode > 0) {
				return new ResponseEntity<>(HttpStatus.CREATED);
			}else {
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			}
		}else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}		
	
	// 메뉴 등록 
	@PostMapping("/stores/{storeId}")
	public ResponseEntity<List<Map<String,Object>>> saveMenuInfo(@PathVariable("storeId") String storeId,
																 @RequestBody Map<String,String> menuMap) {
		// 존재하는 가게 일 때만 메뉴 등록 가능
		menuMap.put("storeId", storeId);
		if(!storeManagementService.showOwnStoreList(menuMap).isEmpty()) {
			int rsltCode = storeManagementService.saveMenuInfo(menuMap);
			if(rsltCode > 0) {
				return new ResponseEntity<>(HttpStatus.CREATED);
			}else {
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			}
		}else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
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
	public ResponseEntity<Void> modifyStoreInfo(@PathVariable("storeId") String storeId,
															 	    @RequestBody Map<String,String> storeMap) {
		storeMap.put("storeId", storeId);
		int rsltCode = storeManagementService.modifyStoreInfo(storeMap);
		if(rsltCode > 0) {
			return new ResponseEntity<>(HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	// 메뉴 정보 수정 
	@PutMapping("/stores/{storeId}/menus/{menuName}")
	public ResponseEntity<Void> modifyMenuInfo(@PathVariable("storeId") String storeId,
																   @PathVariable("menuName") String menuName,
																   @RequestBody Map<String,String> menuMap) {
		menuMap.put("storeId", storeId);
		menuMap.put("menuName", menuName);
		int rsltCode = storeManagementService.modifyMenuInfo(menuMap);
		if(rsltCode > 0) {
			return new ResponseEntity<>(HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}		
	
	// 가게 정보 삭제
	@DeleteMapping("/stores/{storeId}")
	public ResponseEntity<Void> removeOwnStoreInfo(@PathVariable("storeId") String storeId) {
		Map<String,String> storeManagementMap = new HashMap<String,String>(); 
		storeManagementMap.put("storeId", storeId);
		int rsltCode = storeManagementService.removeStoreInfo(storeManagementMap);
		if(rsltCode > 0) {
			return new ResponseEntity<>(HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	// 메뉴 정보 삭제 
	@DeleteMapping("/stores/{storeId}/menus/{menuName}")
	public ResponseEntity<Void> removeMenuInfo(@PathVariable("storeId") String storeId,
																   @PathVariable("menuName") String menuName) {
		Map<String,String> menuMap = new HashMap<String,String>(); 
		menuMap.put("storeId", storeId);
		menuMap.put("menuName", menuName);
		int rsltCode = storeManagementService.removeMenuInfo(menuMap);
		if(rsltCode > 0) {
			return new ResponseEntity<>(HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}		
}
