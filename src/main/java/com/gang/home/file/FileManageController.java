package com.gang.home.file;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import com.gang.home.board.qna.QnaFileVO;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class FileManageController {

	@GetMapping("/fileDown/{path}") //RestFul, RestAPI
	public ModelAndView fileDown(@PathVariable String path, QnaFileVO qnaFileVO) throws Exception{
		log.info("===================");
		log.info("Path : {}",path);
		ModelAndView mv = new ModelAndView();
		
		if(path.equals("qna")) {
			qnaFileVO.setFileName("8aaeaf5b-96fe-418b-abac-6df9d7db9c39_3b9e2db0-f503-4732-8704-f504319b780e_chunsik_춘식.png");
			qnaFileVO.setOriName("춘식.png");
			
		}else if(path.equals("notice")) {
			qnaFileVO.setFileName("palace.jpg");
			qnaFileVO.setOriName("경복궁.png");
		}
		
		//DB에서 정보 조회
		
		mv.addObject("fileVO", qnaFileVO);
		mv.addObject("path", path);

		mv.setViewName("fileManager");
		
		return mv;
		
	}
}
