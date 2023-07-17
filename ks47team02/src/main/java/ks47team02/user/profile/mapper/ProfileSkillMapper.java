package ks47team02.user.profile.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import ks47team02.user.profile.dto.ProfileSkill;

@Mapper
public interface ProfileSkillMapper {

	//자기소개 보유기술 목록
	public List<ProfileSkill> getProfileSkillList();
}
