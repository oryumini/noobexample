package kr.co.from.common.dto;

public class ErrorDTO {

	private int code = 99;
	private String msg = "정상적으로 성공하였습니다.";
	
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}

	
	
}
