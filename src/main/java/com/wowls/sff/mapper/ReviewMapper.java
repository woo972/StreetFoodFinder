package com.wowls.sff.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ReviewMapper {

	int saveReview(Map<String,String> reviewMap);
	List<Map<String,Object>> showReviewListByWriter(Map<String,String> reviewMap);
	List<Map<String,Object>> showReviewListByStore(Map<String,String> reviewMap);
	int modifyReview(Map<String,String> reviewMap);
	int removeReview(Map<String,String> reviewMap);
}
