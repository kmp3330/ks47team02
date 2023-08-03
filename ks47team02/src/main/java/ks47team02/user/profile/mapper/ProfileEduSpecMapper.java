package ks47team02.user.profile.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;

import ks47team02.user.profile.dto.ProfileEduSpec;
import ks47team02.user.profile.dto.ProfileWorkSpec;
import ks47team02.user.profile.dto.UnivGradCate;

@Mapper
public interface ProfileEduSpecMapper {
	//학력 삭제 
	public int profileEduSpecDelete(String userEduSpecCode);
	//학력 수정
	public int profileEduSpecModify(ProfileEduSpec profileEduSpec);
	//학력 상세조회 
	public ProfileEduSpec getProfileEduSpecInfoByCode(String userEduSpecCode);
	//학력 등록
	public int profileEduSpecInsert(ProfileEduSpec profileEduSpec);
	//회원별 학력 목록
	public List<ProfileEduSpec> getProfileEduSpecList(String sessionId);
	//최종학력 상태 목록
	public List<UnivGradCate> getUnivGradCateList();
	
	public UnivGradCate getUnivGradCateByCode(String univGradCateCode);
}
