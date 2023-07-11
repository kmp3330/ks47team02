package ks47team02.user.announcement.dto;

public class Announcement {

	private String announcementCode;
	private String cpId;
	private String cpName;
	private String cpCateCode;
	private String joinCateCode;
	private String joinCateName;
	private String areaCode;
	private String areaCate;
	private String jobOpening;
	private String requiredSkills;
	private String career;
	private String recruitment;
	private String wage;
	private String startDate;
	private String dueDate;
	private String hiringStatusCode;
	private String hiringStatus;
	public String getAnnouncementCode() {
		return announcementCode;
	}
	public void setAnnouncementCode(String announcementCode) {
		this.announcementCode = announcementCode;
	}
	public String getCpId() {
		return cpId;
	}
	public void setCpId(String cpId) {
		this.cpId = cpId;
	}
	public String getCpName() {
		return cpName;
	}
	public void setCpName(String cpName) {
		this.cpName = cpName;
	}
	public String getCpCateCode() {
		return cpCateCode;
	}
	public void setCpCateCode(String cpCateCode) {
		this.cpCateCode = cpCateCode;
	}
	public String getJoinCateCode() {
		return joinCateCode;
	}
	public void setJoinCateCode(String joinCateCode) {
		this.joinCateCode = joinCateCode;
	}
	public String getJoinCateName() {
		return joinCateName;
	}
	public void setJoinCateName(String joinCateName) {
		this.joinCateName = joinCateName;
	}
	public String getAreaCode() {
		return areaCode;
	}
	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}
	public String getAreaCate() {
		return areaCate;
	}
	public void setAreaCate(String areaCate) {
		this.areaCate = areaCate;
	}
	public String getJobOpening() {
		return jobOpening;
	}
	public void setJobOpening(String jobOpening) {
		this.jobOpening = jobOpening;
	}
	public String getRequiredSkills() {
		return requiredSkills;
	}
	public void setRequiredSkills(String requiredSkills) {
		this.requiredSkills = requiredSkills;
	}
	public String getCareer() {
		return career;
	}
	public void setCareer(String career) {
		this.career = career;
	}
	public String getRecruitment() {
		return recruitment;
	}
	public void setRecruitment(String recruitment) {
		this.recruitment = recruitment;
	}
	public String getWage() {
		return wage;
	}
	public void setWage(String wage) {
		this.wage = wage;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getDueDate() {
		return dueDate;
	}
	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}
	public String getHiringStatusCode() {
		return hiringStatusCode;
	}
	public void setHiringStatusCode(String hiringStatusCode) {
		this.hiringStatusCode = hiringStatusCode;
	}
	public String getHiringStatus() {
		return hiringStatus;
	}
	public void setHiringStatus(String hiringStatus) {
		this.hiringStatus = hiringStatus;
	}
	@Override
	public String toString() {
		return "Announcement [announcementCode=" + announcementCode + ", cpId=" + cpId + ", cpName=" + cpName
				+ ", cpCateCode=" + cpCateCode + ", joinCateCode=" + joinCateCode + ", joinCateName=" + joinCateName
				+ ", areaCode=" + areaCode + ", areaCate=" + areaCate + ", jobOpening=" + jobOpening
				+ ", requiredSkills=" + requiredSkills + ", career=" + career + ", recruitment=" + recruitment
				+ ", wage=" + wage + ", startDate=" + startDate + ", dueDate=" + dueDate + ", hiringStatusCode="
				+ hiringStatusCode + ", hiringStatus=" + hiringStatus + ", getAnnouncementCode()="
				+ getAnnouncementCode() + ", getCpId()=" + getCpId() + ", getCpName()=" + getCpName()
				+ ", getCpCateCode()=" + getCpCateCode() + ", getJoinCateCode()=" + getJoinCateCode()
				+ ", getJoinCateName()=" + getJoinCateName() + ", getAreaCode()=" + getAreaCode() + ", getAreaCate()="
				+ getAreaCate() + ", getJobOpening()=" + getJobOpening() + ", getRequiredSkills()="
				+ getRequiredSkills() + ", getCareer()=" + getCareer() + ", getRecruitment()=" + getRecruitment()
				+ ", getWage()=" + getWage() + ", getStartDate()=" + getStartDate() + ", getDueDate()=" + getDueDate()
				+ ", getHiringStatusCode()=" + getHiringStatusCode() + ", getHiringStatus()=" + getHiringStatus()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
}
