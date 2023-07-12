package ks47team02.user.controller;







import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ks47team02.user.dto.Recommend;
import ks47team02.user.mapper.RecommendMapper;
import ks47team02.user.service.RecommendService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/recommend")
public class RecommendController {
	
	public final RecommendService recommendService;
	public final RecommendMapper recommendMapper;
	
	public RecommendController(RecommendMapper recommendMapper, RecommendService recommendService) {
		this.recommendMapper = recommendMapper;
		this.recommendService = recommendService;
	}
	
	/*
	 *  메인 기업 추천 서비스
	 */
	@GetMapping("/recommendMain")
	public String getRecommendMain(Model model) {
		
		model.addAttribute("title", "기업 추천 서비스 메인화면");
		model.addAttribute("titleText", "기업 추천 서비스");
		model.addAttribute("contents","기업 추천 서비스 메인 화면입니다.");
		
		return "user/recommend/recommend_main";
	}
	
	/*
	 *  스크랩 순 기업 추천 서비스
	 */
	
	@GetMapping("/recommendScrap")
	public String getRecommendScrap(Model model) {
		
		model.addAttribute("title", "스크랩 순 기업 추천 서비스");
		model.addAttribute("titleText", "스크랩 순 기업 추천 서비스");
		model.addAttribute("contents","스크랩 순 기업 추천 서비스 화면입니다.");
		
		return "user/recommend/recommend_scrap";
	}
	
	
	/*
	 *  기업 지원 순 기업 추천 서비스
	 */
	@GetMapping("/recommendSupport")
	public String getRecommendSupport(Model model) {
		model.addAttribute("title", "기업 지원 순 기업 추천 서비스");
		model.addAttribute("titleText", "기업 지원 순 기업 추천 서비스");
		model.addAttribute("contents","기업 지원 순 추천 서비스 화면입니다.");
		
		
		return "user/recommend/recommend_support";
	}
	
	/*
	 *  기업 아이디가 기업 지원 순 목록 삭제
	 */
	@GetMapping("/recommendSupportDelete")
	public String removeRecommendSupport(Model model) {
		model.addAttribute("title", "기업 지원 목록 삭제");
		model.addAttribute("titleText", "기업 지원 목록 삭제");
		model.addAttribute("contents","기업 지원 목록 삭제 화면입니다.");
	
		return "user/recommend/recommend_support_delete";
	}
	
	/*
	 *  채용 단계 순 기업 추천 서비스 목록 등록
	 */
	@PostMapping("/addRecommendEmployment")
	public String addRecommendEmployment(Recommend recommend) {
		log.info("목록 등록시 입력정보: {}", recommend);
		
		recommendService.addEmployment(recommend);
		return "redirect:/user/recommend/recommend_employment";
	}
	
	/*
	 *  채용 단계 순 기업 추천 서비스 목록 등록 (폼)
	 */
	@GetMapping("/addRecommendEmployment")
	public String addRecommendEmployment(Model model) {
		
		model.addAttribute("title", "채용 단계 순 목록 등록");
		model.addAttribute("titleText", "채용 단계 순 목록 등록");
		model.addAttribute("contents", "채용 단계 순 목록 등록 화면입니다.");
		
		return "user/recommend/recommend_employment_insert";
	}
	
	/*
	 *  채용 단계 순 기업 추천 서비스
	 */
	@GetMapping("/recommendEmployment")
	public String getRecommendEmployment(Model model) {
		
		List <Recommend> RecommendEmploymentInfo = recommendService.getRecommendEmploymentInfo();
		
		model.addAttribute("title", "채용 단계 순 기업 추천 서비스");
		model.addAttribute("titleText", "채용 단계 순 기업 추천 서비스");
		model.addAttribute("contents","채용 단계 순 추천 서비스 화면입니다.");
		model.addAttribute("RecommendEmploymentInfo", RecommendEmploymentInfo);
		return "user/recommend/recommend_employment";
	}
	

	
}
