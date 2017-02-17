package kr.co.from.board.dto;

import java.util.Date;

public class BoardFileDTO {

	private long fsize = 0;
	
	private Integer fileId;
	private Integer docId;
	private Integer errorCode;
	
	private String orgFileNm;
	private String newFileNm;
	private String ext;
	private String fpath;
	
	// 진정한 파일 타입은 여기에 기재해둬야하나?
	private String fileType;
	
	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	private Date regDt;

	public Integer getFileId() {
		return fileId;
	}

	public void setFileId(Integer fileId) {
		this.fileId = fileId;
	}

	public Integer getDocId() {
		return docId;
	}

	public void setDocId(Integer docId) {
		this.docId = docId;
	}

	public long getFsize() {
		return fsize;
	}

	public void setFsize(long fsize) {
		this.fsize = fsize;
	}

	public String getOrgFileNm() {
		return orgFileNm;
	}

	public void setOrgFileNm(String orgFileNm) {
		this.orgFileNm = orgFileNm;
	}

	public String getNewFileNm() {
		return newFileNm;
	}

	public void setNewFileNm(String newFileNm) {
		this.newFileNm = newFileNm;
	}

	public String getExt() {
		return ext;
	}

	public void setExt(String ext) {
		this.ext = ext;
	}

	public String getFpath() {
		return fpath;
	}

	public void setFpath(String fpath) {
		this.fpath = fpath;
	}

	public Date getRegDt() {
		return regDt;
	}

	public void setRegDt(Date regDt) {
		this.regDt = regDt;
	}

	public Integer getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(Integer errorCode) {
		this.errorCode = errorCode;
	}

	@Override
	public String toString() {
		return "BoardFileDTO [fsize=" + fsize + ", fileId=" + fileId + ", docId=" + docId + ", errorCode=" + errorCode
				+ ", orgFileNm=" + orgFileNm + ", newFileNm=" + newFileNm + ", ext=" + ext + ", fpath=" + fpath
				+ ", fileType=" + fileType + ", regDt=" + regDt + "]";
	}


	
	
}
