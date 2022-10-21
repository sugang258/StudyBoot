package com.gang.home.board.qna;

import java.io.File;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.gang.home.util.FileManager;
import com.gang.home.util.Pager;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@Transactional(rollbackFor = Exception.class)
public class QnaService {
	
	@Autowired
	private QnaMapper qnaMapper;
	@Autowired
	private FileManager fileManager;
	
	@Value("${app.upload.qna}")
	private String path;
	
	
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
		int result = qnaMapper.setAdd(qnaVO);

		File file = new File(path);
		
		if(!file.exists()) {
			boolean check = file.mkdirs();
		}	
		
	
		
		for(MultipartFile f : qnaVO.getFiles()) {
			if(!f.isEmpty()) {
				String fileName = fileManager.saveFile(f, path);
				QnaFileVO qnaFileVO = new QnaFileVO();
				qnaFileVO.setFileName(fileName);
				qnaFileVO.setOriName(f.getOriginalFilename());
				qnaFileVO.setNum(qnaVO.getNum());
				qnaMapper.setFileAdd(qnaFileVO);
			}
		}
		return result;
	}
	
	public QnaVO getDetail(QnaVO qnaVO) throws Exception{
		return qnaMapper.getDetail(qnaVO);
	}
}
