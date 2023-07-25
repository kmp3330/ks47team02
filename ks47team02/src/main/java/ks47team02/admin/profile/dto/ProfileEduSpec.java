package ks47team02.admin.profile.dto;

import java.util.Date;

public class ProfileEduSpec {
	private String userEduSpecCode;
	private String userId;
	private String userDegree;
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
	
	public String getUserEduSpecCode() {
		return userEduSpecCode;
	}
	public void setUserEduSpecCode(String userEduSpecCode) {
		this.userEduSpecCode = userEduSpecCode;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserDegree() {
		return userDegree;
	}
	public void setUserDegree(String userDegree) {
		this.userDegree = userDegree;
	}
	public String getUserUnivName() {
		return userUnivName;
	}
	public void setUserUnivName(String userUnivName) {
		this.userUnivName = userUnivName;
	}
	public String getUserUnivMajor() {
		return userUnivMajor;
	}
	public void setUserUnivMajor(String userUnivMajor) {
		this.userUnivMajor = userUnivMajor;
	}
	public String getUserUnivGrad() {
		return userUnivGrad;
	}
	public void setUserUnivGrad(String userUnivGrad) {
		this.userUnivGrad = userUnivGrad;
	}
	public String getUserUnivEnterDate() {
		return userUnivEnterDate;
	}
	public void setUserUnivEnterDate(String userUnivEnterDate) {
		this.userUnivEnterDate = userUnivEnterDate;
	}
	public String getUserUnivGradDate() {
		return userUnivGradDate;
	}
	public void setUserUnivGradDate(String userUnivGradDate) {
		this.userUnivGradDate = userUnivGradDate;
	}
	public String getUserUnivScore() {
		return userUnivScore;
	}
	public void setUserUnivScore(String userUnivScore) {
		this.userUnivScore = userUnivScore;
	}
	public String getUserUnivTotalScore() {
		return userUnivTotalScore;
	}
	public void setUserUnivTotalScore(String userUnivTotalScore) {
		this.userUnivTotalScore = userUnivTotalScore;
	}
	public String getProfileRegDate() {
		return profileRegDate;
	}
	public void setProfileRegDate(String profileRegDate) {
		this.profileRegDate = profileRegDate;
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
		builder.append("ProfileWorkSpec [userEduSpecCode=");
		builder.append(userEduSpecCode);
		builder.append(", userId=");
		builder.append(userId);
		builder.append(", userDegree=");
		builder.append(userDegree);
		builder.append(", userUnivName=");
		builder.append(userUnivName);
		builder.append(", userUnivMajor=");
		builder.append(userUnivMajor);
		builder.append(", userUnivGrad=");
		builder.append(userUnivGrad);
		builder.append(", userUnivEnterDate=");
		builder.append(userUnivEnterDate);
		builder.append(", userUnivGradDate=");
		builder.append(userUnivGradDate);
		builder.append(", userUnivScore=");
		builder.append(userUnivScore);
		builder.append(", userUnivTotalScore=");
		builder.append(userUnivTotalScore);
		builder.append(", profileRegDate=");
		builder.append(profileRegDate);
		builder.append(", profileHidden=");
		builder.append(profileHidden);
		builder.append(", profileApplicationHidden=");
		builder.append(profileApplicationHidden);
		builder.append("]");
		return builder.toString();
	}
	
	
}
