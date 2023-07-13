package ks47team02.user.project.normal.service;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ks47team02.user.project.normal.dto.NormalProjects;
import ks47team02.user.project.normal.dto.joinCate;
import ks47team02.user.project.normal.dto.subjectCate;
import ks47team02.user.project.normal.mapper.NormalProjectMapper;
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
	
	public List<NormalProjects> getNormalProjects(){
		List<NormalProjects> normalProjectList = normalProjectMapper.getNormalProjectList();
		
		log.info("normalProjectList : {}", normalProjectList);
		
		
		
		
		
		return normalProjectList;
		
		
	}
	
	public List<joinCate> getJoinCateList(){
		List<joinCate> joinCateList = normalProjectMapper.getjoinCateList();
		log.info("joinCateListService : {}", joinCateList);
		
		return joinCateList;
		
		
	}
	public List<subjectCate> getSubjectCateList(){
		List<subjectCate> subjectCateList = normalProjectMapper.getSubjectCateList();
		log.info("subjectCateList : {}", subjectCateList);
		return subjectCateList;
	}
	
	public void addNormalProject(NormalProjects norproject) {
		// goods객체에 현재 상품코드가 없다
		log.info("insert 전 norproject : {}", norproject);
		normalProjectMapper.addNormalProject(norproject);
		// goods객체에 현재 상품코드가 있다.
		log.info("insert 후 norproject : {}", norproject);
	}
	
	
	

}
