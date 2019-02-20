package com.wowls.sff.service;

import java.util.Calendar;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wowls.sff.mapper.TopicMapper;

@Service
public class TopicServiceImpl {
	
	@Autowired
	private TopicMapper topicMapper;
	

	public int saveTopic(Map<String, Object> topicMap) {
		Calendar c = Calendar.getInstance();
		String d = String.valueOf(c.YEAR)+String.valueOf(c.MONTH)+String.valueOf(c.DAY_OF_MONTH);
		String t = String.valueOf(c.HOUR_OF_DAY)+String.valueOf(c.MINUTE)+String.valueOf(c.SECOND);
		topicMap.put("topicId", d+t+topicMap.get("writerId"));
		topicMap.put("creDate", d);
		topicMap.put("creTime", t);
		topicMap.put("updDate", d);
		topicMap.put("updTime", t);
		
		return topicMapper.saveTopic(topicMap);
	}
	public List<Map<String,Object>> showTopicList(Map<String, Object> topicMap) {
		List<Map<String,Object>> topicList = topicMapper.showTopicList(topicMap);
		return topicList;
	}
	public List<Map<String,Object>> showTopicListByWriterId(Map<String, Object> topicMap) {
		List<Map<String,Object>> topicList = topicMapper.showTopicListByWriterId(topicMap);
		return topicList;
	}
	public int modifyTopic(Map<String, Object> topicMap) {
		Calendar c = Calendar.getInstance();
		String d = String.valueOf(c.YEAR)+String.valueOf(c.MONTH)+String.valueOf(c.DAY_OF_MONTH);
		String t = String.valueOf(c.HOUR_OF_DAY)+String.valueOf(c.MINUTE)+String.valueOf(c.SECOND);
		topicMap.put("updDate", d);
		topicMap.put("updTime", t);
		return topicMapper.modifyTopic(topicMap);
	}
	public int removeTopic(Map<String, Object> topicMap) {
		return topicMapper.removeTopic(topicMap);
	}
}
