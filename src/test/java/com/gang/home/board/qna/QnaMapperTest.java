//package com.gang.home.board.qna;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//import java.util.List;
//
//import org.junit.jupiter.api.AfterAll;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeAll;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.annotation.Rollback;
//import org.springframework.test.context.event.annotation.AfterTestClass;
//import org.springframework.test.context.event.annotation.BeforeTestClass;
//import org.springframework.transaction.annotation.Transactional;
//
//@SpringBootTest
////@Rollback(true)
//@Transactional
//class QnaMapperTest {
//	private final Logger log = LoggerFactory.getLogger(this.getClass());
//	@Value("${my.default}")
//	private String app;
//	
//	@Autowired
//	private QnaMapper qnaMapper;
//	private QnaVO qnaVO;
//	
//	//@BeforeAll
//	static void befoClass() {
//		System.out.println("전체 Test 실행 전");
//	}
//	
//	//@AfterAll
//	static void afterClass() {
//		System.out.println("전체 Test 실행 후");
//	}
//	
//	//TEST 여러개 만들지 않고 여기에서 선언해서 사용하면 됨
//	//@BeforeEach
//	void beforeEach() {
//		System.out.println("Test 메서드 실행 전");
//		qnaVO = new QnaVO();
//		qnaVO.setContents("1L");
//		qnaVO.setWriter("TTT");
//	}
//	
//	//@AfterEach
//	void afterEach() {
//		System.out.println("Test 메서드 실행 후");
//	}
//	
//	//@Test
//	void test2() {
//		log.info("test2 case");
//	}
//	
//	//@Test
////	void test() throws Exception{
////		List<QnaVO> ar = qnaMapper.getList();
////		log.warn("List : {}",ar);
////		assertNotEquals(0, ar.size());
////	}
//	
////	@Test
////	void setAdd() throws Exception{
////		QnaVO qnaVO = new QnaVO();
////		int result = 0;
////		log.info("===================={}===============",app);
////			qnaVO.setTitle("배고파");
////			qnaVO.setWriter("수갱갱갱갱");
////			qnaVO.setContents("뭐먹지");
////			//result = qnaMapper.setAdd(qnaVO);
////		
////		assertNotEquals(0,1);
////	}
//	
//	//@Test
//	void setFileAdd() throws Exception{
//		QnaFileVO qnaFileVO = new QnaFileVO();
//		qnaFileVO.setNum(99L);
//		qnaFileVO.setFileName("sususu");
//		qnaFileVO.setOriName("ganggang");
//		int result = qnaMapper.setFileAdd(qnaFileVO);
//		
//		assertNotEquals(0, result);
//	}
//	
//	//@Test
//	void getDetail() throws Exception{
//		QnaVO qnaVO = new QnaVO();
//		qnaVO.setNum(99L);
//		
//		qnaVO = qnaMapper.getDetail(qnaVO);
//		assertNotNull(qnaVO);
//	}
//}
