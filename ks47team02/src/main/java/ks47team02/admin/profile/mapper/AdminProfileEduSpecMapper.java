package ks47team02.admin.profile.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import ks47team02.user.profile.dto.ProfileEduSpec;

@Mapper
public interface AdminProfileEduSpecMapper {
	//학력 목록 조회
	public List<ProfileEduSpec> getProfileEduSpecList();
}
