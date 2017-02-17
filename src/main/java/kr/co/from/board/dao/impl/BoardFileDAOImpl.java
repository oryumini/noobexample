package kr.co.from.board.dao.impl;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import kr.co.from.board.dao.IBoardFileDAO;
import kr.co.from.board.dto.BoardFileDTO;

@Repository
public class BoardFileDAOImpl extends SqlSessionDaoSupport implements IBoardFileDAO {

	@Override
	public void insertData(BoardFileDTO boardFileDTO) {
		getSqlSession().insert("BoardFile.insertData", boardFileDTO);

	}

	@Override
	public void deleteData(Integer fileId) {
		getSqlSession().delete("BoardFile.deleteData", fileId);

	}

	@Override
	public void deleteWithDoc(Integer docId) {
		getSqlSession().delete("BoardFile.deleteWithDoc", docId);
		
	}
	
	@Override
	public List<BoardFileDTO> selectList(Integer docId) {
		
		return getSqlSession().selectList("BoardFile.selectList", docId);
	}

	@Override
	public BoardFileDTO selectOne(Integer fileId) {
		return getSqlSession().selectOne("BoardFile.selectOne", fileId);
	}

	


}
