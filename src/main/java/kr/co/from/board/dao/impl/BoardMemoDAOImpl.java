package kr.co.from.board.dao.impl;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import kr.co.from.board.dao.IBoardMemoDAO;
import kr.co.from.board.dto.BoardMemoDTO;

@Repository
public class BoardMemoDAOImpl extends SqlSessionDaoSupport implements IBoardMemoDAO {

	@Override
	public void insert(BoardMemoDTO memoDTO) {
		getSqlSession().insert("BoardMemo.insert", memoDTO);

	}

	@Override
	public void update(BoardMemoDTO memoDTO) {
		getSqlSession().update("BoardMemo.update", memoDTO);

	}

	@Override
	public BoardMemoDTO selectOne(Integer memoId) {		
		return getSqlSession().selectOne("BoardMemo.selectOne", memoId);
	}

	@Override
	public void remove(Integer memoId) {
		getSqlSession().delete("BoardMemo.delete", memoId);
	}
	
	@Override
	public void deleteByDocId(Integer docId) {
		getSqlSession().delete("BoardMemo.deleteByDocId", docId);
		
	}

	@Override
	public List<BoardMemoDTO> selectList(Integer docId) {		
		return getSqlSession().selectList("BoardMemo.selectList", docId);
	}


}
