package kr.co.from.board.dto;

import java.util.Date;

public class BoardMapDTO {

	Integer mapId;			// 맵 ID
	Integer parMapId;		// 부모 맵 ID
		
	String mapNm;			// 맵 이름
	String mapOrder;		// 맵 순서
	
	char deleteYN;			// 삭제 여부
	char memoYN;			// 댓글 여부
	
	Date regDt;				// 등록일

	public Integer getMapId() {
		return mapId;
	}

	public void setMapId(Integer mapId) {
		this.mapId = mapId;
	}

	public Integer getParMapId() {
		return parMapId;
	}

	public void setParMapId(Integer parMapId) {
		this.parMapId = parMapId;
	}

	public String getMapNm() {
		return mapNm;
	}

	public void setMapNm(String mapNm) {
		this.mapNm = mapNm;
	}

	public String getMapOrder() {
		return mapOrder;
	}

	public void setMapOrder(String mapOrder) {
		this.mapOrder = mapOrder;
	}

	public char getDeleteYN() {
		return deleteYN;
	}

	public void setDeleteYN(char deleteYN) {
		this.deleteYN = deleteYN;
	}

	public char getMemoYN() {
		return memoYN;
	}

	public void setMemoYN(char memoYN) {
		this.memoYN = memoYN;
	}

	public Date getRegDt() {
		return regDt;
	}

	public void setRegDt(Date regDt) {
		this.regDt = regDt;
	}

	@Override
	public String toString() {
		return "boardDTO [mapId=" + mapId + ", parMapId=" + parMapId + ", mapNm=" + mapNm + ", mapOrder=" + mapOrder
				+ ", deleteYN=" + deleteYN + ", memoYN=" + memoYN + ", regDt=" + regDt + "]";
	}
	
	
	
	
}
