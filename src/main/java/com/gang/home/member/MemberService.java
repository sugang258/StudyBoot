package com.gang.home.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@Transactional(rollbackFor = Exception.class)
public class MemberService {
	
	@Autowired
	private MemberMapper memberMapper;
	 
	public int setAdd(MemberVO memberVO) throws Exception{
		return memberMapper.setAdd(memberVO);
	}
	public int setRole(RoleVO roleVO) throws Exception{
		return memberMapper.setRole(roleVO);
	}
	
	public MemberVO getLogin(MemberVO memberVO) throws Exception{
		return memberMapper.getLogin(memberVO);
	}
	
}
