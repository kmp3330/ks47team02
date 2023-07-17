 package ks47team02.user.project.pro.dto;


public class ProProject {
	
	private String cpId;
	private String levelCode;
	
	private String joinCateCode;
	private String workCateCode;
	private String subjectCateCode;
	private String joinCateName;
	private String workCateName;
	private String subjectCateName;
	
	
	private String proProjectCode;
	private String applicationDate;
	private String applicantUserId;
	private String cpName;	
	private String proProjectTitle;
	private String proProjectDetails;
	private int proProjectMaxtotal;
	private String proProjectRunName;
	private int proProjectPrice;
	private String proProjectWriteDate;
	private String proProjectDueDate;
	private String dueCompleteDate;
	private String proProjectStartDate;
	private String proProjectCompleteDate;
	private String runName;
	private int proProjectDays;
	
	
	
	
	
	public String getJoinCateCode() {
		return joinCateCode;
	}
	public void setJoinCateCode(String joinCateCode) {
		this.joinCateCode = joinCateCode;
	}
	public String getWorkCateCode() {
		return workCateCode;
	}
	public void setWorkCateCode(String workCateCode) {
		this.workCateCode = workCateCode;
	}
	public String getSubjectCateCode() {
		return subjectCateCode;
	}
	public void setSubjectCateCode(String subjectCateCode) {
		this.subjectCateCode = subjectCateCode;
	}
	public String getCpId() {
		return cpId;
	}
	public void setCpId(String cpId) {
		this.cpId = cpId;
	}
	public String getLevelCode() {
		return levelCode;
	}
	public void setLevelCode(String levelCode) {
		this.levelCode = levelCode;
	}
	public String getRunName() {
		return runName;
	}
	public void setRunName(String runName) {
		this.runName = runName;
	}
	public String getCpName() {
		return cpName;
	}
	public String getProProjectCode() {
		return proProjectCode;
	}
	public void setProProjectCode(String proProjectCode) {
		this.proProjectCode = proProjectCode;
	}
	public String getApplicationDate() {
		return applicationDate;
	}
	public void setApplicationDate(String applicationDate) {
		this.applicationDate = applicationDate;
	}
	public String getApplicantUserId() {
		return applicantUserId;
	}
	public void setApplicantUserId(String applicantUserId) {
		this.applicantUserId = applicantUserId;
	}
	public void setCpName(String cpName) {
		this.cpName = cpName;
	}
	public String getProProjectTitle() {
		return proProjectTitle;
	}
	public void setProProjectTitle(String proProjectTitle) {
		this.proProjectTitle = proProjectTitle;
	}
	public String getJoinCateName() {
		return joinCateName;
	}
	public void setJoinCateName(String joinCateName) {
		this.joinCateName = joinCateName;
	}
	public String getWorkCateName() {
		return workCateName;
	}
	public void setWorkCateName(String workCateName) {
		this.workCateName = workCateName;
	}
	public String getSubjectCateName() {
		return subjectCateName;
	}
	public void setSubjectCateName(String subjectCateName) {
		this.subjectCateName = subjectCateName;
	}
	public String getProProjectDetails() {
		return proProjectDetails;
	}
	public void setProProjectDetails(String proProjectDetails) {
		this.proProjectDetails = proProjectDetails;
	}
	public int getProProjectMaxtotal() {
		return proProjectMaxtotal;
	}
	public void setProProjectMaxtotal(int proProjectMaxtotal) {
		this.proProjectMaxtotal = proProjectMaxtotal;
	}
	public String getProProjectRunName() {
		return proProjectRunName;
	}
	public void setProProjectRunName(String proProjectRunName) {
		this.proProjectRunName = proProjectRunName;
	}
	public int getProProjectPrice() {
		return proProjectPrice;
	}
	public void setProProjectPrice(int proProjectPrice) {
		this.proProjectPrice = proProjectPrice;
	}
	public String getProProjectWriteDate() {
		return proProjectWriteDate;
	}
	public void setProProjectWriteDate(String proProjectWriteDate) {
		this.proProjectWriteDate = proProjectWriteDate;
	}
	public String getProProjectDueDate() {
		return proProjectDueDate;
	}
	public void setProProjectDueDate(String proProjectDueDate) {
		this.proProjectDueDate = proProjectDueDate;
	}
	public String getDueCompleteDate() {
		return dueCompleteDate;
	}
	public void setDueCompleteDate(String dueCompleteDate) {
		this.dueCompleteDate = dueCompleteDate;
	}
	public String getProProjectStartDate() {
		return proProjectStartDate;
	}
	public void setProProjectStartDate(String proProjectStartDate) {
		this.proProjectStartDate = proProjectStartDate;
	}
	public String getProProjectCompleteDate() {
		return proProjectCompleteDate;
	}
	public void setProProjectCompleteDate(String proProjectCompleteDate) {
		this.proProjectCompleteDate = proProjectCompleteDate;
	}
	public int getProProjectDays() {
		return proProjectDays;
	}
	public void setProProjectDays(int proProjectDays) {
		this.proProjectDays = proProjectDays;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ProProject [cpId=");
		builder.append(cpId);
		builder.append(", levelCode=");
		builder.append(levelCode);
		builder.append(", joinCateCode=");
		builder.append(joinCateCode);
		builder.append(", workCateCode=");
		builder.append(workCateCode);
		builder.append(", subjectCateCode=");
		builder.append(subjectCateCode);
		builder.append(", joinCateName=");
		builder.append(joinCateName);
		builder.append(", workCateName=");
		builder.append(workCateName);
		builder.append(", subjectCateName=");
		builder.append(subjectCateName);
		builder.append(", proProjectCode=");
		builder.append(proProjectCode);
		builder.append(", applicationDate=");
		builder.append(applicationDate);
		builder.append(", applicantUserId=");
		builder.append(applicantUserId);
		builder.append(", cpName=");
		builder.append(cpName);
		builder.append(", proProjectTitle=");
		builder.append(proProjectTitle);
		builder.append(", proProjectDetails=");
		builder.append(proProjectDetails);
		builder.append(", proProjectMaxtotal=");
		builder.append(proProjectMaxtotal);
		builder.append(", proProjectRunName=");
		builder.append(proProjectRunName);
		builder.append(", proProjectPrice=");
		builder.append(proProjectPrice);
		builder.append(", proProjectWriteDate=");
		builder.append(proProjectWriteDate);
		builder.append(", proProjectDueDate=");
		builder.append(proProjectDueDate);
		builder.append(", dueCompleteDate=");
		builder.append(dueCompleteDate);
		builder.append(", proProjectStartDate=");
		builder.append(proProjectStartDate);
		builder.append(", proProjectCompleteDate=");
		builder.append(proProjectCompleteDate);
		builder.append(", runName=");
		builder.append(runName);
		builder.append(", proProjectDays=");
		builder.append(proProjectDays);
		builder.append("]");
		return builder.toString();
	}
	
}