package kr.co.from.board.dao;

import java.util.List;

import kr.co.from.board.dto.BoardMemoDTO;

public interface IBoardMemoDAO {

	public void insert(BoardMemoDTO memoDTO);
	public void update(BoardMemoDTO memoDTO);
	public BoardMemoDTO selectOne(Integer memoId);
	public void remove(Integer memoId);
	public void deleteByDocId(Integer docId);
	
	public List<BoardMemoDTO> selectList(Integer docId);
}
