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
	

	

}
