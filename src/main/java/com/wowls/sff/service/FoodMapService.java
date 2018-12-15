package com.wowls.sff.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wowls.sff.mapper.FoodMapMapper;

@Service
public class FoodMapService {
	
	@Autowired
	private FoodMapMapper foodMapMapper;
	

	public List<Map<String,Object>> showStoreList(Map<String, String> foodMapMap) {
		return foodMapMapper.showStoreList(foodMapMap);
	}

	public Map<String,Object> showStoreInfo(Map<String, String> foodMapMap) {
		return foodMapMapper.showStoreInfo(foodMapMap);
	}
	
	
}
