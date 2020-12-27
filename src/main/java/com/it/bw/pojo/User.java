package com.it.bw.pojo;

public class User extends BasePojo {
	private Long id;
	private String usercode;	
	private String username;	
	private String password;	
	private Long createby;
	private Integer state;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUsercode() {
		return usercode;
	}
	public void setUsercode(String usercode) {
		this.usercode = usercode;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Long getCreateby() {
		return createby;
	}
	public void setCreateby(Long createby) {
		this.createby = createby;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", usercode=" + usercode + ", username=" + username + ", password=" + password
				+ ", createby=" + createby + ", state=" + state + "]";
	}
}
