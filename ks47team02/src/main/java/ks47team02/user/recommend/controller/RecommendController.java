package ks47team02.user.recommend.controller;







import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ks47team02.user.recommend.dto.RecommendEmployment;
import ks47team02.user.recommend.dto.RecommendScrap;
import ks47team02.user.recommend.dto.RecommendSupport;
import ks47team02.user.recommend.mapper.RecommendEmploymentMapper;
import ks47team02.user.recommend.mapper.RecommendScrapMapper;
import ks47team02.user.recommend.mapper.RecommendSupportMapper;
import ks47team02.user.recommend.service.RecommendService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/recommend")
public class RecommendController {
	
	public final RecommendService recommendService;
	public final RecommendEmploymentMapper recommendMapper;
	public final RecommendSupportMapper recommendSupportMapper;
	public final RecommendScrapMapper recommendScrapMapper;
	
	public RecommendController(RecommendEmploymentMapper recommendMapper, 
			RecommendService recommendService, 
			RecommendSupportMapper recommendSupportMapper,
			RecommendScrapMapper recommendScrapMapper) {
		this.recommendMapper = recommendMapper;
		this.recommendService = recommendService;
		this.recommendSupportMapper = recommendSupportMapper;
		this.recommendScrapMapper = recommendScrapMapper;
	}
	
	/*
	 *  메인 기업 추천 서비스
	 */
	@GetMapping("/recommendMain")
	public String getRecommendMain(Model model) {
		
		List <RecommendSupport> recommendSupportRank = recommendService.getRecommendSupportRank();
		
		model.addAttribute("title", "기업 추천 서비스 메인화면");
		model.addAttribute("titleText", "기업 추천 서비스");
		model.addAttribute("contents","기업 추천 서비스 메인 화면입니다.");
		model.addAttribute("recommendSupportRank", recommendSupportRank);
		
		return "user/recommend/recommend_main";
	}
	
	
	
	
	/*
	 *  스크랩 순 기업 추천 서비스
	 */
	
	@GetMapping("/recommendScrap")
	public String getRecommendScrap(Model model) {
		
		List <RecommendScrap> recommendScrapInfo = recommendService.getRecommendScrapInfo();
		
		model.addAttribute("title", "스크랩 순 기업 추천 서비스");
		model.addAttribute("titleText", "스크랩 순 기업 추천 서비스");
		model.addAttribute("contents","스크랩 순 기업 추천 서비스 화면입니다.");
		model.addAttribute("recommendScrapInfo", recommendScrapInfo);
		return "user/recommend/recommend_scrap";
	}
	
	
	/*
	 *  기업 지원 순 기업 추천 서비스
	 */
	@GetMapping("/recommendSupport")
	public String getRecommendSupport(Model model) {
		
		List <RecommendSupport> recommendSupportInfo = recommendService.getRecommendSupportInfo();
		
		model.addAttribute("title", "기업 지원 순 기업 추천 서비스");
		model.addAttribute("titleText", "기업 지원 순 기업 추천 서비스");
		model.addAttribute("contents","기업 지원 순 추천 서비스 화면입니다.");
		model.addAttribute("recommendSupportInfo", recommendSupportInfo);
		
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
	public String addRecommendEmployment(RecommendEmployment recommend) {
		log.info("목록 등록시 입력정보: {}", recommend);
		
		recommendService.addEmployment(recommend);
		return "redirect:/user/recommend/recommend_employment";
	}
	
	/*
	 *  채용 단계 순 기업 추천 서비스 목록 등록 (폼)
	 */
	@GetMapping("/addRecommendEmployment")
	public String addRecommendEmployment(Model model) {
		
		List <RecommendSupport> recommendSupportCode = recommendService.getRecommendSupportCode();
		
		model.addAttribute("title", "채용 단계 순 목록 등록");
		model.addAttribute("titleText", "채용 단계 순 목록 등록");
		model.addAttribute("contents", "채용 단계 순 목록 등록 화면입니다.");
		model.addAttribute("recommendSupportCode", recommendSupportCode);
		
		return "user/recommend/recommend_employment_insert";
	}
	
	/*
	 *  채용 단계 순 기업 추천 서비스
	 */
	@GetMapping("/recommendEmployment")
	public String getRecommendEmployment(Model model) {
		
		List <RecommendEmployment> RecommendEmploymentInfo = recommendService.getRecommendEmploymentInfo();
		
		model.addAttribute("title", "채용 단계 순 기업 추천 서비스");
		model.addAttribute("titleText", "채용 단계 순 기업 추천 서비스");
		model.addAttribute("contents","채용 단계 순 추천 서비스 화면입니다.");
		model.addAttribute("RecommendEmploymentInfo", RecommendEmploymentInfo);
		return "user/recommend/recommend_employment";
	}
	

	
}
