package ks47team02.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/profile")

public class ProfileController {
	@GetMapping("/profileIntroList")
	public String profileIntroList(Model model) {
		model.addAttribute("title", "메인화면");
		model.addAttribute("titleText", "크게 보이는 글씨");
		model.addAttribute("contents", "작게 보이는 글씨");
		return "user/profile/profile_intro_list";
	}

	@GetMapping("/profileSkillList")
	public String profileSkillList(Model model) {
		model.addAttribute("title", "메인화면");
		model.addAttribute("titleText", "크게 보이는 글씨");
		model.addAttribute("contents", "작게 보이는 글씨");
		return "user/profile/profile_skill_list";
	}
	
	@GetMapping("/profileWorkSpecList")
	public String profileWorkSpecList(Model model) {
		model.addAttribute("title", "메인화면");
		model.addAttribute("titleText", "크게 보이는 글씨");
		model.addAttribute("contents", "작게 보이는 글씨");
		return "user/profile/profile_work_spec_list";
	}
	@GetMapping("/profileEduSpecList")
	public String profileEduSpecList(Model model) {
		model.addAttribute("title", "메인화면");
		model.addAttribute("titleText", "크게 보이는 글씨");
		model.addAttribute("contents", "작게 보이는 글씨");
		return "user/profile/profile_edu_spec_list";
	}
	
	@GetMapping("/profileCertificateList")
	public String profileCertificateList(Model model) {
		model.addAttribute("title", "메인화면");
		model.addAttribute("titleText", "크게 보이는 글씨");
		model.addAttribute("contents", "작게 보이는 글씨");
		return "user/profile/profile_certificate_list";
	}
	
	@GetMapping("/profileAwardList")
	public String profileAward(Model model) {
		model.addAttribute("title", "메인화면");
		model.addAttribute("titleText", "크게 보이는 글씨");
		model.addAttribute("contents", "작게 보이는 글씨");
		return "user/profile/profile_award_list";
	}
	@GetMapping("/profilePortfolioList")
	public String profilePortfolioList(Model model) {
		model.addAttribute("title", "메인화면");
		model.addAttribute("titleText", "크게 보이는 글씨");
		model.addAttribute("contents", "작게 보이는 글씨");
		return "user/profile/profile_portfolio_list";
			

	}
}
