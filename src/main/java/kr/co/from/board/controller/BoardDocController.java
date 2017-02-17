package kr.co.from.board.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.from.board.dto.BoardDocDTO;
import kr.co.from.board.dto.BoardMapDTO;
import kr.co.from.board.dto.BoardMemoDTO;
import kr.co.from.board.dto.BoardSearchDTO;
import kr.co.from.board.service.IBoardDocService;
import kr.co.from.board.service.IBoardMapService;
import kr.co.from.board.service.IBoardMemoService;
import kr.co.from.common.dto.ErrorDTO;
import kr.co.from.common.security.SecuritySession;
import kr.co.from.user.dto.UserDTO;

@Controller
@RequestMapping("/board/doc")
public class BoardDocController {
	
	private static final Logger logger = LoggerFactory.getLogger(BoardDocController.class);
	
	@Autowired private IBoardDocService boardDocServiceImpl = null;
	@Autowired private IBoardMapService boardMapServiceImpl = null;
	@Autowired private IBoardMemoService BoardMemoServiceImpl = null;

	
	@RequestMapping(value="/list", method=RequestMethod.POST)
	public void list(Model model
			, @ModelAttribute("search") BoardSearchDTO search){
		
		List<BoardDocDTO> list = boardDocServiceImpl.list(search);
		BoardMapDTO boardMapDTO = boardMapServiceImpl.view(search.getMapId());
		
		model.addAttribute("list", list);
		model.addAttribute("map", boardMapDTO);
	}
	
	
	/**
	 * 
	 * 사진게시판 게시물 보기
	 * @param model
	 * @param search
	 */
	@RequestMapping(value="/listphoto", method=RequestMethod.POST)
	public void listPhoto(Model model
			, @ModelAttribute("search") BoardSearchDTO search){
		
		List<BoardDocDTO> list = boardDocServiceImpl.listPhoto(search);
		BoardMapDTO boardMapDTO = boardMapServiceImpl.view(search.getMapId());
		
		model.addAttribute("list", list);
		model.addAttribute("map", boardMapDTO);
	}
	
	
	@RequestMapping(value="/listphoto", method=RequestMethod.GET)
	public void listPhoto2(Model model
			, @ModelAttribute("search") BoardSearchDTO search){
		
		List<BoardDocDTO> list = boardDocServiceImpl.listPhoto(search);
		BoardMapDTO boardMapDTO = boardMapServiceImpl.view(search.getMapId());
		
		model.addAttribute("list", list);
		model.addAttribute("map", boardMapDTO);
	}
	
	
	
	/**
	 * 로그인한 유저의 작성 글 보기
	 * @param model
	 * @param userId
	 */
	@RequestMapping(value="/listbyuserid", method=RequestMethod.GET)
	public void listByUserId(Model model
			, @ModelAttribute("search") BoardSearchDTO search){
		
		
		Integer userId = SecuritySession.getCurrentUser().getUserId();
		
		search.setUserId(userId);
		
		List<BoardDocDTO> list = boardDocServiceImpl.listByUserId(search);
		
		model.addAttribute("list", list);

	}
	
	
	/**
	 * 로그인한 유저의 작성 글 보기
	 * @param model
	 * @param userId
	 */
	@RequestMapping(value="/listbyuserid", method=RequestMethod.POST)
	public void listByUserId2(Model model
			, @ModelAttribute("search") BoardSearchDTO search){
		
		
		Integer userId = SecuritySession.getCurrentUser().getUserId();
		
		search.setUserId(userId);
		
		List<BoardDocDTO> list = boardDocServiceImpl.listByUserId(search);
		
		model.addAttribute("list", list);

	}
	
	/**
	 * 댓글 개수 불러오기
	 * @param docId
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/memoNum", method=RequestMethod.POST)
	public Integer memoNum(@RequestParam("docId") Integer docId) {
		
		Integer num = boardDocServiceImpl.view(docId).getMemoNum();
		
		return num;
		
	}
	
	/**
	 * 게시물 리스트 페이지
	 * @param model
	 * @param mapId
	 */
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public void list2(Model model
			, @ModelAttribute("Search") BoardSearchDTO search){
		
		List<BoardDocDTO> list = boardDocServiceImpl.list(search);
		BoardMapDTO boardMapDTO = boardMapServiceImpl.view(search.getMapId());
		
		model.addAttribute("list", list);
		model.addAttribute("map", boardMapDTO);
	}
	
	
	/**
	 * 글쓰기 페이지로 이동
	 * @param model
	 * @param mapId
	 */
	@RequestMapping(value="/write", method=RequestMethod.GET)
	public void goWrite(Model model
			, @RequestParam("mapId") Integer mapId) {
		
		BoardMapDTO boardMapDTO = boardMapServiceImpl.view(mapId);
		model.addAttribute("map", boardMapDTO);

	}
	
	/**
	 * 글 저장
	 * @param model
	 * @param boarddocDTO
	 * @return
	 */
	@RequestMapping(value="/write", method=RequestMethod.POST)
	public String doWrite(Model model
			, BoardDocDTO boarddocDTO
			, HttpSession session) {
		

		boarddocDTO.setUserId(SecuritySession.getCurrentUser().getUserId());
		
		boardDocServiceImpl.write(boarddocDTO, session);
		
		return "redirect:./view2?docId=" + boarddocDTO.getDocId();
	}
	
	/**
	 * 글 보기
	 * @param model
	 * @param docId
	 */
	@RequestMapping(value="/view", method=RequestMethod.GET)
	public void view(Model model
			, @RequestParam("docId") Integer docId ) {
		
		BoardDocDTO boardDocDTO = boardDocServiceImpl.view(docId);
		BoardMapDTO boardMapDTO = boardMapServiceImpl.view(boardDocDTO.getMapId());
		
		model.addAttribute("doc", boardDocDTO);
		model.addAttribute("map", boardMapDTO);
		
		//댓글 표시 - 게시글 로딩할 때 같이 로딩되도록 한다.
		List<BoardMemoDTO> list = BoardMemoServiceImpl.list(docId);		
		model.addAttribute("memolist", list);
	}
	
	/**
	 * 글 보기 another
	 * @param model
	 * @param docId
	 */
	@RequestMapping(value="/view2", method=RequestMethod.GET)
	public void view2(Model model
			, @RequestParam("docId") Integer docId ) {

		BoardDocDTO boardDocDTO = boardDocServiceImpl.view(docId);
		BoardMapDTO boardMapDTO = boardMapServiceImpl.view(boardDocDTO.getMapId());
		
		model.addAttribute("doc", boardDocDTO);
		model.addAttribute("map", boardMapDTO);

	}
	
	/**
	 * 글 수정 페이지로 이동
	 * @param model
	 * @param docId
	 */
	@RequestMapping(value="/edit", method=RequestMethod.GET)
	public void goEdit(Model model
			, @RequestParam("docId") Integer docId) {
		
		
		UserDTO user = SecuritySession.getCurrentUser();
		
		// 게시물 정보
		BoardDocDTO boardDocDTO = boardDocServiceImpl.view(docId);
		model.addAttribute("doc", boardDocDTO);

		// 최소한의 권한체크
		ErrorDTO errorDTO = new ErrorDTO();
		if (user.getUserId().intValue() != boardDocDTO.getUserId().intValue()){
			
			errorDTO.setCode(-1);
			errorDTO.setMsg("적합한 권한을 가진 유저가 아닙니다.");
			model.addAttribute("error", errorDTO);
		}
	}
	
	/**
	 * 글 수정 제출
	 * @param model
	 * @param boarddocDTO
	 * @return
	 */
	@RequestMapping(value="/edit", method=RequestMethod.POST)
	public String doEdit(BoardDocDTO boarddocDTO
			, HttpSession session) {
		
		
		boardDocServiceImpl.edit(boarddocDTO, session);
		
		return "redirect:./view2?docId=" + boarddocDTO.getDocId();
	}
	
	/**
	 * 글 삭제
	 * @param model
	 * @param docId
	 */
	@RequestMapping(value="/remove", method=RequestMethod.GET)
	public String remove(@RequestParam("docId") Integer docId) {
		
		BoardDocDTO boardDocDTO = boardDocServiceImpl.view(docId); //리턴 주소 지정을 위한 것
		Integer userId = SecuritySession.getCurrentUser().getUserId();
		
		if ( userId.equals(boardDocDTO.getUserId()) ) {
		
			boardDocServiceImpl.remove(docId);
			return "redirect:./list?mapId=" + boardDocDTO.getMapId();
			
		} else {
			
			return "hello world";
		}
		
	}
	
	/**
	 * 글 삭제 + 댓글 전부 삭제
	 * @param model
	 * @param docId
	 */
/*	@RequestMapping(value="/removememotoo", method=RequestMethod.GET)
	public String removeWithMemo(@RequestParam("docId") Integer docId) {
			
		BoardDocDTO boardDocDTO = boardDocServiceImpl.view(docId); //리턴 주소 지정을 위한 것
		Integer userId = SecuritySession.getCurrentUser().getUserId();
		
		if ( userId.equals(boardDocDTO.getUserId()) ) {
			
			boardDocServiceImpl.removeWithMemo(docId);	
			return "redirect:./list?mapId=" + boardDocDTO.getMapId();
			
		} else {
			
			return "hello world";
		}
		
	}*/
	
	/**
	 * 글 삭제 + 댓글, 첨부파일 전부 삭제
	 * @param model
	 * @param docId
	 */
	@ResponseBody
	@RequestMapping(value="/removememotoo.json", method=RequestMethod.POST)
	public Integer removeWithMemo(@RequestParam("docId") Integer docId) {
		
		try {
			BoardDocDTO boardDocDTO = boardDocServiceImpl.view(docId); //리턴 주소 지정을 위한 것
			Integer userId = SecuritySession.getCurrentUser().getUserId();
			
			if ( userId.equals(boardDocDTO.getUserId()) ) {
				
				boardDocServiceImpl.removeWithMemo(docId);	
				
			} else {
				
				return 0;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("[ERROR]",e);
			
			return 0;
		}
		
		return 1;
		
	}
	

}