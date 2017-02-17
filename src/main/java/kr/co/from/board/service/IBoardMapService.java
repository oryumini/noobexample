package kr.co.from.board.service;

import java.util.List;

import kr.co.from.board.dto.BoardMapDTO;

public interface IBoardMapService {

	public void write(BoardMapDTO boardDTO);
	public void edit(BoardMapDTO boardDTO);
	public BoardMapDTO view(Integer mapId);
	public void remove(Integer mapId);
	
	public List<BoardMapDTO> list();

	
}
