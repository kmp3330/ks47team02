package ks47team02.admin.profile.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import ks47team02.user.profile.dto.ProfileIntro;

@Mapper
public interface AdminProfileIntroMapper {
	
	public List<ProfileIntro> getProfileIntroList();

}
