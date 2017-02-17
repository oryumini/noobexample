package kr.co.from.board.dao;

import java.util.List;

import kr.co.from.board.dto.BoardMapDTO;

public interface IBoardMapDAO {

	public void insert(BoardMapDTO boardDTO);
	public void update(BoardMapDTO boardDTO);
	public BoardMapDTO selectOne(Integer mapId);
	public void remove(Integer mapId);
	
	public List<BoardMapDTO> selectList();
}
