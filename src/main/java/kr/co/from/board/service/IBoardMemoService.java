package kr.co.from.board.service;

import java.util.List;
import kr.co.from.board.dto.BoardMemoDTO;

public interface IBoardMemoService {

	public void write(BoardMemoDTO memoDTO);
	public void edit(BoardMemoDTO memoDTO);
	public BoardMemoDTO view(Integer memoId);
	public void remove(Integer memoId);
	
	public List<BoardMemoDTO> list(Integer docId);
}
