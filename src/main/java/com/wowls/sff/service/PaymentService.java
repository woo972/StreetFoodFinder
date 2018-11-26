package com.wowls.sff.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class PaymentService {

	private static List<Map<String,String>> gameRoomList = new ArrayList<Map<String,String>>();
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
	private Date d;
	
	public String makeGameRoom(@RequestBody Map<String,String> roomMap) {
		// 기존에 만들어 진 방이 있는지 확인
		if(!gameRoomList.isEmpty()) {
			String roomId =  gameRoomList.get(0).get("roomId");
			gameRoomList.remove(0);
			System.out.println("joined:"+ roomId);
			return roomId;
		}
		
		String userId =  roomMap.get("userId");	
		d = new Date();
		String roomId = userId+sdf.format(d);
		roomMap.put("roomId", roomId);
		gameRoomList.add(roomMap);
		
		System.out.println("roomId:"+ roomId+" has been created");
		
		return roomId;
	}
	
	
//	// 서버에 존재하는 게임룸 리스트를 반환한다 -> 향후 쿼리스트링으로 게임모드/레벨 등 필터링 가능토록 변경
//	public List<Map<String,String>> showGameRoom() {
//		System.out.println(gameRoomList);
//		return gameRoomList;
//	}
//		
	// 방 생성 유저가 방에서 나가면, 유저끼리 매칭이 완료되면 방목록에서 삭제
	// 매칭시 게임의 모드나 속성 등을 어떻게 상속시킬 것인가?
	// 방 생성 후 1분 경과시 방 삭제
	public boolean removeGameRoom(String roomId) {
		int gameRoomListIdx=0;
		for(Map<String, String> gameProp : gameRoomList) {
			if(gameProp.get("roomId").equals(roomId)) {
				gameRoomList.remove(gameRoomListIdx); 
				return true; 
			}
			gameRoomListIdx++;
		}
		return  false;
	}
	
}
