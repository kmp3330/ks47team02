package ks47team02.admin.profile.controller;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ks47team02.admin.profile.service.AdminProfileService;
import ks47team02.user.profile.dto.ProfileEduSpec;
import ks47team02.user.profile.dto.ProfileIntro;
import ks47team02.user.profile.dto.ProfileSkill;
import ks47team02.user.profile.dto.ProfileWorkSpec;
import lombok.AllArgsConstructor;

@Controller
@RequestMapping("/admin/profile")
@AllArgsConstructor
public class AdminProfileController {
	
	private final AdminProfileService adminProfileService;
	
	/**
	 * 자기소개 관리(관리자)
	 * @param model
	 * @return
	 */
	@GetMapping("/adminProfileIntroList")
	@SuppressWarnings("unchecked") // unchecked로 되어있으면 데이터타입을 체크 안한다는 뜻
	public String profileIntroList(Model model,
										 @RequestParam(value="currentPage", required = false, defaultValue = "1") int currentPage) {
		
		Map<String, Object> resultMap = adminProfileService.getProfileIntroList(currentPage);
		List<Map<String, Object>> profileIntroList = (List<Map<String, Object>>) resultMap.get("profileIntroList");
		int lastPage = (int) resultMap.get("lastPage");
		int startPageNum = (int) resultMap.get("startPageNum");
		int endPageNum = (int) resultMap.get("endPageNum");
		
		model.addAttribute("title", "자격증 관리");
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("lastPage", lastPage);
		model.addAttribute("profileIntroList", profileIntroList);
		model.addAttribute("startPageNum", startPageNum);
		model.addAttribute("endPageNum", endPageNum);
		
		return "admin/profile/adminProfileIntroList";
	}
	
	@GetMapping("/adminProfileSkillList")
	@SuppressWarnings("unchecked") // unchecked로 되어있으면 데이터타입을 체크 안한다는 뜻
	public String profileSkillList(Model model, @RequestParam(value="currentPage", required=false, defaultValue="1") int currentPage) {
		
		Map<String, Object> resultMap = adminProfileService.getProfileSkillList(currentPage);
		List<Map<String, Object>> profileSkillList = (List<Map<String, Object>>) resultMap.get("profileSkillList");
		int lastPage = (int) resultMap.get("lastPage");
		int startPageNum = (int) resultMap.get("startPageNum");
		int endPageNum = (int) resultMap.get("endPageNum");
		
		model.addAttribute("title", "보유 기술 관리");
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("lastPage", lastPage);
		model.addAttribute("profileSkillList", profileSkillList);
		model.addAttribute("startPageNum", startPageNum);
		model.addAttribute("endPageNum", endPageNum);
		
		return "admin/profile/adminProfileSkillList";
	}
	
	@GetMapping("/adminprofileWorkSpecList")
	public String profileWorkSpecList(Model model) {
		List<ProfileWorkSpec> profileWorkSpecList = adminProfileService.getProfileWorkSpecList();
		
		model.addAttribute("title", "경력 관리");
		model.addAttribute("profileWorkSpecList", profileWorkSpecList);
		return "admin/profile/adminProfileWorkSpecList";
	}
	
	@GetMapping("/adminprofileEduSpecList")
	public String profileEduSpecList(Model model) {
		List<ProfileEduSpec> profileEduSpecList = adminProfileService.getProfileEduSpecList();
		
		model.addAttribute("title", "학력 관리");
		model.addAttribute("profileEduSpecList", profileEduSpecList);
		
		return "admin/profile/adminProfileEduSpecList";
	}
	
	@GetMapping("/adminProfileCertificateList")
	@SuppressWarnings("unchecked") // unchecked로 되어있으면 데이터타입을 체크 안한다는 뜻
	public String profileCertificateList(Model model,
										 @RequestParam(value="currentPage", required = false, defaultValue = "1") int currentPage) {
		
		Map<String, Object> resultMap = adminProfileService.getCertificateList(currentPage);
		int lastPage = (int) resultMap.get("lastPage");
		List<Map<String, Object>> profileCertificateList = (List<Map<String, Object>>) resultMap.get("profileCertificateList");
		int startPageNum = (int) resultMap.get("startPageNum");
		int endPageNum = (int) resultMap.get("endPageNum");
		
		model.addAttribute("title", "자격증 관리");
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("lastPage", lastPage);
		model.addAttribute("profileCertificateList", profileCertificateList);
		model.addAttribute("startPageNum", startPageNum);
		model.addAttribute("endPageNum", endPageNum);
		
		return "admin/profile/adminProfileCertificateList";
	}
	
	
	@GetMapping("/profileAwardList")
	public String profileAwardList(Model model) {
		
		model.addAttribute("title", "수상이력 관리");
		
		return "";
	}
	
	@GetMapping("/profilePortfolioList")
	public String profilePortfolioList(Model model) {
		
		model.addAttribute("title", "포트폴리오 관리");
		
		return "";
	}
}