package ks47team02.admin.profile.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import ks47team02.admin.profile.dto.ProfileAward;

@Mapper
public interface ProfileAwardMapper {
	
	// 수상이력 조회
	public List<ProfileAward> getProfileAwardList(String sessionId);
	
	// 수상이력 등록
	public int addProfileAward(ProfileAward profileAward);
	
	// 수상이력 코드별 조회
	public ProfileAward profileAwardByCode(String userAwardCode);
	
	// 수상이력 수정
	public int modifyProfileAward(ProfileAward profileAward);
	
	// 수상이력 삭제
	public int deleteProfileAward(String profileAwardCode);
}
