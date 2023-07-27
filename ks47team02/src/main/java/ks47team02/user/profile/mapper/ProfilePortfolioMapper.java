package ks47team02.user.profile.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import ks47team02.user.profile.dto.ProfilePortfolio;
import ks47team02.user.project.pro.dto.JoinCate;
import ks47team02.user.project.pro.dto.SubjectCate;
import ks47team02.user.project.pro.dto.WorkCate;

@Mapper
public interface ProfilePortfolioMapper {
	
	// 포트폴리오 조회
	public List<ProfilePortfolio> getProfilePortfolioList(String sessionId);
	
	// 참여 분야 조회
	public List<JoinCate> getJoinCateList();
	// 참여코드별 참여분야 조회
	public JoinCate getJoinCateByCode(String joinCateCode);
	
	// 작업 분류 조회
	public List<WorkCate> getWorkCateList();
	// 작업코드별 참여분야 조회
	public WorkCate getWorkCateByCode(String workCateCode);
	
	// 주제 분류 조회
	public List<SubjectCate> getSubjectCateList();
	// 주제코드별 참여분야 조회
	public SubjectCate getSubjectCateByCode(String subjectCateCode);
	
	// 포트폴리오 코드별 분류 코드,이름 조회
	public ProfilePortfolio getProfilePortfolioByCode(String portfolioCode);
	
	
	// 참여한 전문과제 프로젝트 목록
	public Map<String, Object> getProProjectList(String sessionId);
	
	// 참여한 일반과제 프로젝트 목록
	
	
	// 포트폴리오 등록
	public int addProfilePortfolio(ProfilePortfolio profilePortfolio);

	// 포트폴리오 코드별 조회
	public ProfilePortfolio profilePortfolioByCode(String profilePortfolioCode);
	
	// 포트폴리오 수정
	public int profilePortfolioModify(ProfilePortfolio profilePortfolio);
	
	// 포트폴리오 삭제
	public int profilePortfolioDelete(String profilePortfolioCode);
}
