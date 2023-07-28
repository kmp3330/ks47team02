package ks47team02.admin.profile.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import ks47team02.user.profile.dto.ProfileWorkSpec;

@Mapper
public interface AdminProfileWorkSpecMapper {
	//일경력 목록 조회
	public List<Map<String, Object>> getProfileWorkSpecList(Map<String, Object> paramMap);
	// 일경력 행 갯수
	public int getWorkSpecCnt();
}
