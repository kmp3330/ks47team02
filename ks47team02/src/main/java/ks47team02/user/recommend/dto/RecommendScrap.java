package ks47team02.user.recommend.dto;

import java.sql.Date;

import lombok.Data;

@Data
public class RecommendScrap {
	private String companyScrapCode;
	private String announcementCode;
	private String userId;
	private String joinCateCode;
	private String joinCateName;
	private String areaCode;
	private String areaCate;
	private String jobOpening;
	private String requiredSkills;
	private String career;
	private int wage;
	private Date registrationTime;
}
