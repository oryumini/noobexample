package kr.co.from.board.dao.impl;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import kr.co.from.board.dao.IBoardDocDAO;
import kr.co.from.board.dto.BoardDocDTO;
import kr.co.from.board.dto.BoardSearchDTO;

@Repository
public class BoardDocDAOImpl extends SqlSessionDaoSupport implements IBoardDocDAO {

	@Override
	public void insert(BoardDocDTO docDTO) {
		getSqlSession().insert("BoardDoc.insert", docDTO);
		
	}

	@Override
	public void update(BoardDocDTO docDTO) {
		getSqlSession().update("BoardDoc.update", docDTO);
		
	}

	@Override
	public BoardDocDTO selectOne(Integer docId) {		
		return getSqlSession().selectOne("BoardDoc.selectOne", docId);
	}

	@Override
	public void remove(Integer docId) {
		getSqlSession().delete("BoardDoc.delete", docId);
		
	}

	@Override
	public List<BoardDocDTO> selectList(BoardSearchDTO search) {		
		return getSqlSession().selectList("BoardDoc.selectList", search);
	}
	
	@Override
	public List<BoardDocDTO> selectListByUserId(BoardSearchDTO search) {		
		return getSqlSession().selectList("BoardDoc.selectListByUserId", search);
	}
	
	public List<BoardDocDTO> selectListMain(){
		return getSqlSession().selectList("BoardDoc.selectListMain");
	}

	@Override
	public void increaseHit(Integer docId) {
		getSqlSession().update("BoardDoc.updateHit", docId);
	}

	@Override
	public void increaseMemoNum(Integer docId) {
		getSqlSession().update("BoardDoc.updateMemoNumPlus", docId);
		
	}

	@Override
	public void decreaseMemoNum(Integer docId) {
		getSqlSession().update("BoardDoc.updateMemoNumMinus", docId);
		
	}

	@Override
	public int selectCount(BoardSearchDTO search) {
		return getSqlSession().selectOne("BoardDoc.selectCount", search);
	}

	@Override
	public int selectCountByUserId(BoardSearchDTO search) {
		return getSqlSession().selectOne("BoardDoc.selectCountByUserId", search);
	}

	@Override
	public List<BoardDocDTO> selectListPhoto(BoardSearchDTO search) {
		return getSqlSession().selectList("BoardDoc.selectListPhoto", search);
	}

	@Override
	public int selectCountPhoto(BoardSearchDTO search) {
		return getSqlSession().selectOne("BoardDoc.selectCountPhoto", search);
	}

}
