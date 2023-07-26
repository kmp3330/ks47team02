package ks47team02.admin.profile.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ks47team02.user.profile.dto.ProfileEduSpec;
import ks47team02.user.profile.dto.ProfileIntro;
import ks47team02.user.profile.dto.ProfileSkill;
import ks47team02.user.profile.dto.ProfileWorkSpec;
import ks47team02.admin.profile.mapper.AdminProfileEduSpecMapper;
import ks47team02.admin.profile.mapper.AdminProfileIntroMapper;
import ks47team02.admin.profile.mapper.AdminProfileSkillMapper;
import ks47team02.admin.profile.mapper.AdminProfileWorkSpecMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Transactional
@AllArgsConstructor
@Slf4j
public class AdminProfileService {
	private final AdminProfileIntroMapper adminProfileIntroMapper;
	private final AdminProfileSkillMapper adminProfileSkillMapper;
	private final AdminProfileWorkSpecMapper adminProfileWorkSpecMapper;
	private final AdminProfileEduSpecMapper adminProfileEduSpecMapper;
	//자기소개 목록 조회
	public List<ProfileIntro> getProfileIntroList(){
		
		List<ProfileIntro> profileIntroList = adminProfileIntroMapper.getProfileIntroList();
		
		return profileIntroList;
	}
	
	//보유기술 목록 조회
	public List<ProfileSkill> getProfileSkillList(){
		List <ProfileSkill> profileSkillList = adminProfileSkillMapper.getProfileSkillList();
		
		return profileSkillList;
	}
	
	//일경력 목록 조회 
	public List<ProfileWorkSpec> getProfileWorkSpecList(){
		List<ProfileWorkSpec> profileWorkSpecList = adminProfileWorkSpecMapper.getProfileWorkSpecList();
		
		return profileWorkSpecList;
	}
	public List<ProfileEduSpec> getProfileEduSpecList(){
		List<ProfileEduSpec> profileEduSpecList = adminProfileEduSpecMapper.getProfileEduSpecList();
		
		return profileEduSpecList;
	}

}

