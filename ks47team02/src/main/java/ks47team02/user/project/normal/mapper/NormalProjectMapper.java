package ks47team02.user.project.normal.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import ks47team02.user.project.normal.dto.NormalProjects;
import ks47team02.user.project.normal.dto.joinCate;
import ks47team02.user.project.normal.dto.subjectCate;

@Mapper
public interface NormalProjectMapper {
	
	public List<NormalProjects> getNormalProjectList();
	
	public List<joinCate> getjoinCateList();
	
	public List<subjectCate> getSubjectCateList();
	

	

}
