package ks47team02.user.recommend.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import ks47team02.user.recommend.dto.RecommendScrap;

@Mapper
public interface RecommendScrapMapper {
	
	
	public List<RecommendScrap> getRecommendScrap();
}
