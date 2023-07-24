package ks47team02.user.profile.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import ks47team02.user.profile.dto.ProfilePortfolio;

@Mapper
public interface ProfilePortfolioMapper {
	
	// 포트폴리오 조회
	public List<ProfilePortfolio> getProfilePortfolioList(String sessionId);

}
