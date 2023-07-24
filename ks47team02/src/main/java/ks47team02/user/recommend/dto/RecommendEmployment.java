package ks47team02.user.recommend.dto;


import java.sql.Date;

import lombok.Data;

@Data
public class RecommendEmployment {
	
	
	private String companyEmploymentCode;
	private String companySupportCode;
	private String userId;
	private String announcementCode;
	private String joinCateCode;
	private String joinCateName;
	private String areaCode;
	private String areaCate;
	private String jobOpening;
	private String requiredSkills;
	private String career;
	private String wage;
	private Date startDate;
	private Date dueDate;
	private String jobNormalRunCode;
	private String jobNormalRun;

	
	
}
