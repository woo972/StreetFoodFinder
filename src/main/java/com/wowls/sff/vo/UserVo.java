package com.wowls.sff.vo;

public class UserVo {

	private String userId;
	private String userPw;
	private String userNick;
	public UserVo() {
		super();
	}
	public UserVo(String userId, String userPw, String userNick) {
		super();
		this.userId = userId;
		this.userPw = userPw;
		this.userNick = userNick;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserPw() {
		return userPw;
	}
	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}
	public String getUserNick() {
		return userNick;
	}
	public void setUserNick(String userNick) {
		this.userNick = userNick;
	}
	@Override
	public String toString() {
		return "UserVo [userId=" + userId + ", userPw=" + userPw + ", userNick=" + userNick + "]";
	}
	
	
	
}
