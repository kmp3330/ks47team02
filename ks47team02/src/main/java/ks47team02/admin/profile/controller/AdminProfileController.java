package ks47team02.admin.profile.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ks47team02.admin.profile.service.ProfileService;
import lombok.AllArgsConstructor;

@Controller
@RequestMapping("/admin/profile")
@AllArgsConstructor
public class AdminProfileController {
	
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
		
		return "admin/profile/profileList";
	}
}