package ks47team02.user.announcement.dto;


import java.sql.Date;

import lombok.Data;

@Data
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
	private Date startDate;
	private Date dueDate;
	private String hiringStatusCode;
	private String hiringStatus;
	

}
