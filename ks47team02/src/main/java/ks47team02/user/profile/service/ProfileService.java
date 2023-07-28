package ks47team02.user.profile.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import ks47team02.user.project.pro.dto.JoinCate;
import ks47team02.user.project.pro.dto.ProProjectPersonalFunction;
import ks47team02.user.project.pro.dto.SubjectCate;
import ks47team02.user.project.pro.dto.WorkCate;
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
	private final ProfilePortfolioMapper profilePortfolioMapper;

	/*자기소개 삭제 */
	public void profileIntroDelete(String userIntroCode) {
		profileIntroMapper.profileIntroDelete(userIntroCode);
	}
	/*
	 *자기소개 정보 수정
	 *@param ProfileIntro
	 *@return excuteUpdate() 메소드 리턴 값:(수정처리 완료:1, 미완료:0)
	 * */
	public void profileIntroModify(ProfileIntro profileIntro) {
		 profileIntroMapper.profileIntroModify(profileIntro);
	}
	
	/*자기소개별 상세조회
	 * @param userIntroCode(자기소개코드)
	 * @return ProfileIntro(프로필 자기소개 정보)
	 * */
	public ProfileIntro getProfileIntroInfoByCode(String userIntroCode) {
		ProfileIntro profileIntroInfo = profileIntroMapper.getProfileIntroInfoByCode(userIntroCode);
		log.info("profileIntroInfo : {}", profileIntroInfo);
		return profileIntroInfo;
	}
	
	/*자기소개 등록
	 * @param profileIntro*/
	public void profileIntroInsert(ProfileIntro profileIntro) {
		profileIntroMapper.profileIntroInsert(profileIntro);
	}
	
	/*자기소개 목록 조회 */

	public List<ProfileIntro> getProfileIntroList(String sessionId) {
		
		List<ProfileIntro> profileIntroList = profileIntroMapper.getProfileIntroList(sessionId);
		
		log.info("profileIntroList : {}", profileIntroList);
		
		return profileIntroList;
	}

	/*보유기술 삭제 */
	public void profileSkillDelete(String userSkillCode) {
		profileSkillMapper.profileSkillDelete(userSkillCode);
	}
	
	public void profileSkillModify(ProfileSkill profileSkill){
		profileSkillMapper.profileSkillModify(profileSkill);
	}
	/*보유기술 별 상세조회
	 * @param userSkillCode(보유기술 코드)
	 * @return ProfileIntro(프로필 자기소개 정보)
	 * */
	public ProfileSkill getProfileSkillInfoByCode(String userSkillCode) {
		ProfileSkill profileSkillInfo = profileSkillMapper.getProfileSkillInfoByCode(userSkillCode);
		log.info("profileSkillInfo : {}", profileSkillInfo);
		return profileSkillInfo;
	}
	
	
	/*보유기술 등록
	 * @param profileSkill*/
	public void profileSkillInsert(ProfileSkill profileSkill) {
		profileSkillMapper.profileSkillInsert(profileSkill);
	}
	
	/*회원별 기술 목록 조회 */
	public List<ProfileSkill> getProfileSkillList(String sessionId) {
			
		List<ProfileSkill> profileSkillList = profileSkillMapper.getProfileSkillList(sessionId);
		
		log.info("profileSkillList : {}", profileSkillList);
		
		return profileSkillList;
	}
	/*자기소개 삭제 */
	public void profileWorkSpecDelete(String userWorkSpecCode) {
		profileWorkSpecMapper.profileWorkSpecDelete(userWorkSpecCode);
	}
	/*보유기술 수정 */
	public void profileWorkSpecModify(ProfileWorkSpec profileWorkSpec){
		profileWorkSpecMapper.profileWorkSpecModify(profileWorkSpec);
	}
	
	
	/*일경력 별 상세조회
	 * @param userWorkSpecCode(일경력 코드)
	 * @return ProfileWorkSpec (프로필 일경력 정보)
	 * */
	public ProfileWorkSpec getProfileWorkSpecInfoByCode(String userWorkSpecCode){
		ProfileWorkSpec profileWorkSpecInfo = profileWorkSpecMapper.getProfileWorkSpecInfoByCode(userWorkSpecCode);
		log.info("profileWorkSpecInfo : {}", profileWorkSpecInfo);
		return profileWorkSpecInfo;
	}
	/*일경력 등록
	 * @param profileWorkSpec*/
	public void profileWorkSpecInsert(ProfileWorkSpec profileWorkSpec) {
		profileWorkSpecMapper.profileWorkSpecInsert(profileWorkSpec);
	}
	
	/*회원별 일경력 목록 조회 */
	public List<ProfileWorkSpec> getProfileWorkSpecList(String sessionId) {
		
		List<ProfileWorkSpec>profileWorkSpecList = profileWorkSpecMapper.getProfileWorkSpecList(sessionId);
		
		log.info("profileWorkSpecList : {}", profileWorkSpecList);
		
		return profileWorkSpecList;
	}
	/*학력 삭*/
	public void profileEduSpecDelete(String userEduSpecCode) {
		profileEduSpecMapper.profileEduSpecDelete(userEduSpecCode);
	}
	
	/*@param ProfileIntro
	 *@return excuteUpdate() 메소드 리턴 값:(수정처리 완료:1, 미완료:0)
	학력 수정*/
	public void profileEduSpecModify(ProfileEduSpec profileEduSpec) {
		profileEduSpecMapper.profileEduSpecModify(profileEduSpec);
	}
	/*학력 별 상세조회
	 * @param userEduSpecCode(학력 코드)
	 * @return ProfileEduSpec (프로필 일경력 정보)
	 * */
	public ProfileEduSpec getProfileEduSpecInfoByCode(String userEduSpecCode) {
		ProfileEduSpec profileEduSpecInfo = profileEduSpecMapper.getProfileEduSpecInfoByCode(userEduSpecCode);
		log.info("profileEduInfo : {}", profileEduSpecInfo);
		return profileEduSpecInfo;
	}
	
	/*학력 등록
	 * @param profileEduSpec*/
	public void profileEduSpecInsert(ProfileEduSpec profileEduSpec) {
		profileEduSpecMapper.profileEduSpecInsert(profileEduSpec);
	}
	/*회원별 학력 목록 조회 */
	public List<ProfileEduSpec> getProfileEduSpecList(String sessionId){
		
		List<ProfileEduSpec> profileEduSpecList = profileEduSpecMapper.getProfileEduSpecList(sessionId);
		
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

	/**
	 * 참여분야 조회
	 * @return
	 */
	public List<JoinCate> getJoinCateList() {
		List<JoinCate> joinCateList = profilePortfolioMapper.getJoinCateList();
		return joinCateList;
	}
	/**
	 * 참여코드별 참여분야 조회
	 * @param joinCateCode
	 * @return
	 */
	public JoinCate getJoinCateByCode(String joinCateCode) {
		JoinCate joinCateInfo = profilePortfolioMapper.getJoinCateByCode(joinCateCode);
		log.info("joinCateInfo : {}", joinCateInfo);
		return joinCateInfo;
	}
	
	/**
	 * 작업분류 조회
	 * @return
	 */
	public List<WorkCate> getWorkCateList() {
		List<WorkCate> workCateList = profilePortfolioMapper.getWorkCateList();
		return workCateList;
	}
	/**
	 * 작업코드별 작업분류 조회
	 * @param workCateCode
	 * @return
	 */
	public WorkCate getWorkCateByCode(String workCateCode) {
		WorkCate workCateInfo = profilePortfolioMapper.getWorkCateByCode(workCateCode);
		log.info("workCateInfo : {}", workCateInfo);
		return workCateInfo;
	}
	
	/**
	 * 주제분류 조회
	 * @return
	 */
	public List<SubjectCate> getSubjectCateList() {
		List<SubjectCate> subjectCateList = profilePortfolioMapper.getSubjectCateList();
		return subjectCateList;
	}
	/**
	 * 주제코드별 주제분류 조회
	 * @param subjectCateCode
	 * @return
	 */
	public SubjectCate getSubjectCateByCode(String subjectCateCode) {
		SubjectCate subjectCateInfo = profilePortfolioMapper.getSubjectCateByCode(subjectCateCode);
		log.info("subjectCateInfo : {}", subjectCateInfo);
		return subjectCateInfo;
	}
	
	/**
	 * 포트폴리오 코드별 분류 코드,이름 조회
	 * @param portfolioCode
	 * @return
	 */
	public ProfilePortfolio getProfilePortfolioByCode(String portfolioCode) {
		
		ProfilePortfolio profilePortfolioInfo = profilePortfolioMapper.getProfilePortfolioByCode(portfolioCode);
		log.info("profilePortfolioInfo", profilePortfolioInfo);
		
		return profilePortfolioInfo;
	}
	
	/**
	 * 포트폴리오 등록
	 * @param profilePortfolio
	 */
	public void addProfilePortfolio(ProfilePortfolio profilePortfolio) {
		profilePortfolioMapper.addProfilePortfolio(profilePortfolio);
		log.info("profilePortfolio : {}", profilePortfolio);
	}
	
	/**
	 * 포트폴리오 코드별 조회
	 * @param profilePortfolioByCode
	 * @return
	 */
	public ProfilePortfolio profilePortfolioByCode(String profilePortfolioByCode) {
		
		ProfilePortfolio profilePortfolioInfo = profilePortfolioMapper.profilePortfolioByCode(profilePortfolioByCode);
		log.info("profilePortfolioInfo : {}", profilePortfolioInfo);
		
		return profilePortfolioInfo;
	}
	
	/**
	 * 포트폴리오 수정
	 * @param profilePortfolio
	 */
	public void profilePortfolioModify(ProfilePortfolio profilePortfolio) {
		profilePortfolioMapper.profilePortfolioModify(profilePortfolio);
	}
	
	/**
	 * 포트폴리오 삭제
	 * @param profilePortfolioCode
	 */
	public void profilePortfolioDelete(String profilePortfolioCode) {
		profilePortfolioMapper.profilePortfolioDelete(profilePortfolioCode);
	}
	
	/**
	 * 참여한 전문과제 프로젝트 목록
	 * @param sessionId
	 * @return
	 */
	public List<Map<String, Object>> getProProjectList(String sessionId) {
		
		List<Map<String, Object>> proProjectList = profilePortfolioMapper.getProProjectList(sessionId);
		log.info("proProjectList : {}", proProjectList);
		
		return proProjectList;
	}
}
