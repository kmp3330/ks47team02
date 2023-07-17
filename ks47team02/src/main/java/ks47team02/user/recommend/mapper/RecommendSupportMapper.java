package ks47team02.user.recommend.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import ks47team02.user.recommend.dto.RecommendSupport;

@Mapper
public interface RecommendSupportMapper {
	
	/*
	 *  기업지원 top5 순위
	 */
	public List <RecommendSupport> getRecommendSupportRank();
	
	/*
	 *  기업 지원 코드 조회
	 */
	public List <RecommendSupport> getRecommendSupportCode();
	
	/*
	 *  기업 지원 순 목록 조회
	 */
	public List <RecommendSupport> getRecommendSupport();
}
