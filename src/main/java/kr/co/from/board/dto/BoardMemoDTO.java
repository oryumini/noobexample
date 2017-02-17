package kr.co.from.board.dto;

import java.util.Date;

public class BoardMemoDTO {

	private Integer memoId;		// 댓글 아이디
	private Integer docId;		// 게시물 아이디
	private Integer userId;		// 작성자 아이디
	
	private String memoContents;	// 덧글 내용
	private String name;		// 작성자 이름
	
	private Date regDt;				// 작성일

	
	public Integer getMemoId() {
		return memoId;
	}

	public void setMemoId(Integer memoId) {
		this.memoId = memoId;
	}

	public Integer getDocId() {
		return docId;
	}

	public void setDocId(Integer docId) {
		this.docId = docId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getMemoContents() {
		return memoContents;
	}

	public void setMemoContents(String memoContents) {
		this.memoContents = memoContents;
	}

	public Date getRegDt() {
		return regDt;
	}

	public void setRegDt(Date regDt) {
		this.regDt = regDt;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "BoardMemoDTO [memoId=" + memoId + ", docId=" + docId + ", userId=" + userId + ", memoContents="
				+ memoContents + ", regDt=" + regDt + "]";
	}
	
	
	
}
