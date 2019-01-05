package com.wowls.sff.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wowls.sff.service.FoodMapServiceImpl;


@RestController
@RequestMapping("/stores*")
public class FoodMapController {

	@Autowired
	private FoodMapServiceImpl foodMapService;
	
	// 가게 목록 불러오기
	@GetMapping("/search")
	public ResponseEntity<List<Map<String,Object>>> showStoreList(
			@RequestParam(value="lat",required=false) String lat,
			@RequestParam(value="lon",required=false) String lon,
			@RequestParam(value="measure",required=false) String measure,
			@RequestParam(value="keywords",required=false) String keywords) {
		
		Map<String,Object> foodMapMap = new HashMap<String,Object>();
		foodMapMap.put("lat",lat);
		foodMapMap.put("lon",lon);
		foodMapMap.put("measure",measure);
		if(!StringUtils.isEmpty(keywords)) {
			foodMapMap.put("keywords",Arrays.asList(keywords.split(",")));
		}
		
		return new ResponseEntity<>(foodMapService.showStoreList(foodMapMap),HttpStatus.OK);
	}
	
	// 특정 가게 정보
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