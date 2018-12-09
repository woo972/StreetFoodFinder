package com.wowls.sff.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/favorite*")
public class FavoriteController {

	@Autowired
//	private FoodMapService foodMapService;
	
	@PostMapping("/{storeId}")
	public ResponseEntity<Void> saveFavoriteStore(@PathVariable("storeId") String storeId){
		Map<String,String> favoriteMap = new HashMap<String,String>();
		favoriteMap.put("userId", storeId); // 세션에서 유저아이디 가져올 것
		favoriteMap.put("storeId", storeId);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
}


// create = save
// retrieve = show
// update = modify
// delete = remove