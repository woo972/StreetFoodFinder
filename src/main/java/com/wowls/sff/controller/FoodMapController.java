package com.wowls.sff.controller;

import java.util.ArrayList;
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

import com.wowls.sff.service.FoodMapService;


@RestController
@RequestMapping("/foodMap/*")
public class FoodMapController {

	@Autowired
	private FoodMapService foodMapService;
	
	// 클라이언트에서 수행할 것
	@GetMapping("/location/{location}")
	public ResponseEntity<Map<String,String>> showCoordinate(@PathVariable("location") String location){
		Map<String,String> foodMapMap = new HashMap<String,String>();
		foodMapMap.put("location",location);
		return new ResponseEntity<>(foodMapService.showCoordinate(foodMapMap),HttpStatus.OK);
	}
	
	
	@GetMapping("/lat/{lat}/lon/{lon}")
	public ResponseEntity<List<Map<String,Object>>> showStoreList(@PathVariable("lat") String lat,
																  @PathVariable("lon") String lon) {
		Map<String,String> foodMapMap = new HashMap<String,String>();
		foodMapMap.put("lat",lat);
		foodMapMap.put("lon",lon);
		
		List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("lat", 1);
		map.put("lon", 2);
		map.put("storeName", "test1");
		list.add(map);
		map = new HashMap<String, Object>();
		map.put("lat", 1);
		map.put("lon", 2);
		map.put("storeName", "test2");
		list.add(map);
		map = new HashMap<String, Object>();
		map.put("lat", 1);
		map.put("lon", 2);
		map.put("storeName", "test3");
		list.add(map);
		map = new HashMap<String, Object>();
		map.put("lat", 1);
		map.put("lon", 2);
		map.put("storeName", "test4");
		list.add(map);
		
		return new ResponseEntity<>(list,HttpStatus.OK);
	//	return new ResponseEntity<>(foodMapService.showStoreList(foodMapMap),HttpStatus.OK);
	}
}


// create = save
// retrieve = show
// update = modify
// delete = remove