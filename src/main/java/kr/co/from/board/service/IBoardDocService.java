package kr.co.from.board.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import kr.co.from.board.dto.BoardDocDTO;
import kr.co.from.board.dto.BoardSearchDTO;

public interface IBoardDocService {

	public void write(BoardDocDTO docDTO, HttpSession session);
	public void edit(BoardDocDTO docDTO, HttpSession session);
	public BoardDocDTO view(Integer docId);
	
	public void remove(Integer docId);
	public void removeWithMemo(Integer docId);
	
	public List<BoardDocDTO> list(BoardSearchDTO search);
	public List<BoardDocDTO> listPhoto(BoardSearchDTO search);
	public List<BoardDocDTO> listByUserId(BoardSearchDTO search);
	
	public List<BoardDocDTO> listMain();
	
	public void increaseHit(Integer docId);
	
	public void increaseMemoNum(Integer docId);
	public void decreaseMemoNum(Integer docId);
}
