package com.wowls.sff.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;

import com.wowls.sff.service.StoreService;

@Controller
public class StoreController {
	
	@Autowired
	private StoreService storeService;
	
	@MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public Map<String,String> greeting(Map<String, String> message) throws Exception {
		System.out.println("greeting:"+message);
        message.put("time","time:"+System.currentTimeMillis());
        return message;
    }

	
	@MessageMapping("/rooms/{roomId}")
	@SendTo("/topic/rooms/{roomId}")
//	public Map<String,String> userAction(@DestinationVariable("roomId") String roomId
////						  ,SessionSubscribeEvent event
////						  ,SimpMessageHeaderAccessor accessor
//						  ,@RequestBody Map<String, String> message) {
////		System.out.println("room:"+roomId+" / "+event+" / "+accessor);
////		String sessionId = accessor.getSessionAttributes().get("sessionId").toString();
//		return gameService.userAction(message);
//	}
	public String userAction(@DestinationVariable("roomId") String roomId
						    ,@RequestBody String message) {
		return message;
	}
}
