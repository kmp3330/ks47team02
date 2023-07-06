package ks47team02.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")

public class ProfileController {
	@GetMapping("/")
	public String main(Model model) {
		model.addAttribute("title", "메인화면");
		model.addAttribute("contents", "자기소개 페이지입니다.");
		return "user/profile/intro";
	}

}
