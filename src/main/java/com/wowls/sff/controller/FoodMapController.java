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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wowls.sff.service.FoodMapService;


@RestController
@RequestMapping("/stores*")
public class FoodMapController {

	@Autowired
	private FoodMapService foodMapService;
	
	// 클라이언트에서 수행할 것
//	@GetMapping("/location/{location}")
//	public ResponseEntity<Map<String,String>> showCoordinate(@PathVariable("location") String location){
//		Map<String,String> foodMapMap = new HashMap<String,String>();
//		foodMapMap.put("location",location);
//		return new ResponseEntity<>(foodMapService.showCoordinate(foodMapMap),HttpStatus.OK);
//	}
	
	@GetMapping("/search")
	public ResponseEntity<List<Map<String,Object>>> showStoreList(
			@RequestParam(value="lat",required=false) String lat,
			@RequestParam(value="lon",required=false) String lon,
			@RequestParam(value="menus",required=false) String menus) {
		// url에 배열로 넘기기 가능한가? 나중에 in 조건에 넣도록
		// 붕어빵이든 크림붕어빵이든 검색되게 하려면? like 또는 대분류를 붕어빵으로 
		
		Map<String,String> foodMapMap = new HashMap<String,String>();
		foodMapMap.put("lat",lat);
		foodMapMap.put("lon",lon);
		foodMapMap.put("menus",menus);
		return new ResponseEntity<>(foodMapService.showStoreList(foodMapMap),HttpStatus.OK);
	}
	
	@GetMapping("/{storeId}")
	public ResponseEntity<Map<String,Object>> showStoreInfo(@PathVariable("storeId") String storeId){
		Map<String,String> foodMapMap = new HashMap<String,String>();
		foodMapMap.put("storeId",storeId);
		return new ResponseEntity<>(foodMapService.showStoreInfo(foodMapMap),HttpStatus.OK);
	}
}


// create = save
// retrieve = show
// update = modify
// delete = remove