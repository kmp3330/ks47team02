package ks47team02.user.profile.controller;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.servlet.http.HttpSession;
import ks47team02.user.profile.dto.ProfileAward;
import ks47team02.user.profile.dto.ProfileCertificate;
import ks47team02.user.profile.dto.ProfileEduSpec;
import ks47team02.user.profile.dto.ProfileIntro;
import ks47team02.user.profile.dto.ProfilePortfolio;
import ks47team02.user.profile.dto.ProfileSkill;
import ks47team02.user.profile.dto.ProfileWorkSpec;
import ks47team02.user.profile.service.ProfileService;
import ks47team02.user.project.pro.dto.JoinCate;
import ks47team02.user.project.pro.dto.SubjectCate;
import ks47team02.user.project.pro.dto.WorkCate;
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
		
		model.addAttribute("title", "구직 프로필");
		model.addAttribute("titleText", "구직 프로필");
		model.addAttribute("contents", "구직 프로필을 볼 수 있는 페이지입니다.");
		
		return "user/profile/profileList";
	}
	/*자기소개 삭제 */
	@GetMapping("/profileIntroDelete")
	public String profileIntroDelete(@RequestParam(value="userIntroCode") String userIntroCode,
										   Model model) {
		
		profileService.profileIntroDelete(userIntroCode);
		
		model.addAttribute("title", "자격증 삭제 화면");
		
		return "redirect:/profile/profileIntroList";
	}
	
	@PostMapping("/profileIntroModify")
	public String profileIntroModify(ProfileIntro profileIntro) {
		
		profileService.profileIntroModify(profileIntro);
		
		return "redirect:/profile/profileIntroList";
	}
	
	/*
	 * 사용자 요청 시 쿼리스트링 : ex) userIntrocode=user_intro_code001
	 * @RequestParam(value="userIntroCode") String userIntroCode
	 * @return
	 * */
	@GetMapping("/profileIntroModify")
	public String profileIntroModify(@RequestParam(value="userIntroCode") String userIntroCode, Model model) {
		//회원 상세조회
		ProfileIntro profileIntroInfo = profileService.getProfileIntroInfoByCode(userIntroCode);
		//회원등급 목록 조회
		//List<ProfileLevel> profileLevelList = profileService.getProfileLevelList
		model.addAttribute("title","회원수정");
		model.addAttribute("profileIntroInfo",profileIntroInfo);
		model.addAttribute("title","회원수정");
		
		return "user/profile/profile_intro_modify";
		
	}
	
	@PostMapping("/profileIntroInsert")
	public String profileIntroInsert(ProfileIntro profileIntro) {
		
		log.info("자기소개 등록시 입력정보: {}", profileIntro);
		
		profileService.profileIntroInsert(profileIntro);
		
		return "redirect:/profile/profileIntroList";
	}
	
	@GetMapping("/profileIntroInsert")
	public String profileIntroInsert(Model model, HttpSession session) {
		
		String sessionId = (String)session.getAttribute("SID");

		List<ProfileIntro> profileIntroList = profileService.getProfileIntroList(sessionId);
		
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
	public String profileIntroList(Model model, HttpSession session) {

		 String sessionId = (String)session.getAttribute("SID");
		
		List<ProfileIntro> profileIntroList = profileService.getProfileIntroList(sessionId);
		
		model.addAttribute("title", "자기소개");
		model.addAttribute("titleText", "크게 보이는 글씨");
		model.addAttribute("contents", "작게 보이는 글씨");
		model.addAttribute("profileIntroList", profileIntroList);
		return "user/profile/profile_intro_list";
	}

	@GetMapping("/profileSkillDelete")
	public String profileSkillDelete(@RequestParam(value="userSkillCode") String userSkillCode, Model model) {
		profileService.profileSkillDelete(userSkillCode);
		model.addAttribute("title", "보유기술 삭제화면");
		return "redirect:/profile/profileSkillList";
	}
	/*
	 * 사용자 요청 시 쿼리스트링 : ex) userSkillcode=user_skill_code001
	 * @RequestParam(value="userSkillCode") String userSkillCode
	 * @return
	 * */
	@PostMapping("/profileSkillModify")
	public String profileSkillModify(ProfileSkill profileSkill) {
		
		profileService.profileSkillModify(profileSkill);
		
		return "redirect:/profile/profileSkillList";
	}
	

	/*
	 * 사용자 요청 시 쿼리스트링 : ex) userSkillcode=user_Skill_code001
	 * @RequestParam(value="userSkillCode") String userSkillCode
	 * @return
	 * */
	@GetMapping("/profileSkillModify")
	public String profileSkillModify(@RequestParam(value="userSkillCode") String userSkillCode, Model model) {
		//회원 상세조회
		ProfileSkill profileSkillInfo = profileService.getProfileSkillInfoByCode(userSkillCode);
		//회원등급 목록 조회
		//List<ProfileLevel> profileLevelList = profileService.getProfileLevelList
		model.addAttribute("title","회원수정");
		model.addAttribute("profileSkillInfo",profileSkillInfo);
		model.addAttribute("title","회원수정");
		
		return "user/profile/profile_skill_modify";
		
	}
	
	
	@PostMapping("/profileSkillInsert")
	public String profileSkillInsert(ProfileSkill profileSkill) {
		
		log.info("자기소개 등록시 입력정보: {}", profileSkill);
		
		profileService.profileSkillInsert(profileSkill);
		
		return "redirect:/profile/profileSkillList";
	}
	@GetMapping("/profileSkillInsert")
	public String profilSkillInsert(Model model, HttpSession session) {
		
		String sessionId = (String)session.getAttribute("SID");

		List<ProfileIntro> profileSkillList = profileService.getProfileIntroList(sessionId);

		model.addAttribute("title", "메인화면");
		model.addAttribute("titleText", "크게 보이는 글씨");
		model.addAttribute("contents", "작게 보이는 글씨");
		model.addAttribute("profileSkillList", profileSkillList);
		return "user/profile/profile_skill_insert";
	}
	/**
	 * 보유기술 화면
	 * @param model
	 * @return
	 */
	@GetMapping("/profileSkillList")
	public String profileSkillList(Model model, HttpSession session) {
		
		String sessionId = (String)session.getAttribute("SID");
		
		List<ProfileSkill> profileSkillList = profileService.getProfileSkillList(sessionId);
		
		model.addAttribute("title", "메인화면");
		model.addAttribute("titleText", "크게 보이는 글씨");
		model.addAttribute("contents", "작게 보이는 글씨");
		model.addAttribute("profileSkillList", profileSkillList);

		return "user/profile/profile_skill_list";
	}
	
	@GetMapping("/profileWorkSpecDelete")
	public String profileWorkSpecDelete(@RequestParam(value="userWorkSpecCode") String userWorkSpecCode, Model model) {
		profileService.profileWorkSpecDelete(userWorkSpecCode);
		model.addAttribute("title","보유기술 삭제화면");
		return "redirect:/profile/profileWorkSpecList";
	}
	
	@PostMapping("/profileWorkSpecModify")
	public String profileWorkSpecModify(ProfileWorkSpec profileWorkSpec) {
		profileService.profileWorkSpecModify(profileWorkSpec);
		
		return "redirect:/profile/profileWorkSpecList";
	}
	/*
	 * 사용자 요청 시 쿼리스트링 : ex) userWorkSpeccode=user_WorkSpec_code001
	 * @RequestParam(value="userWorkSpecCode") String userWorkSpecCode
	 * @return
	 * */
	@GetMapping("/profileWorkSpecModify")
	public String profileWorkSpecModify(@RequestParam(value="userWorkSpecCode") String userWorkSpecCode, Model model) {
		//회원 상세조회
		ProfileWorkSpec profileWorkSpecInfo = profileService.getProfileWorkSpecInfoByCode(userWorkSpecCode);
		//회원등급 목록 조회
		//List<ProfileLevel> profileLevelList = profileService.getProfileLevelList
		model.addAttribute("title","회원수정");
		model.addAttribute("profileWorkSpecInfo",profileWorkSpecInfo);
		
		return "user/profile/profile_work_spec_modify";
		
	}
	@PostMapping("/profileWorkSpecInsert")
	public String profileWorkSpecInsert(ProfileWorkSpec profileWorkSpec) {
		
		log.info("일경력  등록시 입력정보: {}", profileWorkSpec);
		
		profileService.profileWorkSpecInsert(profileWorkSpec);
		
		return "redirect:/profile/profileWorkSpecList";
	}
	@GetMapping("/profileWorkSpecInsert")
	public String profilWorkSpecInsert(Model model, HttpSession session) {
		
		String sessionId = (String)session.getAttribute("SID");
		
		List<ProfileWorkSpec> profileWorkSpecList = profileService.getProfileWorkSpecList(sessionId);
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
	public String profileWorkSpecList(Model model, HttpSession session) {
		
		String sessionId = (String)session.getAttribute("SID");
		
		List<ProfileWorkSpec>profileWorkSpecList = profileService.getProfileWorkSpecList(sessionId);
		
		model.addAttribute("title", "경력");
		model.addAttribute("titleText", "경력 관리");
		model.addAttribute("contents", "경력을 관리할 수 있는 페이지입니다.");
		model.addAttribute("profileWorkSpecList", profileWorkSpecList);
		
		return "user/profile/profile_work_spec_list";
	}
	/*학력 수*/
	@GetMapping("/profileEduSpecDelete")
	public String profileEduSpecDelete(@RequestParam(value="userEduSpecCode") String userEduSpecCode,
										   Model model) {
		
		profileService.profileEduSpecDelete(userEduSpecCode);
		
		model.addAttribute("title", "학력 삭제 화면");
		
		return "redirect:/profile/profileEduSpecList";
	}
	
	@PostMapping("/profileEduSpecModify")
	public String profileEduSpecModify(ProfileEduSpec profileEduSpec) {
		profileService.profileEduSpecModify(profileEduSpec);
		return "redirect:/profile/profileEduSpecList";
	}
	/*
	 * 사용자 요청 시 쿼리스트링 : ex) userEduSpeccode=user_work_spec_code001
	 * @RequestParam(value="userEduSpecCode") String userEduSpecCode
	 * @return
	 * */
	@GetMapping("/profileEduSpecModify")
	public String profileEduSpecModify(@RequestParam(value="userEduSpecCode") String userEduSpecCode, Model model) {
		//회원 상세조회
		ProfileEduSpec profileEduSpecInfo = profileService.getProfileEduSpecInfoByCode(userEduSpecCode);
		//회원등급 목록 조회
		//List<ProfileLevel> profileLevelList = profileService.getProfileLevelList
		model.addAttribute("title","회원수정");
		model.addAttribute("profileEduSpecInfo",profileEduSpecInfo);
		
		return "user/profile/profile_edu_spec_modify";
		
	}
	
	
	@PostMapping("/profileEduSpecInsert")
	public String profileEduSpecInsert(ProfileEduSpec profileEduSpec) {
		
		log.info("학력 등록시 입력정보: {}", profileEduSpec);
		
		profileService.profileEduSpecInsert(profileEduSpec);
		
		return "redirect:/profile/profileEduSpecList";
	}
	@GetMapping("/profileEduSpecInsert")
	public String profileEduSpecInsert(Model model, HttpSession session) {
		
		String sessionId = (String)session.getAttribute("SID");

		List<ProfileEduSpec> profileEduSpecList = profileService.getProfileEduSpecList(sessionId);
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
	public String profileEduSpecList(Model model, HttpSession session) {
		
		String sessionId = (String)session.getAttribute("SID");
		
		List<ProfileEduSpec> profileEduSpecList = profileService.getProfileEduSpecList(sessionId);
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
	@GetMapping("/profileCertificateList") //session: 해당 session 에 담겨져있는 값을 가져와서 String sessionid에 담아
	public String profileCertificateList(Model model, HttpSession session) {
		
		String sessionId = (String) session.getAttribute("SID");
		
		List<ProfileCertificate> certificateList = profileService.certificateList(sessionId);
		
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
		
		model.addAttribute("title", "자격증 등록");
		model.addAttribute("titleText", "자격증 등록");
		model.addAttribute("contents", "나의 자격증 정보를 등록하는 페이지입니다.");
		
		return "user/profile/profile_certificate_insert";
	}
	
	/**
	 * 자격증 등록 처리
	 * @param profileCertificate
	 * @return
	 */
	@PostMapping("/profileCertificateInsert")
	public String profileCertificateInsert(ProfileCertificate profileCertificate, HttpSession session) {
		
		// if(sessionId == null) 조건을 넣어서 null 이면 로그인 페이지로 이동하게 하면 되는데
		// 지금은 인터셉터에서 이미 처리가 되어있는 상태라 필요없다.
		String sessionId = (String) session.getAttribute("SID");
		profileCertificate.setUserId(sessionId);
		
		profileService.profileCertificateInsert(profileCertificate);
		
		return "redirect:/profile/profileCertificateList";
	}
	
	/**
	 * 자격증 수정 화면
	 * @param model
	 * @return
	 */
	@GetMapping("/profileCertificateModify")
	public String profileCertificateModify(Model model,
										   @RequestParam(value="certificateCode") String certificateCode) {
		
		ProfileCertificate certificateInfo = profileService.certificateByCode(certificateCode);
		log.info("certificateInfo : {}", certificateInfo);
		
		model.addAttribute("title", "자격증 수정");
		model.addAttribute("titleText", "자격증 수정");
		model.addAttribute("contents", "나의 자격증 정보를 수정하는 페이지입니다.");
		model.addAttribute("certificateInfo", certificateInfo);
		
		return "user/profile/profile_certificate_modify";
	}
	/**
	 * 자격증 수정 처리
	 * @param profileCertificate
	 * @return
	 */
	@PostMapping("/profileCertificateModify")
	public String profileCertificateModify(ProfileCertificate profileCertificate) {
		
		log.info("modifyCertificate profileCertificate : {}", profileCertificate);
		profileService.profileCertificateModify(profileCertificate);
		
		return "redirect:/profile/profileCertificateList";
	}
	
	/**
	 * 자격증 삭제 화면
	 * @param certificateCode
	 * @return
	 */
	@GetMapping("/profileCertificateDelete")
	public String profileCertificateDelete(@RequestParam(value="certificateCode") String certificateCode,
										   Model model) {
		
		profileService.profileCertificateDelete(certificateCode);
		
		model.addAttribute("title", "자격증 삭제 화면");
		
		return "redirect:/profile/profileCertificateList";
	}
	
	
	/**
	 * 수상이력 화면
	 * @param model
	 * @return
	 */
	@GetMapping("/profileAwardList")
	public String profileAward(Model model, HttpSession session) {
		
		String sessionId = (String) session.getAttribute("SID");
		
		List<ProfileAward> profileAwardList = profileService.getProfileAwardList(sessionId);
		
		model.addAttribute("title", "수상이력");
		model.addAttribute("titleText", "수상이력 관리");
		model.addAttribute("contents", "지금까지 수상했던 이력을 관리할 수 있는 페이지입니다.");
		
		model.addAttribute("profileAwardList", profileAwardList);
		
		return "user/profile/profile_award_list";
	}
	
	/**
	 * 수상이력 등록 화면
	 * @param model
	 * @return
	 */
	@GetMapping("/profileAwardInsert")
	public String profileAwardInsert(Model model) {
		
		model.addAttribute("title", "수상이력 등록");
		model.addAttribute("titleText", "수상이력 등록");
		model.addAttribute("contents", "나의 수상이력 정보를 등록 할 수 있는 페이지입니다.");
		
		return "user/profile/profile_award_insert";
	}
	/**
	 * 수상이력 등록 처리
	 * @param profileAward
	 * @param session
	 * @return
	 */
	@PostMapping("/profileAwardInsert")
	public String profileAwardInsert(ProfileAward profileAward,
									 HttpSession session) {
		
		String sessionId = (String) session.getAttribute("SID");
		profileAward.setUserId(sessionId);
		
		profileService.addProfileAward(profileAward);
		
		return "redirect:/profile/profileAwardList";
	}
	
	/**
	 * 수상이력 수정 화면
	 * @param model
	 * @param userAwardCode
	 * @return
	 */
	@GetMapping("/profileAwardModify")
	public String profileAwardModify(Model model,
									 @RequestParam(value="profileAwardCode") String userAwardCode) {
		
		ProfileAward profileAwardInfo = profileService.profileAwardByCode(userAwardCode);
		
		model.addAttribute("title", "수상이력 수정");
		model.addAttribute("titleText", "수상이력 수정");
		model.addAttribute("contents", "나의 수상이력 정보를 수정 할 수 있는 페이지입니다.");
		model.addAttribute("profileAwardInfo", profileAwardInfo);
		
		return "user/profile/profile_award_modify";
	}
	/**
	 * 수상이력 수정처리
	 * @param profileAward
	 * @return
	 */
	@PostMapping("/profileAwardModify")
	public String profileAwardModify(ProfileAward profileAward) {
		
		profileService.modifyProfileAward(profileAward);
		
		return "redirect:/profile/profileAwardList";
	}
	
	/**
	 * 수상이력 삭제
	 * @param profileAwardCode
	 * @return
	 */
	@GetMapping("/profileAwardDelete")
	public String profileAwardDelete(@RequestParam(value="profileAwardCode") String profileAwardCode) {
		
		profileService.deleteProfileAward(profileAwardCode);
		
		return "redirect:/profile/profileAwardList";
	}
	
	/**
	 * 포트폴리오 조회
	 * @param model
	 * @return
	 */
	@GetMapping("/profilePortfolioList")
	public String profilePortfolioList(Model model, HttpSession session) {
		
		String sessionId = (String) session.getAttribute("SID");
		
		List<ProfilePortfolio> portfolioList = profileService.getProfilePortfolioList(sessionId);
		
		model.addAttribute("title", "포트폴리오");
		model.addAttribute("titleText", "포트폴리오 관리");
		model.addAttribute("contents", "자신의 포트폴리오를 관리할 수 있는 페이지입니다.");
		model.addAttribute("portfolioList", portfolioList);
		
		return "user/profile/profile_portfolio_list";
	}
	
	/**
	 * 포트폴리오 등록
	 * @param model
	 * @return
	 */
	@GetMapping("/profilePortfolioInsert")
	public String profilePortfolioInsert(Model model) {
		
		List<JoinCate> joinCateList = profileService.getJoinCateList();
		List<WorkCate> workCateList = profileService.getWorkCateList();
		List<SubjectCate> subjectCateList = profileService.getSubjectCateList();
		
		model.addAttribute("title", "포트폴리오 등록");
		model.addAttribute("titleText", "포트폴리오 등록");
		model.addAttribute("contents", "나의 포트폴리오를 등록 할 수 있는 페이지입니다.");
		model.addAttribute("joinCateList", joinCateList);
		model.addAttribute("workCateList", workCateList);
		model.addAttribute("subjectCateList", subjectCateList);
		
		return "user/profile/profile_portfolio_insert";
	}
	
	/**
	 * 포트폴리오 등록 처리
	 * @param profilePortfolio
	 * @param session
	 * @return
	 */
	@PostMapping("/profilePortfolioInsert")
	public String profilePortfolioInsert(ProfilePortfolio profilePortfolio,
										 HttpSession session) {
		
		String sessionId = (String) session.getAttribute("SID");
		profilePortfolio.setUserId(sessionId);
		
		String joinCateCode = profilePortfolio.getJoinCateCode();
		String workCateCode = profilePortfolio.getWorkCateCode();
		String subjectCateCode = profilePortfolio.getSubjectCateCode();
		
		JoinCate joinCateInfo = profileService.getJoinCateByCode(joinCateCode);
		WorkCate workCateInfo = profileService.getWorkCateByCode(workCateCode);
		SubjectCate subjectCateInfo = profileService.getSubjectCateByCode(subjectCateCode);
		
		profilePortfolio.setJoinCateName(joinCateInfo.getJoinCateName());
		profilePortfolio.setWorkCateName(workCateInfo.getWorkCateName());
		profilePortfolio.setSubjectCateName(subjectCateInfo.getSubjectCateName());
		log.info("profilePortfolio : {}", profilePortfolio);
		
		profileService.addProfilePortfolio(profilePortfolio);
		
		return "redirect:/profile/profilePortfolioList";
	}
	
	/**
	 * 포트폴리오 수정
	 * @param model
	 * @param profilePortfolioCode
	 * @return
	 */
	@GetMapping("/profilePortfolioModify")
	public String profilePortfolioModify(Model model,
										 @RequestParam(value="profilePortfolioCode") String profilePortfolioCode) {
		
		ProfilePortfolio profilePortfolioInfo = profileService.profilePortfolioByCode(profilePortfolioCode);
		
		List<JoinCate> joinCateList = profileService.getJoinCateList();
		List<WorkCate> workCateList = profileService.getWorkCateList();
		List<SubjectCate> subjectCateList = profileService.getSubjectCateList();
		
		model.addAttribute("title", "포트폴리오 수정");
		model.addAttribute("titleText", "포트폴리오 수정");
		model.addAttribute("contents", "나의 포트폴리오를 수정 할 수 있는 페이지입니다.");
		model.addAttribute("profilePortfolioInfo", profilePortfolioInfo);
		model.addAttribute("joinCateList", joinCateList);
		model.addAttribute("workCateList", workCateList);
		model.addAttribute("subjectCateList", subjectCateList);
		
		return "user/profile/profile_portfolio_modify";
	}
	/**
	 * 포트폴리오 수정처리
	 * @param profilePortfolio
	 * @return
	 */
	@PostMapping("/profilePortfolioModify")
	public String profilePortfolioModify(ProfilePortfolio profilePortfolio) {
		
		String joinCateCode = profilePortfolio.getJoinCateCode();
		String workCateCode = profilePortfolio.getWorkCateCode();
		String subjectCateCode = profilePortfolio.getSubjectCateCode();
		
		JoinCate joinCateInfo = profileService.getJoinCateByCode(joinCateCode);
		WorkCate workCateInfo = profileService.getWorkCateByCode(workCateCode);
		SubjectCate subjectCateInfo = profileService.getSubjectCateByCode(subjectCateCode);
		
		profilePortfolio.setJoinCateName(joinCateInfo.getJoinCateName());
		profilePortfolio.setWorkCateName(workCateInfo.getWorkCateName());
		profilePortfolio.setSubjectCateName(subjectCateInfo.getSubjectCateName());
		log.info("profilePortfolio : {}", profilePortfolio);
		
		profileService.profilePortfolioModify(profilePortfolio);
		
		return "redirect:/profile/profilePortfolioList";
	}
	
	/**
	 * 포트폴리오 삭제
	 * @param profilePortfolioCode
	 * @return
	 */
	@GetMapping("/profilePortfolioDelete")
	public String profilePortfolioDelete(@RequestParam(value="profilePortfolioCode") String profilePortfolioCode) {
		
		profileService.profilePortfolioDelete(profilePortfolioCode);
		
		return "redirect:/profile/profilePortfolioList";
	}
	
	@PostMapping("/pro")
	@ResponseBody
	public List<Map<String, Object>> projectList(HttpSession session) {
		
		String sessionId = (String) session.getAttribute("SID");
		
		List<Map<String, Object>> result = profileService.getProProjectList(sessionId);
		
		return result;
	}
}
