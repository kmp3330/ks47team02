package ks47team02.user.mapper;


import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import ks47team02.user.dto.Recommend;

@Mapper
public interface RecommendMapper {
	
	/*
	 * 채용 단계 순 목록 등록
	 */
	public int addRecommendEmploymnet();
	
	
	/*
	 * 채용 단계 순 목록
	 */
	public List <Recommend> getRecommendEmployment();
}
