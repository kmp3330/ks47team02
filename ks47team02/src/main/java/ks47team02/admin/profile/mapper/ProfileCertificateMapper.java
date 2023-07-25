package ks47team02.admin.profile.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import ks47team02.admin.profile.dto.ProfileCertificate;

@Mapper
public interface ProfileCertificateMapper {
	
	// 자격증 조회
	public List<ProfileCertificate> certificateList(String sessionId);
	
	// 자격증 등록
	public int profileCertificateInsert(ProfileCertificate profileCertificate);
	
	// 자격증 코드별 자격증 조회
	public ProfileCertificate certificateByCode(String certificateCode);
	
	// 자격증 수정
	public int profileCertificateModify(ProfileCertificate profileCertificate);
	
	// 자격증 삭제
	public int profileCertificateDelete(String certificateCode);

}
