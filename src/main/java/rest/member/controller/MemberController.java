package rest.member.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import rest.member.service.MemberService;
import rest.member.vo.Member;

@Controller
@RequestMapping("/member")
public class MemberController {
	
	@Autowired
	private MemberService memberService;

	@GetMapping("/login")
	public String loginForm() {
		return "/member/login";
	}
	
//	@PostMapping("/login")
//	public String login(@RequestParam Map map,HttpServletRequest request) {
//		if(null == map.get("email")
//				||"".equals(map.get("email"))
//				||null == map.get("password")
//				||"".equals(map.get("password"))){
//			request.setAttribute("uri", request.getRequestURI());
//			request.setAttribute("msg", "NotEmpty email/password");
//			return "common/alert";
//		}
//		return "main";
//	}
	
	@PostMapping("/login")
	public String login(@Valid Member member,HttpSession session,HttpServletRequest request) {
		Member dbMember = memberService.readOne(member);
		if (null != dbMember) {
			session.setAttribute("MEMBER", dbMember);
		} else {
			request.setAttribute("uri", request.getRequestURI());
			request.setAttribute("msg", "Check email/password");
			return "common/alert";
		}
		return "main";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/main";
	}
}
