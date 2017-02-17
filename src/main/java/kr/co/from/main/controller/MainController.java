package kr.co.from.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.co.from.board.dto.BoardDocDTO;
import kr.co.from.board.service.IBoardDocService;

@Controller
public class MainController {
	
	@Autowired IBoardDocService boardDocServiceImpl = null;
	
	@RequestMapping(value="/main/index", method=RequestMethod.GET)
	public void main(Model model) {
		
		
		List<BoardDocDTO> list = boardDocServiceImpl.listMain();
		
		model.addAttribute("list", list);
		
	}
	
	@RequestMapping(value="/main/main", method=RequestMethod.GET)
	public void fullList(Model model) {

		
	}

}
