package ks47team02.user.profile.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ks47team02.user.profile.dto.ProfileAward;
import ks47team02.user.profile.dto.ProfileCertificate;
import ks47team02.user.profile.dto.ProfileEduSpec;
import ks47team02.user.profile.dto.ProfileIntro;
import ks47team02.user.profile.dto.ProfileSkill;
import ks47team02.user.profile.dto.ProfileWorkSpec;
import ks47team02.user.profile.mapper.ProfileAwardMapper;
import ks47team02.user.profile.mapper.ProfileCertificateMapper;
import ks47team02.user.profile.mapper.ProfileEduSpecMapper;
import ks47team02.user.profile.mapper.ProfileIntroMapper;
import ks47team02.user.profile.mapper.ProfileSkillMapper;
import ks47team02.user.profile.mapper.ProfileWorkSpecMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Transactional
@Slf4j
@AllArgsConstructor
public class ProfileService {
	
	private final ProfileCertificateMapper profileCertificateMapper;
	private final ProfileAwardMapper profileAwardMapper;
	private final ProfileIntroMapper profileIntroMapper;
	private final ProfileSkillMapper profileSkillMapper;
	private final ProfileWorkSpecMapper profileWorkSpecMapper;
	private final ProfileEduSpecMapper profileEduSpecMapper;
	
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
	/*보유기술 등록
	 * @param profileSkill*/
	public void profileSkillInsert(ProfileSkill profileSkill) {
		profileSkillMapper.profileSkillInsert(profileSkill);
	}
	
	/*회원별 기술 목록 조회 */
	public List<ProfileSkill> getProfileSkillList() {
			
		List<ProfileSkill> profileSkillList = profileSkillMapper.getProfileSkillList();
		
		log.info("profileSkillList : {}", profileSkillList);
		
		return profileSkillList;
	}
	/*회원별 보유기술 목록 조회 */
	public List<ProfileWorkSpec> getProfileWorkSpecList() {
		
		List<ProfileWorkSpec>profileWorkSpecList = profileWorkSpecMapper.getProfileWorkSpecList();
		
		log.info("profileWorkSpecList : {}", profileWorkSpecList);
		
		return profileWorkSpecList;
	}
	/*회원별 학력 목록 조회 */
	public List<ProfileEduSpec> getProfileEduSpecList(){
		
		List<ProfileEduSpec> profileEduSpecList = profileEduSpecMapper.getProfileEduSpecList();
		
		log.info("profileEduSpeclList : {}", profileEduSpecList);
		
		return profileEduSpecList;
	}
	
	/**
	 * 자격증 목록 조회
	 * @return
	 */
	public List<ProfileCertificate> certificateList(String sessionId) {
		
		List<ProfileCertificate> certificateList = profileCertificateMapper.certificateList(sessionId);
		log.info("자격증 목록 조회 : {}", certificateList);
		
		return certificateList;
	}
	/**
	 * 자격증 등록
	 * @param profileCertificate
	 */
	public void profileCertificateInsert(ProfileCertificate profileCertificate) {
		
		log.info("profileCertificate : {}", profileCertificate);
		profileCertificateMapper.profileCertificateInsert(profileCertificate);
		log.info("profileCertificate : {}", profileCertificate);
	}
	
	/**
	 * 아이디별 자격증 조회
	 * @param userId
	 * @return
	 */
	public ProfileCertificate certificateByCode(String certificateCode) {
		
		ProfileCertificate certificateInfo = profileCertificateMapper.certificateByCode(certificateCode); 
		
		return certificateInfo;
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
