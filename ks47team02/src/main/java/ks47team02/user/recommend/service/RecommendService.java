package ks47team02.user.recommend.service;





import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ks47team02.user.announcement.dto.Announcement;
import ks47team02.user.member.dto.User;
import ks47team02.user.recommend.dto.RecommendEmployment;
import ks47team02.user.recommend.dto.RecommendScrap;
import ks47team02.user.recommend.dto.RecommendSupport;
import ks47team02.user.recommend.mapper.RecommendEmploymentMapper;
import ks47team02.user.recommend.mapper.RecommendScrapMapper;
import ks47team02.user.recommend.mapper.RecommendSupportMapper;

@Service
@Transactional
public class RecommendService {

	public final RecommendEmploymentMapper recommendEmploymentMapper;
	public final RecommendSupportMapper recommendSupportMapper;
	public final RecommendScrapMapper recommendScrapMapper;
	
	public RecommendService
		  (RecommendEmploymentMapper recommendEmploymentMapper, 
		   RecommendSupportMapper recommendSupportMapper,
		   RecommendScrapMapper recommendScrapMapper) {
		
		this.recommendEmploymentMapper = recommendEmploymentMapper;
		this.recommendSupportMapper = recommendSupportMapper; 
		this.recommendScrapMapper = recommendScrapMapper;
	}
	
	/*
	 *  공고 목록
	 */
	public List <Announcement> getAnnouncementCodeRecommend(){
		List<Announcement> recommendAnnouncemetCodeInfo = recommendEmploymentMapper.getAnnouncementCodeRecommend();
		return recommendAnnouncemetCodeInfo;
	}
	
	
	/*
	 *  회원 아이디 목록
	 */
	public List <User> getUserIdRecommend(){
		List<User> recommendUserIdInfo = recommendEmploymentMapper.getUserIdRecommend();
		return recommendUserIdInfo;
	}
	
	
	/*
	 *  스크랩 순 목록
	 */
	public List <RecommendScrap> getRecommendScrapInfo(){
		List <RecommendScrap> recommendScrapInfo = recommendScrapMapper.getRecommendScrap();
		return recommendScrapInfo;
	}
	
	/*
	 *  기업 지원 순 목록 
	 */
	public List <RecommendSupport> getRecommendSupportInfo(){
		List <RecommendSupport> recommendSupportInfo = recommendSupportMapper.getRecommendSupport();
		return recommendSupportInfo;
	}
	
	/*
	 *  기업 지원 코드 조회
	 */
	
	public List <RecommendSupport> getRecommendSupportCode(){
		List <RecommendSupport> recommendSupportCode = recommendSupportMapper.getRecommendSupportCode();
		return recommendSupportCode;
	}
	
	
	/*
	 *  기업 지원 top5 순위
	 */
	
	public List <RecommendSupport> getRecommendSupportRank(){
		List <RecommendSupport> recommendSupportRank = recommendSupportMapper.getRecommendSupportRank();
		return recommendSupportRank;
	}
	/*
	 * 코드 별 상세 조회
	 */
	public RecommendEmployment getRecommendEmploymentByCode(String companyEmploymentCode) {
		RecommendEmployment recommendEmploymentByCode = recommendEmploymentMapper.getRecommendEmploymentByCode(companyEmploymentCode);
		return recommendEmploymentByCode;
	}
	
	/*
	 *  채용 단계 순 목록 삭제 
	 */
	public void recommendRemoveEmployment(String companyEmploymentCode) {
		recommendEmploymentMapper.recommendRemoveEmployment(companyEmploymentCode);
	}
	
	
	/*
	 *  채용 단계 순 목록 수정
	 */
	
	public int recommendModifyEmployment(RecommendEmployment recommendEmployment) {
		int recommendModifyEmployment = recommendEmploymentMapper.recommendModifyEmployment(recommendEmployment);
		return recommendModifyEmployment;
	}
	
	/*
	 *  채용 단계 순 목록 등록
	 */
	
	public void recommendInsertEmployment(RecommendEmployment recommendEmployment) {
		recommendEmploymentMapper.recommendInsertEmployment(recommendEmployment);
	}
	
	/*
	 * 채용 단계 순 목록 
	 */
	public List <RecommendEmployment> getRecommendEmploymentInfo(){
		List <RecommendEmployment> RecommendEmploymentInfo = recommendEmploymentMapper.getRecommendEmployment();
		return RecommendEmploymentInfo;
	}
	
	
}
