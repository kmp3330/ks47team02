package ks47team02.user.member.controller;

import java.util.HashMap;
import java.util.Map;

import ks47team02.admin.dto.Member;
import ks47team02.user.member.dto.Company;
import ks47team02.user.member.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import ks47team02.user.member.dto.User;
import ks47team02.user.member.service.MemberService;
import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
@Slf4j
public class MemberController {
	
	// 의존성 주입
	private final MemberService memberService;
	private final UserMapper userMapper;

	/**
	 * 로그인 화면
	 * @return
	 */
	@GetMapping("/login")
	public String login(Model model,
						@RequestParam(value = "msg", required = false) String msg) {
		
		model.addAttribute("title", "로그인 화면");
		if(msg != null) model.addAttribute("msg", msg);
		
		return "user/login/login";
	}
	
	/**
	 * 로그인 처리
	 * @return
	 */
	@PostMapping("/login") 
	public String login(@RequestParam(value = "userId") String userId,
						@RequestParam(value = "userPw") String userPw,
						HttpServletRequest request,
						HttpServletResponse response,
						HttpSession session,
						RedirectAttributes reAttr) { //redirect를 될때 데이터를 전달 (모델이랑 같은 역할)
		
		Map<String, Object> validMap = memberService.loginCheck(userId, userPw);
		boolean isValid = (boolean) validMap.get("isValid"); //get: MAP에 담아져있는 데이터를 가져옴 
		
		if(isValid) {
			User userInfo = (User) validMap.get("userInfo");
			session.setAttribute("SID", userInfo.getUserId());
			session.setAttribute("SLEVEL", userInfo.getLevelName());
			session.setAttribute("SNAME", userInfo.getUserName());
			
			
			return "redirect:/";
		}
		
		reAttr.addAttribute("msg", "일치하는 회원의 정보가 없습니다.");
		return "redirect:/login";
	}
	
	/**
	 * 로그아웃 처리
	 * @param session
	 * @return
	 */
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		
		session.invalidate();
		
		return "redirect:/";
	}

	@PostMapping("/checkId")
	@ResponseBody
	public boolean checkId(@RequestParam(value="userId") String userId) {
		boolean result = memberService.checkId(userId);
		return result;
	}
	@PostMapping("/addNormalMember")
	public String addUser(User user){
		memberService.addUser(user);
		return "redirect:/";
	}

	@GetMapping("/addMember")
	public String addMember(Member member, HttpSession session, Model model){
		model.addAttribute("titleText", "회원가입");
		model.addAttribute("contents", "가입하려는 회원의 유형을 선택해주세요");

		return "user/member/addMember";
	}

	@GetMapping("/addNormalMember")
	public String addUser(User user, HttpSession session, Model model){
		model.addAttribute("titleText", "일반 회원 가입");
		return "user/member/addNormalMember";
	}

	@GetMapping("/addCompanyUser")
	public String addCompany(Company company, HttpSession session, Model model){
		model.addAttribute("titleText", "기업 회원 가입");
		return "user/member/addCompanyMember";
	}
}
