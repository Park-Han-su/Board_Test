package rest.board.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import rest.board.vo.Board;

@Repository
public class BoardDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	public int insert(Board board) {
		return sqlSession.insert("rest.board.mapper.BoardMapper.insert", board);
	}
	
	public int selectCount() {
		return sqlSession.selectOne("rest.board.mapper.BoardMapper.selectCount");
	}
	
	public List<Board> selectList(Board board){
		return sqlSession.selectList("rest.board.mapper.BoardMapper.select", board);
	}
	
	public Board selectOne(Board board){
		return sqlSession.selectOne("rest.board.mapper.BoardMapper.select", board);
	}
	
	public int delete(Board board){
		return sqlSession.delete("rest.board.mapper.BoardMapper.delete", board);
	}
	
	public int update(Board board){
		return sqlSession.update("rest.board.mapper.BoardMapper.update", board);
	}

}
