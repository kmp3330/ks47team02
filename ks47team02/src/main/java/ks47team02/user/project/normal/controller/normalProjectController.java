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
@RequestMapping("/normalProject")
@AllArgsConstructor
@lombok.extern.slf4j.Slf4j
public class normalProjectController {
	
	/*생성자 메서드*/
	
	private final NormalProjectService normalProjectService;
	

	
	
		/*등록 영역*/
	
	
	@GetMapping("/personalFunction/addPersonalFunction")
	public String addPersonalFunction(Model model) {
		model.addAttribute("title", "일반과제 개인별 과제 추가");
		
		return "user/project/normal/personalFunction/addPersonalFunction";
	}
	
	@GetMapping("/progress/addProgress")
	public String addProgress(Model model) {
		model.addAttribute("title", "일반과제 진행상황 작성");
		
		return "user/project/normal/progress/addProgress";
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
	
	/**
	 * 일반과제 작성 폼
	 * @param normalProjects
	 * @return 일반과제 리스트
	 */
	@PostMapping("/list/addProject")
	public String addProject(NormalProjects normalProjects) {
		
		log.info("addProject normalProjects 전송 : {}", normalProjects);
		normalProjectService.addNormalProject(normalProjects);
		
		log.info("addProject normalProjects : {}", normalProjects);
		
		
		return "redirect:/user/project/normal/list/getProjectList";
	}
	
	@GetMapping("/applyApplicant/addApplicantAccept")
	public String addApplicantAccept(Model model) {
		model.addAttribute("title", "일반과제 신청");
		
		return "user/project/normal/applyApplicant/addApplicantAccept";
	}
	
	@GetMapping("/applyApplicant/addAcceptApprove")
	public String addAcceptApprove(Model model) {
		model.addAttribute("title", "일반과제 신청자 승인");
		
		return "user/project/normal/applyApplicant/addAcceptApprove";
	}
	
	/*등록영역 끝*/
	
	
	
	
	
	
	/*수정영역*/
	@GetMapping("/list/modifyProject")
	public String modifyProject(Model model) {
		model.addAttribute("title", "일반과제 수정 페이지");
		
		return "user/project/normal/list/modifyProject";
	}
	
	@GetMapping("/applyApplicant/modifyApplyApplicant")
	public String modifyApplyApplicant(Model model) {
		model.addAttribute("title", "일반과제 신청자 수정");
		
		return "user/project/normal/applyApplicant/modifyApplyApplicant";
	}
	
	@GetMapping("/progress/modifyProgress")
	public String modifyProgress(Model model) {
		model.addAttribute("title", "일반과제 진행상황 수정");
		
		return "user/project/normal/progress/modifyProgress";
	}
	
	@GetMapping("/personalFunction/modifyPersonalFunction")
	public String modifyPersonalFunction(Model model) {
		model.addAttribute("title", "일반과제 개인별 맡은기능 수정");
		
		return "user/project/normal/personalFunction/modifyPersonalFunction";
	}
	/*수정영역 끝*/
	
	/* 삭제영역*/
	
	@GetMapping("/progress/removeProgress")
	public String removeProgress(Model model) {
		model.addAttribute("title", "일반과제 진행상황 삭제");
		
		return "user/project/normal/progress/removeProgress";
	}
	
	
	@GetMapping("/applyApplicant/removePerson")
	public String removePerson(Model model) {
		model.addAttribute("title", "일반과제 신청자 삭제");
		
		return "user/project/normal/applyApplicant/removePerson";
	}
	
	@GetMapping("/list/removeProject")
	public String removeProject(Model model) {
		model.addAttribute("title", "일반과제 삭제페이지");
		
		return "user/project/normal/list/removeProject";
	}
	
	
	
	
	@GetMapping("/personalFunction/removePersonalFunction")
	public String removePersonalFunction(Model model) {
		model.addAttribute("title", "일반과제 개인별 맡은기능 삭제");
		
		return "user/project/normal/personalFunction/removePersonalFunction";
	}
	
	/* 삭제영역 끝*/
	
	/*get영역*/
	
	@GetMapping("/projectList")
	public String getProjectList(Model model) {
		
		log.info("normalProjectList = {}", "안녕");
		List<NormalProjects> normalProjectList =  normalProjectService.getNormalProjects();
		
		model.addAttribute("normalProjectList", normalProjectList);
		
		
		model.addAttribute("title", "일반과제 목록");
		
		return "user/project/normal/list/projectList";
	}
	
	
	
	@GetMapping("/progress/getProgressList")
	public String getProgressList(Model model) {
		model.addAttribute("title", "일반과제 진행상황 목록");
		
		return "user/project/normal/progress/getProgressList";
	}
	
	
	
	
	
	@GetMapping("/personalFunction/getPersonalFunctionList")
	public String getPersonalFunctionList(Model model) {
		model.addAttribute("title", "일반과제 신청자별 맡은기능 목록");
		
		return "user/project/normal/personalFunction/getPersonalFunctionList";
	}
	
	

	
	@GetMapping("/applyApplicant/getAcceptList")
	public String getAcceptList(Model model) {
		model.addAttribute("title", "일반과제 신청자 목록");
		
		return "user/project/normal/applyApplicant/getAcceptList";
	}
	
	/*get영역 끝*/
	
	
	

}
