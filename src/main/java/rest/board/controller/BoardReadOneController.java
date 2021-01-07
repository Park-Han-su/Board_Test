package rest.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import rest.board.service.BoardService;
import rest.board.vo.Board;

@Controller
@RequestMapping("/board")
public class BoardReadOneController {
	
	@Autowired
	private BoardService boardService;
	
	@GetMapping("/readOne")
	public String readList(Board board, Model model) {
		model.addAttribute("board", boardService.readOne(board));
		return "/board/readOne";
	}

}
