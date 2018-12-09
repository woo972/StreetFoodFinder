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
		storeManagementMapper.saveStoreInfo(storeMap);
	}
	
	public void saveMenuInfo(Map<String, String> menuMap) {
		storeManagementMapper.saveMenuInfo(menuMap);
	}
	
	public List<Map<String,Object>> showOwnStoreList(Map<String, String> storeManagementMap) {		
		return storeManagementMapper.showOwnStoreList(storeManagementMap);
	}

	public List<Map<String,Object>> showOwnMenuList(Map<String, String> storeManagementMap) {
		return storeManagementMapper.showOwnMenuList(storeManagementMap);
	}

	public void modifyStoreInfo(Map<String, String> storeMap) {
		storeManagementMapper.modifyStoreInfo(storeMap);
	}

	public void modifyMenuInfo(Map<String, String> menuMap) {
		storeManagementMapper.modifyMenuInfo(menuMap);
	}

}
