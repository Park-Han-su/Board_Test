package rest.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import rest.board.service.BoardService;
import rest.board.vo.Board;
import rest.board.vo.Page;

@Controller
@RequestMapping("/board")
public class BoardReadListController {
	
	@Autowired
	private BoardService boardService;
	
	@GetMapping("/readList")
	public String readList(Page page, Board board, Model model) {
		boardService.readList(page,board,model);
		return "/board/readList";
	}

}
