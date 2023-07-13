package ks47team02.user.profile.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import ks47team02.user.profile.dto.ProfileWorkSpec;

@Mapper
public interface ProfileWorkSpecMapper {
	//회원별 경력 목록
	public List<ProfileWorkSpec> getProfileWorkSpecList();
}
