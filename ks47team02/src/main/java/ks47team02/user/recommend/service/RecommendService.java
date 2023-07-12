package ks47team02.user.recommend.service;





import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ks47team02.user.recommend.dto.Recommend;
import ks47team02.user.recommend.mapper.RecommendMapper;

@Service
@Transactional
public class RecommendService {

	public final RecommendMapper recommendMapper;
	
	public RecommendService(RecommendMapper recommendMapper) {
		this.recommendMapper = recommendMapper;
	}
	
	
	/*
	 *  채용 단계 순 목록 등록
	 */
	
	public void addEmployment(Recommend recommend) {
		recommendMapper.addRecommendEmploymnet(recommend);
	}
	
	/*
	 * 채용 단계 순  목록 
	 */
	public List <Recommend> getRecommendEmploymentInfo(){
		List <Recommend> RecommendEmploymentInfo = recommendMapper.getRecommendEmployment();
		return RecommendEmploymentInfo;
	}
	
	
}
