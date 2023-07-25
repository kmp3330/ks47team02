package ks47team02.user.profile.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import ks47team02.user.profile.dto.ProfileIntro;
import ks47team02.user.profile.dto.ProfileSkill;

@Mapper
public interface ProfileSkillMapper {
	//보유기술 삭제 
	public int profileSkillDelete(String userSkillCode);
	//보유기술 정보 수정 
	public int profileSkillModify(ProfileSkill profileSkill);
	//보유기술 상세조회
	public ProfileSkill getProfileSkillInfoByCode(String userSkillCode);
	//보유기술 등록
	public int profileSkillInsert(ProfileSkill profileSkill);
	//회원 보유기술 목록
	public List<ProfileSkill> getProfileSkillList(String sessionId);
}

