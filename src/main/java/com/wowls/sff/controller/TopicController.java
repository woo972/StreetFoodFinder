package com.wowls.sff.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wowls.sff.service.TopicServiceImpl;


@RestController
@RequestMapping("/topics*")
public class TopicController {

	@Autowired
	private TopicServiceImpl topicService;
	
	// 글 저장
	@PostMapping
	public ResponseEntity<Void> saveTopic(@RequestBody Map<String, Object> topicMap){
		int rsltCode = topicService.saveTopic(topicMap);
		if(rsltCode > 0) {
			return new ResponseEntity<>(HttpStatus.CREATED);
		}else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	// 글 목록 검색
	@GetMapping("/search")
	public ResponseEntity<List<Map<String,Object>>> showTopicList(
							@RequestParam(value="limit", required=false) int limit,
							@RequestParam(value="lastTopicId", required=false) int lastTopicId,
							@RequestParam(value="category", required=false) String category,							
							@RequestParam(value="writerId", required=false) String writerId){
		
		Map<String,Object> topicMap = new HashMap<String,Object>();
//		if(!StringUtils.isEmpty(String.valueOf(limit))) {
//			topicMap.put("limit",30);
//		}
		if(!StringUtils.isEmpty(String.valueOf(lastTopicId))) {
			// credate+cretime+userId
			//topicMap.put("limit",topicService.showMaxTopicNo(topicMap));
		}
		topicMap.put("category",category);
		topicMap.put("writerId",writerId);
		
		return new ResponseEntity<List<Map<String,Object>>>
					(topicService.showTopicList(topicMap), HttpStatus.CREATED);
	}
	
	// 내가 쓴 글 목록
	@GetMapping("/writers/{writerId}")
	public ResponseEntity<List<Map<String,Object>>> showTopicListByWriterId(										
			@PathVariable("writerId") String writerId){
		
		Map<String,Object> topicMap = new HashMap<String,Object>();
		topicMap.put("writerId",writerId);
		
		return new ResponseEntity<List<Map<String,Object>>>
		(topicService.showTopicListByWriterId(topicMap), HttpStatus.CREATED);
	}
}


// create = save
// retrieve = show
// update = modify
// delete = remove