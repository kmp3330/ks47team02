package ks47team02.user.recommend.controller;







import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import ks47team02.user.announcement.dto.Announcement;
import ks47team02.user.member.dto.Company;
import ks47team02.user.member.dto.User;
import ks47team02.user.project.pro.dto.JoinCate;
import ks47team02.user.recommend.dto.AreaCate;
import ks47team02.user.recommend.dto.NormalRun;
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
	public final RecommendEmploymentMapper recommendEmploymentMapper;
	public final RecommendSupportMapper recommendSupportMapper;
	public final RecommendScrapMapper recommendScrapMapper;
	
	public RecommendController(RecommendEmploymentMapper recommendEmploymentMapper, 
			RecommendService recommendService, 
			RecommendSupportMapper recommendSupportMapper,
			RecommendScrapMapper recommendScrapMapper) {
		this.recommendEmploymentMapper = recommendEmploymentMapper;
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
	 * 채용 단계 순 기업 추천 서비스 목록 삭제
	 */
	
	@GetMapping("/recommendRemoveEmployment")
	public String recommendRemoveEmployment(@RequestParam(value="companyEmploymentCode")String companyEmploymentCode) {
		
		recommendService.recommendRemoveEmployment(companyEmploymentCode);
		
		log.info("채용 단계 삭제시 입력정보: {}", companyEmploymentCode);

		return "redirect:/recommend/recommendEmployment";
	}
	
	/*
	 *  채용 단계 순 기업 추천 서비스 목록 수정
	 */
	
	@PostMapping("/recommendModifyEmployment")
	public String recommendModifyEmployment(RecommendEmployment recommendEmployment) {
		
		recommendService.recommendModifyEmployment(recommendEmployment);
		log.info("목록 수정시 입력정보: {}", recommendEmployment);
		return "redirect:/recommend/recommendEmployment";
	}
	
	/*
	 *  채용 단계 순 기업 추천 서비스 목록 수정 (폼)
	 */
	
	@GetMapping("/recommendModifyEmployment")
	public String recommendModifyEmployment(Model model, String companyEmploymentCode) {
		
		RecommendEmployment recommendEmploymentByCode = recommendService.getRecommendEmploymentByCode(companyEmploymentCode);
		List <RecommendEmployment> RecommendEmploymentInfo = recommendService.getRecommendEmploymentInfo();
		List <RecommendSupport>	recommendSupportCodeInfo =recommendService.getRecommendSupportCode();
		List <User> recommendUserIdInfo = recommendService.getUserIdRecommend();
		List <Announcement> recommendAnnouncemetCodeInfo = recommendService.getAnnouncementCodeRecommend();
		List <RecommendSupport> recommendSupportInfo = recommendService.getRecommendSupportInfo();
		List <Company> recommendCpIdInfo = recommendService.getCpIdRecommend();
		List <AreaCate> recommendAreaInfo = recommendService.getAreaRecommend();
		List <JoinCate> recommendJoinCateInfo = recommendService.getJoinCateRecommend();
		List <NormalRun> recommendNormalRun = recommendService.getNormalRunRecommend();
		
		model.addAttribute("title", "채용 단계 순 목록 등록");
		model.addAttribute("titleText", "채용 단계 순 목록 등록");
		model.addAttribute("contents", "채용 단계 순 목록 등록 화면입니다.");
		model.addAttribute("RecommendEmploymentInfo", RecommendEmploymentInfo);
		model.addAttribute("recommendSupportCodeInfo", recommendSupportCodeInfo);
		model.addAttribute("recommendUserIdInfo", recommendUserIdInfo);
		model.addAttribute("recommendAnnouncemetCodeInfo", recommendAnnouncemetCodeInfo);
		model.addAttribute("recommendSupportInfo", recommendSupportInfo);
		model.addAttribute("recommendCpIdInfo", recommendCpIdInfo);
		model.addAttribute("recommendAreaInfo", recommendAreaInfo);
		model.addAttribute("recommendJoinCateInfo", recommendJoinCateInfo);
		model.addAttribute("recommendNormalRun", recommendNormalRun);
		model.addAttribute("recommendEmploymentByCode", recommendEmploymentByCode);
		return "user/recommend/recommend_employment_modify";
	}
	
	/*
	 *  채용 단계 순 기업 추천 서비스 목록 등록
	 */
	@PostMapping("/recommendInsertEmployment")
	public String recommendInsertEmployment(RecommendEmployment recommendEmployment) {
		
		recommendService.recommendInsertEmployment(recommendEmployment);
		log.info("목록 등록시 입력정보: {}", recommendEmployment);
		return "redirect:/recommend/recommendEmployment";
	}
	
	/*
	 * ajax로 진행 상황 분류 데이터 요청을 위한 컨트롤러
	 */
	@GetMapping("/recommendAjaxNormalRun")
	  @ResponseBody 
	  public List<NormalRun> getNormalRunRecommend() {
		List<NormalRun> recommendNormalRun = recommendService.getNormalRunRecommend();
	    return recommendNormalRun;
	  }
	
	/*
	 * ajax로 참여 분야 데이터 요청을 위한 컨트롤러
	 */
	@GetMapping("/recommendAjaxJoinCate")
	  @ResponseBody 
	  public List<JoinCate> getJoinCateRecommend() {
		List<JoinCate> recommendJoinCateInfo = recommendService.getJoinCateRecommend();
	    return recommendJoinCateInfo;
	  }
	/*
	 *  ajax로 Area 데이터 요청을 위한 컨트롤러
	 */
	@GetMapping("/recommendAjaxArea")
	  @ResponseBody 
	  public List<AreaCate> getAreaRecommend() {
		List<AreaCate> recommendAreaInfo = recommendService.getAreaRecommend();
	    return recommendAreaInfo;
	  }
	
	/*
	 *  ajax로 Support 데이터 요청을 위한 컨트롤러
	 */
	@GetMapping("/recommendAjaxSupport")
	  @ResponseBody 
	  public List<RecommendSupport> getRecommendSupport() {
		List<RecommendSupport> recommendSupportInfo = recommendService.getRecommendSupportInfo();
	    return recommendSupportInfo;
	  }
	
	
	/*
	 *  ajax로 Employment 데이터 요청을 위한 컨트롤러
	 */
	  @GetMapping("/recommendAjaxEmployment")
	  @ResponseBody 
	  public List<RecommendEmployment> getRecommendEmployment() {
	    List<RecommendEmployment> recommendEmploymentInfo = recommendService.getRecommendEmploymentInfo();
	    
	    return recommendEmploymentInfo;
	  }
	
	/*
	 *  채용 단계 순 기업 추천 서비스 목록 등록 (폼)
	 */
	@GetMapping("/recommendInsertEmployment")
	public String recommendInsertEmployment(Model model) {
		
		List <RecommendEmployment> RecommendEmploymentInfo = recommendService.getRecommendEmploymentInfo();
		List <RecommendSupport>	recommendSupportCodeInfo =recommendService.getRecommendSupportCode();
		List <User> recommendUserIdInfo = recommendService.getUserIdRecommend();
		List <Announcement> recommendAnnouncemetCodeInfo = recommendService.getAnnouncementCodeRecommend();
		List <RecommendSupport> recommendSupportInfo = recommendService.getRecommendSupportInfo();
		List <Company> recommendCpIdInfo = recommendService.getCpIdRecommend();
		List <AreaCate> recommendAreaInfo = recommendService.getAreaRecommend();
		List <JoinCate> recommendJoinCateInfo = recommendService.getJoinCateRecommend();
		List <NormalRun> recommendNormalRun = recommendService.getNormalRunRecommend();
		
		model.addAttribute("title", "채용 단계 순 목록 등록");
		model.addAttribute("titleText", "채용 단계 순 목록 등록");
		model.addAttribute("contents", "채용 단계 순 목록 등록 화면입니다.");
		model.addAttribute("RecommendEmploymentInfo", RecommendEmploymentInfo);
		model.addAttribute("recommendSupportCodeInfo", recommendSupportCodeInfo);
		model.addAttribute("recommendUserIdInfo", recommendUserIdInfo);
		model.addAttribute("recommendAnnouncemetCodeInfo", recommendAnnouncemetCodeInfo);
		model.addAttribute("recommendSupportInfo", recommendSupportInfo);
		model.addAttribute("recommendCpIdInfo", recommendCpIdInfo);
		model.addAttribute("recommendAreaInfo", recommendAreaInfo);
		model.addAttribute("recommendJoinCateInfo", recommendJoinCateInfo);
		model.addAttribute("recommendNormalRun", recommendNormalRun);
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
