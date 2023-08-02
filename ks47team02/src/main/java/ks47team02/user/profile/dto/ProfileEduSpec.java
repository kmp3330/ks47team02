package ks47team02.user.profile.dto;


import lombok.Data;

@Data
public class ProfileEduSpec {
	private String userEduSpecCode;
	private String userId;
	private String univGradCateCode;
	private String univGradCateName;
	private String userUnivName;
	private String userUnivMajor;
	private String userUnivGrad;
	private String userUnivEnterDate;
	private String userUnivGradDate;
	private String userUnivScore;
	private String userUnivTotalScore;
	private String profileRegDate;
	private boolean profileHidden;
	private boolean profileApplicationHidden;
	
	
}
