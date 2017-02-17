package kr.co.from.board.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.from.board.dao.IBoardMapDAO;
import kr.co.from.board.dto.BoardMapDTO;
import kr.co.from.board.service.IBoardMapService;

@Service
public class BoardMapServiceImpl implements IBoardMapService {

	@Autowired private IBoardMapDAO boardDAOImpl = null;
	
	@Override
	public void write(BoardMapDTO boardDTO) {
		boardDAOImpl.insert(boardDTO);
	}

	@Override
	public void edit(BoardMapDTO boardDTO) {
		boardDAOImpl.update(boardDTO);

	}

	@Override
	public BoardMapDTO view(Integer mapId) {
		return boardDAOImpl.selectOne(mapId);
	}

	@Override
	public void remove(Integer mapId) {
		boardDAOImpl.remove(mapId);

	}

	@Override
	public List<BoardMapDTO> list() {
		return boardDAOImpl.selectList();
	}


}
