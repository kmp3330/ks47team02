package ks47team02.user.profile.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ks47team02.user.profile.dto.ProfileAward;
import ks47team02.user.profile.dto.ProfileCertificate;
import ks47team02.user.profile.dto.ProfileEduSpec;
import ks47team02.user.profile.dto.ProfileIntro;
import ks47team02.user.profile.dto.ProfilePortfolio;
import ks47team02.user.profile.dto.ProfileSkill;
import ks47team02.user.profile.dto.ProfileWorkSpec;
import ks47team02.user.profile.mapper.ProfileAwardMapper;
import ks47team02.user.profile.mapper.ProfileCertificateMapper;
import ks47team02.user.profile.mapper.ProfileEduSpecMapper;
import ks47team02.user.profile.mapper.ProfileIntroMapper;
import ks47team02.user.profile.mapper.ProfilePortfolioMapper;
import ks47team02.user.profile.mapper.ProfileSkillMapper;
import ks47team02.user.profile.mapper.ProfileWorkSpecMapper;
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
	private final ProfileWorkSpecMapper profileWorkSpecMapper;
	private final ProfileEduSpecMapper profileEduSpecMapper;
	private final ProfilePortfolioMapper profilePortfolioMapper;
	
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
	 * 자격증 코드별 자격증 조회
	 * @param userId
	 * @return
	 */
	public ProfileCertificate certificateByCode(String certificateCode) {
		
		ProfileCertificate certificateInfo = profileCertificateMapper.certificateByCode(certificateCode); 
		
		return certificateInfo;
	}
	
	/**
	 * 자격증 수정
	 * @param profileCertificate
	 */
	public void profileCertificateModify(ProfileCertificate profileCertificate) {
		profileCertificateMapper.profileCertificateModify(profileCertificate);
	}
	
	/**
	 * 자격증 삭제 처리
	 * @param certificateCode
	 */
	public void profileCertificateDelete(String certificateCode) {
		profileCertificateMapper.profileCertificateDelete(certificateCode);
	}
	
	/**
	 * 수상이력 목록 조회
	 * @return
	 */
	public List<ProfileAward> getProfileAwardList(String sessionId) {
		
		List<ProfileAward> profileAwardList = profileAwardMapper.getProfileAwardList(sessionId);
		log.info("수상이력 목록 조회 : {}", profileAwardList);
		
		return profileAwardList;
	}
	
	/**
	 * 수상이력 등록 처리
	 * @param profileAward
	 */
	public void addProfileAward(ProfileAward profileAward) {
		
		profileAwardMapper.addProfileAward(profileAward);
		log.info("profileAward : {}", profileAward);
	}

	/**
	 * 수상이력 코드별 조회
	 * @param userAwardCode
	 * @return
	 */
	public ProfileAward profileAwardByCode(String userAwardCode) {
		
		ProfileAward profileAwardInfo = profileAwardMapper.profileAwardByCode(userAwardCode);
		
		return profileAwardInfo;
	}
	
	/**
	 * 수상이력 수정
	 * @param profileAward
	 */
	public void modifyProfileAward(ProfileAward profileAward) {
		profileAwardMapper.modifyProfileAward(profileAward);
		log.info("profileAward : {}", profileAward);
	}
	
	/**
	 * 수상이력 삭제
	 * @param userAwardCode
	 */
	public void deleteProfileAward(String profileAwardCode) {
		profileAwardMapper.deleteProfileAward(profileAwardCode);
	}
	
	/**
	 * 포트폴리오 조회
	 * @param sessionId
	 * @return
	 */
	public List<ProfilePortfolio> getProfilePortfolioList(String sessionId) {
		
		List<ProfilePortfolio> portfolioList = profilePortfolioMapper.getProfilePortfolioList(sessionId);
		
		return portfolioList;
	}
}
