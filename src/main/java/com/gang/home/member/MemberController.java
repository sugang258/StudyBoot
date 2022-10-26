package com.gang.home.member;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@RequestMapping(value="/member/*")
@Controller
public class MemberController {

	@Autowired
	private MemberService memberService;
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());

	 
	@GetMapping("add")
	public String setAdd() throws Exception{
		
		return "member/add";
	}
	
	@PostMapping("add")
	public ModelAndView setAdd(MemberVO memberVO,ModelAndView mv,RoleVO roleVO) throws Exception{
		memberVO.setEnabled(true);
		int result = memberService.setAdd(memberVO);
		if(result == 1) {
			roleVO.setId(memberVO.getId());
			roleVO.setNum(3L);
			memberService.setRole(roleVO);
			mv.setViewName("/index");
		}
		
		return mv;
	}
	
	@GetMapping("login")
	public String getLogin() throws Exception{
		return "/member/login";
	}
	
	@PostMapping("login")
	public ModelAndView getLogin(MemberVO memberVO,HttpSession session,ModelAndView mv) throws Exception{
		
		memberVO = memberService.getLogin(memberVO);
		log.info("memberVO :{}",memberVO);
		if(memberVO.getId() != null) {
			session.setAttribute("member", memberVO);
			mv.addObject("member", memberVO);
			mv.setViewName("/index");
		}else {
			mv.setViewName("/member/add");
		}
		return mv;
		
	}
	
	@GetMapping("logout")
	public String getLogout(HttpSession session) throws Exception{
		session.invalidate();
		return "/index";
	}
}
