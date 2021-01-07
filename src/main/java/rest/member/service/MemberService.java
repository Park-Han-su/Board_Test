package rest.member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import rest.member.dao.MemberDao;
import rest.member.vo.Member;

@Service
@Transactional
public class MemberService {
	
	@Autowired
	private MemberDao memberDao;
	
	public Member readOne(Member member) {
		return memberDao.selectOne(member);
	}
}
