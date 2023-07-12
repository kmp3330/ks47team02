package ks47team02.user.project.pro.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;

import ks47team02.user.project.pro.dto.ProProject;
	
@Mapper
public interface ProProjectMapper {

		// 전문 과제 목록 조회
	public List<ProProject> getProProjectList();
		// 전문 과제 구인글 작성
	public int proProjectInsert(ProProject proProject);
	
	
	
	
	
	
	
	
		// 전문 과제 별 신청자 목록
	public List<ProProject> getProProjectApplcantList();
}
