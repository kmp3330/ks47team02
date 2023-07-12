package ks47team02.user.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ks47team02.user.dto.ProfileIntro;
import ks47team02.user.dto.ProfileSkill;
import ks47team02.user.service.ProfileService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@AllArgsConstructor
@RequestMapping("/profile")
public class ProfileController {

	private final ProfileService profileService;
	/*
	 * 회원목록 조회
	 * 
	 * @param model
	 * 
	 * @return
	 */

	// 자기소개 프로필 등록 화면
	/*
	 * @PostMapping("/profileIntroInsert") public String
	 * profileIntroInsert(ProfileIntro profileIntro) {
	 * 
	 * log.info("자기소개 등록시 입력정보 : {}", profileIntro);
	 * 
	 * profileService.profileIntroInsert(profileIntro); return
	 * "redirect:/user/profile/profile_intro_list"; }
	 */

	@GetMapping("/profileIntroInsert")
	public String profileIntroInsert(Model model) {

		List<ProfileIntro> profileIntroList = profileService.getProfileIntroList();
		model.addAttribute("title", "메인화면");
		model.addAttribute("titleText", "크게 보이는 글씨");
		model.addAttribute("contents", "작게 보이는 글씨");
		model.addAttribute("profileIntroList", profileIntroList);
		return "user/profile/profile_intro_insert";
	}

	@GetMapping("/profileIntroList")
	public String profileIntroList(Model model) {

		List<ProfileIntro> profileIntroList = profileService.getProfileIntroList();
		model.addAttribute("title", "메인화면");
		model.addAttribute("titleText", "크게 보이는 글씨");
		model.addAttribute("contents", "작게 보이는 글씨");
		model.addAttribute("profileIntroList", profileIntroList);
		return "user/profile/profile_intro_list";
	}

	@GetMapping("/profileSkillList")
	public String profileSkillList(Model model) {

		List<ProfileSkill> profileSkillList = profileService.getProfileSkillList();
		model.addAttribute("title", "메인화면");
		model.addAttribute("titleText", "크게 보이는 글씨");
		model.addAttribute("contents", "작게 보이는 글씨");
		model.addAttribute("profileSkillList", profileSkillList);

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

	/*
	 * @GetMapping("/profileWorkSpecList") public String profileWorkSpecList(Model
	 * model) { model.addAttribute("title", "메인화면"); model.addAttribute("titleText",
	 * "크게 보이는 글씨"); model.addAttribute("contents", "작게 보이는 글씨"); return
	 * "user/profile/profile_work_spec_list"; }
	 * 
	 * @GetMapping("/profileEduSpecList") public String profileEduSpecList(Model
	 * model) { model.addAttribute("title", "메인화면"); model.addAttribute("titleText",
	 * "크게 보이는 글씨"); model.addAttribute("contents", "작게 보이는 글씨"); return
	 * "user/profile/profile_edu_spec_list"; }
	 * 
	 * @GetMapping("/profileCertificateList") public String
	 * profileCertificateList(Model model) { model.addAttribute("title", "메인화면");
	 * model.addAttribute("titleText", "크게 보이는 글씨"); model.addAttribute("contents",
	 * "작게 보이는 글씨"); return "user/profile/profile_certificate_list"; }
	 * 
	 * @GetMapping("/profileAwardList") public String profileAward(Model model) {
	 * model.addAttribute("title", "메인화면"); model.addAttribute("titleText",
	 * "크게 보이는 글씨"); model.addAttribute("contents", "작게 보이는 글씨"); return
	 * "user/profile/profile_award_list"; }
	 * 
	 * @GetMapping("/profilePortfolioList") public String profilePortfolioList(Model
	 * model) { model.addAttribute("title", "메인화면"); model.addAttribute("titleText",
	 * "크게 보이는 글씨"); model.addAttribute("contents", "작게 보이는 글씨"); return
	 * "user/profile/profile_portfolio_list";
	 * 
	 */
}
