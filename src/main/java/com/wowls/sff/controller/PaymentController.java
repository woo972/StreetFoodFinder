package com.wowls.sff.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wowls.sff.service.PaymentService;

@RestController
@RequestMapping("/rooms/*")
public class PaymentController {

	@Autowired
	private PaymentService gameRoomService;
	
//	private static List<Map<String,String>> gameRoomList = new ArrayList<Map<String,String>>();
	
	// 로비에 보여줄 게임룸 리스트를 만든다
	@PostMapping("/")
	public ResponseEntity<String> makeGameRoom(@RequestBody Map<String,String> roomMap) {
		return new ResponseEntity<String>(gameRoomService.makeGameRoom(roomMap), HttpStatus.CREATED);
	}
//	public ResponseEntity<String> makeGameRoom(@RequestBody String userId) {
//		return new ResponseEntity<String>(gameRoomManagerService.makeGameRoom(userId), HttpStatus.CREATED);
//	}	
	
//	// 서버에 존재하는 게임룸 리스트를 반환한다 -> 향후 쿼리스트링으로 게임모드/레벨 등 필터링 가능토록 변경
//	@GetMapping("/")
//	public List<Map<String,String>> showGameRoom() {
//		return gameRoomManagerService.showGameRoom();
//	}
//		
	// 방 생성 유저가 방에서 나가면, 유저끼리 매칭이 완료되면 방목록에서 삭제
	// 매칭시 게임의 모드나 속성 등을 어떻게 상속시킬 것인가?
	@DeleteMapping("/{roomId}")
	public ResponseEntity<Void> removeGameRoom(@PathVariable("roomId") String roomId) {
		gameRoomService.removeGameRoom(roomId);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
