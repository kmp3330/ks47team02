package ks47team02.user.project.pro.controller;

import java.util.List;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.annotation.PostConstruct;
import jakarta.servlet.http.HttpSession;
import ks47team02.user.project.pro.dto.ApplicantAccount;
import ks47team02.user.project.pro.dto.JoinCate;
import ks47team02.user.project.pro.dto.ProProject;
import ks47team02.user.project.pro.dto.ProProjectApplicant;
import ks47team02.user.project.pro.dto.ProProjectPersonalFunction;
import ks47team02.user.project.pro.dto.ProgressStatus;
import ks47team02.user.project.pro.dto.SubjectCate;
import ks47team02.user.project.pro.dto.WorkCate;

import ks47team02.user.project.pro.service.ProProjectService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequestMapping("/project/pro")
@Controller
@AllArgsConstructor
@Slf4j
public class ProProjectController {
	private final ProProjectService ProProjectService;
	@PostConstruct
	public void proProjectControllerInit() {
		System.out.println("proProjectController 생성");
	}
	
//-----------------------------------전문과제 목록 조회, 등록, 수정, 삭제-------------------------------------------------------------------------------------------------------------------
	// 모든 전문과제 목록 조회
	@GetMapping("/proProjectList")
	public String getProProjectList(Model model) {
		
		List<ProProject> proProjectList = ProProjectService.getProProjectList();
		
		model.addAttribute("title", "메인화면");
		model.addAttribute("contents", "전문과제 목록 페이지 입니다.");
		model.addAttribute("proProjectList", proProjectList);
		
		return "user/project/pro/pro_project_list";
	}
	// 전문과제 구인글 작성 후 처리
	@PostMapping("/proProjectInsert")
	public String proProjectInsert(ProProject proProject) {
		
//		log.info("구인글 작성시 입력정보: {}", proProject);
		ProProjectService.proProjectInsert(proProject);
		return "redirect:/project/pro/proProjectList";
	}
	// 전문과제 구인글 작성 전 처리
	@GetMapping("/proProjectInsert")
	public String proProjectInsert(Model model) {
		
		List<ProProject> proProjectList = ProProjectService.getProProjectList();
		List<JoinCate> joinCate = ProProjectService.getJoinCateList();
		List<WorkCate> workCate = ProProjectService.getWorkCateList();
		List<SubjectCate> subjectCate = ProProjectService.getSubjectCateList();
		
		model.addAttribute("joinCate", joinCate);
		model.addAttribute("workCate", workCate);
		model.addAttribute("subjectCate", subjectCate);
		model.addAttribute("proProjectList", proProjectList);
		model.addAttribute("title","전문과제 구인글 작성");
		model.addAttribute("contents", "전문과제 구인글 작성 페이지 입니다.");
		
		return "user/project/pro/pro_project_insert";
	}
	// 전문과제 구인글 수정 후 처리
	@PostMapping("/proProjectModify")
	public String proProjectModify(ProProject proProject) {
		
		ProProjectService.proProjectModify(proProject);
		
		return "redirect:/project/pro/proProjectList";
	}
	// 전문과제 구인글 수정 전 처리
	@GetMapping("/proProjectModify")
	public String proProjectModify(@RequestParam(value="proProjectCode") String proProjectCode, Model model) {
		  
		// 전문과제 상세조회
		ProProject proProjectInfo = ProProjectService.getProjectInfoByCode(proProjectCode);		
		// 전문과제 전체 목록 조회
		List<ProProject> proProjectsList = ProProjectService.getProProjectList();
		
		List<JoinCate> joinCate = ProProjectService.getJoinCateList();
		List<WorkCate> workCate = ProProjectService.getWorkCateList();
		List<SubjectCate> subjectCate = ProProjectService.getSubjectCateList();
		
		model.addAttribute("joinCate", joinCate);
		model.addAttribute("workCate", workCate);
		model.addAttribute("subjectCate", subjectCate);
		model.addAttribute("proProjectsList", proProjectsList);
		model.addAttribute("title","전문과제 수정");
		model.addAttribute("contents", "전문과제 구인글 수정 페이지 입니다.");
		model.addAttribute("proProjectInfo",proProjectInfo);
		
		return "user/project/pro/pro_project_modify";
	}
	// 전문과제 구인글 삭제 처리
	@GetMapping("/proProjectDelete")
	public String proProjectDelete(@RequestParam(value="proProjectCode") String proProjectCode, Model model) {
		ProProjectService.proProjectDelete(proProjectCode);

		model.addAttribute("title","전문과제 삭제");
		model.addAttribute("contents", "전문과제 구인글 삭제 페이지 입니다.");
		
		return "redirect:/project/pro/proProjectList";
	}
//---------------------------------전문과제별 신청자 목록 조회, 등록, 수정, 삭제--------------------------------------------------------------------------------------------------------------
	// 전문과제별 신청자 목록 조회
	@GetMapping("/proProjectApplicantList")
	public String getProProjectApplicantList(@RequestParam(value="proProjectCode") String proProjectCode, Model model) {
		
		List<ProProjectApplicant> proProjectApplicantList = ProProjectService.proProjectApplicantList(proProjectCode);
		
		
		model.addAttribute("title", "전문과제 신청");
		model.addAttribute("contents", "해당 전문과제 신청자 목록 페이지 입니다.");
		model.addAttribute("proProjectCode", proProjectCode);
		model.addAttribute("proProjectApplicantList", proProjectApplicantList);
		
		
		return "user/project/pro/pro_project_applicant_list";
	}
	// 전문과제별 신청서 작성 완료 전 처리
	@GetMapping("/proProjectApplicantInsert")
	public String proProjectApplicantInsert(@RequestParam(value="proProjectCode") String proProjectCode,
											HttpSession session,
											Model model) {

		String sessionId = (String)session.getAttribute("SID");
		List<ProProjectApplicant> proProjectApplicantList = ProProjectService.proProjectApplicantList(proProjectCode);
		List<ApplicantAccount> applicantAccountList = ProProjectService.getApplicantAccountList(sessionId);
		
		model.addAttribute("applicantAccountList", applicantAccountList);
//		log.info("applicantAccountList : {}", applicantAccountList);
		model.addAttribute("proProjectList", proProjectApplicantList);
		model.addAttribute("proProjectCode", proProjectCode);
		model.addAttribute("sessionId", sessionId);
		model.addAttribute("title","전문과제 신청서 작성");
		model.addAttribute("contents", "전문과제 신청서 작성 페이지 입니다.");
		
		return "user/project/pro/pro_project_applicant_insert";
	}
	// 전문과제별 신청서 작성 완료 후 처리
	@PostMapping("proProjectApplicantInsert")
	public String proProjectApplicantInsert(ProProjectApplicant proProjectApplicant, HttpSession session,
											@RequestParam(value="proProjectCode") String proProjectCode) {
		
//		String sessionId = (String)session.getAttribute("SID");
//		proProjectApplicant.setApplicantUserId(sessionId);
		
		ProProjectService.proProjectApplicantInsert(proProjectApplicant);
		log.info("proProjectApplicant : {}", proProjectApplicant);
		
		return "redirect:/project/pro/proProjectApplicantList?proProjectCode=" + proProjectCode + "";
	}
	// 전문과제별 신청 취소 처리
	@GetMapping("proProjectApplicantDelete")
	public String proProjectApplicantDelete(@RequestParam(value="proProjectCode") String proProjectCode,
											HttpSession session,
											Model model) {
		
		String sessionId = (String)session.getAttribute("SID");
		ProProjectService.proProjectApplicantDelete(proProjectCode,sessionId);
		
		model.addAttribute("title", "전문과제 신청 취소");
		model.addAttribute("contents", "전문과제 신청 취소 페이지 입니다.");
		
		return "redirect:/project/pro/proProjectApplicantList?proProjectCode=" + proProjectCode + "";
	}
//---------------------------------전문과제 개인별 맡은 기능 목록 조회, 등록, 수정, 삭제--------------------------------------------------------------------------------------------------------------
	// 전문과제 개인별 맡은 기능 목록 조회
	@GetMapping("/proProjectPersonalFunctionList")
	public String getProProjectPersonalFunctionList(@RequestParam(value="proProjectCode") String proProjectCode, Model model) {
		List<ProProjectPersonalFunction> proProjectPersonalFunctionList = ProProjectService.proProjectPersonalFunctionList(proProjectCode);
		log.info("구인글 작성시 입력정보: {}", proProjectPersonalFunctionList);
		
		model.addAttribute("title", "개인별 맡은 기능");
		model.addAttribute("contents", "해당 전문과제 개인별 맡은 기능 목록 페이지 입니다.");
		model.addAttribute("proProjectCode", proProjectCode);
		model.addAttribute("proProjectPersonalFunctionList", proProjectPersonalFunctionList);
		return "user/project/pro/pro_project_personal_function_list";
		
	}
	// 전문과제 개인별 맡은 기능 수정 전 처리
	@GetMapping("/proProjectPersonalFunctionModify")
	public String proProjectPersonalFunctionModify(@RequestParam(value="proProjectCode") String proProjectCode,
													HttpSession session,
													Model model) {
		// 세션아이디 
		String sessionId = (String)session.getAttribute("SID");
		// 전문과제 개인별 맡은 기능 상세조회
		ProProjectPersonalFunction proProjectPersonalFunctionInfo = ProProjectService.getProProjectPersonalFunctionInfoByUserID(proProjectCode,sessionId);
		model.addAttribute("proProjectPersonalFunctionInfo", proProjectPersonalFunctionInfo);
		model.addAttribute("title", "개인별 맡은 기능 수정 ");
		model.addAttribute("contents", "해당 전문과제 개인별 맡은 기능 수정 페이지 입니다.");
		return "user/project/pro/pro_project_personal_function_modify";
	}
	// 전문과제 개인별 맡은 기능 수정 후 처리
	@PostMapping("/proProjectPersonalFunctionModify")
	public String proProjectPersonalFunctionModify(ProProjectPersonalFunction proProjectPersonalFunction,
												   RedirectAttributes reAttr) {
		
		ProProjectService.proProjectPersonalFunctionModify(proProjectPersonalFunction);
		String proProjectCode = proProjectPersonalFunction.getProProjectCode();
		
		reAttr.addAttribute("proProjectCode", proProjectCode);
		
	return "redirect:/project/pro/proProjectPersonalFunctionList";	
	}
//---------------------------------전문과제 --------------------------------------------------------------------------------------------------------------
	// 전문 과제 진행 상태 목록 조회
	@GetMapping("/progressStatusList")
	public String getProgressStatusList(Model model) {
		List<ProgressStatus> progressStatusList = ProProjectService.getProgressStatusList();
		
		model.addAttribute("title", "전문과제 진행상태 목록");
		model.addAttribute("contents", "전문과제 진행상태 전체 목록 조회 페이지 입니다.");
		model.addAttribute("progressStatusList", progressStatusList);
		
		return "/user/project/pro/progress_status_list";
	}
	// 전문 과제 진행상태 수정 전 처리
	@GetMapping("/progressStatusModify")
	public String progressStatusModify(@RequestParam(value="proProjectCode") String proProjectCode, 
					Model model) {
		// 전문과제 진행상태 상세조회
		ProgressStatus progressStatusInfo = ProProjectService.getProgressStatusInfoByProProjectCode(proProjectCode);
		
		//log.info("db에 저장된 정보 - Service : {}", progressStatusInfo);
		
		model.addAttribute("progressStatusInfo", progressStatusInfo);
		model.addAttribute("title", "진행상태 수정 ");
		model.addAttribute("contents", "전문과제 진행상태 수정 페이지 입니다.");
		
		return "/user/project/pro/progress_status_modify";
		
	}
	
	
	
	
	
	
	
	
	
//	// 전문과제 구인글 삭제 후 처리
//	@PostMapping("/proProjectDelete")
//	public String proProjectDelete(@RequestParam(value="proProjectCode") String proProjectCode){
//		
//		ProProjectService.getProjectInfoByCode(proProjectCode);
////		String cpId = proProjectInfo.getCpId();
////		// 회원 여부 검증
////		Map<String, Object> isValidMap = ProProjectService.isValidCp(cpId, cpPw);
////		boolean isValid = (boolean) isValidMap.get("isValid");
////		
////		if(isValid) {
////			ProProjectService.proProjectDelete(proProjectInfo);
////			return "redirect:/goods/goodsList";
////		}
////		reAttr.addAttribute("proProjectCode", proProjectCode);
////		reAttr.addAttribute("msg", "회원 정보 불일치");
////		
//		return "redirect:/goods/removeGoods";
//		
//	}
//	// 전문과제에 신청한 회원 목록 (작업중)
//	@GetMapping("/proProjectApplicantList")
//	public String proProjectApplicantList(Model model) {
//		
//		List<ProProject> proProjectApplicantList = ProProjectService.getProProjectApplicantList();
//		model.addAttribute("title", "메인화면");
//		model.addAttribute("contents", "전문과제 신청자 목록 페이지 입니다.");
//		model.addAttribute("proProjectApplicantList", proProjectApplicantList);
//		return "user/project/pro/pro_project_applicant_list";
//	}
//	
//	
//	
//	// 전문 과제 진행 상태 목록
//	@GetMapping("/proProjectPersonalFunctionList")
//	public String proProjectPersonalFunctionList(Model model) {
//		
//		model.addAttribute("title", "전문과제 - 개인별 맡은 기능 목록");
//		model.addAttribute("contents", "전문과제 개인별 맡은 기능 목록 페이지 입니다.");
//		return "user/project/pro/pro_project_personal_function_list";
//	}
//	// 성과금 예치 목록
//	@GetMapping("/proProjectDepositList")
//	public String proProjectDepositList(Model model) {
//		
//		model.addAttribute("title", "메인화면");
//		model.addAttribute("contents", "성과금 예치 목록 페이지 입니다.");
//		return "user/project/pro/deposit_list";
//	}
//	// 성과금 송금 완료 목록
//	@GetMapping("/proProjectSendMoneyCompleteList")
//	public String proProjectSendMoneyCompleteList(Model model) {  
//		
//		model.addAttribute("title", "메인화면");
//		model.addAttribute("contents", "성과금 송금 완료 목록 페이지 입니다.");
//		return "user/project/pro/send_money_complete _list";
//	}
//	// 신청자별 계좌 정보 목록
//	@GetMapping("/pro/proProjectApplicantAccountList")
//	public String proProjectApplicantAccountList(Model model) {
//		
//		model.addAttribute("title", "메인화면");
//		model.addAttribute("contents", "신청자별 계좌 정보 목록 페이지 입니다."); 
//		return "user/project/pro/applicant_account_list";
//	}
////	// 신청자 진행 상황 분류 목록
////	@GetMapping("/pro")
////	public String normalApplyerRunList(Model model) {
////		
////		model.addAttribute("title", "신청자 진행 상황 분류 목록 페이지");
////		model.addAttribute("contents", "신청자 진행 상황 분류 목록 페이지 입니다.");
////		return "user/project/pro/normalApplyerRunList";
////	}
////	 전문과제 개인별 맡은 기능 목록
////	@GetMapping("/pro")
////	public String proProjectProgressStatusList(Model model)  {
////		
////		model.addAttribute("title", "전문과제 진행상태 목록");
////		model.addAttribute("contents", "전문 과제 진행 상태 목록 페이지 입니다.");
////		return "user/project/pro/proProjectProgressStatusList";
////	}
//  
}
