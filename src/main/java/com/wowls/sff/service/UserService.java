package com.wowls.sff.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wowls.sff.mapper.UserMapper;

@Service
public class UserService {
	
	@Autowired
	private UserMapper userMapper;
	
	public void saveUserInfo(Map<String,String> paramMap) {
		userMapper.saveUserInfo(paramMap);
	}

	public List<Map<String,String>> showUserList() {
		return userMapper.showUserList();
	}

	public Map<String,String> showUserInfo(Map<String,String> paramMap) {
		return userMapper.showUserInfo(paramMap);
	}

	public void modifyUserInfo(Map<String,String> paramMap) {
		userMapper.modifyUserInfo(paramMap);
	}

	public void removeUser(Map<String,String> paramMap) {
		userMapper.removeUser(paramMap);
	}
}
