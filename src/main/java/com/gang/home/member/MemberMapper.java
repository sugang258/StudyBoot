package com.gang.home.member;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface MemberMapper {
	
	public Integer getIdCheck(MemberVO memberVO) throws Exception;
	public int setAdd(MemberVO memberVO) throws Exception;
	public MemberVO getLogin(MemberVO memberVO) throws Exception;
	public int setRole(MemberVO memberVO) throws Exception;

}
