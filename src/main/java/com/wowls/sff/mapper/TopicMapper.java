package com.wowls.sff.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TopicMapper {
	int saveTopic(Map<String, Object> topicMap);
	List<Map<String,Object>> showTopicList(Map<String, Object> topicMap);
	List<Map<String,Object>> showTopicListByWriterId(Map<String, Object> topicMap);
}
