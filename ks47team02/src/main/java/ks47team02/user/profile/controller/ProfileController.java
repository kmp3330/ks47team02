package ks47team02.user.profile.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ks47team02.user.profile.dto.ProfileAward;
import ks47team02.user.profile.dto.ProfileCertificate;
import ks47team02.user.profile.dto.ProfileEduSpec;
import ks47team02.user.profile.dto.ProfileIntro;
import ks47team02.user.profile.dto.ProfileSkill;
import ks47team02.user.profile.dto.ProfileWorkSpec;
import ks47team02.user.profile.service.ProfileService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/profile")
@AllArgsConstructor
@Slf4j
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
	
	@PostMapping("/profileIntroInsert")
	public String profileIntroInsert(ProfileIntro profileIntro) {
		
		log.info("자기소개 등록시 입력정보: {}", profileIntro);
		
		profileService.profileIntroInsert(profileIntro);
		
		return "redirect:/profile/profileIntroList";
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
	/*
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
	
	@PostMapping("/profileSkillInsert")
	public String profileSkillInsert(ProfileSkill profileSkill) {
		
		log.info("자기소개 등록시 입력정보: {}", profileSkill);
		
		profileService.profileSkillInsert(profileSkill);
		
		return "redirect:/profile/profileSkillList";
	}
	@GetMapping("/profileSkillInsert")
	public String profilSkillInsert(Model model) {

		List<ProfileSkill> profileSkillList = profileService.getProfileSkillList();
		model.addAttribute("title", "메인화면");
		model.addAttribute("titleText", "크게 보이는 글씨");
		model.addAttribute("contents", "작게 보이는 글씨");
		model.addAttribute("profileSkillList", profileSkillList);
		return "user/profile/profile_Skill_insert";
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
	@PostMapping("/profileWorkSpecInsert")
	public String profileWorkSpecInsert(ProfileWorkSpec profileWorkSpec) {
		
		log.info("일경력  등록시 입력정보: {}", profileWorkSpec);
		
		profileService.profileWorkSpecInsert(profileWorkSpec);
		
		return "redirect:/profile/profileWorkSpecList";
	}
	@GetMapping("/profileWorkSpecInsert")
	public String profilWorkSpecInsert(Model model) {

		List<ProfileWorkSpec> profileWorkSpecList = profileService.getProfileWorkSpecList();
		model.addAttribute("title", "메인화면");
		model.addAttribute("titleText", "크게 보이는 글씨");
		model.addAttribute("contents", "작게 보이는 글씨");
		model.addAttribute("profileWorkSpecList", profileWorkSpecList);
		return "user/profile/profile_work_spec_insert";
	}
	
	/**
	 * 경력 화면
	 * @param model
	 * @return
	 */
	@GetMapping("/profileWorkSpecList")
	public String profileWorkSpecList(Model model) {
		List<ProfileWorkSpec>profileWorkSpecList = profileService.getProfileWorkSpecList();
		model.addAttribute("title", "경력");
		model.addAttribute("titleText", "경력 관리");
		model.addAttribute("contents", "경력을 관리할 수 있는 페이지입니다.");
		model.addAttribute("profileWorkSpecList", profileWorkSpecList);
		
		return "user/profile/profile_work_spec_list";
	}
	
	@PostMapping("/profileEduSpecInsert")
	public String profileEduSpecInsert(ProfileEduSpec profileEduSpec) {
		
		log.info("학력 등록시 입력정보: {}", profileEduSpec);
		
		profileService.profileEduSpecInsert(profileEduSpec);
		
		return "redirect:/profile/profileEduSpecList";
	}
	@GetMapping("/profileEduSpecInsert")
	public String profileEduSpecInsert(Model model) {

		List<ProfileEduSpec> profileEduSpecList = profileService.getProfileEduSpecList();
		model.addAttribute("title", "메인화면");
		model.addAttribute("titleText", "크게 보이는 글씨");
		model.addAttribute("contents", "작게 보이는 글씨");
		model.addAttribute("profileEduSpecList", profileEduSpecList);
		return "user/profile/profile_edu_spec_insert";
	}
	
	/**
	 * 학력 화면
	 * @param model
	 * @return
	 */
	@GetMapping("/profileEduSpecList")
	public String profileEduSpecList(Model model) {
		List<ProfileEduSpec> profileEduSpecList = profileService.getProfileEduSpecList();
		model.addAttribute("title", "학력");
		model.addAttribute("titleText", "학력 관리");
		model.addAttribute("contents", "학력을 관리할 수 있는 페이지입니다.");
		model.addAttribute("profileEduSpecList", profileEduSpecList);
		
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
	 * 자격증 등록화면
	 * @param model
	 * @return
	 */
	@GetMapping("/profileCertificateInsert")
	public String profileCertificateInsert(Model model) {
		
		model.addAttribute("title", "자격증 등록화면");
		
		return "user/profile/profile_certificate_insert";
	}
	
	@PostMapping("/profileCertificateInsert")
	public String profileCertificateInsert(ProfileCertificate profileCertificate) {
		
		profileService.profileCertificateInsert(profileCertificate);
		
		return "redirect:/profile/profileCertificateList";
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
