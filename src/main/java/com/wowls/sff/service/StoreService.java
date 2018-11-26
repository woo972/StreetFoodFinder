package com.wowls.sff.service;

import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.wowls.sff.mapper.PaymentMapper;
import com.wowls.sff.mapper.StoreMapper;

@Service
public class StoreService {

	private PaymentMapper itemMapper;
	private StoreMapper wordMapper;
	
	public Map<String,String> userAction(Map<String, String> message){

		String actionType = message.get("actionType");
		if(StringUtils.isNotBlank(actionType)) {
			switch(actionType) {
			
			case "word":
				message.put("isUsable", checkWord(message));
				break;
			case "item":
				message.put("isUsable", checkItem(message));
				break;
			default:
				message.put("isUsable", checkWord(message));
				break;
			}
		}else {
			System.out.println("no action type");
		}
			
		return message;
	}

	private String checkItem(Map<String, String> message) {
		
		String userId = message.get("userId");
		String itemId =  message.get("itemId");
		String useCount =  message.get("useCount");		
		
		if(StringUtils.isNotBlank(userId) 
				&& StringUtils.isNotBlank(itemId) 
				&& StringUtils.isNotBlank(useCount)) {
			if(itemMapper.checkItemQty(message) > 0) {
				itemMapper.useItem(message);
				return "TRUE";
			}
		}else {
			System.out.println("one of parameters is null");
		}
		return "FALSE";
	}
	
	private String checkWord(Map<String, String> message) {
		
		String word =  message.get("word");
		if(StringUtils.isNotBlank(word)) {
//			return gameMapper.showkWord(word);
			return "TRUE";
		}else {
			System.out.println("word is null");
		}
		return "FALSE";
	}
}
