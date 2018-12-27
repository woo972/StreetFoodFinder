package com.wowls.sff.service;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wowls.sff.mapper.UserMapper;

@Service
public class UserService {
	
	@Autowired
	private UserMapper userMapper;
	
	public int saveUserInfo(Map<String,String> paramMap) {
		if(StringUtils.isEmpty(paramMap.get("userName"))) {
			paramMap.put("userName", paramMap.get("userId"));
		}
		
		if(showUserInfo(paramMap).isEmpty()) {
			return userMapper.saveUserInfo(paramMap);
		}else {
			return 0;
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
}
