package com.gang.home.member;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface MemberMapper {
	
	public int setAdd(MemberVO memberVO) throws Exception;
	public MemberVO getLogin(MemberVO memberVO) throws Exception;
	public int setRole(RoleVO roleVO) throws Exception;

}
