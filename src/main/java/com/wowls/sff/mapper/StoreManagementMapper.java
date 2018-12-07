package com.wowls.sff.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface StoreManagementMapper {
	void saveStoreInfoInfo(Map<String, Object> storeMap);
	void saveMenuInfo(Map<String, Object> menuMap);
	List<Map<String, String>> showOwnStoreList(Map<String, String> storeManagementMap);
	List<Map<String, String>> showOwnMenuList(Map<String, String> storeManagementMap);
	void modifyStoreInfo(Map<String, Object> storeMap);
	void modifyMenuInfo(Map<String, Object> menuMap);
}
