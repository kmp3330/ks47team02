package ks47team02.user.project.pro.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;

import ks47team02.user.project.pro.dto.AccountHolderInfoList;
import ks47team02.user.project.pro.dto.ApplicantAccount;
import ks47team02.user.project.pro.dto.DepositList;
import ks47team02.user.project.pro.dto.JoinCate;
import ks47team02.user.project.pro.dto.NotPaidList;
import ks47team02.user.project.pro.dto.ProProject;
import ks47team02.user.project.pro.dto.ProProjectApplicant;
import ks47team02.user.project.pro.dto.ProProjectPersonalFunction;
import ks47team02.user.project.pro.dto.ProgressStatus;
import ks47team02.user.project.pro.dto.SendMoneyComplete;
import ks47team02.user.project.pro.dto.SubjectCate;
import ks47team02.user.project.pro.dto.WorkCate;

	
@Mapper
public interface ProProjectMapper {
	
//------------------------------------전문과제 관련---------------------------------------------------------------------
		// 전문 과제 목록 조회
	public List<ProProject> getProProjectList();
		// 전문 과제 구인글 작성
	public int proProjectInsert(ProProject proProject);
		// 전문 과제 상세 조회
	public ProProject getProjectInfoByCode(String proProjectCode);
		// 전문 과제 수정
	public int proProjectModify(ProProject proProject);
//------------------------------------전문과제 삭제 관련-----------------------------------------------------------------
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
//------------------------------------전문과제별 신청자 관련---------------------------------------------------------------	
		// 전문 과제 별 신청자 목록 조회
	public List<ProProjectApplicant> getProProjectApplicantList(String proProject);
		// 전문 과제 신청서 작성 전 처리
	public int proProjectApplicantInsert(String proProject);
		// 신청자별 계좌정보 목록 조회
	public List<ApplicantAccount> getApplicantAccountList(String userId);
		// 전문 과제 신청서 작성 후 처리
	public int proProjectApplicantInsert(ProProjectApplicant proProjectApplicant);
		// 전문 과제 신청취소
	public int proProjectApplicantDeleteByUserId(String proProjectCode, String sessionId);
//------------------------------------전문과제 개인별 맡은 기능 관련---------------------------------------------------------------
		// 전문과제 개인별 맡은 기능 목록 조회
	public List<ProProjectPersonalFunction> getProProjectPersonalFunctionList(String proProjectCode);
		// 전문과제 신청자별 맡은 기능 상세 조회
	public ProProjectPersonalFunction getProProjectPersonalFunctionInfoByUserID(String proProjectCode,String sessionId);
		// 전문과제 신청자별 맡은 기능 수정
	public int proProjectPersonalFunctionModify(ProProjectPersonalFunction proProjectPersonalFunction);
//------------------------------------전문과제 진행상태 관련---------------------------------------------------------------
		// 전문과제 진행상태 목록 조회
	public List<ProgressStatus> getProgressStatusList();
		// 전문과제 진행상태 상세 조회
	public ProgressStatus getProgressStatusInfoByProProjectCode(String proProjectCode);
		// 전문과제 진행상태 수정
	public int progressStatusModify(ProgressStatus progressStatus);
//------------------------------------전문과제 성과금예치 관련---------------------------------------------------------------
		// 전문과제 성과금 예치 목록 조회
	public List<DepositList> getDepositList();
		// 전문과제 성과금 예치 완료 작성
	public void depositListInsert(DepositList depositList);
		// 전문과제 성과금 예치 완료 작성 - 성과금 미입금 프로젝트 조회
	public List<NotPaidList> getNotPaidList();
		// 성과금 예치 목록 상세조회
	public DepositList getDepositListInfoByProjectCode(String proProjectCode);
		// 성과금 예치 목록 수정
	public int depositListModify(DepositList depositList);
		// 성과금 예치 목록 삭제
	public void depositListDelete(String proProjectCode);
//------------------------------------전문과제 성과금 송금 완료 관련---------------------------------------------------------------
		// 성과금 송금 완료 목록 조회
	public List<SendMoneyComplete> getSendMoneyCompleteList();
		// 성과금 송금 완료 작성 - 예금주정보목록
	public List<AccountHolderInfoList> getAccountHolderInfoList();
		// 성과금 송금 완료 작성 - 개인별 맡은 기능 목록
	public List<ProProjectPersonalFunction> getProProjectPersonalFunctionList2();
		// 성과금 송금 완료 작성
	public void sendMoneyCompleteInsert(SendMoneyComplete sendMoneyComplete);
		// 성과금 송금 완료 수정 - 상세 조회
	public SendMoneyComplete getSendMoneyCompleteListInfo(String proProjectCode);
		// 성과금 송금 완료 수정 
	public int sendMoneyCompleteModify(SendMoneyComplete sendMoneyComplete);
		// 성과금 송금 완료 삭제
	public void sendMoneyCompleteDelete(String sendMoneyCompleteCode);
	
	
	
	
	
	
	
	
	
	
	
//------------------------------------분루 관련---------------------------------------------------------------	
	// 참여분야 목록 조회
	public List<JoinCate> getJoinCateList();
	// 작업분야 목록 조회
	public List<WorkCate> getWorkCateList();
	// 주제분야 목록 조회
	public List<SubjectCate> getSubjectCateList();

	
	
}
