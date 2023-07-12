package ks47team02.user.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ks47team02.user.dto.ProfileIntro;
import ks47team02.user.dto.ProfileSkill;
import ks47team02.user.mapper.ProfileIntroMapper;
import ks47team02.user.mapper.ProfileSkillMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Transactional
@Slf4j
@AllArgsConstructor
public class ProfileService {
	//private static final Logger log = LoggerFactory.getLogger(ProfileService.class);
	private final ProfileIntroMapper profileIntroMapper;
	private final ProfileSkillMapper profileSkillMapper;
	
	//public ProfileService(ProfileMapper profileMapper) {
	//	this.profileMapper = profileMapper;
	//}
	
	/*자기소개 등록
	 * @param profileIntro*/
	public void profileIntroInsert(ProfileIntro profileIntro) {
		profileIntroMapper.profileIntroInsert(profileIntro);
	}
	
	/*자기소개 목록 조회 */

	public List<ProfileIntro> getProfileIntroList() {
		
		List<ProfileIntro> profileIntroList = profileIntroMapper.getProfileIntroList();
		
		log.info("profileIntroList : {}", profileIntroList);
		
		return profileIntroList;
	}
	
	public List<ProfileSkill> getProfileSkillList() {
			
		List<ProfileSkill> profileSkillList = profileSkillMapper.getProfileSkillList();
		
		log.info("profileSkillList : {}", profileSkillList);
		
		return profileSkillList;
	}

}
