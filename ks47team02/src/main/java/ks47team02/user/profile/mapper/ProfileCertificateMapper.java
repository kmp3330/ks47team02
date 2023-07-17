package ks47team02.user.profile.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import ks47team02.user.profile.dto.ProfileCertificate;

@Mapper
public interface ProfileCertificateMapper {
	
	// 자격증 조회
	public List<ProfileCertificate> certificateList();
	
	// 자격증 등록
	public int profileCertificateInsert(ProfileCertificate profileCertificate);

}
