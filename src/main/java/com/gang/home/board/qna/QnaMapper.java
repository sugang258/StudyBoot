package com.gang.home.board.qna;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gang.home.util.Pager;

@Repository //생략가능
@Mapper
public interface QnaMapper {
	
	
	public List<QnaVO> getList(Pager pager) throws Exception;
	public int setAdd(QnaVO qnaVO) throws Exception;
	public Long getCount() throws Exception;
	public int setFileAdd(QnaFileVO qnaFileVO) throws Exception;
	public QnaVO getDetail(QnaVO qnaVO) throws Exception;
	public QnaFileVO getFileDetail(QnaFileVO qnaFileVO) throws Exception;

}
