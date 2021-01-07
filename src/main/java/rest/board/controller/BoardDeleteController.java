package rest.board.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import rest.board.service.BoardService;
import rest.board.vo.Board;

@Controller
@RequestMapping("/board")
public class BoardDeleteController {
	
	@Autowired
	private BoardService boardService;

	@GetMapping("/delete")
	public String delete(Board board, HttpServletRequest request) {
		int count = boardService.delete(board);
		if (1 == count) {
			request.setAttribute("msg", "board delete success");
		} else {
			request.setAttribute("msg", "board delete failed");
		}
		request.setAttribute("uri", request.getContextPath() + "/main");
		return "common/alert";
	}
}
