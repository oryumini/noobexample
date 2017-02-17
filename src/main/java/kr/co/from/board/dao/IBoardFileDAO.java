package kr.co.from.board.dao;

import java.util.List;

import kr.co.from.board.dto.BoardFileDTO;

public interface IBoardFileDAO {

	public void insertData(BoardFileDTO boardFileDTO);
	
	public void deleteData(Integer fileId);
	public void deleteWithDoc(Integer docId);
	
	public List<BoardFileDTO> selectList(Integer docId);
	public BoardFileDTO selectOne(Integer fileId);
	
	
}
