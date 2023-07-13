package ks47team02.user.project.normal.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ks47team02.user.project.normal.dto.NormalProjects;
import ks47team02.user.project.normal.dto.joinCate;
import ks47team02.user.project.normal.dto.subjectCate;
import ks47team02.user.project.normal.service.NormalProjectService;
import lombok.AllArgsConstructor;


@Controller
@RequestMapping("/user/project/normal")
@AllArgsConstructor
public class normalProjectController {
	/*
	
	@GetMapping("/progress/dddd")
	public String dddd(Model model) {
		model.addAttribute("title", "일반과제 ");
		
		return "user/project/normal/progress/dddd";
	}
	
	*/
	
	private final NormalProjectService normalProjectService;
	
	@GetMapping("/list/getProjectList")
	public String getProjectList(Model model) {
		
		List<NormalProjects> normalProjectList =  normalProjectService.getNormalProjects();
		
		model.addAttribute("normalProjectList", normalProjectList);
		
		
		model.addAttribute("title", "일반과제 목록");
		
		return "user/project/normal/list/getProjectList";
	}
	
	@PostMapping("/list/addProject")
	public String addProject(NormalProjects normalProjects) {
		
		
		return "redirect:/user/project/normal/list/getProjectList";
	}
	
	@GetMapping("/progress/getProgressList")
	public String getProgressList(Model model) {
		model.addAttribute("title", "일반과제 진행상황 목록");
		
		return "user/project/normal/progress/getProgressList";
	}
	
	@GetMapping("/progress/modifyProgress")
	public String modifyProgress(Model model) {
		model.addAttribute("title", "일반과제 진행상황 수정");
		
		return "user/project/normal/progress/modifyProgress";
	}
	
	@GetMapping("/progress/removeProgress")
	public String removeProgress(Model model) {
		model.addAttribute("title", "일반과제 진행상황 삭제");
		
		return "user/project/normal/progress/removeProgress";
	}
	
	@GetMapping("/progress/addProgress")
	public String addProgress(Model model) {
		model.addAttribute("title", "일반과제 진행상황 작성");
		
		return "user/project/normal/progress/addProgress";
	}
	
	@GetMapping("/personalFunction/modifyPersonalFunction")
	public String modifyPersonalFunction(Model model) {
		model.addAttribute("title", "일반과제 개인별 맡은기능 수정");
		
		return "user/project/normal/personalFunction/modifyPersonalFunction";
	}
	
	@GetMapping("/personalFunction/removePersonalFunction")
	public String removePersonalFunction(Model model) {
		model.addAttribute("title", "일반과제 개인별 맡은기능 삭제");
		
		return "user/project/normal/personalFunction/removePersonalFunction";
	}
	
	@GetMapping("/personalFunction/getPersonalFunctionList")
	public String getPersonalFunctionList(Model model) {
		model.addAttribute("title", "일반과제 신청자별 맡은기능 목록");
		
		return "user/project/normal/personalFunction/getPersonalFunctionList";
	}
	
	@GetMapping("/personalFunction/addPersonalFunction")
	public String addPersonalFunction(Model model) {
		model.addAttribute("title", "일반과제 개인별 과제 추가");
		
		return "user/project/normal/personalFunction/addPersonalFunction";
	}
	
	@GetMapping("/applyApplicant/removePerson")
	public String removePerson(Model model) {
		model.addAttribute("title", "일반과제 신청자 삭제");
		
		return "user/project/normal/applyApplicant/removePerson";
	}
	
	@GetMapping("/applyApplicant/addAcceptApprove")
	public String addAcceptApprove(Model model) {
		model.addAttribute("title", "일반과제 신청자 승인");
		
		return "user/project/normal/applyApplicant/addAcceptApprove";
	}
	
	@GetMapping("/applyApplicant/modifyApplyApplicant")
	public String modifyApplyApplicant(Model model) {
		model.addAttribute("title", "일반과제 신청자 수정");
		
		return "user/project/normal/applyApplicant/modifyApplyApplicant";
	}
	
	@GetMapping("/applyApplicant/getAcceptList")
	public String getAcceptList(Model model) {
		model.addAttribute("title", "일반과제 신청자 목록");
		
		return "user/project/normal/applyApplicant/getAcceptList";
	}
	
	@GetMapping("/applyApplicant/addApplicantAccept")
	public String addApplicantAccept(Model model) {
		model.addAttribute("title", "일반과제 신청");
		
		return "user/project/normal/applyApplicant/addApplicantAccept";
	}
	
	
	
	@GetMapping("/list/removeProject")
	public String removeProject(Model model) {
		model.addAttribute("title", "일반과제 삭제페이지");
		
		return "user/project/normal/list/removeProject";
	}
	
	
	
	@GetMapping("/list/addProject")
	public String addProject(Model model) {
		List<joinCate> joinCateList = normalProjectService.getJoinCateList();
		List<subjectCate> subjectCateList = normalProjectService.getSubjectCateList();
		
		model.addAttribute("joinCateList", joinCateList);
		model.addAttribute("subjectCateList", subjectCateList);
		model.addAttribute("title", "일반과제 등록 페이지");
		
		
		return "user/project/normal/list/addProject";
	}
	
	@GetMapping("/list/modifyProject")
	public String modifyProject(Model model) {
		model.addAttribute("title", "일반과제 수정 페이지");
		
		return "user/project/normal/list/modifyProject";
	}


	
	
	

}
