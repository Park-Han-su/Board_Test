package rest.board.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import rest.board.service.BoardService;
import rest.board.vo.Board;
import rest.common.ResultObject;

@RestController
public class BoardRestController {
	
	@Autowired
	private BoardService boardService;
	
	@PostMapping("/api/board/write")
	public ResponseEntity write(@RequestBody @Valid Board board) {
		int count = boardService.write(board);
		ResultObject ro;
		if (1 == count) {
			ro = new ResultObject("0","success");
		} else {
			ro = new ResultObject("1","fail");
		}
		return ResponseEntity.ok(ro);
	}
	
	@GetMapping("/api/board/read")
	public ResponseEntity read() {
		return ResponseEntity.ok(boardService.readListRest(null));
	}
	
	@GetMapping("/api/board/read/{id}")
	public ResponseEntity readById(Board board) {
		return ResponseEntity.ok(boardService.readOne(board));
	}

}
