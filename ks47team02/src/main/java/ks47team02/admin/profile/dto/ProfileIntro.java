package ks47team02.admin.profile.dto;

import java.util.Date;

public class ProfileIntro {
	//profile_intro 테이블 
	private String userIntroCode;
	private String userId;
	private String userIntro;
	private boolean profileHidden;
	private boolean profileApplicationHidden;
	
	public String getUserIntroCode() {
		return userIntroCode;
	}
	public void setUserIntroCode(String userIntroCode) {
		this.userIntroCode = userIntroCode;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserIntro() {
		return userIntro;
	}
	public void setUserIntro(String userIntro) {
		this.userIntro = userIntro;
	}
	public boolean isProfileHidden() {
		return profileHidden;
	}
	public void setProfileHidden(boolean profileHidden) {
		this.profileHidden = profileHidden;
	}
	public boolean isProfileApplicationHidden() {
		return profileApplicationHidden;
	}
	public void setProfileApplicationHidden(boolean profileApplicationHidden) {
		this.profileApplicationHidden = profileApplicationHidden;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ProfileIntro [userIntroCode=");
		builder.append(userIntroCode);
		builder.append(", userId=");
		builder.append(userId);
		builder.append(", userIntro=");
		builder.append(userIntro);
		builder.append(", profileHidden=");
		builder.append(profileHidden);
		builder.append(", profileApplicationHidden=");
		builder.append(profileApplicationHidden);
		builder.append("]");
		return builder.toString();
	}
	
	
	
	/*
	// profile_skill 테이블 
	private String userSkillCode;
	// private String userId; (fk)
	private String userSkill;
	private String userSkillRank;
	private int userExperience;
	private Date useRegDate;
	// private boolean profileHidden;
	// private boolean profileApplicationHidden;
	
	// profile_work_spec 테이블  
	private String userWorkSpecCode;
	// private String userId; (fk)
	private String userCompany;
	//private String userSkill;
	private Date userEnterDate;
	private Date userLeaveDate;
	private String userDepartment;
	private String userRank;
	private String userWork;
	private String userRank;
	// private Date useRegDate;
	// private boolean profileHidden;
	// private boolean profileApplicationHidden;
	
	
	// profile_edu_spec 테이블
	 * 
	 */
}
