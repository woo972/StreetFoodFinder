package com.wowls.sff.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wowls.sff.mapper.FoodMapMapper;

@Service
public class FoodMapService {
	
	@Autowired
	private FoodMapMapper foodMapMapper;
	

	public List<Map<String,Object>> showStoreList(Map<String, Object> foodMapMap) {
		List<Map<String,Object>> storeList = foodMapMapper.showStoreList(foodMapMap);
		return storeList;
		/* 반경 검색 */
//		List<Map<String,Object>> selectedStoreList = new ArrayList<Map<String,Object>>();
//		
//		if(foodMapMap.get("lat")==null && foodMapMap.get("lon")==null) {
//			return storeList;
//		}
//		
//		
//		double curLat = (double) foodMapMap.get("lat");		
//		double curLon = (double) foodMapMap.get("lon");
//		int measure = 0;
//		if(foodMapMap.get("measure")==null) measure = 500; 
//		measure= (int) foodMapMap.get("measure");
//		curLat = (double) Math.toRadians(curLat);
//		curLon = (double) Math.toRadians(curLon);
//		
//		for(Map<String,Object> store : storeList) {
//			double targetLat = (double) store.get("targetLat");
//			double targetLon = (double) store.get("targetLon");			
//			targetLat = (double) Math.toRadians(targetLat);
//			targetLon = (double) Math.toRadians(targetLon);
//			double dist = calculateDistance(curLat,curLon,targetLat,targetLon);
//			if (dist <= measure) {
//				selectedStoreList.add(store);
//			}
//		}
//		
//		return selectedStoreList;
	}


	public Map<String,Object> showStoreInfo(Map<String, String> foodMapMap) {
		Map<String,Object> storeInfo = foodMapMapper.showStoreInfo(foodMapMap); 
		List<Map<String,Object>> menuList = foodMapMapper.showMenuList(foodMapMap); 
		List<Map<String,Object>> ratingList =foodMapMapper.showRatingList(foodMapMap); 
		
		Map<String,Object> storeInfoMap = new HashMap<String,Object>();
		storeInfoMap.put("storeInfo", storeInfo);
		storeInfoMap.put("menuList", menuList);
		storeInfoMap.put("ratingList", ratingList);
		return storeInfoMap;
	}
	
//	private double calculateDistance(double curLat, double curLon, double targetLat, double targetLon) {	
//		if ((curLat == targetLat) && (curLon == targetLon)) {
//			return 0;
//		} else {
//			double theta = curLon - targetLon;
//			double dist = Math.sin(curLat) * Math.sin(targetLat) + 
//					Math.cos(curLat) * Math.cos(targetLat) * Math.cos(theta);
//			dist = Math.acos(dist);
//			dist = Math.toDegrees(dist);
//			dist = dist * 60 * 1.1515;
//			dist = dist * 1609.344;
//			
//			return (dist);
//		}		
//	}
	
}
