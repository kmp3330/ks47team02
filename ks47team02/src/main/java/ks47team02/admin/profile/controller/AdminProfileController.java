package ks47team02.admin.profile.controller;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ks47team02.admin.profile.service.AdminProfileService;
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
	
	@GetMapping("/adminProfileWorkSpecList")
	@SuppressWarnings("unchecked") //unchecked로 되어있으면 데이터타입을 체크 안한다는 뜻
	public String profileWorkSpecList(Model model, @RequestParam(value="currentPage", required=false, defaultValue="1")int currentPage) {
		
		Map<String, Object> resultMap = adminProfileService.getProfileWorkSpecList(currentPage);
		List<Map<String, Object>> profileWorkSpecList = (List<Map<String, Object>>) resultMap.get("profileWorkSpecList");
		int lastPage = (int) resultMap.get("lastPage");
		int startPageNum = (int) resultMap.get("startPageNum");
		int endPageNum = (int) resultMap.get("lastPage");
		
		model.addAttribute("title", "경력 관리");
		model.addAttribute("profileWorkSpecList", profileWorkSpecList);
		model.addAttribute("lastPage", lastPage);
		model.addAttribute("startPageNum", startPageNum);
		model.addAttribute("endPageNum", endPageNum);
		
		return "admin/profile/adminProfileWorkSpecList";
	}
	
	@GetMapping("/adminProfileEduSpecList")
	public String profileEduSpecList(Model model, @RequestParam(value="currentPage", required=false, defaultValue="1")int currentPage) {
		Map<String,Object> resultMap = adminProfileService.getProfileEduSpecList(currentPage);
		List<Map<String, Object>> profileEduSpecList = (List<Map<String, Object>>) resultMap.get("profileEduSpecList");
		
		model.addAttribute("title", "학력 관리");
		model.addAttribute("profileEduSpecList", profileEduSpecList);
		
		return "admin/profile/adminProfileEduSpecList";
	}
	
	/**
	 * 자격증 등록 회원 목록
	 * @param model
	 * @param currentPage
	 * @param searchKey
	 * @param searchValue
	 * @return
	 */
	@GetMapping("/adminProfileCertificateList")
	@SuppressWarnings("unchecked") // unchecked로 되어있으면 데이터타입을 체크 안한다는 뜻
	public String profileCertificateList(Model model,
										 @RequestParam(value="currentPage", required = false, defaultValue = "1") int currentPage,
										 @RequestParam(value="searchKey", required = false) String searchKey,
										 @RequestParam(value="searchValue", required = false) String searchValue) {
		
		/* 페이징 */
		Map<String, Object> resultMap = adminProfileService.getCertificateList(currentPage, searchKey, searchValue);
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
		
		/* 검색 */
		model.addAttribute("searchKey", searchKey);
		model.addAttribute("searchValue", searchValue);
		
		return "admin/profile/adminProfileCertificateList";
	}
	
	/**
	 * 자격증 삭제
	 * @param reAttr
	 * @param certificateCode
	 * @param currentPage
	 * @param searchKey
	 * @param searchValue
	 * @return
	 */
	@GetMapping("/removeAdminProfileCertificate")
	public String removeAdminProfileCertificate(RedirectAttributes reAttr,
												@RequestParam(value="certificateCode") List<String> certificateCodeList,
												@RequestParam(value="currentPage", required = false, defaultValue = "1") int currentPage,
												@RequestParam(value="searchKey", required = false) String searchKey,
												@RequestParam(value="searchValue", required = false) String searchValue) {
		
		adminProfileService.removeAdminProfileCertificate(certificateCodeList);
		
		reAttr.addAttribute("currentPage", currentPage);
		reAttr.addAttribute("searchKey", searchKey);
		reAttr.addAttribute("searchValue", searchValue);
		
		return "redirect:/admin/profile/adminProfileCertificateList";
	}
	
	@GetMapping("/adminProfileAwardList")
	public String profileAwardList(Model model,
								   @RequestParam(value="currentPage", required = false, defaultValue = "1") int currentPage) {
		
		
		
		model.addAttribute("title", "수상이력 관리");
		
		return "admin/profile/adminProfileAwardList";
	}
	
	@GetMapping("/adminProfilePortfolioList")
	public String profilePortfolioList(Model model,
									   @RequestParam(value="currentPage", required = false, defaultValue = "1") int currentPage) {
		
		model.addAttribute("title", "포트폴리오 관리");
		
		return "admin/profile/adminProfilePortfolioList";
	}
}