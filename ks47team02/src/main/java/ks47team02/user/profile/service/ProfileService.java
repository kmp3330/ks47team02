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
@AllArgsConstructor
@Slf4j
public class ProfileService {
	
	private final ProfileCertificateMapper profileCertificateMapper;
	private final ProfileAwardMapper profileAwardMapper;
	private final ProfileIntroMapper profileIntroMapper;
	private final ProfileSkillMapper profileSkillMapper;
	private final ProfileWorkSpecMapper profileWorkSpecMapper;
	private final ProfileEduSpecMapper profileEduSpecMapper;

	/*
	 *자기소개 정보 수정
	 *@param ProfileIntro
	 *@return excuteUpdate() 메소드 리턴 값:(수정처리 완료:1, 미완료:0)
	 * */
	public int profileIntroModify(ProfileIntro profileIntro) {
		int result = profileIntroMapper.profileIntroModify(profileIntro);
		return result;
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

	public List<ProfileIntro> getProfileIntroList() {
		
		List<ProfileIntro> profileIntroList = profileIntroMapper.getProfileIntroList();
		
		log.info("profileIntroList : {}", profileIntroList);
		
		return profileIntroList;
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
	public List<ProfileSkill> getProfileSkillList() {
			
		List<ProfileSkill> profileSkillList = profileSkillMapper.getProfileSkillList();
		
		log.info("profileSkillList : {}", profileSkillList);
		
		return profileSkillList;
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
	public List<ProfileWorkSpec> getProfileWorkSpecList() {
		
		List<ProfileWorkSpec>profileWorkSpecList = profileWorkSpecMapper.getProfileWorkSpecList();
		
		log.info("profileWorkSpecList : {}", profileWorkSpecList);
		
		return profileWorkSpecList;
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
	public List<ProfileEduSpec> getProfileEduSpecList(){
		
		List<ProfileEduSpec> profileEduSpecList = profileEduSpecMapper.getProfileEduSpecList();
		
		log.info("profileEduSpeclList : {}", profileEduSpecList);
		
		return profileEduSpecList;
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
	 * 자격증 등록
	 * @param profileCertificate
	 */
	public void profileCertificateInsert(ProfileCertificate profileCertificate) {
		
		log.info("profileCertificate : {}", profileCertificate);
		profileCertificateMapper.profileCertificateInsert(profileCertificate);
		log.info("profileCertificate : {}", profileCertificate);
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
