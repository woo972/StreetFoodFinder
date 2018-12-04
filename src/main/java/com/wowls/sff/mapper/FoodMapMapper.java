package com.wowls.sff.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface FoodMapMapper {
	List<Map<String,Object>> showStoreList(Map<String, String> foodMapMap);

}
