package com.wowls.sff.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.wowls.sff.mapper.StoreManagementMapper;

@Service
public class StoreManagementService {

	private StoreManagementMapper storeManagementMapper;

	public void saveStoreInfoInfo(Map<String, String> storeMap) {
		storeManagementMapper.saveStoreInfoInfo(storeMap);
	}
	
	public void saveMenuInfo(Map<String, Object> menuMap) {
		storeManagementMapper.saveMenuInfo(menuMap);
	}
	
	public List<Map<String,String>> showOwnStoreList(Map<String, String> storeManagementMap) {		
		return storeManagementMapper.showOwnStoreList(storeManagementMap);
	}

	public List<Map<String,String>> showOwnMenuList(Map<String, String> storeManagementMap) {
		return storeManagementMapper.showOwnMenuList(storeManagementMap);
	}

	public void modifyStoreInfo(Map<String, Object> storeMap) {
		storeManagementMapper.modifyStoreInfo(storeMap);
	}

	public void modifyMenuInfo(Map<String, Object> menuMap) {
		storeManagementMapper.modifyMenuInfo(menuMap);
	}

}
