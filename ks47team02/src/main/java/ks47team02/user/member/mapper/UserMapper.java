package ks47team02.user.member.mapper;

import org.apache.ibatis.annotations.Mapper;

import ks47team02.user.member.dto.User;

@Mapper
public interface UserMapper {
	
	// 로그인 시 아이디, 비밀번호, 권한 조회
	public User loginCheck(String userId);

}
