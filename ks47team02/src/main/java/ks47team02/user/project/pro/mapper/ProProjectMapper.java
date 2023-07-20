package ks47team02.user.project.pro.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;

import ks47team02.user.project.pro.dto.JoinCate;
import ks47team02.user.project.pro.dto.ProProject;
import ks47team02.user.project.pro.dto.SubjectCate;
import ks47team02.user.project.pro.dto.WorkCate;

	
@Mapper
public interface ProProjectMapper {

		// 전문 과제 목록 조회
	public List<ProProject> getProProjectList();
		// 전문 과제 구인글 작성
	public int proProjectInsert(ProProject proProject);
		// 전문 과제 상세 조회
	public ProProject getProjectInfoByCode(String proProjectCode);
		// 전문 과제 수정
	public int proProjectModify(ProProject proProject);
//------------------------------------ 전문과제 삭제 관련------------------------------------------
		// 성과금 예치 목록 삭제
	public int depositDeleteByProProjectCode(String proProjectCode);
		// 기업이 올린 전문과제 진행 상태 삭제
	public int progressStatusDeleteByProProjectCode(String proProjectCode);
		// 해당 전문과제 신청자 목록 삭제
	public int proProjectApplicantDeleteByProProjectCode(String proProjectCode);
		// 해당 전문과제 별 개인별 맡은 기능 삭제
	public int proProjectPersonalFunctionDeleteByProProjectCode(String proProjectCode);
		// 해당 전문과제 성과금 송금 완료 삭제 
	public int sendMoneyCompleteDeleteByProProjectCode(String proProjectCode);
		// 해당 전문과제 삭제
	public int proProjectDelete(String proProjectCode);
//---------------------------------------------------------------------------------------------------	

	
	
	
	
	
	
	
	
	
	
		// 전문 과제 별 신청자 목록
	public List<ProProject> getProProjectApplcantList();
	// 참여분야 리스트
	public List<JoinCate> getJoinCateList();
	// 작업분야 리스트
	public List<WorkCate> getWorkCateList();
	// 주제분야 리스트
	public List<SubjectCate> getSubjectCateList();
}
