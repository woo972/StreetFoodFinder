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

import com.wowls.sff.service.ReviewServiceImpl;


@RestController
@RequestMapping("/reviews*")
public class ReviewController {

	@Autowired
	private ReviewServiceImpl reviewService;
	
	// 리뷰 등록
	@PostMapping("/writers/{writerId}/stores")
	public ResponseEntity<Void> saveReview(@PathVariable("writerId") String writerId,
										   @RequestBody Map<String,String> reviewMap) {
		reviewMap.put("writerId", writerId);
		int rsltCode = reviewService.saveReview(reviewMap);
		if(rsltCode > 0 ) {
			return new ResponseEntity<>(HttpStatus.CREATED);
		}else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	// 사용자가 작성한 리뷰 조회
	@GetMapping("/writers/{writerId}")
	public ResponseEntity<List<Map<String,Object>>> showReviewListByWriter(@PathVariable("writerId") String writerId){
		Map<String,String> reviewMap = new HashMap<String,String>();
		reviewMap.put("writerId",writerId);
		return new ResponseEntity<>(reviewService.showReviewListByWriter(reviewMap),HttpStatus.OK);
	}
	
	// 매점에 등록된 리뷰 조회
	@GetMapping("/stores/{storeId}")
	public ResponseEntity<List<Map<String,Object>>> showReviewListByStore(@PathVariable("storeId") String storeId){
		Map<String,String> reviewMap = new HashMap<String,String>();
		reviewMap.put("storeId",storeId);
		return new ResponseEntity<>(reviewService.showReviewListByStore(reviewMap),HttpStatus.OK);
	}
	
	// 리뷰 수정
	@PutMapping("/writers/{writerId}/stores/{storeId}")
	public ResponseEntity<Void> modifyReview(@PathVariable("writerId") String writerId,
											 @PathVariable("storeId") String storeId,
											 @RequestBody Map<String, String> reviewMap){
		reviewMap.put("writerId",writerId);
		reviewMap.put("storeId",storeId);
		
		int rsltCode = reviewService.modifyReview(reviewMap);
		if (rsltCode > 0 ) {
			return new ResponseEntity<>(HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	// 리뷰 삭제
	@DeleteMapping("/writers/{writerId}/stores/{storeId}")
	public ResponseEntity<Void> removeReview(@PathVariable("writerId") String writerId,
											 @PathVariable("storeId") String storeId){
		Map<String,String> reviewMap = new HashMap<String,String>();
		reviewMap.put("writerId",writerId);
		reviewMap.put("storeId",storeId);
		
		int rsltCode = reviewService.removeReview(reviewMap);
		if (rsltCode > 0 ) {
			return new ResponseEntity<>(HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
}


// create = save
// retrieve = show
// update = modify
// delete = remove