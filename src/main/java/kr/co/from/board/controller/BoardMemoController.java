package kr.co.from.board.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.from.board.dto.BoardMemoDTO;
import kr.co.from.board.service.IBoardMemoService;
import kr.co.from.common.security.SecuritySession;

@Controller
@RequestMapping("/board/memo")
public class BoardMemoController {

	private static final Logger logger = LoggerFactory.getLogger(BoardMemoController.class);
	
	@Autowired private IBoardMemoService boardMemoServiceImpl = null;
	
	
	/**
	 * 댓글 리스트 표시
	 * @param model
	 * @param docId
	 */
	@RequestMapping(value="/list", method=RequestMethod.POST)
	public void memoList(Model model
						, @RequestParam("docId") Integer docId) {
		
		List<BoardMemoDTO> list = boardMemoServiceImpl.list(docId);
		
		model.addAttribute("memolist", list);
		
	}

	/**
	 * 댓글 작성
	 * @param model
	 * @param boardMemoDTO
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/write.json", method=RequestMethod.POST)
	public Integer doWrite(BoardMemoDTO boardMemoDTO) {
		
		try {
			
			boardMemoDTO.setUserId(SecuritySession.getCurrentUser().getUserId());
			boardMemoServiceImpl.write(boardMemoDTO);
			
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("[ERROR]",e);
			
			return 0;
		}

		return 1;
	}
	
	/**
	 *	댓글 삭제
	 * @param model
	 * @param memoId
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/remove.json", method=RequestMethod.POST)
	public Integer remove(@RequestParam("memoId") Integer memoId) {

		try {
			
			boardMemoServiceImpl.remove(memoId);						// 삭제 수행
						
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("[ERROR]",e);
			
			return 0;
		}
		
		return 1;
		
	}
	
}
