package ks47team02.user.recommend.mapper;


import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import ks47team02.user.announcement.dto.Announcement;
import ks47team02.user.member.dto.Company;
import ks47team02.user.member.dto.User;
import ks47team02.user.project.pro.dto.JoinCate;
import ks47team02.user.recommend.dto.AreaCate;
import ks47team02.user.recommend.dto.NormalRun;
import ks47team02.user.recommend.dto.RecommendEmployment;

@Mapper
public interface RecommendEmploymentMapper {
	
	/*
	 * 진행 상황 분류 조회
	 */
	public List <NormalRun> getNormalRunRecommend();
	
	
	/*
	 * 분야 조회
	 */
	public List <JoinCate> getJoinCateRecommend();
	/*
	 * 지역 조회
	 */
	public List <AreaCate> getAreaRecommend();
	
	/*
	 * 회사 이름 조회
	 */
	public List<Company> getCpIdRecommend();
	
	
	/*
	 * 공고 조회
	 */
	public List<Announcement> getAnnouncementCodeRecommend();
	
	
	/*
	 * 회원 아이디 조회
	 */
	public List<User> getUserIdRecommend();
	
	
	/*
	 * 채용 단계 순 목록 삭제
	 */
	public int recommendRemoveEmployment(String companyEmploymentCode);
	
	/*
	 * 코드 별 상세 조회
	 */
	public RecommendEmployment getRecommendEmploymentByCode(String companyEmploymentCode);
	
	/*
	 * 채용 단계 순 목록 수정
	 */
	public int recommendModifyEmployment(RecommendEmployment recommendEmployment);
	
	
	/*
	 * 채용 단계 순 목록 등록
	 */
	public int recommendInsertEmployment(RecommendEmployment recommendEmployment);
		
	/*
	 * 채용 단계 순 목록
	 */
	public List <RecommendEmployment> getRecommendEmployment();
}
