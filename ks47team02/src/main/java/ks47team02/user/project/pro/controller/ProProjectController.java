package ks47team02.user.project.pro.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.annotation.PostConstruct;
import ks47team02.user.project.pro.dto.JoinCate;
import ks47team02.user.project.pro.dto.ProProject;
import ks47team02.user.project.pro.dto.SubjectCate;
import ks47team02.user.project.pro.dto.WorkCate;
import ks47team02.user.project.pro.mapper.ProProjectMapper;
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
	
	
	// 모든 전문과제 목록
	@GetMapping("/proProjectList")
	public String getProProjectList(Model model) {
		
		List<ProProject> proProjectList = ProProjectService.getProProjectList();
		
		model.addAttribute("title", "메인화면");
		model.addAttribute("contents", "전문과제 목록 페이지 입니다.");
		model.addAttribute("proProjectList", proProjectList);
		
		return "user/project/pro/pro_project_list";
	}
	
	// 전문과제 구인글 작성
	@GetMapping("/proProjectInsert")
	public String proProjectInsert(Model model) {
		
//		List<ProProject> proProjectList = ProProjectService.getProProjectList();
		List<JoinCate> joinCate = ProProjectService.getJoinCateList();
		List<WorkCate> workCate = ProProjectService.getWorkCateList();
		List<SubjectCate> subjectCate = ProProjectService.getSubjectCateList();
		
		model.addAttribute("joinCate", joinCate);
		model.addAttribute("workCate", workCate);
		model.addAttribute("subjectCate", subjectCate);
//		model.addAttribute("proProjectList", proProjectList);
		model.addAttribute("title","회원가입");
		model.addAttribute("contents", "전문과제 구인글 작성 페이지 입니다.");
		
		return "user/project/pro/pro_project_insert";
	}
	@PostMapping("/proProjectInsert")
	public String proProjectInsert(ProProject proProject) {
//		
//		log.info("구인글 작성시 입력정보: {}", proProject);
//		ProProjectService.proProjectInsert(proProject);
		return "redirect:/user/project/pro/proProjectList";
	}
	// response.sendRedirect("/member/memberList");
	// spring framework mvc 에서는 controller의 리턴값에 redirect: 키워드로 작성
	// redirect: 키워드를 작성할 경우 그 다음의 문자열은 html파일 논리 경로가 아닌 주소를 의미

	
	
	
	

		
		
		
		
		
		
	
//	@PostMapping("/proProjectInsert")
//	public String proProjectInsert(ProProject proProject) {
//		
//		log.info("구인글 작성시 입력정보: {}", proProject);
//		
//		ProProjectService.proProjectInsert(proProject);
//		
//		// response.sendRedirect("/member/memberList");
//		// spring framework mvc 에서는 controller의 리턴값에 redirect: 키워드로 작성
//		// redirect: 키워드를 작성할 경우 그다음의 문자열은 html파일 논리 경로가 아닌 주소를 의미
//		return "redirect:/user/project/pro/proProjectInsert";
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
