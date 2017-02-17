package kr.co.from.board.service.impl;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import kr.co.from.board.dao.IBoardDocDAO;
import kr.co.from.board.dao.IBoardFileDAO;
import kr.co.from.board.dao.IBoardMemoDAO;
import kr.co.from.board.dto.BoardDocDTO;
import kr.co.from.board.dto.BoardFileDTO;
import kr.co.from.board.dto.BoardMapDTO;
import kr.co.from.board.dto.BoardSearchDTO;
import kr.co.from.board.service.IBoardDocService;
import kr.co.from.board.service.IBoardMapService;
import kr.co.from.board.service.IBoardMemoService;
import kr.co.from.common.file.FileService;

@Service
public class BoardDocServiceImpl implements IBoardDocService {

	@Autowired IBoardDocDAO boardDocDAOImpl = null;
	@Autowired IBoardMemoDAO boardMemoDAOImpl = null;
	@Autowired IBoardFileDAO boardFileDAOImpl = null;
	@Autowired FileService fileService = null;
	
	@Autowired IBoardMemoService boardMemoServiceImpl = null;
	@Autowired IBoardMapService boardMapServiceImpl = null;
	
	private static final Logger logger = LoggerFactory.getLogger(BoardDocServiceImpl.class);
	
	
	@Transactional
	@Override
	public void write(BoardDocDTO docDTO, HttpSession session) {
		//1. 게시물 추가
		boardDocDAOImpl.insert(docDTO);
		
		//2. 파일 추가
		for(MultipartFile file : docDTO.getFiles()) {
					
			BoardFileDTO fileDTO = fileService.uploadSingleFile(file, session);
			fileDTO.setDocId(docDTO.getDocId());
			
			boardFileDAOImpl.insertData(fileDTO);
			
		}
		
	}

	
	@Transactional
	@Override
	public void edit(BoardDocDTO docDTO, HttpSession session) {
				
		
		for (Integer fileId : docDTO.getDelFileList()) {	
			//if문으로 플래그가 들어온 파일만 지운다.
			boardFileDAOImpl.deleteData(fileId);
		}
	
		
		//2. 첨부파일 추가
		for(MultipartFile file : docDTO.getFiles()) {
			
			logger.debug("file =======> " + file.getOriginalFilename() + ", size ====> " + file.getSize());
			
			
			BoardFileDTO fileDTO = fileService.uploadSingleFile(file, session);
			fileDTO.setDocId(docDTO.getDocId());
			
			boardFileDAOImpl.insertData(fileDTO);
			
			logger.debug("=======>" + fileDTO.toString());
		}
		
		//3. 게시물 수정
		boardDocDAOImpl.update(docDTO);
		
	}

	@Override
	public BoardDocDTO view(Integer docId) {
		
		//조회수 증가
		increaseHit(docId);
		
		//게시물 정보
		BoardDocDTO boardDocDTO = boardDocDAOImpl.selectOne(docId);
		
		//맵 정보
		BoardMapDTO boardMapDTO = boardMapServiceImpl.view(boardDocDTO.getMapId());
		boardDocDTO.setBoardMapDTO(boardMapDTO);
		
		
		//첨부파일 가져오기, 이미지 표시를 위한 첨부파일의 파일타입 기록
		List<BoardFileDTO> fileList = boardFileDAOImpl.selectList(docId);
		
		for (BoardFileDTO boardFileDTO : fileList) {
			boardFileDTO.setFileType(boardFileDTO.getFileType().substring(0, 5));
			
		}
		
		boardDocDTO.setFileList(fileList);
				
		//댓글 가져오기 - ajax로 처리
		
		//이것저것 많이 먹고 비대해진 보드독DTO를 리턴한다.
		return boardDocDTO;
	}

	//첨부파일 제거도 함
	@Transactional
	@Override
	public void remove(Integer docId) {
		boardFileDAOImpl.deleteWithDoc(docId);
		boardDocDAOImpl.remove(docId);
		
	}
	
	//첨부파일 제거도 함
	@Transactional
	@Override
	public void removeWithMemo(Integer docId) {
		//
		//1. 댓글 삭제
		boardMemoDAOImpl.deleteByDocId(docId);
		//2. 첨부파일 삭제
		boardFileDAOImpl.deleteWithDoc(docId);
		//3. 게시물 삭제
		boardDocDAOImpl.remove(docId);
		
	}

	@Override
	public List<BoardDocDTO> list(BoardSearchDTO search) {
		
		logger.debug("========> 검색어 : " + search.getSearchText() + " /// 검색타입 : " + search.getSearchType() );
		
		//1. 전체 게시물 개수 가져오기
		int cnt = boardDocDAOImpl.selectCount(search);
		search.setTotal(cnt);
		//search.setRows(3);
		
		logger.debug(" search =========>" + search.toString());
		
		//2. 게시물 목록 가져오기
		List<BoardDocDTO> list = boardDocDAOImpl.selectList(search);
		
		//3. 게시물에 대응하는 파일 리스트 매칭시키기 + 섬네일 표시를 위한 파일타입 수정
		for (BoardDocDTO boardDocDTO : list) {
			List<BoardFileDTO> fileList = boardFileDAOImpl.selectList(boardDocDTO.getDocId());
			
			for (BoardFileDTO boardFileDTO : fileList) {
				boardFileDTO.setFileType(boardFileDTO.getFileType().substring(0, 5));
				
			}
			
			boardDocDTO.setFileList(fileList);
		}
		
		return list; 
	}
	

	@Override
	public List<BoardDocDTO> listPhoto(BoardSearchDTO search) {
		
		logger.debug("========> 검색어 : " + search.getSearchText() + " /// 검색타입 : " + search.getSearchType() );
		
		//1. 전체 게시물 개수 가져오기
		int cnt = boardDocDAOImpl.selectCountPhoto(search);
		search.setTotal(cnt);
		//search.setRows(3);
		
		logger.debug(" search =========>" + search.toString());
		
		//2. 게시물 목록 가져오기
		List<BoardDocDTO> list = boardDocDAOImpl.selectListPhoto(search);
		
		//3. 게시물에 대응하는 파일 리스트 매칭시키기 + 섬네일 표시를 위한 파일타입 수정
		for (BoardDocDTO boardDocDTO : list) {
			List<BoardFileDTO> fileList = boardFileDAOImpl.selectList(boardDocDTO.getDocId());
			
			for (BoardFileDTO boardFileDTO : fileList) {
				boardFileDTO.setFileType(boardFileDTO.getFileType().substring(0, 5));
				
			}
			
			boardDocDTO.setFileList(fileList);
		}
		
		return list; 
	}
	
	@Override
	public List<BoardDocDTO> listMain() {
		
		List<BoardDocDTO> list = boardDocDAOImpl.selectListMain();
		
		for (BoardDocDTO boardDocDTO : list) {
			List<BoardFileDTO> fileList = boardFileDAOImpl.selectList(boardDocDTO.getDocId());
			boardDocDTO.setFileList(fileList);
		}
		
		return list;
	}
	
	@Override
	public List<BoardDocDTO> listByUserId(BoardSearchDTO search) {
		
		int cnt = boardDocDAOImpl.selectCountByUserId(search);
		search.setTotal(cnt);
		
		List<BoardDocDTO> list = boardDocDAOImpl.selectListByUserId(search);
		
		for (BoardDocDTO boardDocDTO : list) {
			List<BoardFileDTO> fileList = boardFileDAOImpl.selectList(boardDocDTO.getDocId());
			boardDocDTO.setFileList(fileList);
		}
			
		return list;
	}

	@Override
	public void increaseHit(Integer docId) {
		boardDocDAOImpl.increaseHit(docId);
		
	}

	@Override
	public void increaseMemoNum(Integer docId) {
		boardDocDAOImpl.increaseMemoNum(docId);
		
	}

	@Override
	public void decreaseMemoNum(Integer docId) {
		boardDocDAOImpl.decreaseMemoNum(docId);
		
	}




}
