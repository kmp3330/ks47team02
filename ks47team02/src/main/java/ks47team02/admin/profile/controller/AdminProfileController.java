package ks47team02.admin.profile.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
	@GetMapping("/profileIntroList")
	public String profileIntroList(Model model) {
		
		model.addAttribute("title", "자기소개 관리");
		
		return "";
	}
	
	@GetMapping("/profileSkillList")
	public String profileSkillList(Model model) {
		
		model.addAttribute("title", "보유 기술 관리");
		
		return "";
	}
	
	@GetMapping("/profileWorkSpecList")
	public String profileWorkSpecList(Model model) {
		
		model.addAttribute("title", "경력 관리");
		
		return "";
	}
	
	@GetMapping("/profileEduSpecList")
	public String profileEduSpecList(Model model) {
		
		model.addAttribute("title", "학력 관리");
		
		return "";
	}
	
	@GetMapping("/profileCertificateList")
	public String profileCertificateList(Model model) {
		
		model.addAttribute("title", "자격증 관리");
		
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