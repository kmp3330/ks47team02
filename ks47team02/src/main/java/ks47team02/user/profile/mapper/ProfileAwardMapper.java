package ks47team02.user.profile.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import ks47team02.user.profile.dto.ProfileAward;

@Mapper
public interface ProfileAwardMapper {
	
	// 수상이력 조회
	public List<ProfileAward> profileAwardList();
	
}
