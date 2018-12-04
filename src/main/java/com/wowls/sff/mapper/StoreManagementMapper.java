package com.wowls.sff.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface StoreManagementMapper {
	List<Map<String, String>> showOwnStoreList(Map<String, String> storeManagementMap);
	List<Map<String, String>> showOwnMenuList(Map<String, String> storeManagementMap);
}
