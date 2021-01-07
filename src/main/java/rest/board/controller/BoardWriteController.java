package rest.board.controller;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import rest.board.service.BoardService;
import rest.board.vo.Board;
import rest.member.vo.Member;

@Controller
@RequestMapping("/board")
@PropertySource("classpath:application.properties")
public class BoardWriteController {

	@Value("${file.upload.location}")
	private String fileUploadLocation;

	@Autowired
	private BoardService boardService;

	@GetMapping("/write")
	public String write() {
		return "board/write";
	}

	@PostMapping("/write")
	public String write(@Valid Board board, HttpSession session, HttpServletRequest request) throws Exception {
		MultipartFile file1 = board.getFile1();
		String file1Name = file1.getOriginalFilename();
		if (!"".equals(file1Name)) {
			String fileName = file1Name.substring(0, file1Name.lastIndexOf("."));
			String extension = file1Name.substring(file1Name.lastIndexOf(".") + 1);
			String file1SName = getUniqueFileName(fileName, extension);
			File uploadFile = new File(fileUploadLocation + file1SName);
			file1.transferTo(uploadFile);
			board.setFile1Name(file1Name);
			board.setFile1SName(file1SName);
		}
		board.setM_id(((Member) session.getAttribute("MEMBER")).getId());
		int count = boardService.write(board);
		if (1 == count) {
			request.setAttribute("msg", "board write success");
		} else {
			request.setAttribute("msg", "board write failed");
		}
		request.setAttribute("uri", request.getContextPath() + "/main");
		return "common/alert";
	}

	private static String getUniqueFileName(String fileName, String extension) {
		return fileName + "_" + System.currentTimeMillis() + "_" + System.nanoTime() + "." + extension;
	}

}
