package ks47team02.user.service;





import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ks47team02.user.dto.Recommend;
import ks47team02.user.mapper.RecommendMapper;

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
		recommendMapper.addRecommendEmploymnet();
	}
	
	/*
	 * 채용 단계 순  목록 
	 */
	public List <Recommend> getRecommendEmploymentInfo(){
		List <Recommend> RecommendEmploymentInfo = recommendMapper.getRecommendEmployment();
		return RecommendEmploymentInfo;
	}
	
	
}
