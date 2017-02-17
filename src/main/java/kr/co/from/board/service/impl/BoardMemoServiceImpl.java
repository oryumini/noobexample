package kr.co.from.board.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.from.board.dao.IBoardMemoDAO;
import kr.co.from.board.dto.BoardMemoDTO;
import kr.co.from.board.service.IBoardDocService;
import kr.co.from.board.service.IBoardMemoService;

@Service
public class BoardMemoServiceImpl implements IBoardMemoService {

	@Autowired IBoardMemoDAO BoardMemoDAOImpl = null;
	@Autowired IBoardDocService boardDocServiceImpl = null;
	
	@Override
	public void write(BoardMemoDTO memoDTO) {
		
		BoardMemoDAOImpl.insert(memoDTO);
		boardDocServiceImpl.increaseMemoNum(memoDTO.getDocId());

	}

	@Override
	public void edit(BoardMemoDTO memoDTO) {
		BoardMemoDAOImpl.update(memoDTO);

	}

	@Override
	public BoardMemoDTO view(Integer memoId) {
		
		return BoardMemoDAOImpl.selectOne(memoId);
	}

	@Override
	public void remove(Integer memoId) {
		
		BoardMemoDTO boardMemoDTO = view(memoId);
		BoardMemoDAOImpl.remove(memoId);
		boardDocServiceImpl.decreaseMemoNum(boardMemoDTO.getDocId());

	}

	@Override
	public List<BoardMemoDTO> list(Integer docId) {
		
		return BoardMemoDAOImpl.selectList(docId);
	}

}
