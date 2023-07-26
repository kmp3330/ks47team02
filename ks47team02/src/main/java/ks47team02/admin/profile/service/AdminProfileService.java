package ks47team02.admin.profile.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ks47team02.admin.profile.mapper.AdminProfileCertificateMapper;
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
	public Map<String,Object> getProfileIntroList(int currentPage){
	
		// 보여질 행의 갯수
		int rowPerPage = 10;

		// 페이지 계산(시작될 행의 인덱스)
		int startIndex = (currentPage - 1) * rowPerPage;

		// 마지막 페이지 계산
		// 1. 보여질 테이블의 전체 행의 갯수
		double rowsCnt = adminProfileIntroMapper.getIntroCnt();
		// 2. 마지막 페이지
		int lastPage = (int) Math.ceil(rowsCnt / rowPerPage);

		int startPageNum = 1;
		int endPageNum = (lastPage < 10) ? lastPage : 10;

		// 동적페이지 구성 (7page 부터)
		if (lastPage > 10 && currentPage > 6) {
			startPageNum = currentPage - 5;
			endPageNum = currentPage + 4;
			if (endPageNum >= lastPage) {
				startPageNum = lastPage - 9;
				endPageNum = lastPage;
			}
		}

		//HashMap<String, object> 여러 데이터타입을 담을 수 있는 Map<> 이라는 객체를 생성한다. 
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("startIndex", startIndex);
		paramMap.put("rowPerPage", rowPerPage);

		// 화면에 보여질 로그인 이력 데이터
		List<Map<String, Object>> profileIntroList = adminProfileIntroMapper.getProfileIntroList(paramMap);
		log.info("자격증 전체 목록: {}", profileIntroList);

		// controller에 전달될 data
		paramMap.clear(); // map 객체안의 data 초기화
		paramMap.put("lastPage", lastPage);
		paramMap.put("profileIntroList", profileIntroList);
		paramMap.put("startPageNum", startPageNum);
		paramMap.put("endPageNum", endPageNum);

		return paramMap;
	}
	
	/*List<ProfileIntro> profileIntroList = adminProfileIntroMapper.getProfileIntroList();
	
	return profileIntroList; */

	
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

	private final AdminProfileCertificateMapper adminProfileCertificateMapper;

	/**
	 * 자격증 페이징 목록
	 * @param currentPage
	 * @return
	 */
	public Map<String, Object> getCertificateList(int currentPage) {

		// 보여질 행의 갯수
		int rowPerPage = 10;

		// 페이지 계산(시작될 행의 인덱스)
		int startIndex = (currentPage - 1) * rowPerPage;

		// 마지막 페이지 계산
		// 1. 보여질 테이블의 전체 행의 갯수
		double rowsCnt = adminProfileCertificateMapper.getCertificateCnt();
		// 2. 마지막 페이지
		int lastPage = (int) Math.ceil(rowsCnt / rowPerPage);

		int startPageNum = 1;
		int endPageNum = (lastPage < 10) ? lastPage : 10;

		// 동적페이지 구성 (7page 부터)
		if (lastPage > 10 && currentPage > 6) {
			startPageNum = currentPage - 5;
			endPageNum = currentPage + 4;
			if (endPageNum >= lastPage) {
				startPageNum = lastPage - 9;
				endPageNum = lastPage;
			}
		}

		//HashMap<String, object> 여러 데이터타입을 담을 수 있는 Map<> 이라는 객체를 생성한다. 
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("startIndex", startIndex);
		paramMap.put("rowPerPage", rowPerPage);

		// 화면에 보여질 로그인 이력 데이터
		List<Map<String, Object>> profileCertificateList = adminProfileCertificateMapper.getCertificateList(paramMap);
		log.info("자격증 전체 목록: {}", profileCertificateList);

		// controller에 전달될 data
		paramMap.clear(); // map 객체안의 data 초기화
		paramMap.put("lastPage", lastPage);
		paramMap.put("profileCertificateList", profileCertificateList);
		paramMap.put("startPageNum", startPageNum);
		paramMap.put("endPageNum", endPageNum);

		return paramMap;
	}

}
