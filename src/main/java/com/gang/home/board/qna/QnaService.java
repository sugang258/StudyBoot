package com.gang.home.board.qna;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.gang.home.util.Pager;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class QnaService {
	
	@Autowired
	private QnaMapper qnaMapper;
	//private final Logger log = LoggerFactory.getLogger(this.getClass());

	
	public List<QnaVO> getList(Pager pager) throws Exception{
		
		log.info("page : " + pager.getPage());
		Long totalCount = qnaMapper.getCount();
		log.info("total : "+ totalCount);
		pager.getNum(totalCount);
		pager.getRowNum();
		return qnaMapper.getList(pager);
		
	}
	
	public int setAdd(QnaVO qnaVO) throws Exception{
		for(MultipartFile f : qnaVO.getFiles()) {
			if(!f.isEmpty()) {
				log.info("FileName : {}",f.getOriginalFilename());			
			}
		}
		return 1;//qnaMapper.setAdd(qnaVO);
	}
}
