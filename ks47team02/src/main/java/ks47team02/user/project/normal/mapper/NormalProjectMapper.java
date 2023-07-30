package ks47team02.user.project.normal.mapper;

import java.util.List;

import ks47team02.user.project.normal.dto.normalProjectApplyApplicant;
import ks47team02.user.project.normal.dto.rejectApprovalList;
import org.apache.ibatis.annotations.Mapper;

import ks47team02.user.project.normal.dto.NormalProjects;
import ks47team02.user.project.pro.dto.JoinCate;
import ks47team02.user.project.pro.dto.SubjectCate;
import ks47team02.user.project.pro.dto.WorkCate;

@Mapper
public interface NormalProjectMapper {

	/**
	 * 신청자 승인/거절 사유 리스트 조회
	 *
	 * */
	public List<rejectApprovalList> getAcceptApproveList();

	/**
	 * 일반과제 신청자 상세조회
	 * @param userId 신청자 아이디
	 * @return normalProjectApplyApplicant 신청자 상세정보
	 * */
	public normalProjectApplyApplicant getNormalProjectApplyApplicantById(String userId);

	/**
	 * @param normalProjectCode 일반과제 코드
	 * 일반과제 신청
	 *
	 * */
	public int addApplicantAccept(String normalProjectCode);


	/**
	 * 일반과제 신청자 목록 조회
	 * @return 일반과제 목록
	 * */
	public List<normalProjectApplyApplicant> getNormalProjectApplyApplicantList();


	/**
	 * 일반과제 게시글 수정
	 * @param normalProjects 일반과제 form
	 *
	 * */
	public int modifyNormalProject(NormalProjects normalProjects);

	/**
	 * 일반과제 전체목록 조회
	 * @return  NormalProjects
	 * */
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
	public NormalProjects getNormalPrjectByCode(String normalProjectCode);
	

	

}
