package kr.co.from.board.dto;

import kr.co.from.common.dto.PageDTO;

public class BoardSearchDTO extends PageDTO {

	private Integer userId = null;
	private Integer mapId = null;
	private String searchText = null;
	private String searchType = null;
	
	public Integer getMapId() {
		return mapId;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public void setMapId(Integer mapId) {
		this.mapId = mapId;
	}
	public String getSearchText() {
		return searchText;
	}
	public void setSearchText(String searchText) {
		this.searchText = searchText;
	}
	public String getSearchType() {
		return searchType;
	}
	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}
	
	@Override
	public String toString() {
		return "BoardSearchDTO [mapId=" + mapId + ", searchText=" + searchText + ", searchType=" + searchType + "]";
	}
	
	
}

