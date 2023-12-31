package ks47team02.user.project.pro.service;


import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jakarta.annotation.PostConstruct;
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

//------------------------------------전문과제 관련---------------------------------------------------------------------------
	// 전문과제 전체 목록
	public List<ProProject> getProProjectList(){

		List<ProProject> proProjectList = proProjectMapper.getProProjectList();
//		log.info("proProject : {}", proProjectList);
		return proProjectList;
	}
	// 전문과제 구인글 작성
	public void proProjectInsert(ProProject proProject) {  
		proProjectMapper.proProjectInsert(proProject);
	}
	// 전문과제 수정
	public int proProjectModify(ProProject proProject) {
		int result = proProjectMapper.proProjectModify(proProject);
		return result;
	}
	// 전문과제 상세 조회
	public ProProject getProjectInfoByCode(String proProjectCode) {
		ProProject proProjectInfo = proProjectMapper.getProjectInfoByCode(proProjectCode);
		//log.info("db에 저장된 정보 - Service : {}", proProjectInfo);
		return proProjectInfo;
	}
	// 전문과제 삭제
	public void proProjectDelete(String proProjectCode) {
		
		proProjectMapper.depositDeleteByProProjectCode(proProjectCode);
		proProjectMapper.progressStatusDeleteByProProjectCode(proProjectCode);
		proProjectMapper.proProjectApplicantDeleteByProProjectCode(proProjectCode);
		proProjectMapper.proProjectPersonalFunctionDeleteByProProjectCode(proProjectCode);
		proProjectMapper.sendMoneyCompleteDeleteByProProjectCode(proProjectCode);
		proProjectMapper.proProjectDelete(proProjectCode);
		
	}
	
//-----------------------------------전문과제별 신청자 관련-----------------------------------------------------------------------------------
	// 전문과제별 신청자 목록
	public List<ProProjectApplicant> proProjectApplicantList(String proProject){
		List<ProProjectApplicant> proProjectApplicantList = proProjectMapper.getProProjectApplicantList(proProject);
		//log.info("proProjectApplicantList : {}", proProjectApplicantList);
		return proProjectApplicantList;
	}
	// 전문과제 신청서 작성
	public void proProjectApplicantInsert(ProProjectApplicant proProjectApplicant) {
		proProjectMapper.proProjectApplicantInsert(proProjectApplicant);
	
	}
	// 전문과제 신청 취소
	public void proProjectApplicantDelete(String proProjectCode, String sessionId) {
		proProjectMapper.proProjectApplicantDeleteByUserId(proProjectCode, sessionId);
	}
//----------------------------------전문과제 신청자별 맡은 기능 관련-----------------------------------------------------------------------------------
	// 전문과제 신청자별 맡은 기능 목록 조회
	public List<ProProjectPersonalFunction> proProjectPersonalFunctionList(String proProjectCode) {
		List<ProProjectPersonalFunction> proProjectPersonalFunctionList = proProjectMapper.getProProjectPersonalFunctionList(proProjectCode);
		
		return proProjectPersonalFunctionList;
	}
	// 전문과제 신청자별 맡은 기능 상세 조회
	public ProProjectPersonalFunction getProProjectPersonalFunctionInfoByUserID(String proProjectCode, String sessionId) {
		ProProjectPersonalFunction proProjectPersonalFunctionInfo = proProjectMapper.getProProjectPersonalFunctionInfoByUserID(proProjectCode,sessionId);
		
		return proProjectPersonalFunctionInfo;
	}
	// 전문과제 신청자별 맡은 기능 수정
	public int proProjectPersonalFunctionModify(ProProjectPersonalFunction proProjectPersonalFunction) {
		int result = proProjectMapper.proProjectPersonalFunctionModify(proProjectPersonalFunction);
		return result;
	}
//----------------------------------전문과제 진행상태 관련-----------------------------------------------------------------------------------
	// 전문과제 진행상태 목록 조회
	public List<ProgressStatus> getProgressStatusList() {
		List<ProgressStatus> progressStatusList = proProjectMapper.getProgressStatusList();
		
		return progressStatusList;
	}
	// 전문과제 진행상태 상세 조회
	public ProgressStatus getProgressStatusInfoByProProjectCode(String proProjectCode) {
		ProgressStatus progressStatusInfo = proProjectMapper.getProgressStatusInfoByProProjectCode(proProjectCode);
		//log.info("db에 저장된 정보 - Service : {}", progressStatusInfo);
		return progressStatusInfo;
	}
	// 전문과제 진행상태 수정
	public int progressStatusModify(ProgressStatus progressStatus) {
		int result = proProjectMapper.progressStatusModify(progressStatus);
		log.info("result : {}", result);
		return result;
	}
//----------------------------------전문과제 성과금예치 관련-----------------------------------------------------------------------------------
	// 전문과제 성과금 예치 목록 조회
	public List<DepositList> getDepositList() {
		List<DepositList> getDepositList = proProjectMapper.getDepositList();
		return getDepositList;
	}
	// 전문과제 성과금 예치 완료 작성
	public void DepositInsert(DepositList depositList) {
		proProjectMapper.depositListInsert(depositList);
	}
	// 전문과제 성과금 예치 완료 작성 - 성과금 미입금 프로젝트 조회
	public List<NotPaidList> getNotPaidList() {
		List<NotPaidList> notPaidList = proProjectMapper.getNotPaidList();
		log.info("notPaidList", notPaidList);
		return notPaidList;
	}
	// 성과금 예치 목록 수정 - 성과금 예치 목록 상세조회
	public DepositList getDepositListInfoByProjectCode(String proProjectCode) {
		DepositList depositListInfo = proProjectMapper.getDepositListInfoByProjectCode(proProjectCode);
		return depositListInfo;
	}
	// 성과금 예치 목록 수정
	public int depositListModify(DepositList depositList) {
		int result = proProjectMapper.depositListModify(depositList);
		return result;
	}
	// 성과금 예치 목록 삭제
	public void depositListDelete(String proProjectCode) {
		proProjectMapper.depositListDelete(proProjectCode);
	}
//----------------------------------전문과제 성과금 송금 관련-----------------------------------------------------------------------------------
	//	성과금 송금 완료 목록 조회
	public List<SendMoneyComplete> getSendMoneyCompleteList() {
		List<SendMoneyComplete> getSendMoneyCompleteList = proProjectMapper.getSendMoneyCompleteList();
		
		return getSendMoneyCompleteList;
	}
	// 성과금 송금 완료 작성 - 송금대상정보 리스트
	public List<AccountHolderInfoList> getAccountHolderInfoList() {
		List<AccountHolderInfoList> accountHolderInfoList = proProjectMapper.getAccountHolderInfoList();
		log.info("db에 저장된 정보 - accountHolderInfoList : {}", accountHolderInfoList);

		return accountHolderInfoList;
	}
	// 성과금 송금 완료 작성 - 개인별 맡은 기능 리스트
	public List<ProProjectPersonalFunction> proProjectPersonalFunctionList() {
		List<ProProjectPersonalFunction> proProjectPersonalFunctionList = proProjectMapper.getProProjectPersonalFunctionList2();
		return proProjectPersonalFunctionList;
	}
	// 성과금 송금 완료 작성
	public void sendMoneyCompleteInsert(SendMoneyComplete sendMoneyComplete) {
		proProjectMapper.sendMoneyCompleteInsert(sendMoneyComplete);
	}
	// 성과금 송금 완료 수정
	public SendMoneyComplete getSendMoneyCompleteListInfo(String proProjectCode) {
		SendMoneyComplete sendMoneyCompleteListInfo = proProjectMapper.getSendMoneyCompleteListInfo(proProjectCode);
		return sendMoneyCompleteListInfo;
	}
	// 성과금 송금 완료 수정 후 처리
	public int sendMoneyCompleteModify(SendMoneyComplete sendMoneyComplete) {
		int result = proProjectMapper.sendMoneyCompleteModify(sendMoneyComplete);
		return result;
	}
	// 성과금 송금 완료 삭제 처리
	public void sendMoneyCompleteDelete(String sendMoneyCompleteCode) {
		proProjectMapper.sendMoneyCompleteDelete(sendMoneyCompleteCode);
	}
	
	
	

	
	
	
	
	
	
	
	
	
//-----------------------------------분야 목록 -----------------------------------------------------------------------------------
	// 참여분야 리스트 조회
	public List<JoinCate> getJoinCateList(){
		List<JoinCate> JoinCateList = proProjectMapper.getJoinCateList();
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
	// 회원별 계좌정보 조회
	public List<ApplicantAccount> getApplicantAccountList(String userId) {
		List<ApplicantAccount> applicantAccountList = proProjectMapper.getApplicantAccountList(userId);
		log.info("applicantAccountList : {}", applicantAccountList);
		return applicantAccountList;
	}
	
}
