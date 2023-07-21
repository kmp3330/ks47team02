package ks47team02.user.recommend.mapper;


import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import ks47team02.user.recommend.dto.RecommendEmployment;

@Mapper
public interface RecommendEmploymentMapper {
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
