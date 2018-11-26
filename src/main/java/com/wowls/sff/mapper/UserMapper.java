package com.wowls.sff.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

	void saveUserInfo(Map<String,String> paramMap);

	List<Map<String,String>> showUserList();

	Map<String,String> showUserInfo(Map<String,String> paramMap);

	void modifyUserInfo(Map<String,String> paramMap);

	void removeUser(Map<String,String> paramMap);
}
