package kr.co.from.board.dao.impl;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import kr.co.from.board.dao.IBoardMapDAO;
import kr.co.from.board.dto.BoardMapDTO;

@Repository
public class BoardMapDAOImpl extends SqlSessionDaoSupport implements IBoardMapDAO {

	@Override
	public void insert(BoardMapDTO boardDTO) {
		getSqlSession().insert("BoardMap.insert", boardDTO);

	}

	@Override
	public void update(BoardMapDTO boardDTO) {
		getSqlSession().update("BoardMap.update", boardDTO);

	}

	@Override
	public BoardMapDTO selectOne(Integer mapId) {
		return getSqlSession().selectOne("BoardMap.selectOne", mapId);
		
	}

	@Override
	public void remove(Integer mapId) {
		getSqlSession().delete("BoardMap.delete", mapId);

	}

	@Override
	public List<BoardMapDTO> selectList() {
		return getSqlSession().selectList("BoardMap.selectList");
	}


}
