package ks47team02.user.profile.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ks47team02.user.profile.dto.ProfileAward;
import ks47team02.user.profile.dto.ProfileCertificate;
import ks47team02.user.profile.dto.ProfileIntro;
import ks47team02.user.profile.dto.ProfileSkill;
import ks47team02.user.profile.mapper.ProfileAwardMapper;
import ks47team02.user.profile.mapper.ProfileCertificateMapper;
import ks47team02.user.profile.mapper.ProfileIntroMapper;
import ks47team02.user.profile.mapper.ProfileSkillMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Transactional
@AllArgsConstructor
@Slf4j
public class ProfileService {
	
	private final ProfileCertificateMapper profileCertificateMapper;
	private final ProfileAwardMapper profileAwardMapper;
	private final ProfileIntroMapper profileIntroMapper;
	private final ProfileSkillMapper profileSkillMapper;
	
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
	
	/**
	 * 자격증 목록 조회
	 * @return
	 */
	public List<ProfileCertificate> certificateList() {
		
		List<ProfileCertificate> certificateList = profileCertificateMapper.certificateList();
		log.info("자격증 목록 조회 : {}", certificateList);
		
		return certificateList;
	}
	
	/**
	 * 수상이력 목록 조회
	 * @return
	 */
	public List<ProfileAward> profileAwardList() {
		
		List<ProfileAward> profileAwardList = profileAwardMapper.profileAwardList();
		log.info("수상이력 목록 조회 : {}", profileAwardList);
		
		return profileAwardList;
	}

}
