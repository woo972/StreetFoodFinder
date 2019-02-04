package com.wowls.sff.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wowls.sff.mapper.ReviewMapper;

@Service
public class ReviewServiceImpl {
	
	@Autowired
	private ReviewMapper reviewMapper;
	
	public int saveReview(Map<String,String> reviewMap) {
		
		int MaxBytesOfComment = 300;
		int maxSizeOfRate = 5;
		int minSizeOfRate = 0;
		
		int rate = Integer.parseInt(reviewMap.get("rate"));
		String comment = reviewMap.get("comment");
		
		if(rate < minSizeOfRate || rate > maxSizeOfRate) {
			return 0;
		}
		if(comment.getBytes().length > MaxBytesOfComment) {
			return 0;
		}
		
		return reviewMapper.saveReview(reviewMap);
	}
	public List<Map<String,Object>> showReviewListByWriter(Map<String,String> reviewMap) {
		return reviewMapper.showReviewListByWriter(reviewMap);
	}
	public List<Map<String,Object>> showReviewListByStore(Map<String,String> reviewMap) {
		return reviewMapper.showReviewListByStore(reviewMap);
	}
	public int modifyReview(Map<String,String> reviewMap) {
		int MaxBytesOfComment = 300;
		int maxSizeOfRate = 5;
		int minSizeOfRate = 0;
		
		int rate = Integer.parseInt(reviewMap.get("rate"));
		String comment = reviewMap.get("comment");
		
		if(rate < minSizeOfRate || rate > maxSizeOfRate) {
			return 0;
		}
		if(comment.getBytes().length > MaxBytesOfComment) {
			return 0;
		}		
		return reviewMapper.modifyReview(reviewMap);
	}
	public int removeReview(Map<String,String> reviewMap) {
		return reviewMapper.removeReview(reviewMap);
	}	 
}


