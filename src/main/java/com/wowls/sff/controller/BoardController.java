package com.wowls.sff.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/boards*")
public class BoardController {

	@Autowired
//	private FoodMapService foodMapService;
	
	@PostMapping
	public ResponseEntity<Void> savePost(@RequestBody Map<String, String> boardsMap){
		
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
}


// create = save
// retrieve = show
// update = modify
// delete = remove