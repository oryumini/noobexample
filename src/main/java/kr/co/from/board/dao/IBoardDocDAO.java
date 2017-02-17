package kr.co.from.board.dao;

import java.util.List;

import kr.co.from.board.dto.BoardDocDTO;
import kr.co.from.board.dto.BoardSearchDTO;

public interface IBoardDocDAO {

	public void insert(BoardDocDTO docDTO);
	public void update(BoardDocDTO docDTO);
	public BoardDocDTO selectOne(Integer docId);
	public void remove(Integer docId);
	
	public List<BoardDocDTO> selectList(BoardSearchDTO search);
	public List<BoardDocDTO> selectListPhoto(BoardSearchDTO search);
	public List<BoardDocDTO> selectListByUserId(BoardSearchDTO search);
	
	public List<BoardDocDTO> selectListMain();
	
	public void increaseHit(Integer docId);
	
	public void increaseMemoNum(Integer docId);
	public void decreaseMemoNum(Integer docId);
	
	public int selectCount(BoardSearchDTO search);
	public int selectCountPhoto(BoardSearchDTO search);
	public int selectCountByUserId(BoardSearchDTO search);
	
}
