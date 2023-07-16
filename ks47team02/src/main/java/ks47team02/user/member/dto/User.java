package ks47team02.user.member.dto;

import lombok.Data;

@Data
public class User {
	
	private String userId;
	private String userPw;
	private String userName;
	private String levelCode;
	private String levelName;
	private String userGender;
	private boolean careerCheck;
	private boolean freelancerCheck;
	private String userAddr;
	private String userEmail;
	private String userPhone;
	private String userJoinDate;
	private String gradeFeeCode;
	private String userGrade;
	private int totalScore;
	private int reportScore;

}
