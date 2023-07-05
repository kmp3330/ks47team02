package ks47team02.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller("userCommonController")
public class CommonController {

	@GetMapping("/")
	public String main(Model model) {
		model.addAttribute("title", "메인화면");
		model.addAttribute("contents", "spring boot mybatis");
		return "user/main";
	}
	
}
