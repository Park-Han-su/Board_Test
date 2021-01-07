package rest.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import rest.board.dao.BoardDao;
import rest.board.vo.Board;
import rest.board.vo.Page;
import rest.common.PageUtil;

@Service
@Transactional
public class BoardService {
	
	@Autowired
	private BoardDao boardDao;

	public int write(Board board) {
		return boardDao.insert(board);
	}
	
	public List<Board> readListRest(Board board){
		return boardDao.selectList(board);
	}
	
	public void readList(Page page, Board board, Model model){
		if(0 == page.getPageNo()) page.setPageNo(1);
		board.setPageIndex((page.getPageNo()-1) * PageUtil.PER_PAGE_CNT);
		board.setPerPageCount(PageUtil.PER_PAGE_CNT);
		page.setPageCnt(PageUtil.getPageCnt(boardDao.selectCount()));
		model.addAttribute("boardList", boardDao.selectList(board));
		model.addAttribute("page", page);
	}
	
	public Board readOne(Board board){
		return boardDao.selectOne(board);
	}
	
	public int delete(Board board){
		return boardDao.delete(board);
	}
	
	public int update(Board board){
		return boardDao.update(board);
	}
}
