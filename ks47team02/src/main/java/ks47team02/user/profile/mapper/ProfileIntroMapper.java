package ks47team02.user.profile.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import ks47team02.user.profile.dto.ProfileCertificate;
import ks47team02.user.profile.dto.ProfileIntro;

@Mapper
public interface ProfileIntroMapper {
	//자기소개 삭제
	public int profileIntroDelete(String userIntroCode);
	
	//자기소개 정보 수정
	public int profileIntroModify(ProfileIntro profileIntro);
	
	//자기소개 상세조회
	public ProfileIntro getProfileIntroInfoByCode(String userIntroCode);
	
	//자기소개 등록
	public int profileIntroInsert(ProfileIntro profileIntro);
	
	
	// 자기소개 목록 조회 
	public List<ProfileIntro> getProfileIntroList();

}
