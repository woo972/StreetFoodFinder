package com.wowls.sff.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

	int saveUserInfo(Map<String,String> paramMap);

	void saveNonce(Map<String, String> paramMap);

	void activateAccount(Map<String, String> userMap);

	List<Map<String,String>> showUserList();

	Map<String,String> showUserInfo(Map<String,String> paramMap);

	int modifyUserInfo(Map<String,String> paramMap);

	int removeUser(Map<String,String> paramMap);

	String showNonce(Map<String, String> userMap);

	void removeNonce(Map<String, String> userMap);


}
