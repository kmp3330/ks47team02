package ks47team02.user.profile.dto;

import java.util.Date;

public class ProfileSkill {
	
	private String userSkillCode;
	private String userId;
	private String userSkill;
	private String userSkillRank;
	private String userExperience;
	private String userRegDate;
	private boolean profileHidden;
	private boolean profileApplicationHidden;
	
	
	public String getUserSkillCode() {
		return userSkillCode;
	}
	public void setUserSkillCode(String userSkillCode) {
		this.userSkillCode = userSkillCode;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserSkill() {
		return userSkill;
	}
	public void setUserSkill(String userSkill) {
		this.userSkill = userSkill;
	}
	public String getUserSkillRank() {
		return userSkillRank;
	}
	public void setUserSkillRank(String userSkillRank) {
		this.userSkillRank = userSkillRank;
	}
	public String getUserExperience() {
		return userExperience;
	}
	public void setUserExperience(String userExperience) {
		this.userExperience = userExperience;
	}
	public String getUserRegDate() {
		return userRegDate;
	}
	public void setUserRegDate(String userRegDate) {
		this.userRegDate = userRegDate;
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
		builder.append("ProfileSkill [userSkillCode=");
		builder.append(userSkillCode);
		builder.append(", userId=");
		builder.append(userId);
		builder.append(", userSkill=");
		builder.append(userSkill);
		builder.append(", userSkillRank=");
		builder.append(userSkillRank);
		builder.append(", userExperience=");
		builder.append(userExperience);
		builder.append(", userRegDate=");
		builder.append(userRegDate);
		builder.append(", profileHidden=");
		builder.append(profileHidden);
		builder.append(", profileApplicationHidden=");
		builder.append(profileApplicationHidden);
		builder.append("]");
		return builder.toString();
	}
	
	
}
