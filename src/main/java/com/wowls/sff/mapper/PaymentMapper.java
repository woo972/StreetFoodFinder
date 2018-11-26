package com.wowls.sff.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PaymentMapper {
	
	List<Map<String,String>> showItemList();

	List<Map<String,String>> showOwnItemList(Map<String,String> paramMap);
	
	int checkItemQty(Map<String,String> paramMap);
	
	int useItem(Map<String,String> paramMap);	
}
