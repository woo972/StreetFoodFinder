package com.wowls.sff.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wowls.sff.mapper.StoreManagementMapper;

@Service
public class StoreManagementService {

	@Autowired
	private StoreManagementMapper storeManagementMapper;

	public void saveStoreInfo(Map<String, String> storeMap) {
		String ownerId = storeMap.get("ownerId");
		storeMap.put("storeId", ownerId+"_store");
		storeManagementMapper.saveStoreInfo(storeMap);
	}
	
	public void saveMenuInfo(Map<String, String> menuMap) {
		storeManagementMapper.saveMenuInfo(menuMap);
	}
	
	public List<Map<String,Object>> showOwnStoreList(Map<String, String> storeManagementMap) {		
		return storeManagementMapper.showOwnStoreList(storeManagementMap);
	}

	public List<Map<String,Object>> showOwnMenuList(Map<String, String> storeManagementMap) {
		List<Map<String,Object>> ownMenuList = storeManagementMapper.showOwnMenuList(storeManagementMap);
		System.out.println(ownMenuList.get(0).get("MENU_NAME"));
		return ownMenuList;
	}

	public void modifyStoreInfo(Map<String, String> storeMap) {
		storeManagementMapper.modifyStoreInfo(storeMap);
	}

	public void modifyMenuInfo(Map<String, String> menuMap) {
		storeManagementMapper.modifyMenuInfo(menuMap);
	}

}
