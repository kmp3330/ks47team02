package ks47team02.admin.profile.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import ks47team02.user.profile.dto.ProfileSkill;

@Mapper
public interface AdminProfileSkillMapper {
	
	public List<ProfileSkill> getProfileSkillList();
	
}

