package ks47team02.user.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import ks47team02.user.dto.ProfileIntro;

@Mapper
public interface ProfileIntroMapper {
	
	//자기소개 등록
	public int profileIntroInsert(ProfileIntro profileIntro);
	
	
	// 자기소개 목록 조회 
	public List<ProfileIntro> getProfileIntroList();

}
