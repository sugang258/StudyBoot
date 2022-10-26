package com.gang.home.board.qna;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.gang.home.util.Pager;


@RequestMapping(value="/qna/*")
@Controller
public class QnaController {

	@Autowired
	private QnaService qnaService;
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@GetMapping("List")
	public ModelAndView getList(ModelAndView mv, Pager pager) throws Exception{
		List<QnaVO> ar = qnaService.getList(pager);
		
		mv.addObject("ar", ar);
		mv.addObject("pager", pager);
		mv.setViewName("/board/list");
		
		return mv;
	}
	
	@GetMapping("write")
	public String setAdd() throws Exception{
		return "./board/write";
	}
	
	@PostMapping("write")
	public String setAdd(QnaVO qnaVO,RedirectAttributes redirectAttributes) throws Exception{
		
		qnaVO.setWriter("수갱");
		int result = qnaService.setAdd(qnaVO);
		redirectAttributes.addAttribute("result", result);
		return "redirect:./List";
		
	}
	
	@GetMapping("detail")
	public ModelAndView getDetail(QnaVO qnaVO,ModelAndView mv) throws Exception{
		qnaVO = qnaService.getDetail(qnaVO);
		mv.addObject("qnaVO", qnaVO);
		mv.setViewName("/board/detail");

		return mv;
	}
	
}
