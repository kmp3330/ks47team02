package ks47team02.user.project.pro.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jakarta.annotation.PostConstruct;
import ks47team02.user.project.pro.dto.JoinCate;
import ks47team02.user.project.pro.dto.ProProject;
import ks47team02.user.project.pro.dto.SubjectCate;
import ks47team02.user.project.pro.dto.WorkCate;
import ks47team02.user.project.pro.mapper.ProProjectMapper;
import lombok.extern.slf4j.Slf4j;


@Service
@Transactional
@Slf4j
public class ProProjectService {
	private final ProProjectMapper proProjectMapper;
	// 생성자 메소드 의존성 주입방식
	public ProProjectService(ProProjectMapper proProjectMapper) {
		this.proProjectMapper = proProjectMapper;
	}
	@PostConstruct
	public void proProjectMapperServiceInit() {
		System.out.println("proProjectMapperService 객체 생성");
	}

	
	// 전문과제 전체 목록
	public List<ProProject> getProProjectList(){

		List<ProProject> proProjectList = proProjectMapper.getProProjectList();
		log.info("proProject : {}", proProjectList);
		return proProjectList;
	}
	
	// 전문과제 구인글 작성
	public void proProjectInsert(ProProject proProject) {  
		
		log.info("insert 전 proProject : {}", proProject);
		proProjectMapper.proProjectInsert(proProject);
		
	}
	// 참여분야 리스트 조회
	public List<JoinCate> getJoinCateList(){
		
		List<JoinCate> JoinCateList = proProjectMapper.getJoinCateList();
		log.info("JoinCate : {}", JoinCateList);

			
		return JoinCateList;
	}
	// 작업분야 리스트 조회
	public List<WorkCate> getWorkCateList(){ 
			
		List<WorkCate> WorkCateList = proProjectMapper.getWorkCateList();
			
		return WorkCateList;
	}
	// 주제분야 리스트 조회
	public List<SubjectCate> getSubjectCateList(){
			
		List<SubjectCate> SubjectCateList = proProjectMapper.getSubjectCateList();
			
		return SubjectCateList;
	}
	
	
	// 전문과제별 신청자 목록 (작업중)
	public List<ProProject> getProProjectApplicantList(){
		
		List<ProProject> proProjectApplicantList = proProjectMapper.getProProjectApplcantList();
		//log.info("proProjectApplicantList : {}",proProjectApplicantList);
		
		return proProjectApplicantList;
	}

}
