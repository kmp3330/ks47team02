package ks47team02.project.normal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/project/normal")
public class normalProjectController {
	/*
	
	@GetMapping("/progress/dddd")
	public String dddd(Model model) {
		model.addAttribute("title", "일반과제 ");
		
		return "project/normal/progress/dddd";
	}
	
	*/
	
	@GetMapping("/progress/getProgressList")
	public String getProgressList(Model model) {
		model.addAttribute("title", "일반과제 진행상황 목록");
		
		return "project/normal/progress/getProgressList";
	}
	
	@GetMapping("/progress/modifyProgress")
	public String modifyProgress(Model model) {
		model.addAttribute("title", "일반과제 진행상황 수정");
		
		return "project/normal/progress/modifyProgress";
	}
	
	@GetMapping("/progress/removeProgress")
	public String removeProgress(Model model) {
		model.addAttribute("title", "일반과제 진행상황 삭제");
		
		return "project/normal/progress/removeProgress";
	}
	
	@GetMapping("/progress/addProgress")
	public String addProgress(Model model) {
		model.addAttribute("title", "일반과제 진행상황 작성");
		
		return "project/normal/progress/addProgress";
	}
	
	@GetMapping("/personalFunction/modifyPersonalFunction")
	public String modifyPersonalFunction(Model model) {
		model.addAttribute("title", "일반과제 개인별 맡은기능 수정");
		
		return "project/normal/personalFunction/modifyPersonalFunction";
	}
	
	@GetMapping("/personalFunction/removePersonalFunction")
	public String removePersonalFunction(Model model) {
		model.addAttribute("title", "일반과제 개인별 맡은기능 삭제");
		
		return "project/normal/personalFunction/removePersonalFunction";
	}
	
	@GetMapping("/personalFunction/getPersonalFunctionList")
	public String getPersonalFunctionList(Model model) {
		model.addAttribute("title", "일반과제 신청자별 맡은기능 목록");
		
		return "project/normal/personalFunction/getPersonalFunctionList";
	}
	
	@GetMapping("/personalFunction/addPersonalFunction")
	public String addPersonalFunction(Model model) {
		model.addAttribute("title", "일반과제 개인별 과제 추가");
		
		return "project/normal/personalFunction/addPersonalFunction";
	}
	
	@GetMapping("/applyApplicant/removePerson")
	public String removePerson(Model model) {
		model.addAttribute("title", "일반과제 신청자 삭제");
		
		return "project/normal/applyApplicant/removePerson";
	}
	
	@GetMapping("/applyApplicant/addAcceptApprove")
	public String addAcceptApprove(Model model) {
		model.addAttribute("title", "일반과제 신청자 승인");
		
		return "project/normal/applyApplicant/addAcceptApprove";
	}
	
	@GetMapping("/applyApplicant/modifyApplyApplicant")
	public String modifyApplyApplicant(Model model) {
		model.addAttribute("title", "일반과제 신청자 수정");
		
		return "project/normal/applyApplicant/modifyApplyApplicant";
	}
	
	@GetMapping("/applyApplicant/getAcceptList")
	public String getAcceptList(Model model) {
		model.addAttribute("title", "일반과제 신청자 목록");
		
		return "project/normal/applyApplicant/getAcceptList";
	}
	
	@GetMapping("/applyApplicant/addApplicantAccept")
	public String addApplicantAccept(Model model) {
		model.addAttribute("title", "일반과제 신청");
		
		return "project/normal/applyApplicant/addApplicantAccept";
	}
	
	@GetMapping("/list/getProjectList")
	public String dddd(Model model) {
		model.addAttribute("title", "일반과제 목록");
		
		return "project/normal/list/getProjectList";
	}
	
	@GetMapping("/list/removeProject")
	public String removeProject(Model model) {
		model.addAttribute("title", "일반과제 삭제페이지");
		
		return "project/normal/list/removeProject";
	}
	
	
	
	@GetMapping("/list/addProject")
	public String addProject(Model model) {
		model.addAttribute("title", "일반과제 등록 페이지");
		
		return "project/normal/list/addProject";
	}
	
	@GetMapping("/list/modifyProject")
	public String modifyProject(Model model) {
		model.addAttribute("title", "일반과제 수정 페이지");
		
		return "project/normal/list/modifyProject";
	}
	
	
	

}
