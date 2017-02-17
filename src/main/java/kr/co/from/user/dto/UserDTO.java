package kr.co.from.user.dto;

import java.io.Serializable;
import java.util.Date;

public class UserDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5565935231088986589L;
	private Integer userId;
	private Integer status;
	
	private String lgnId;
	private String lgnPw;
	private String email;
	private String phone;
	private String name;
	
	private String role ="USER";
	

	private Date regDt;

	
	
	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getLgnId() {
		return lgnId;
	}

	public void setLgnId(String lgnId) {
		this.lgnId = lgnId;
	}

	public String getLgnPw() {
		return lgnPw;
	}

	public void setLgnPw(String lgnPw) {
		this.lgnPw = lgnPw;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getRegDt() {
		return regDt;
	}

	public void setRegDt(Date regDt) {
		this.regDt = regDt;
	}
	public String getRole() {
		return role;
	}
	
	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "UserDTO [userId=" + userId + ", status=" + status + ", lgnId=" + lgnId + ", lgnPw=" + lgnPw + ", email="
				+ email + ", phone=" + phone + ", name=" + name + ", regDt=" + regDt + "]";
	}
	
	
	
}
