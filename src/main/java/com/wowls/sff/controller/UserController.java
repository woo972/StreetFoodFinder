package com.wowls.sff.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.MailException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wowls.sff.service.MailServiceImpl;
import com.wowls.sff.service.UserServiceImpl;

/* 필요 메서드 
 * 1. admin 용
 *  - 사용자 전체 목록, 회원 정보, 회원 삭제(탈퇴)
 * 2. user 용
 *  - 내 정보(사용자 통계), 회원가입, 회원정보 변경, 회원 탈퇴, 로그인, 로그아웃 
 */

@RestController
@RequestMapping("/users*")
public class UserController {

	@Autowired
	private UserServiceImpl userService;
	@Autowired
	private MailServiceImpl mailService;
	
	
	//test
	@GetMapping("/test")
	public String test() {
		try{
			mailService.sendSimpleMessage("dntnrmsss@naver.com","test","asdf","dntnrmsss@gmail.com");
		}catch(MailException e) {
			System.out.println(e.getMessage());
		}
		return "test complete";
	}
	
	// sign up
	@PostMapping
	public ResponseEntity<Map<String,String>> saveUserInfo(@RequestBody Map<String,String> userMap) {
		Map<String,String> nonceMap = userService.saveUserInfo(userMap);
		if(nonceMap != null) {
			return new ResponseEntity<Map<String,String>>(nonceMap, HttpStatus.CREATED);
		}
		
		return new ResponseEntity<Map<String,String>>(nonceMap, HttpStatus.BAD_REQUEST);
	}
	
	// activate account
	@PutMapping("/activate/{userId}")	
	public ResponseEntity<Void> activateAccount(@PathVariable("userId") String userId
											   ,@RequestBody Map<String,String> userMap) {
		// check nonce 
		userMap.put("userId", userId);
		if(userService.activateAccount(userMap)) {
			return new ResponseEntity<>(HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	// get all user list
	@GetMapping
	public ResponseEntity<List<Map<String,String>>> showUserList() {
		List<Map<String,String>> userList = userService.showUserList();
		return new ResponseEntity<>(userList,HttpStatus.OK);
	}
	
	// get specific user info
	@GetMapping("/{userId}")
	public ResponseEntity<Map<String,String>> showUserInfo(@PathVariable("userId") String userId) {
		Map<String,String> userMap = new HashMap<>();
		userMap.put("userId", userId);
		return new ResponseEntity<>(userService.showUserInfo(userMap), HttpStatus.OK);
	}
	
	 // modify user info
	@PutMapping("/{userId}")
	public ResponseEntity<Void> modifyUserInfo(@PathVariable("userId") String userId
											  ,@RequestBody Map<String,String> userMap ){
		userMap.put("userId", userId);
		int rsltCode = userService.modifyUserInfo(userMap);
		if(rsltCode > 0) {
			return new ResponseEntity<>(HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	// remove user
	@DeleteMapping("/{userId}")
	public ResponseEntity<Void> removeUser(@PathVariable("userId") String userId){
		Map<String,String> userMap = new HashMap<>();
		userMap.put("userId", userId);
		int rsltCode = userService.removeUser(userMap);
		if(rsltCode > 0) {
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