package ks47team02.user.profile.dto;

import lombok.Data;

@Data
public class ProfilePortfolio {
	
	private String userPortfolioCode;
	private String userId;
	private String userProjectName;
	private String joinCateCode;
	private String joinCateName;
	private String workCateCode;
	private String workCateName;
	private String subjectCateCode;
	private String subjectCateName;
	private String userRequiredSkill;
	private String userDetails;
	private String userProjectStartDate;
	private String userProjectEndDate;
	private String userProjectDays;
	private String userProjectGen;
	private boolean profileHidden;
	private boolean profileApplicationHidden;
	
}
