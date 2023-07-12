package ks47team02.user.recommend.mapper;


import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import ks47team02.user.recommend.dto.Recommend;

@Mapper
public interface RecommendMapper {
	
	/*
	 * 회사 지원 코드 조회
	 */
	
	
	/*
	 * 채용 단계 순 목록 등록
	 */
	public int addRecommendEmploymnet(Recommend recommend);
	
	
	/*
	 * 채용 단계 순 목록
	 */
	public List <Recommend> getRecommendEmployment();
}
