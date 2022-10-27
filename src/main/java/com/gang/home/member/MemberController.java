package com.gang.home.member;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
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
	public String setAdd(MemberVO memberVO) throws Exception{
		memberVO.setEnabled(true);
		int result = memberService.setAdd(memberVO);
		return "redirect:../";
	}
	
	@GetMapping("login")
	public String getLogin() throws Exception{
		return "/member/login";
	}
	
	@PostMapping("login")
	public String getLogin(MemberVO memberVO,HttpSession session,ModelAndView mv) throws Exception{
		
		memberVO = memberService.getLogin(memberVO);
		log.info("memberVO :{}",memberVO);
		session.setAttribute("member", memberVO);
		return "redirect:../";
		
	}
	
	@GetMapping("logout")
	public String getLogout(HttpSession session) throws Exception{
		session.invalidate();
		return "redirect:../";
	}
	
	@GetMapping("idCheck")
	@ResponseBody
	public int getIdCheck(MemberVO memberVO) throws Exception{
		return memberService.getIdCheck(memberVO);
	}
	
	@PostMapping("test")
	@ResponseBody
	public MemberVO setTest(MemberVO memberVO, String[] ar) throws Exception{
		log.info("=================]");
		log.info("ID: {}", memberVO.getId());
		log.info("name :{}",memberVO.getName());
		log.info("ar :{}",ar);
		
//		int result =memberService.getIdCheck(memberVO);
//		if (result ==0) {
//			
//			throw new Exception("뾰로롱");
//		}
//		return result;
		
		for(String s:ar) {
			log.info("ar: {}",s);
		}
		
		return memberVO;
	}
}
