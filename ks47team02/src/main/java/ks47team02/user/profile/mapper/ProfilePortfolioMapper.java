package ks47team02.user.profile.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import ks47team02.user.profile.dto.ProfilePortfolio;
import ks47team02.user.project.pro.dto.JoinCate;

@Mapper
public interface ProfilePortfolioMapper {
	
	// 포트폴리오 조회
	public List<ProfilePortfolio> getProfilePortfolioList(String sessionId);
	
	// 참여 분야 조회
	//public List<JoinCate> getJoinCateList();
	
	// 포트폴리오 등록
	public int addProfilePortfolio(ProfilePortfolio profilePortfolio);

}
