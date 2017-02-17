package kr.co.unified;

import java.util.List;

import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.co.from.board.dto.BoardDocDTO;
import kr.co.from.board.dto.BoardMapDTO;
import kr.co.from.board.dto.BoardSearchDTO;
import kr.co.from.board.service.IBoardDocService;
import kr.co.from.board.service.IBoardMapService;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={
		"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml",
"file:src/main/webapp/WEB-INF/spring/root-context.xml"})

public class Test2 {
	
/*	private static final Logger logger = LoggerFactory.getLogger(Test2.class);
	
	@Autowired private IBoardMapService boardServiceImpl = null;
	@Autowired private IBoardDocService boardDocServiceImpl = null;
	
	@org.junit.Test
	public void write() {
		
		BoardMapDTO boardDTO = new BoardMapDTO();
		
		
		boardDTO.setMapNm("board1");
		boardDTO.setMapOrder("order");
		boardDTO.setDeleteYN('Y');
		boardDTO.setMemoYN('N');
		
		boardServiceImpl.write(boardDTO);
		
	}
	
	@org.junit.Test
	public void view() {
		
		Integer mapId = 21;
		
		BoardMapDTO boardDTO = boardServiceImpl.view(mapId);
		
		logger.debug("=========>" + boardDTO.toString());
	}
	
	@org.junit.Test
	public void list() {
		
		List<BoardMapDTO> list = boardServiceImpl.list();
		
		for ( int i = 0 ; i < list.size() ; i++) {
			logger.debug("========>" + list.get(i).toString());
		}
	}
	
	@org.junit.Test
	public void write2() {
		
		BoardDocDTO boardDocDTO = new BoardDocDTO();
		
		boardDocDTO.setTitle("제목입니다33333");
		boardDocDTO.setDocContents("djdjdjdjdjdjd");
		boardDocDTO.setUserId(10000005);
		boardDocDTO.setMapId(44);
		
		boardDocServiceImpl.write(boardDocDTO, null);
	}
	
	@org.junit.Test
	public void update222() {
		
		BoardDocDTO boardDocDTO = new BoardDocDTO();
		
		Integer docId = 8;
		String title = "연습";
		String docContents = "연습연습연습연습";
		
		boardDocDTO.setDocId(docId);
		boardDocDTO.setTitle(title);
		boardDocDTO.setDocContents(docContents);
		
		boardDocServiceImpl.edit(boardDocDTO);
		
		selectOne();
		
	}
	@org.junit.Test
	public void remove2() {
		
		Integer docId = 6;
		
		boardDocServiceImpl.remove(docId);
	}
	
	@org.junit.Test
	public void selectOne() {
		
		Integer docId = 8;
		
		logger.debug("=======>" +  boardDocServiceImpl.view(docId).toString());
		
	}*/
	
	/*@org.junit.Test
	public void list2() {
		
		BoardSearchDTO mapId = 42;
		List<BoardDocDTO> list = boardDocServiceImpl.list(mapId);
		
		for (BoardDocDTO boardDocDTO : list) {
			logger.debug("=======>" + boardDocDTO);
		}
	}*/
}
