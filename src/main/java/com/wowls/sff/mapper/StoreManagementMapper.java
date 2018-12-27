package com.wowls.sff.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface StoreManagementMapper {
	int saveStoreInfo(Map<String, String> storeMap);
	int saveMenuInfo(Map<String, String> menuMap);
	List<Map<String, Object>> showOwnStoreList(Map<String, String> storeManagementMap);
	List<Map<String, Object>> showOwnMenuList(Map<String, String> storeManagementMap);
	int modifyStoreInfo(Map<String, String> storeMap);
	int modifyMenuInfo(Map<String, String> menuMap);
	int removeStoreInfo(Map<String, String> menuMap);
	int removeMenuInfo(Map<String, String> menuMap);
}
