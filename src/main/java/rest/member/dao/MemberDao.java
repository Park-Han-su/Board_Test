package rest.member.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import rest.member.vo.Member;

@Repository
public class MemberDao {
	
	@Autowired
	private SqlSession sqlSession;

	public Member selectOne(Member member){
		return sqlSession.selectOne("rest.member.mapper.MemberMapper.select", member);
	}
}
