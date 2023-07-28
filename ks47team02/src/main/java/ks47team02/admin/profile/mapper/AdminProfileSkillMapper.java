package ks47team02.admin.profile.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import ks47team02.user.profile.dto.ProfileSkill;

@Mapper
public interface AdminProfileSkillMapper {
	//보유기술 전체 조회
	public List<Map<String, Object>> getProfileSkillList(Map<String, Object> paramMap);
	//public List<ProfileSkill> getProfileSkillList();
	
	//보유기술 행 갯수
	public int getSkillCnt();
	
}

