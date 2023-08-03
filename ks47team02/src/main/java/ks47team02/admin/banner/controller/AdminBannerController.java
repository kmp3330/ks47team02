package ks47team02.admin.banner.controller;

import ks47team02.admin.banner.service.AdminBannerService;
import ks47team02.user.banner.dto.BannerRequestCompany;
import ks47team02.user.banner.service.BannerService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Slf4j
@AllArgsConstructor
@Controller
public class AdminBannerController {

	private final AdminBannerService adminBannerService;


	/*@GetMapping("/banner/bannerRequest")
	public String request(Model model) {
		model.addAttribute("title", "광고 신청");
		model.addAttribute("titleText", "광고 신청");
		model.addAttribute("contents", "광고 단가 및 예상 가격을 확인할 수 있고, 광고 신청 및 조회를 할 수 있습니다.");
		return "user/banner/bannerRequest";
	}

	@PostMapping("/banner/bannerRequest")
	public String request(BannerRequestCompany bannerRequestCompany){
		log.info("신청 시 입력 정보: {}", bannerRequestCompany);
		bannerService.request(bannerRequestCompany);

		return "redirect:/banner/bannerMain";
	}
*/

}
