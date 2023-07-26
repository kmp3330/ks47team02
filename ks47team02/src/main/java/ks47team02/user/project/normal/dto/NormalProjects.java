package ks47team02.user.project.normal.dto;

import lombok.Data;

@Data
public class NormalProjects {
	private String normalProjectCode;
	private String userId;
	private String normalProjectName;
	private String joinCateCode;
	private String joinCateName;
	private String workCateCode;
	private String workCateName;
	private String subjectCateCode;
	private String subjectCateName;
	private String requiredSkill;
	private String normalProjectDetail;
	private int projectMaxPeopleNum;
	private String normalRunCode;
	private String runName;
	private String projectAdvertiseStartDate;
	private String projectAdvertiseFinishDate;
	private String projectStartUpDate;
	private String projectFinishDate;
	private int projectDay;	
	private int projectDayScore;
	private int projectFinishScore;
	
}
