package com.gang.home.member;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.gang.home.board.qna.QnaMapper;

@SpringBootTest
@Transactional
class MemberTest {
	
	@Autowired
	private MemberMapper memberMapper;

	//@Test
	void test() throws Exception {
		MemberVO memberVO = new MemberVO();
		memberVO.setId("gang");
		memberVO.setPw("gang");
		memberVO.setName("수갱");
		memberVO.setEmail("gang");
		memberVO.setEnabled(true);
		
		int result = memberMapper.setAdd(memberVO);
		assertNotEquals(0, result);
		
	}
	
	//@Test
	void setRole() throws Exception{
		RoleVO roleVO = new RoleVO();
		roleVO.setNum(1L);
		roleVO.setId("susu");
		
		int result = memberMapper.setRole(roleVO);
		assertNotEquals(0, result);

	}
	
	//@Test
	void getLogin() throws Exception{
		MemberVO memberVO = new MemberVO();
		memberVO.setId("susu");
		memberVO.setPw("ssu");
		
		memberVO = memberMapper.getLogin(memberVO);
		
		
		assertNotNull(memberVO);
	}

}
