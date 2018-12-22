package com.wowls.sff.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface StoreManagementMapper {
	void saveStoreInfo(Map<String, String> storeMap);
	void saveMenuInfo(Map<String, String> menuMap);
	List<Map<String, Object>> showOwnStoreList(Map<String, String> storeManagementMap);
	List<Map<String, Object>> showOwnMenuList(Map<String, String> storeManagementMap);
	void modifyStoreInfo(Map<String, String> storeMap);
	void modifyMenuInfo(Map<String, String> menuMap);
	void removeMenuInfo(Map<String, String> menuMap);
}
