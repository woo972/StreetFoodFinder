package com.wowls.sff.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ImageStorageMapper {
	int saveImage(Map<String, Object> imageMap);
	List<String> showImageList(Map<String, String> imageMap);
}
