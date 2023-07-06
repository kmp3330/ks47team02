package ks47team02.banner.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BannerController {

	@GetMapping("/banner")
	public String main(Model model) {
		model.addAttribute("title", "메인화면");
		model.addAttribute("contents", "spring boot mybatis");
		return "user/banner/bannerMain";
	}
	
}
