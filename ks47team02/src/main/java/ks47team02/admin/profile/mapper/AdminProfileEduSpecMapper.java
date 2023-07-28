package ks47team02.admin.profile.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import ks47team02.user.profile.dto.ProfileEduSpec;

@Mapper
public interface AdminProfileEduSpecMapper {
	//학력 목록 조회
	public List<Map<String,Object>> getProfileEduSpecList(Map<String,Object> paramMap);
	//학력 행 갯수
	public int getEduSpecCnt();
}
