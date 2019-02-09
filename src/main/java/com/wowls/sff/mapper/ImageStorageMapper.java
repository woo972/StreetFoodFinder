package com.wowls.sff.mapper;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ImageStorageMapper {
	int saveImage(Map<String, Object> imageMap);
	String showImageNameByImageOrder(Map<String, Object> imageMap);
	String showImageNameByImageName(Map<String, Object> imageMap);
	int removeImage(Map<String, Object> imageMap);
}
