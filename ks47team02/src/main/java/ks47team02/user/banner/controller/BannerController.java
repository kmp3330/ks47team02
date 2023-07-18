package ks47team02.user.banner.controller;

import ks47team02.user.banner.dto.BannerRequestCompany;
import ks47team02.user.banner.service.BannerService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@AllArgsConstructor
@Controller
public class BannerController {

	private final BannerService bannerService;

	@GetMapping("/banner")
	public String main(Model model) {
		model.addAttribute("title", "광고 문의");
		model.addAttribute("titleText", "광고 문의");
		model.addAttribute("contents", "광고 단가 및 예상 가격을 확인할 수 있고, 광고 신청 및 조회를 할 수 있습니다.");
		return "user/banner/bannerMain";
	}

	@GetMapping("/banner/bannerRequest")
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

	@GetMapping("/banner/bannerProcessList")
	public String processList(Model model) {
		model.addAttribute("title", "광고 진행 현황");
		model.addAttribute("titleText", "광고 진행 현황");
		model.addAttribute("contents", "광고 단가 및 예상 가격을 확인할 수 있고, 광고 신청 및 조회를 할 수 있습니다.");
		return "user/banner/bannerProcessList";
	}

	@GetMapping("/banner/bannerRequestList")
	public String requestList(Model model) {
		model.addAttribute("title", "광고 신청 현황");
		model.addAttribute("titleText", "광고 신청 현황");
		model.addAttribute("contents", "광고 단가 및 예상 가격을 확인할 수 있고, 광고 신청 및 조회를 할 수 있습니다.");
		return "user/banner/bannerRequestList";
	}

	@GetMapping("/banner/bannerPayment")
	public String payment(Model model){
		model.addAttribute("title", "결제하기");
		model.addAttribute("titleText", "결제하기");
		model.addAttribute("contents", "배너 결제");
		return "user/banner/bannerPayment";
	}



	
}
