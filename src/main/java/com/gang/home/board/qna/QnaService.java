package com.gang.home.board.qna;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gang.home.util.Pager;

@Service
public class QnaService {
	
	@Autowired
	private QnaMapper qnaMapper;
	private final Logger log = LoggerFactory.getLogger(this.getClass());

	
	public List<QnaVO> getList(Pager pager) throws Exception{
		
		log.info("page : " + pager.getPage());
		Long totalCount = qnaMapper.getCount();
		log.info("total : "+ totalCount);
		pager.getNum(totalCount);
		pager.getRowNum();
		return qnaMapper.getList(pager);
		
	}
}
