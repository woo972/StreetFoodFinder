package com.wowls.sff.service;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wowls.sff.mapper.StoreManagementMapper;

@Service
public class StoreManagementServiceImpl {

	@Autowired
	private StoreManagementMapper storeManagementMapper;

	public int saveStoreInfo(Map<String, String> storeMap) {
		String ownerId = storeMap.get("ownerId");
		if(StringUtils.isEmpty(storeMap.get("storeId"))) {
			storeMap.put("storeId", ownerId+"_store");
		}
		if(StringUtils.isEmpty(storeMap.get("storeName"))) {
			storeMap.put("storeId", ownerId+"의 가게");
		}
		return storeManagementMapper.saveStoreInfo(storeMap);
	}
	
	public int saveMenuInfo(Map<String, String> menuMap) {
		return storeManagementMapper.saveMenuInfo(menuMap);
	}
	
	public List<Map<String,Object>> showOwnStoreList(Map<String, String> storeManagementMap) {		
		return storeManagementMapper.showOwnStoreList(storeManagementMap);
	}

	public List<Map<String,Object>> showOwnMenuList(Map<String, String> storeManagementMap) {
		List<Map<String,Object>> ownMenuList = storeManagementMapper.showOwnMenuList(storeManagementMap);
		return ownMenuList;
	}

	public int modifyStoreInfo(Map<String, String> storeMap) {
		return storeManagementMapper.modifyStoreInfo(storeMap);
	}

	public int modifyMenuInfo(Map<String, String> menuMap) {
		return storeManagementMapper.modifyMenuInfo(menuMap);
	}

	public int removeStoreInfo(Map<String, String> menuMap) {
		return storeManagementMapper.removeStoreInfo(menuMap);
	}
	
	public int removeMenuInfo(Map<String, String> menuMap) {
		return storeManagementMapper.removeMenuInfo(menuMap);
	}

}
