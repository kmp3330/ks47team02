package ks47team02.admin.profile.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AdminProfileCertificateMapper {
	
	// 자격증 전체 조회
	public List<Map<String, Object>> getCertificateList(Map<String, Object> paramMap);
	
	// 자격증 행 갯수
	public int getCertificateCnt();

}
