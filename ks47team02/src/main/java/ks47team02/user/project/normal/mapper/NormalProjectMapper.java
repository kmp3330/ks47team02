package ks47team02.user.project.normal.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import ks47team02.user.project.normal.dto.NormalProjects;
import ks47team02.user.project.pro.dto.JoinCate;
import ks47team02.user.project.pro.dto.SubjectCate;
import ks47team02.user.project.pro.dto.WorkCate;

@Mapper
public interface NormalProjectMapper {
	
	public List<NormalProjects> getNormalProjectList();
	
	public List<JoinCate> getjoinCateList();
	
	public List<SubjectCate> getSubjectCateList();
	
	public List<WorkCate> getWorkCateList();
	
	public int addNormalProject(NormalProjects normalProject);
	
	/**
	 * 일반과제 WHERE 코드로 가져옴
	 * @param String normalProjectCode 일반과제코드
	 * @return NormalProjects 일반과제 정보
	 * 
	 * */
	public List<NormalProjects> getNormalPrjectByCode(String normalProjectCode); 
	

	

}
