package kr.co.from.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.from.board.dto.BoardMapDTO;
import kr.co.from.board.service.IBoardMapService;

@Controller
@RequestMapping(value="/board/map")
public class BoardMapController {
	
	@Autowired IBoardMapService boardMapServiceImpl = null;
	
	@ResponseBody
	@RequestMapping(value="/list", method=RequestMethod.POST)
	public List<BoardMapDTO> list() {
		
		List<BoardMapDTO> list = boardMapServiceImpl.list();
		
		return list;
		
	}
	
}
