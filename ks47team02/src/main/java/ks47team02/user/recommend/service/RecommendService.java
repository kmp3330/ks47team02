package ks47team02.user.recommend.service;





import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ks47team02.user.recommend.dto.RecommendEmployment;
import ks47team02.user.recommend.dto.RecommendScrap;
import ks47team02.user.recommend.dto.RecommendSupport;
import ks47team02.user.recommend.mapper.RecommendEmploymentMapper;
import ks47team02.user.recommend.mapper.RecommendScrapMapper;
import ks47team02.user.recommend.mapper.RecommendSupportMapper;

@Service
@Transactional
public class RecommendService {

	public final RecommendEmploymentMapper recommendMapper;
	public final RecommendSupportMapper recommendSupportMapper;
	public final RecommendScrapMapper recommendScrapMapper;
	
	public RecommendService
		  (RecommendEmploymentMapper recommendMapper, 
		   RecommendSupportMapper recommendSupportMapper,
		   RecommendScrapMapper recommendScrapMapper) {
		
		this.recommendMapper = recommendMapper;
		this.recommendSupportMapper = recommendSupportMapper; 
		this.recommendScrapMapper = recommendScrapMapper;
	}
	
	/*
	 *  스크랩 순 목록
	 */
	public List <RecommendScrap> getRecommendScrapInfo(){
		List <RecommendScrap> recommendScrapInfo = recommendScrapMapper.getRecommendScrap();
		return recommendScrapInfo;
	}
	
	/*
	 *  기업 지원 순 목록 
	 */
	public List <RecommendSupport> getRecommendSupportInfo(){
		List <RecommendSupport> recommendSupportInfo = recommendSupportMapper.getRecommendSupport();
		return recommendSupportInfo;
	}
	
	/*
	 *  기업 지원 코드
	 */
	public List <RecommendSupport> getRecommendSupportCode(){
		List <RecommendSupport> recommendSupportCode = recommendSupportMapper.getRecommendSupportCode();
		return recommendSupportCode;
	}
	
	/*
	 *  기업 지원 top5 순위
	 */
	
	public List <RecommendSupport> getRecommendSupportRank(){
		List <RecommendSupport> recommendSupportRank = recommendSupportMapper.getRecommendSupportRank();
		return recommendSupportRank;
	}
	
	/*
	 *  채용 단계 순 목록 등록
	 */
	
	public void addEmployment(RecommendEmployment recommend) {
		recommendMapper.addRecommendEmploymnet(recommend);
	}
	
	/*
	 * 채용 단계 순 목록 
	 */
	public List <RecommendEmployment> getRecommendEmploymentInfo(){
		List <RecommendEmployment> RecommendEmploymentInfo = recommendMapper.getRecommendEmployment();
		return RecommendEmploymentInfo;
	}
	
	
}