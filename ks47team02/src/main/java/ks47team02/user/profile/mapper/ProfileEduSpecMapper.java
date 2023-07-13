package ks47team02.user.profile.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;

import ks47team02.user.profile.dto.ProfileEduSpec;

@Mapper
public interface ProfileEduSpecMapper {
	//회원별 경력 목록
	public List<ProfileEduSpec> getProfileEduSpecList();
}
