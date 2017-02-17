package kr.co.from.common.controller;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.from.board.dao.impl.BoardFileDAOImpl;
import kr.co.from.board.dto.BoardFileDTO;
import kr.co.from.common.file.FileService;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/file")
public class FileController {

	@Autowired private FileService fileService = null;
	@Autowired private BoardFileDAOImpl boardFileDAOImpl = null;
	
	@RequestMapping(value="/download", method=RequestMethod.GET)
	public void download(@RequestParam("fileId") Integer fileId
			, HttpServletResponse response
			, HttpSession session){
		
		BoardFileDTO fileDTO = boardFileDAOImpl.selectOne(fileId);
		fileService.downloadFile(response, session, fileDTO);
	}
}
