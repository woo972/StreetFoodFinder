package com.wowls.sff.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface FoodMapMapper {
	List<Map<String,Object>> showStoreList(Map<String, Object> foodMapMap);

	Map<String, Object> showStoreInfo(Map<String, String> foodMapMap);

	List<Map<String, Object>> showMenuList(Map<String, String> foodMapMap);

	List<Map<String, Object>> showReviewList(Map<String, String> foodMapMap);

}
