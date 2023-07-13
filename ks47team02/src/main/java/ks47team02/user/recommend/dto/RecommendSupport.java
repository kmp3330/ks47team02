package ks47team02.user.recommend.dto;

import java.sql.Date;

import lombok.Data;

@Data
public class RecommendSupport {
	private String companySupportCode;
	private String userId;
	private String announcementCode;
	private String cpId;
	private String cpName;
	private String areaCode;
	private String areaCate;
	private String jobOpening;
	private String requiredSkills;
	private String career;
	private	int wage;
	private Date applicationDate;
}
