package com.gang.home.board.qna;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.gang.home.util.Pager;


@RequestMapping(value="/qna/*")
@Controller
public class QnaController {

	@Autowired
	private QnaService qnaService;
	
	@GetMapping("List")
	public ModelAndView getList(ModelAndView mv, Pager pager) throws Exception{
		List<QnaVO> ar = qnaService.getList(pager);
		
		mv.addObject("ar", ar);
		mv.addObject("pager", pager);
		mv.setViewName("/board/list");
		
		return mv;
	}
}
