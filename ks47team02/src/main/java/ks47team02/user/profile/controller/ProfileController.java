package ks47team02.user.profile.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ks47team02.user.profile.dto.ProfileAward;
import ks47team02.user.profile.dto.ProfileCertificate;
import ks47team02.user.profile.dto.ProfileIntro;
import ks47team02.user.profile.dto.ProfileSkill;
import ks47team02.user.profile.service.ProfileService;
import lombok.AllArgsConstructor;

@Controller
@RequestMapping("/profile")
@AllArgsConstructor
public class ProfileController {
	
	private final ProfileService profileService;
	
	/**
	 * 전체 프로필 화면
	 * @param model
	 * @return
	 */
	@GetMapping("/")
	public String profileList(Model model) {
		
		model.addAttribute("title", "전체 프로필");
		model.addAttribute("titleText", "전체 프로필");
		model.addAttribute("contents", "전체 프로필을 볼 수 있는 페이지입니다.");
		
		return "user/profile/profileList";
	}
	
	/**
	 * 자기소개 화면
	 * @param model
	 * @return
	 */
	@GetMapping("/profileIntroList")
	public String profileIntroList(Model model) {
		List<ProfileIntro> profileIntroList = profileService.getProfileIntroList();
		model.addAttribute("title", "메인화면");
		model.addAttribute("titleText", "크게 보이는 글씨");
		model.addAttribute("contents", "작게 보이는 글씨");
		model.addAttribute("profileIntroList", profileIntroList);
		return "user/profile/profile_intro_list";
	}
	@GetMapping("/profileIntroInsert")
	public String profileIntroInsert(Model model) {

		List<ProfileIntro> profileIntroList = profileService.getProfileIntroList();
		model.addAttribute("title", "메인화면");
		model.addAttribute("titleText", "크게 보이는 글씨");
		model.addAttribute("contents", "작게 보이는 글씨");
		model.addAttribute("profileIntroList", profileIntroList);
		return "user/profile/profile_intro_insert";
	}

	/**
	 * 보유기술 화면
	 * @param model
	 * @return
	 */
	@GetMapping("/profileSkillList")
	public String profileSkillList(Model model) {
		List<ProfileSkill> profileSkillList = profileService.getProfileSkillList();
		model.addAttribute("title", "메인화면");
		model.addAttribute("titleText", "크게 보이는 글씨");
		model.addAttribute("contents", "작게 보이는 글씨");
		model.addAttribute("profileSkillList", profileSkillList);

		return "user/profile/profile_skill_list";
	}
	
	/**
	 * 경력 화면
	 * @param model
	 * @return
	 */
	@GetMapping("/profileWorkSpecList")
	public String profileWorkSpecList(Model model) {
		model.addAttribute("title", "경력");
		model.addAttribute("titleText", "경력 관리");
		model.addAttribute("contents", "경력을 관리할 수 있는 페이지입니다.");
		return "user/profile/profile_work_spec_list";
	}
	
	/**
	 * 학력 화면
	 * @param model
	 * @return
	 */
	@GetMapping("/profileEduSpecList")
	public String profileEduSpecList(Model model) {
		model.addAttribute("title", "학력");
		model.addAttribute("titleText", "학력 관리");
		model.addAttribute("contents", "학력을 관리할 수 있는 페이지입니다.");
		return "user/profile/profile_edu_spec_list";
	}
	
	/**
	 * 자격증 화면
	 * @param model
	 * @return
	 */
	@GetMapping("/profileCertificateList")
	public String profileCertificateList(Model model) {
		
		List<ProfileCertificate> certificateList = profileService.certificateList();
		
		model.addAttribute("title", "자격증");
		model.addAttribute("titleText", "보유 자격증");
		model.addAttribute("contents", "현재 보유중인 자격증을 관리할 수 있는 페이지입니다.");
		
		model.addAttribute("certificateList", certificateList);
		
		return "user/profile/profile_certificate_list";
	}
	
	/**
	 * 수상이력 화면
	 * @param model
	 * @return
	 */
	@GetMapping("/profileAwardList")
	public String profileAward(Model model) {
		
		List<ProfileAward> profileAwardList = profileService.profileAwardList();
		
		model.addAttribute("title", "수상이력");
		model.addAttribute("titleText", "수상이력 관리");
		model.addAttribute("contents", "지금까지 수상했던 이력을 관리할 수 있는 페이지입니다.");
		
		model.addAttribute("profileAwardList", profileAwardList);
		
		return "user/profile/profile_award_list";
	}
	
	/**
	 * 포트폴리오 화면
	 * @param model
	 * @return
	 */
	@GetMapping("/profilePortfolioList")
	public String profilePortfolioList(Model model) {
		model.addAttribute("title", "포트폴리오");
		model.addAttribute("titleText", "포트폴리오 관리");
		model.addAttribute("contents", "자신의 포트폴리오를 관리할 수 있는 페이지입니다.");
		return "user/profile/profile_portfolio_list";
			

	}
}
