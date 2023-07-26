package ks47team02.admin.profile.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import ks47team02.user.profile.dto.ProfileIntro;

@Mapper
public interface AdminProfileIntroMapper {
	//자기소개 전체 조회
	public List<Map<String,Object>> getProfileIntroList(Map<String,Object> paramMap);
	//public List<ProfileIntro> getProfileIntroList();
	//자기소개 행 갯수
	public int getIntroCnt();

}
