package com.wowls.sff.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wowls.sff.mapper.UserMapper;

@Service
public class UserServiceImpl {
	
	@Autowired
	private UserMapper userMapper;
	private MailServiceImpl mailService;
	
	public Map<String,String> saveUserInfo(Map<String,String> paramMap) {
		if(StringUtils.isEmpty(paramMap.get("userName"))) {
			paramMap.put("userName", paramMap.get("userId"));
		}
		
		if(checkSignUpForm(paramMap)) {
			
			// 이메일 인증 전 회원 비활성화
			String nonce="";
			for(int i=0; i<6; i++) {
				nonce += String.valueOf((int)Math.random()*10);
			}
			paramMap.put("nonce", nonce);
			paramMap.put("enabled", "N");
//			mailService.sendSimpleMessage("");
			
			userMapper.saveUserInfo(paramMap);
			
			Map<String,String> nonceMap = new HashMap<String,String>();
			nonceMap.put("nonce",nonce);
			return nonceMap;
		}else {
			return null;
		}
		
	}
	
	public boolean activateAccount(Map<String, String> userMap) {
		if(userMap.get("nonce").equals(userMapper.showNonce(userMap))){
			userMapper.removeNonce(userMap);
			userMapper.activateAccount(userMap);
			return true;
		}else {
			return false;
		}
	}

	public List<Map<String,String>> showUserList() {
		return userMapper.showUserList();
	}

	public Map<String,String> showUserInfo(Map<String,String> paramMap) {
		return userMapper.showUserInfo(paramMap);
	}

	public int modifyUserInfo(Map<String,String> paramMap) {
		return userMapper.modifyUserInfo(paramMap);
	}

	public int removeUser(Map<String,String> paramMap) {
		return userMapper.removeUser(paramMap);
	}
	
	
	private boolean checkSignUpForm(Map<String, String> paramMap) {
		Pattern pattern; 
		Matcher matcher;
		// 아이디 체크 (이메일 양식 확인)
		String userEmail = paramMap.get("userId");
		pattern = Pattern.compile("^[a-zA-Z0-9\\._-]+@[a-zA-Z0-9\\._-]+\\.[a-z\\.]{2,}");
		matcher = pattern.matcher(userEmail);
		if(!matcher.find()) {
			// failed
		}
		
		// 아이디 체크 (중복 확인)		
		if(showUserInfo(paramMap).isEmpty()) {
		}
	/*	
		// 비밀번호 체크 (자리수, 영문자 및 숫자 조합 확인)
		String userPw = paramMap.get("userPw");
		// 특문 검사
		pattern = Pattern.compile("[\\\\.,/?<>_-`~!@#$%^&*()+=\\\\|{}:;\\\"']+");
		if(!matcher.find()) {
			// failed
		}
		// 숫자 검사
		pattern = Pattern.compile("[0-9]+");
		matcher = pattern.matcher(userEmail);
		if(!matcher.find()) {
			// failed
		}
		// 문자 검사
		pattern = Pattern.compile("[a-z]+");
		matcher = pattern.matcher(userEmail);
		if(!matcher.find()) {
			// failed
		}
		// 길이 검사
		if(userPw.length() > 8) {
			
		}
		
		// 약관 동의 체크
		
		// 닉네임 체크 (중복 확인)
		if(showUserInfo(paramMap).isEmpty()) {
			return userMapper.saveUserInfo(paramMap);
		}
		*/	
		
		return true;
	}

}


