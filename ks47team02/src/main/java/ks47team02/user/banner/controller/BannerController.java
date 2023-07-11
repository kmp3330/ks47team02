package ks47team02.user.banner.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@AllArgsConstructor
@Controller
public class BannerController {

	@GetMapping("/banner")
	public String main(Model model) {
		model.addAttribute("title", "광고 문의");
		model.addAttribute("titleText", "광고 문의");
		model.addAttribute("contents", "광고 단가 및 예상 가격을 확인할 수 있고, 광고 신청 및 조회를 할 수 있습니다.");
		return "user/banner/bannerMain";
	}
	
}
