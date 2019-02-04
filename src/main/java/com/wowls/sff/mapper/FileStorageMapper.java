package com.wowls.sff.mapper;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface FileStorageMapper {
	int saveFile(Map<String, Object> fileMap);
}
