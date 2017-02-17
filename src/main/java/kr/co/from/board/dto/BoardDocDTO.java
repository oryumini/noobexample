package kr.co.from.board.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class BoardDocDTO {

	private Integer docId;		// 게시물 ID
	private Integer mapId;		// 맵 ID
	private Integer userId;		// 유저 ID
	private Integer hit;		// 조회수
	
	private int memoNum;	// 댓글 개수
	
	private String title;		// 제목
	private String docContents;	// 내용
	private String name;		// 작성자 이름
	private String mapNm;		// 맵 이름
	
	private Date regDt;			// 등록일
	
	private BoardMapDTO boardMapDTO;	// 이 게시물의 MAP DTO
		
	private List<MultipartFile> files = new ArrayList<>();		// 첨부파일. 이건 null로 하면 안된다.
	private List<BoardFileDTO> fileList;						// 이 게시물의 첨부파일 리스트
	private List<Integer> delFileList = new ArrayList<>();		// 게시물 수정 시 삭제할 파일 리스트

	

	public List<Integer> getDelFileList() {
		return delFileList;
	}

	public void setDelFileList(List<Integer> delFileList) {
		this.delFileList = delFileList;
	}

	public String getMapNm() {
		return mapNm;
	}

	public void setMapNm(String mapNm) {
		this.mapNm = mapNm;
	}

	public Integer getDocId() {
		return docId;
	}

	public void setDocId(Integer docId) {
		this.docId = docId;
	}

	public Integer getMapId() {
		return mapId;
	}

	public void setMapId(Integer mapId) {
		this.mapId = mapId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getHit() {
		return hit;
	}

	public void setHit(Integer hit) {
		this.hit = hit;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDocContents() {
		return docContents;
	}

	public void setDocContents(String docContents) {
		this.docContents = docContents;
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

	public int getMemoNum() {
		return memoNum;
	}

	public void setMemoNum(int memoNum) {
		this.memoNum = memoNum;
	}

	public List<MultipartFile> getFiles() {
		return files;
	}

	public void setFiles(List<MultipartFile> files) {
		this.files = files;
	}

	public BoardMapDTO getBoardMapDTO() {
		return boardMapDTO;
	}

	public void setBoardMapDTO(BoardMapDTO boardMapDTO) {
		this.boardMapDTO = boardMapDTO;
	}

	public List<BoardFileDTO> getFileList() {
		return fileList;
	}

	public void setFileList(List<BoardFileDTO> fileList) {
		this.fileList = fileList;
	}

	@Override
	public String toString() {
		return "BoardDocDTO [docId=" + docId + ", mapId=" + mapId + ", userId=" + userId + ", hit=" + hit + ", memoNum="
				+ memoNum + ", title=" + title + ", docContents=" + docContents + ", name=" + name + ", regDt=" + regDt
				+ "]";
	}

	
	
	
}
