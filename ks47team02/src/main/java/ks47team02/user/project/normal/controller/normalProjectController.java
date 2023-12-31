package ks47team02.user.project.normal.controller;

import java.security.Key;
import java.util.List;
import java.util.Map;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import ks47team02.user.project.normal.dto.normalProjectApplyApplicant;
import ks47team02.user.project.pro.dto.ProProjectApplicant;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import ks47team02.user.project.normal.dto.NormalProjects;
import ks47team02.user.project.normal.dto.rejectApprovalList;
import ks47team02.user.project.normal.service.NormalProjectService;
import ks47team02.user.project.pro.dto.JoinCate;
import ks47team02.user.project.pro.dto.SubjectCate;
import ks47team02.user.project.pro.dto.WorkCate;
import ks47team02.user.project.pro.service.ProProjectService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.context.annotation.RequestScope;


@Component
@RequestScope
@Controller
@RequestMapping("/normalProject")
@Slf4j
@AllArgsConstructor
public class normalProjectController {
	
	/*생성자 메서드*/
	
	private final NormalProjectService normalProjectService;
	private final ProProjectService proProjectService;
	/**
	 * http서블릿리퀘스트
	 *
	 * */
	private final HttpServletRequest request;
	

	
	
		/*등록 영역*/



	/**
	 * 일반과제 신청
	 * @param normalProjectCode 일반과제 코드
	 * @param model 모델
	 *
	 * */
	@GetMapping("/addApplicantAccept")
	public String addApplicantAccept(@RequestParam(value = "normalProjectCode") String normalProjectCode,
									 Model model){

		HttpSession session = request.getSession();
		String loggedInUserId = (String) session.getAttribute("SID");

		model.addAttribute("normalProjectCode", normalProjectCode);
		model.addAttribute("loggedInUserId", loggedInUserId);



		return "user/project/normal/applyApplicant/addApplicantAccept";
	}
	/**
	 * 일반과제 신청
	 * @param normalProjects 일반과제dto
	 *
	 * */
	@PostMapping("/addApplicantAccept")
	public String addApplicantAccept(NormalProjects normalProjects){

		log.info("normalProjectsAccept : {}", normalProjects);
		normalProjectService.addApplicantAccept(normalProjects);


		return "redirect:/normalProject/projectList";

	}
	
	
	@GetMapping("/addPersonalFunction")
	public String addPersonalFunction(Model model) {
		model.addAttribute("title", "일반과제 개인별 과제 추가");
		
		return "user/project/normal/personalFunction/addPersonalFunction";
	}
	
	@GetMapping("/addProgress")
	public String addProgress(Model model) {
		model.addAttribute("title", "일반과제 진행상황 작성");
		
		return "user/project/normal/progress/addProgress";
	}
	
	/**
	 * 일반과제 작성 
	 * @param model 모델태그임
	 * @return 일반과제 추가 페이지
	 * 
	 * */
	@GetMapping("/addProject")
	public String addProject(Model model) {
		//joinCateList 가져오기
		List<JoinCate> joinCateList = normalProjectService.getJoinCateList();
		log.info("joinCateList arr : {}", joinCateList);
		List<SubjectCate> subjectCateList = proProjectService.getSubjectCateList();
		log.info("subjectCateList ida", subjectCateList);
		List<WorkCate> workCateList = normalProjectService.getWorkCateList();
		log.info("WorkCateList controller : {}", workCateList);
		model.addAttribute("joinCateList", joinCateList);
		model.addAttribute("subjectCateList", subjectCateList);
		model.addAttribute("workCateList", workCateList);
		model.addAttribute("title", "일반과제 등록 페이지");
		
		
		return "user/project/normal/list/addProject";
	}
	
	/**
	 * 일반과제 작성 폼 post
	 * @param normalProjects 입력받은 일반과제
	 * @return 일반과제 리스트
	 */
	@PostMapping("/addProject")
	public String addProject(NormalProjects normalProjects) {
		
		
		log.info("addProject normalProjects 전송 : {}", normalProjects);
		normalProjectService.addNormalProject(normalProjects);
		
		log.info("addProject normalProjects : {}", normalProjects);
		
		
		return "redirect:/normalProject/projectList";
	}


	/**
	 * 일반과제 신청자 승인폼 GET
	 * @param normalProjectApplyCode 신청자 코드
	 *
	 * */
	@PostMapping("/addAcceptApprove")
	public String addAcceptApprove(normalProjectApplyApplicant applyApplicant , String normalProjectApplyCode,
								   Model model){
		normalProjectService.addAcceptApprove(applyApplicant);

		return "redirect:/normalProject/getApplicantAcceptList";
	}



	/**
	 * 일반과제 신청자 승인폼 GET
	 * @param normalProjectApplyCode 신청자 코드
	 *
	 * */
	@GetMapping("/addAcceptApprove")
	public String addAcceptApprove(@RequestParam(value = "normalProjectApplyCode") String normalProjectApplyCode,
								   Model model) {
		List<rejectApprovalList> acceptApproveList = normalProjectService.getAcceptApproveList();
		log.info("acceptApproveList", acceptApproveList);

		HttpSession session = request.getSession();
		String loggedInUserId = (String) session.getAttribute("SID");


		model.addAttribute("normalProjectApplyCode", normalProjectApplyCode);
		model.addAttribute("acceptApproveList", acceptApproveList);
		// 유저아이디
		model.addAttribute("loggedInUserId", loggedInUserId);
		return "user/project/normal/applyApplicant/addAcceptApprove";
	}
	
	/*등록영역 끝*/
	
	
	/*수정영역*/
	@PostMapping("/modifyProject")
	public String modifyProject(NormalProjects normalProject) {

		normalProjectService.modifyNormalProject(normalProject);
		
		
		return "redirect:/normalProject/projectList";
	}
	
	
	/**
	 * @Param String normalProjectCode 일반과제코드
	 * @Param Model model
	 * 
	 * 
	 * @return 일반과제 수정 페이지로 이동 
	 * */
	@GetMapping("/modifyProject")
	public String modifyProject(@RequestParam(value="normalProjectCode") String normalProjectCode
			,Model model) {

		//일반과제 리스트
		NormalProjects normalProject = normalProjectService.getNormalProjectByCode(normalProjectCode);
		//참여분야 리스트
		List<JoinCate> joinCateList = normalProjectService.getJoinCateList();
		//작업분류 리스트
		List<WorkCate> workCateList = normalProjectService.getWorkCateList();
		//주제분류 리스트 
		List<SubjectCate> subjectCateList = normalProjectService.getSubjectCateList();
		
		model.addAttribute("joinCateList", joinCateList);
		model.addAttribute("workCateList", workCateList);
		log.info("normalProjectController = {}", normalProject);
		model.addAttribute("normalProject" ,normalProject);
		model.addAttribute("subjectCateList" ,subjectCateList);
		model.addAttribute("title", "일반과제 수정 페이지");
		
		
		
		return "user/project/normal/list/modifyProject";
	}
	
	@GetMapping("/modifyApplyApplicant")
	public String modifyApplyApplicant(Model model) {
		model.addAttribute("title", "일반과제 신청자 수정");
		
		return "user/project/normal/applyApplicant/modifyApplyApplicant";
	}
	
	@GetMapping("/modifyProgress")
	public String modifyProgress(Model model) {
		model.addAttribute("title", "일반과제 진행상황 수정");
		
		return "user/project/normal/progress/modifyProgress";
	}
	
	@GetMapping("/modifyPersonalFunction")
	public String modifyPersonalFunction(Model model) {
		model.addAttribute("title", "일반과제 개인별 맡은기능 수정");
		
		return "user/project/normal/personalFunction/modifyPersonalFunction";
	}
	/*수정영역 끝*/
	
	/* 삭제영역*/
	
	@GetMapping("/removeProgress")
	public String removeProgress(Model model) {
		model.addAttribute("title", "일반과제 진행상황 삭제");
		
		return "user/project/normal/progress/removeProgress";
	}
	
	
	@GetMapping("/removePerson")
	public String removePerson(Model model) {
		model.addAttribute("title", "일반과제 신청자 삭제");
		
		return "user/project/normal/applyApplicant/removePerson";
	}
	
	/**
	 * 일반과제 게시글 삭제
	 * */
	@GetMapping("/removeProject")
	public String removeProject(Model model) {
		model.addAttribute("title", "일반과제 삭제페이지");
		
		return "user/project/normal/list/removeProject";
	}
	
	@PostMapping("/removeProject")
	public String removeProject(@RequestParam(value="userPw") String userPw ,Model model) {
		model.addAttribute("title", "일반과제 삭제페이지");
		
		return "redirect:/normalProject/projectList";
	}
	
	
	
	
	@GetMapping("/removePersonalFunction")
	public String removePersonalFunction(Model model) {
		model.addAttribute("title", "일반과제 개인별 맡은기능 삭제");
		
		return "user/project/normal/personalFunction/removePersonalFunction";
	}
	
	/* 삭제영역 끝*/
	
	/*get영역*/

	/**
	 * 일반과제 신청자 상세보기
	 * @param userId 신청자 아이디
	 * @return
	 *
	 * */
	@GetMapping("/getAcceptApproveDetail")
	public String getProjectAcceptDetail(@RequestParam(value = "userId") String userId,
										 Model model){
		normalProjectApplyApplicant applyApplicantInfo = normalProjectService.getNormalProjectApplyApplicantById(userId);
		log.info("applyApplicantInfo : {}", applyApplicantInfo);
		model.addAttribute("applyApplicantInfo", applyApplicantInfo);
		return "user/project/normal/applyApplicant/getAcceptApproveDetail";
	}

	/**
	 * 일반과제 상세 페이지 이동
	 * @param projectCode 일반과제코드
	 * @return 일반과제 상세 화면
	 * */
	@GetMapping("/projectDetail")
	public String getProjectDetail(@RequestParam(value = "normalProjectCode") String projectCode,Model model){
		NormalProjects normalProject = normalProjectService.getNormalProjectByCode(projectCode);
		model.addAttribute("title", "일반과제 상세 페이지 이동");
		model.addAttribute("normalProject", normalProject);

		return "user/project/normal/list/projectDetail";
	}
	
	/**
	 * 일반과제 전체 리스트 가져오는 폼
	 * @param model 모델 가져옴
	 * @return 프로젝트 리스트 화면
	 * 
	 * */
	@GetMapping("/projectList")
	public String getProjectList(Model model) {

		List<NormalProjects> normalProjectList =  normalProjectService.getNormalProjects();
		model.addAttribute("normalProjectList", normalProjectList);
		model.addAttribute("title", "일반과제 목록");
		
		return "user/project/normal/list/projectList";
	}
	
	
	
	@GetMapping("/getProgressList")
	public String getProgressList(Model model) {
		model.addAttribute("title", "일반과제 진행상황 목록");
		
		return "user/project/normal/progress/getProgressList";
	}
	
	
	
	
	
	@GetMapping("/getPersonalFunctionList")
	public String getPersonalFunctionList(Model model) {
		model.addAttribute("title", "일반과제 신청자별 맡은기능 목록");
		
		return "user/project/normal/personalFunction/getPersonalFunctionList";
	}
	
	

	/**
	 * 신청자 목록 조회
	 * @param model
	 * @return normalProjectApplyApplicantList 신청자 리스트
	 *
	 * */
	@GetMapping("/getApplicantAcceptList")
	public String getAcceptList(Model model) {
		// 신청자 목록 조회
		List<normalProjectApplyApplicant> normalProjectApplyApplicantList = normalProjectService.getNormalProjectApplyApplicantList();


		model.addAttribute("normalProjectApplyApplicantList", normalProjectApplyApplicantList);
		model.addAttribute("title", "일반과제 신청자 목록");
		
		return "user/project/normal/applyApplicant/getApplicantAcceptList";
	}

	/**
	 * 일반과제 신청자 인원 확인
	 *
	 * */
	@PostMapping("/checkPeople")
	@ResponseBody
	public boolean checkPeople(@RequestParam(value = "normalProjectCode") String normalProjectCode,
							   Model model){
		boolean checkPeopleResult = normalProjectService.checkPeople(normalProjectCode);



		return checkPeopleResult;
	}
	
	

}
