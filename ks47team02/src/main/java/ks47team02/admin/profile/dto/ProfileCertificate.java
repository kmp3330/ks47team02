package ks47team02.admin.profile.dto;

import lombok.Data;

@Data
public class ProfileCertificate {
	
	private String certificateCode;
	private String userId;
	private String certificateName;
	private String certificatePublication;
	private String certificateDate;
	private boolean profileHidden;
	private boolean profileApplicationHidden;

}
