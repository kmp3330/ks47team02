package ks47team02.user.profile.dto;

import java.util.Date;

public class ProfileWorkSpec {
	
	private String userWorkSpecCode;
	private String userId;
	private String userCompany;
	private String userSkill;
	private Date userEnterDate;
	private Date userLeaveDate;
	private String userDepartment;
	private String userRank;
	private String userWork;
	private Date profileRegDate;
	private boolean profileHidden;
	private boolean profileApplicationHidden;
	
	public String getUserWorkSpecCode() {
		return userWorkSpecCode;
	}
	public void setUserWorkSpecCode(String userWorkSpecCode) {
		this.userWorkSpecCode = userWorkSpecCode;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserCompany() {
		return userCompany;
	}
	public void setUserCompany(String userCompany) {
		this.userCompany = userCompany;
	}
	public String getUserSkill() {
		return userSkill;
	}
	public void setUserSkill(String userSkill) {
		this.userSkill = userSkill;
	}
	public Date getUserEnterDate() {
		return userEnterDate;
	}
	public void setUserEnterDate(Date userEnterDate) {
		this.userEnterDate = userEnterDate;
	}
	public Date getUserLeaveDate() {
		return userLeaveDate;
	}
	public void setUserLeaveDate(Date userLeaveDate) {
		this.userLeaveDate = userLeaveDate;
	}
	public String getUserDepartment() {
		return userDepartment;
	}
	public void setUserDepartment(String userDepartment) {
		this.userDepartment = userDepartment;
	}
	public String getUserRank() {
		return userRank;
	}
	public void setUserRank(String userRank) {
		this.userRank = userRank;
	}
	public String getUserWork() {
		return userWork;
	}
	public void setUserWork(String userWork) {
		this.userWork = userWork;
	}
	public Date getProfileRegDate() {
		return profileRegDate;
	}
	public void setProfileRegDate(Date profileRegDate) {
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
		builder.append("ProfileWorkSpec [userWorkSpecCode=");
		builder.append(userWorkSpecCode);
		builder.append(", userId=");
		builder.append(userId);
		builder.append(", userCompany=");
		builder.append(userCompany);
		builder.append(", userSkill=");
		builder.append(userSkill);
		builder.append(", userEnterDate=");
		builder.append(userEnterDate);
		builder.append(", userLeaveDate=");
		builder.append(userLeaveDate);
		builder.append(", userDepartment=");
		builder.append(userDepartment);
		builder.append(", userRank=");
		builder.append(userRank);
		builder.append(", userWork=");
		builder.append(userWork);
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