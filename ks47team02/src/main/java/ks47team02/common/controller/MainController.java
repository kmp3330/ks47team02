package ks47team02.common.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
	
	@GetMapping("/")
	public String main(Model model) {
		
		model.addAttribute("title", "소개페이지");
		
		return "main/index";
	}

}
