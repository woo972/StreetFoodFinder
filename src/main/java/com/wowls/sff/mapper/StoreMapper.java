package com.wowls.sff.mapper;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface StoreMapper {

	Map<String,String> showWord(Map<String,String> paramMap);

}
