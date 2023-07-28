package ks47team02.user.project.normal.service;


import java.util.List;

import ks47team02.user.project.normal.dto.normalProjectApplyApplicant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ks47team02.user.project.normal.dto.NormalProjects;
import ks47team02.user.project.pro.dto.SubjectCate;
import ks47team02.user.project.pro.dto.WorkCate;
import ks47team02.user.project.normal.mapper.NormalProjectMapper;
import ks47team02.user.project.pro.dto.JoinCate;
import lombok.extern.slf4j.Slf4j;

@Service
@Transactional
@Slf4j
public class NormalProjectService {
	
	private static final Logger log = LoggerFactory.getLogger(NormalProjectService.class);
	
	//생성자 메서드 생성
	private final NormalProjectMapper normalProjectMapper;
	
	// 생성자 메소드 의존성 주입방식
	public NormalProjectService(NormalProjectMapper normalProjectMapper) {
		this.normalProjectMapper = normalProjectMapper;
	}

	public void addApplicantAccept(String normalProjectCode){
		normalProjectMapper.addApplicantAccept(normalProjectCode);
	}

	public normalProjectApplyApplicant getNormalProjectApplyApplicantById(String userId){
		normalProjectApplyApplicant ApplyApplicantInfo = normalProjectMapper.getNormalProjectApplyApplicantById(userId);
		return ApplyApplicantInfo;

	}

	/**
	 * 일반과제 신청자 목록 조회
	 * @return 일반과제 목록
	 * */
	public List<normalProjectApplyApplicant> getNormalProjectApplyApplicantList(){
		List<normalProjectApplyApplicant> normalProjectApplyApplicantList = normalProjectMapper.getNormalProjectApplyApplicantList();

		return normalProjectApplyApplicantList;

	}

	/**
	 * @param normalProjects 일반과제 dto
	 *일반과제 수정폼
	 * */
	public void modifyNormalProject(NormalProjects normalProjects){
		log.info("normalProjects : {}", normalProjects);
		normalProjectMapper.modifyNormalProject(normalProjects);
	}
	
	public List<NormalProjects> getNormalProjects(){
		List<NormalProjects> normalProjectList = normalProjectMapper.getNormalProjectList();
		log.info("normalProjectList : {}", normalProjectList);
		return normalProjectList;
		
		
	}
	
	public List<JoinCate> getJoinCateList(){
		List<JoinCate> joinCateList = normalProjectMapper.getjoinCateList();
		log.info("joinCateListService : {}", joinCateList);
		
		return joinCateList;
		
		
	}
	public List<SubjectCate> getSubjectCateList(){
		List<SubjectCate> subjectCateList = normalProjectMapper.getSubjectCateList();
		log.info("subjectCateList : {}", subjectCateList);
		return subjectCateList;
	}
	public List<WorkCate> getWorkCateList(){
		List<WorkCate> workCateList =  normalProjectMapper.getWorkCateList();
		log.info("getWorkCateListService : {}", workCateList);
		return workCateList;
		
	}
	
	public void addNormalProject(NormalProjects norproject) {
		// goods객체에 현재 상품코드가 없다
		log.info("insert 전 norproject : {}", norproject);
		normalProjectMapper.addNormalProject(norproject);
		// goods객체에 현재 상품코드가 있다.
		log.info("insert 후 norproject : {}", norproject);
	}
	
	public NormalProjects getNormalProjectByCode(String normalProjectCode) {
		NormalProjects normalProjects = normalProjectMapper.getNormalPrjectByCode(normalProjectCode);
		log.info("normalProjectsByCode : {}", normalProjects);
		
		
		return normalProjects;
	}
	
	

}
